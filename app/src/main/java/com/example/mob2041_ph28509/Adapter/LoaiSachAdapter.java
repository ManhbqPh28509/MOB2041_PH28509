package com.example.mob2041_ph28509.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mob2041_ph28509.DAO.LoaiSachDAO;
import com.example.mob2041_ph28509.DAO.SachDAO;
import com.example.mob2041_ph28509.Model.LoaiSach;
import com.example.mob2041_ph28509.Model.Sach;
import com.example.mob2041_ph28509.R;

import java.util.ArrayList;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachAdapter.ViewHolder> {
    private ArrayList<LoaiSach> arrayList;
    private Context context;
    private LoaiSachDAO loaiSachDAO;
    public LoaiSachAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<LoaiSach> arrayList, LoaiSachDAO loaiSachDAO){
        this.arrayList = arrayList;
        this.loaiSachDAO = loaiSachDAO;
    }
    @NonNull
    @Override
    public LoaiSachAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_loai_sach, parent, false);
        return new LoaiSachAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSachAdapter.ViewHolder holder, int position) {
        LoaiSach loaiSach = arrayList.get(position);
        holder.tv_maLoaiSach.setText(loaiSach.getMa_loai_sach());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Do you want to delete");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        long res = loaiSachDAO.deleteLoaiSach(loaiSach);
                        if (res != 0 ){
                            Toast.makeText(context, "Xóa Thành công", Toast.LENGTH_SHORT).show();
                            arrayList.remove(loaiSach);
                            notifyDataSetChanged();
                            dialog.dismiss();

                        } else {
                            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
            }

        });
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateLoaiSach(loaiSach,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    private void UpdateLoaiSach(LoaiSach loaiSach,int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_loai_sach, null);

        // Khởi tạo dialog
        Dialog dialog = new Dialog(context, androidx.appcompat.R.style.Base_V21_Theme_AppCompat_Dialog);
        dialog.setContentView(view);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);
        EditText edt_MaLoaiSach = view.findViewById(R.id.edt_MaLoaiSach);
        edt_MaLoaiSach.setText(loaiSach.getMa_loai_sach());
        Button btn_ok = view.findViewById(R.id.btn_SuaDiaLogUpdateLoaiSach);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiSach.setMa_loai_sach(edt_MaLoaiSach.getText().toString().trim());
                long res = loaiSachDAO.editLoaiSach(loaiSach);
                if (res != 0 ){
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    arrayList.set(position,loaiSach);
                    notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btn_cancel = view.findViewById(R.id.btn_CancelDialogUpdateLoaiSach);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void AddLoaiSach() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_add_loai_sach, null);

        // Khởi tạo dialog
        Dialog dialog = new Dialog(context, androidx.appcompat.R.style.Base_V21_Theme_AppCompat_Dialog);
        dialog.setContentView(view);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);
        EditText edt_MaLoaiSach = view.findViewById(R.id.edt_AddMaLoaiSach);
        Button btn_ok = view.findViewById(R.id.btn_AddDiaLogAddLoaiSach);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiSach loaiSach = new LoaiSach();
                loaiSach.setMa_loai_sach(edt_MaLoaiSach.getText().toString().trim());
                long res = loaiSachDAO.insertNew(loaiSach);
                if (res != 0 ){
                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    arrayList.add(loaiSach);
                    notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btn_cancel = view.findViewById(R.id.btn_CancelDialogAddLoaiSach);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_maLoaiSach;
        private ImageView img_edit,img_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maLoaiSach = itemView.findViewById(R.id.tv_ma_loai_sach);
            img_edit = itemView.findViewById(R.id.imgEditLoaiSach);
            img_delete = itemView.findViewById(R.id.imgBinLoaiSach);
        }
    }
}

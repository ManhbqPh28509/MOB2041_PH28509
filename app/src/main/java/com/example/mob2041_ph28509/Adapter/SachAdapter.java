package com.example.mob2041_ph28509.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mob2041_ph28509.DAO.SachDAO;
import com.example.mob2041_ph28509.Model.Sach;
import com.example.mob2041_ph28509.R;

import java.util.ArrayList;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder> {
    private ArrayList<Sach> arrayList;
    private Context context;
    private SachDAO sachDAO;
    public SachAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Sach> arrayList, SachDAO sachDAO){
        this.arrayList = arrayList;
        this.sachDAO = sachDAO;
    }

    @NonNull
    @Override
    public SachAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SachAdapter.ViewHolder holder, int position) {
        Sach sach = arrayList.get(position);
        Glide.with(context).load(arrayList.get(position).getImage()).fitCenter()
                .placeholder(R.drawable.ic_launcher_background).into(holder.imageSach);
        holder.tvNameSach.setText(arrayList.get(position).getTen_sach());
        holder.tv_TacGia.setText(arrayList.get(position).getTac_gia());
        holder.tv_NXB.setText(arrayList.get(position).getNha_xuat_ban());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.imgBinSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        long res = sachDAO.deleteSach(sach);
                        if (res != 0 ){
                            Toast.makeText(context, "Xóa Thành công", Toast.LENGTH_SHORT).show();
                            arrayList.remove(sach);
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
        holder.imgEditSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageSach,imgBinSach,imgEditSach;
        private TextView tvNameSach,tv_TacGia,tv_NXB;
        private LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSach = itemView.findViewById(R.id.imgSach);
            imgBinSach = itemView.findViewById(R.id.imgBinSach);
            imgEditSach = itemView.findViewById(R.id.imgEditSach);
            tvNameSach = itemView.findViewById(R.id.tvNameSach);
            tv_TacGia = itemView.findViewById(R.id.tv_tacGia);
            tv_NXB = itemView.findViewById(R.id.tv_NXB);
            linearLayout = itemView.findViewById(R.id.layout_detail);
        }
    }
}

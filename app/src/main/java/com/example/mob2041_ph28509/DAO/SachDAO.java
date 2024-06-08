package com.example.mob2041_ph28509.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.mob2041_ph28509.DbHelper.DbHelper;
import com.example.mob2041_ph28509.Model.Sach;
import com.example.mob2041_ph28509.Model.Sach;

import java.time.LocalDate;
import java.util.ArrayList;

public class SachDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    public SachDAO(Context context){dbHelper = new DbHelper(context);}
    public void open(){db = dbHelper.getWritableDatabase();}
    public void close(){ dbHelper.close();}
    public long insertNew(Sach sach){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Sach.COL_Ma_Sach,generateNewMaSach());
        contentValues.put(Sach.COL_TenSach,sach.getTen_sach());
        contentValues.put(Sach.COL_TacGia, sach.getTac_gia());
        contentValues.put(Sach.COL_NXB,sach.getNha_xuat_ban());
        contentValues.put(Sach.COL_MoTa,sach.getMo_ta());
        contentValues.put(Sach.COL_SL,sach.getSo_luong());
        contentValues.put(Sach.COL_TinhTrang,sach.getTinh_trang());
        contentValues.put(Sach.COL_Image,sach.getImage());
        contentValues.put(Sach.COL_MaLoaiSach,sach.getMa_loai_sach());
        long res = db.insert(Sach.TB_NAME,null,contentValues);
        return res;
    }
    public String generateNewMaSach() {
        String query = "SELECT ma_sach FROM Sach ORDER BY ma_Sach DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        String newMaSach = "S1";
        if (cursor.moveToFirst()) {
            String lastMaSach = cursor.getString(0);
            int newNumber = Integer.parseInt(lastMaSach.substring(1)) + 1;
            newMaSach = "S" + newNumber;
        }

        cursor.close();
        return newMaSach;
    }
    public long editSach(Sach sach){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Sach.COL_Ma_Sach,sach.getMa_sach());
        contentValues.put(Sach.COL_TenSach,sach.getTen_sach());
        contentValues.put(Sach.COL_TacGia, sach.getTac_gia());
        contentValues.put(Sach.COL_NXB,sach.getNha_xuat_ban());
        contentValues.put(Sach.COL_MoTa,sach.getMo_ta());
        contentValues.put(Sach.COL_SL,sach.getSo_luong());
        contentValues.put(Sach.COL_TinhTrang,sach.getTinh_trang());
        contentValues.put(Sach.COL_Image,sach.getImage());
        contentValues.put(Sach.COL_MaLoaiSach,sach.getMa_loai_sach());
        long res = db.update(Sach.TB_NAME,contentValues,"ma_sach = ? ",new String[]{sach.getMa_sach()+""});
        return res;
    }
    public long deleteSach(Sach sach){
        long res = db.delete(Sach.TB_NAME,"ma_sach = ?",new String[]{sach.getMa_sach()+""});
        return res;
    }

    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> arrayList = new ArrayList<>();
        String[] ds_cot = new String[]{"*"};

        // Thêm điều kiện WHERE role = 2 vào truy vấn SQL
        Cursor cursor = db.query(Sach.TB_NAME, ds_cot,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){
                Sach sach = new Sach();
                sach.setMa_sach(cursor.getString(0));
                sach.setTen_sach(cursor.getString(1));
                sach.setTac_gia(cursor.getString(2));
                sach.setNha_xuat_ban(cursor.getString(3));
                sach.setMo_ta(cursor.getString(4));
                sach.setSo_luong(cursor.getInt(5));
                sach.setTinh_trang(cursor.getString(6));
                sach.setImage(cursor.getString(7));
                sach.setMa_loai_sach(cursor.getString(8));
                arrayList.add(sach);
                cursor.moveToNext();
            }

        }

        // Đóng cursor
        cursor.close();

        return arrayList;
    }

}

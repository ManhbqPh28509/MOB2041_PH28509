package com.example.mob2041_ph28509.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mob2041_ph28509.DbHelper.DbHelper;
import com.example.mob2041_ph28509.Model.LoaiSach;
import com.example.mob2041_ph28509.Model.Sach;

import java.util.ArrayList;

public class LoaiSachDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    public LoaiSachDAO(Context context){dbHelper = new DbHelper(context);}
    public void open(){db = dbHelper.getWritableDatabase();}
    public void close(){ dbHelper.close();}
    public long insertNew(LoaiSach loaiSach){
        ContentValues contentValues = new ContentValues();
        contentValues.put(LoaiSach.COL_Ma_Loai_Sach,loaiSach.getMa_loai_sach());
        long res = db.insert(LoaiSach.TB_NAME,null,contentValues);
        return res;
    }
    public long editLoaiSach(LoaiSach loaiSach){
        ContentValues contentValues = new ContentValues();
        contentValues.put(LoaiSach.COL_Ma_Loai_Sach,loaiSach.getMa_loai_sach());
        long res = db.update(LoaiSach.TB_NAME,contentValues,"ma_loai_sach = ? ",new String[]{loaiSach.getMa_loai_sach()+""});
        return res;
    }
    public long deleteLoaiSach(LoaiSach loaiSach){
        long res = db.delete(LoaiSach.TB_NAME,"ma_loai_sach = ? ",new String[]{loaiSach.getMa_loai_sach()+""});
        return res;
    }
    public ArrayList<LoaiSach> selectAll() {
        ArrayList<LoaiSach> arrayList = new ArrayList<>();
        String[] ds_cot = new String[]{"*"};

        // Thêm điều kiện WHERE role = 2 vào truy vấn SQL
        Cursor cursor = db.query(LoaiSach.TB_NAME, ds_cot,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){
                LoaiSach loaiSach = new LoaiSach();
                loaiSach.setMa_loai_sach(cursor.getString(0));
                arrayList.add(loaiSach);
                cursor.moveToNext();
            }

        }

        // Đóng cursor
        cursor.close();

        return arrayList;
    }
}

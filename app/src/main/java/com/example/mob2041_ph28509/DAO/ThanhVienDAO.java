package com.example.mob2041_ph28509.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mob2041_ph28509.DbHelper.DbHelper;
import com.example.mob2041_ph28509.Model.ThanhVien;

import java.time.LocalDate;
import java.util.ArrayList;

public class ThanhVienDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    public ThanhVienDAO(Context context){dbHelper = new DbHelper(context);}
    public void open(){db = dbHelper.getWritableDatabase();}
    public void close(){ dbHelper.close();}
    public long insertNew(ThanhVien thanhVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThanhVien.COL_Ma_TV,generateNewMaThanhVien());
        contentValues.put(ThanhVien.COL_HoTen,thanhVien.getHoten());
        contentValues.put(ThanhVien.COL_NgaySinh, String.valueOf(thanhVien.getNgaysinh()));
        contentValues.put(ThanhVien.COL_Email,thanhVien.getEmail());
        contentValues.put(ThanhVien.COL_SDT,thanhVien.getSdt());
        contentValues.put(ThanhVien.COL_MatKhau,thanhVien.getMatkhau());
        long res = db.insert(ThanhVien.TB_NAME,null,contentValues);
        return res;
    }
    public String generateNewMaThanhVien() {
        String query = "SELECT ma_thanh_vien FROM Thanh_Vien ORDER BY ma_thanh_vien DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        String newMaThanhVien = "TV1";
        if (cursor.moveToFirst()) {
            String lastMaThanhVien = cursor.getString(0);
            int newNumber = Integer.parseInt(lastMaThanhVien.substring(2)) + 1;
            newMaThanhVien = "TV" + newNumber;
        }

        cursor.close();
        return newMaThanhVien;
    }

    public ArrayList<ThanhVien> selectAll() {
        ArrayList<ThanhVien> arrayList = new ArrayList<>();
        String[] ds_cot = new String[]{"*"};

        // Thêm điều kiện WHERE role = 2 vào truy vấn SQL
        Cursor cursor = db.query(ThanhVien.TB_NAME, ds_cot,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()){
                ThanhVien thanhVien = new ThanhVien();
                thanhVien.setMa_thanh_vien(cursor.getString(0));
                thanhVien.setHoten(cursor.getString(1));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    thanhVien.setNgaysinh(LocalDate.parse(cursor.getString(2)));
                }
                thanhVien.setEmail(cursor.getString(3));
                thanhVien.setSdt(cursor.getInt(4));
                thanhVien.setMatkhau(cursor.getString(5));
                arrayList.add(thanhVien);
                cursor.moveToNext();
            }

        }

        // Đóng cursor
        cursor.close();

        return arrayList;
    }
}

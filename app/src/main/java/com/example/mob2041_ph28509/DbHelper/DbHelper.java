package com.example.mob2041_ph28509.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb";
    private static final int DATABASE_VERSION = 1;
    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TV = "CREATE TABLE Thanh_Vien (ma_thanh_vien text primary key, hoten text not null, ngaysinh date not null, sdt integer not null, diachi text not null, matkhau text not null, email text not null)";
        db.execSQL(CREATE_TABLE_TV);
        db.execSQL("INSERT INTO Thanh_Vien VALUES ('TV1','Bùi Quang Mạnh','2003-02-09','0984938203','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','manh123','manhbqph28509@fpt.edu.vn')," +
                "('TV2','Nguyễn Thế Việt','2003-09-08','0984943646','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','viet123','theviet89@gmail.com')");
        String CREATE_TABLE_TT = "CREATE TABLE Thu_Thu (ma_thanh_vien text primary key, hoten text not null, ngaysinh date not null, sdt integer not null, diachi text not null, matkhau text not null, email text not null)";
        db.execSQL(CREATE_TABLE_TT);
        db.execSQL("INSERT INTO Thanh_Vien VALUES ('TT1','Bùi Quang Mạnh','2003-02-09','0984938203','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','manh123','manhbqph28508@fpt.edu.vn')," +
                "('TT2','Nguyễn Thế Việt','2003-09-08','0984943646','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','viet123','theviet189@gmail.com')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Thanh_Vien");
        db.execSQL("DROP TABLE IF EXISTS Thu_Thu");
        onCreate(db);
    }
}

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
        db.execSQL("INSERT INTO Thu_Thu VALUES ('TT1','Bùi Quang Mạnh','2003-02-09','0984938203','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','manh123','manhbqph28508@fpt.edu.vn')," +
                "('TT2','Nguyễn Thế Việt','2003-09-08','0984943646','37 ngõ 25 ngách 106 Phú Minh Phương Minh Khai, Quận Bắc Từ Liêm, Hà Nội','viet123','theviet189@gmail.com')");
        String CREATE_TABLE_LOAISACH="CREATE TABLE Loai_Sach(ma_loai_sach text primary key)";
        db.execSQL(CREATE_TABLE_LOAISACH);
        db.execSQL("INSERT INTO Loai_Sach(ma_loai_sach) VALUES('Tiểu Thuyết'),('Kỹ Năng Sống'),('Lịch Sử'),('Trinh Thám'),('Tâm Linh')");
        String CREATE_TABLE_SACH ="CREATE TABLE Sach(ma_sach text primary key, ten_sach text not null, tac_gai text not null, nha_xuat_ban text not null, mo_ta text not null, so_luong integer not null, tinh_trang text not null,image text not null,ma_loai_sach text REFERENCES Loai_Sach(ma_loai_sach) )";
        db.execSQL(CREATE_TABLE_SACH);
        db.execSQL("INSERT INTO Sach VALUES('S1','Đắc Nhân Tâm','Dale Carnegie','First National','\"Đắc Nhân Tâm\" của Dale Carnegie là cuốn sách kinh điển về nghệ thuật giao tiếp và ứng xử, cung cấp những nguyên tắc và kỹ năng để xây dựng mối quan hệ tốt đẹp với mọi người. Cuốn sách tập trung vào việc thấu hiểu bản thân, tôn trọng người khác, và tạo ra những ảnh hưởng tích cực trong giao tiếp hàng ngày. Với những lời khuyên thực tế và dễ áp dụng, \"Đắc Nhân Tâm\" đã giúp hàng triệu người trên thế giới cải thiện kỹ năng giao tiếp và đạt được thành công trong cuộc sống cá nhân và sự nghiệp.',1,'Đã Mượn','https://m.media-amazon.com/images/I/51lbHL4PURL._SY445_SX342_.jpg','Kỹ Năng Sống'),('S2','Nhà Giả Kim','Paulo Coelho','Rocco','\"Nhà Giả Kim\" của Paulo Coelho là câu chuyện đầy mê hoặc về hành trình theo đuổi ước mơ của chàng chăn cừu Santiago. Bắt đầu từ một giấc mơ kỳ lạ về kho báu ẩn giấu, Santiago dấn thân vào cuộc phiêu lưu qua sa mạc, gặp gỡ nhiều người và học được những bài học quý giá về cuộc sống, tình yêu và ý nghĩa của việc lắng nghe trái tim mình. Đây là một câu chuyện đầy cảm hứng về sự dũng cảm, kiên trì và niềm tin vào bản thân, khuyến khích người đọc khám phá và theo đuổi \"Huyền thoại Cá nhân\" của chính mình.',1,'Sẵn Sàng','https://nxbhcm.com.vn/Image/Biasach/nhagiakimTB2020.jpg','Tiểu Thuyết')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Thanh_Vien");
        db.execSQL("DROP TABLE IF EXISTS Thu_Thu");
        db.execSQL("DROP TABLE IF EXISTS Loai_Sach ");
        db.execSQL("DROP TABLE IF EXISTS Sach ");
        onCreate(db);
    }
}

package com.example.mob2041_ph28509.Model;

import java.time.LocalDate;

public class ThanhVien {
    private String ma_thanh_vien, hoten, diachi, email, matkhau;
    private int sdt;
    private LocalDate ngaysinh;

    public static final String TB_NAME = "TB_Thanh_Vien";
    public static final String COL_Ma_TV = "ma_thanh_vien";
    public static final String COL_HoTen = "hoten";
    public static final String COL_DiaChi = "diachi";
    public static final String COL_Email = "email";
    public static final String COL_MatKhau = "matkhau";
    public static final String COL_SDT = "sdt";
    public static final String COL_NgaySinh = "ngaysinh";

    public ThanhVien() {
    }

    public ThanhVien(String ma_thanh_vien, String hoten, String diachi, String email, String matkhau, int sdt, LocalDate ngaysinh) {
        this.ma_thanh_vien = ma_thanh_vien;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.matkhau = matkhau;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
    }

    public String getMa_thanh_vien() {
        return ma_thanh_vien;
    }

    public void setMa_thanh_vien(String ma_thanh_vien) {
        this.ma_thanh_vien = ma_thanh_vien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
}

package com.example.mob2041_ph28509.Model;

public class Sach {
    private String ma_sach,ten_sach,tac_gia,nha_xuat_ban,mo_ta,tinh_trang,ma_loai_sach,image;
    private Integer so_luong;

    public static final String TB_NAME = "Sach";
    public static final String COL_Ma_Sach = "ma_sach";
    public static final String COL_TenSach = "ten_sach";
    public static final String COL_TacGia = "tac_gia";
    public static final String COL_NXB = "nha_xuat_ban";
    public static final String COL_MoTa = "mo_ta";
    public static final String COL_SL = "so_luong";
    public static final String COL_TinhTrang = "tinh_trang";
    public static final String COL_Image = "iamge";
    public static final String COL_MaLoaiSach ="ma_loai_sach";

    public Sach() {
    }


    public Sach(String ma_sach, String ten_sach, String tac_gia, String nha_xuat_ban, String mo_ta, String tinh_trang, String ma_loai_sach, String image, Integer so_luong) {
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.tac_gia = tac_gia;
        this.nha_xuat_ban = nha_xuat_ban;
        this.mo_ta = mo_ta;
        this.tinh_trang = tinh_trang;
        this.ma_loai_sach = ma_loai_sach;
        this.image = image;
        this.so_luong = so_luong;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getNha_xuat_ban() {
        return nha_xuat_ban;
    }

    public void setNha_xuat_ban(String nha_xuat_ban) {
        this.nha_xuat_ban = nha_xuat_ban;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public String getMa_loai_sach() {
        return ma_loai_sach;
    }

    public void setMa_loai_sach(String ma_loai_sach) {
        this.ma_loai_sach = ma_loai_sach;
    }

    public Integer getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(Integer so_luong) {
        this.so_luong = so_luong;
    }
}

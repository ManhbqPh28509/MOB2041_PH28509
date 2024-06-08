package com.example.mob2041_ph28509.Model;

public class LoaiSach {
    private String ma_loai_sach;
    public static final String TB_NAME = "Loai_Sach";
    public static final String COL_Ma_Loai_Sach = "ma_loai_sach";

    public LoaiSach() {
    }
    public LoaiSach(String ma_loai_sach) {
        this.ma_loai_sach = ma_loai_sach;
    }

    public String getMa_loai_sach() {
        return ma_loai_sach;
    }

    public void setMa_loai_sach(String ma_loai_sach) {
        this.ma_loai_sach = ma_loai_sach;
    }
}

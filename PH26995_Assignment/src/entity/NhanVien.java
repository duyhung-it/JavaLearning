/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class NhanVien {

    private String maNV;
    private String hoTen;
    private double luong;

    public double getThueTN(double luong) {
        double thue;
        if (luong > 15) {
            thue = luong * 12.0 / 100;
        } else if (luong <= 15 && luong >= 9) {
            thue = luong * 10.0 / 100;
        } else {
            thue = 0;
        }
        return thue;
    }

    public double getThuNhap() {
        return (this.luong - getThueTN(this.luong));
    }

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void xuatThongTin() {
        System.out.println("MaNV: " + maNV + " - " + "HoTen: " + hoTen + " - " + "ThuNhap: " + getThuNhap());
    }
}

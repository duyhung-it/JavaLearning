/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hung-PC
 */
public class TiepThi extends NhanVien {

    private double doanhSo;
    private double hoaHong;

    @Override
    public double getThuNhap() {
        double thuong = doanhSo * ((double) hoaHong / 100);
        double luongThuc = thuong + super.getLuong() - super.getThueTN(super.getLuong());
        return luongThuc;
    }

    public TiepThi() {
    }

    public TiepThi(double doanhSo, double hoaHong) {
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public TiepThi(double doanhSo, double hoaHong, String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }

}

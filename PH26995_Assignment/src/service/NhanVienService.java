/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.NhanVien;
import entity.TiepThi;
import entity.TruongPhong;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author Hung-PC
 */
public class NhanVienService {

    public NhanVien nhapHanhChinh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin nhan vien hanh chinh.");
        System.out.print("Nhap ma: ");
        String ma = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        NhanVien nhanVien = new NhanVien(ma, hoTen, luong);
        return nhanVien;
    }

    public TruongPhong nhapTruongPhong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin truong phong.");
        System.out.print("Nhap ma: ");
        String ma = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        System.out.print("Nhap luong trach nhiem: ");
        double trachNhiem = Double.valueOf(scanner.nextLine());
        TruongPhong truongPhong = new TruongPhong(trachNhiem, ma, hoTen, luong);
        return truongPhong;
    }

    public TiepThi nhapTiepThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin nhan vien tiep thi.");
        System.out.print("Nhap ma: ");
        String ma = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        System.out.print("Nhap doanh so: ");
        double doanhSo = Double.valueOf(scanner.nextLine());
        System.out.print("Nhap hoa hong(%): ");
        double hoaHong = Double.valueOf(scanner.nextLine());
        TiepThi tiepThi = new TiepThi(doanhSo, hoaHong, ma, hoTen, luong);
        return tiepThi;
    }

    public ArrayList<NhanVien> timNhanVien(ArrayList<NhanVien> listNhanViens, String maNV) {
        ArrayList<NhanVien> timNhanViens = new ArrayList<>();
        for (NhanVien n : listNhanViens) {
            if (n.getMaNV().contains(maNV)) {
                timNhanViens.add(n);
            }
        }
        return timNhanViens;
    }

    public ArrayList<NhanVien> timNhanVienTheoLuong(ArrayList<NhanVien> listNhanViens, double max, double min) {
        ArrayList<NhanVien> timNhanViens = new ArrayList<>();
        for (NhanVien n : listNhanViens) {
            if (n.getLuong() >= min && n.getLuong() <= max) {
                timNhanViens.add(n);
            }
        }
        return timNhanViens;
    }

    public boolean xoaNhanVien(ArrayList<NhanVien> listNhanViens, String maNV) {
        int n = listNhanViens.size();
        for (int i = 0; i < n; i++) {
            if (listNhanViens.get(i).getMaNV().equals(maNV)) {
                listNhanViens.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean capNhat(ArrayList<NhanVien> listNhanViens, String maNV) {
        for (NhanVien n : listNhanViens) {
            if (n.getMaNV().equalsIgnoreCase(maNV)) {
                String className = n.getClass().getSimpleName();
                int setCase = className.equals("TruongPhong") ? 1 : (className.equals("TiepThi") ? 2 : 3);
                switch (setCase) {
                    case 1:
                        return capNhatTruongPhong((TruongPhong) n);
                    case 2:
                        return capNhatTiepThi((TiepThi) n);
                    case 3:
                        return capNhapHanhChinh(n);
                    default:
                        System.out.println("Fail!");
                }
            }
        }
        return false;
    }

    private boolean capNhatTruongPhong(TruongPhong truongPhong) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cap nhat thong tin truong phong: ");
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        truongPhong.setHoTen(hoTen);
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        truongPhong.setLuong(luong);
        System.out.print("Nhap luong trach nhiem: ");
        double trachNhiem = Double.valueOf(scanner.nextLine());
        truongPhong.setTrachNhiem(trachNhiem);
        return true;
    }

    private boolean capNhatTiepThi(TiepThi tiepThi) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cap nhat thong tin tiep thi: ");
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        tiepThi.setHoTen(hoTen);
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        tiepThi.setLuong(luong);
        System.out.print("Nhap doanh so: ");
        double doanhSo = Double.valueOf(scanner.nextLine());
        tiepThi.setDoanhSo(doanhSo);
        System.out.print("Nhap hoa hong: ");
        double hoaHong = Double.valueOf(scanner.nextLine());
        tiepThi.setHoaHong(hoaHong);
        return true;
    }

    private boolean capNhapHanhChinh(NhanVien nhanVien) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cap nhat thong tin hanh chinh: ");
        System.out.print("Nhap ten: ");
        String hoTen = scanner.nextLine();
        nhanVien.setHoTen(hoTen);
        System.out.print("Nhap luong: ");
        double luong = Double.valueOf(scanner.nextLine());
        nhanVien.setLuong(luong);
        return true;
    }

    public void sapXepTheoTen(ArrayList<NhanVien> listNhanViens) {
        listNhanViens.sort((n1, n2) -> n1.getHoTen().compareTo(n2.getHoTen()));
    }

    public void sapXepTheoThuNhap(ArrayList<NhanVien> listNhanViens) {
        listNhanViens.sort((n1, n2) -> (int) (n1.getThuNhap() - n2.getThuNhap()));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.NhanVien;
import java.util.ArrayList;
import java.util.Scanner;
import service.NhanVienService;

/**
 *
 * @author Hung-PC
 */
public class Main {

    private void menu() {
        System.out.println("---------MENU---------");
        System.out.println("1.Nhap danh sach nhan vien.");
        System.out.println("2.Xuat danh sach nhan vien.");
        System.out.println("3.Tim va hien thi nhan vien theo ma.");
        System.out.println("4.Xoa nhan vien theo ma.");
        System.out.println("5.Cap nhap thong tin nhan vien theo ma.");
        System.out.println("6.Tim cac nhan vien theo khoang luong.");
        System.out.println("7.Sap xep nhan vien theo ho va ten.");
        System.out.println("8.Sap xep nhan vien theo thu nhap");
        System.out.println("9.Xuat 5 nhan vien co thu nhap cao nhat.");
        System.out.println("0.Thoat chuong trinh.");
        System.out.println("-----------------------");
        System.out.print("Moi ban chon chuc nang: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int function = 0;
        ArrayList<NhanVien> listNhanViens = new ArrayList<>();
        NhanVienService nhanVienService = new NhanVienService();
        do {
            new Main().menu();
            function = Integer.valueOf(scanner.nextLine());
            switch (function) {
                case 1:
                    System.out.println("Chon nhan vien muon nhap:");
                    System.out.print("\"1-Truong phong, 2-Tiep thi, 3-Hanh chinh\":");
                    int choice = Integer.valueOf(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            while (true) {
                                listNhanViens.add(nhanVienService.nhapTruongPhong());
                                System.out.print("Ban muon nhap tiep khong (Y-Co,N-Khong): ");
                                String check = scanner.nextLine();
                                if (check.equalsIgnoreCase("N")) {
                                    break;
                                }
                            }
                            break;
                        case 2:
                            while (true) {
                                listNhanViens.add(nhanVienService.nhapTiepThi());
                                System.out.print("Ban muon nhap tiep khong (Y-Co,N-Khong): ");
                                String check = scanner.nextLine();
                                if (check.equalsIgnoreCase("N")) {
                                    break;
                                }
                            }
                            break;
                        case 3:
                            while (true) {
                                listNhanViens.add(nhanVienService.nhapHanhChinh());
                                System.out.print("Ban muon nhap tiep khong (Y-Co,N-Khong): ");
                                String check = scanner.nextLine();
                                if (check.equalsIgnoreCase("N")) {
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Misson fail.");
                    }
                    break;
                case 2:
                    if (!listNhanViens.isEmpty()) {
                        System.out.println("Thong tin nhan vien:");
                        listNhanViens.forEach(nhanVien -> nhanVien.xuatThongTin());
                    } else {
                        System.out.println(">>Danh sach dang rong!");
                    }
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien muon tim: ");
                    String maNV_search = scanner.nextLine();
                    ArrayList<NhanVien> findById = nhanVienService.timNhanVien(listNhanViens, maNV_search);
                    if (findById.isEmpty()) {
                        System.out.println("Khong tim thay nhan vien.");
                    } else {
                        findById.forEach(nhanVien -> nhanVien.xuatThongTin());
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma nhan vien muon xoa: ");
                    String maNV_remove = scanner.nextLine();
                    if (nhanVienService.xoaNhanVien(listNhanViens, maNV_remove)) {
                        System.out.println("Xoa thanh cong.");
                    } else {
                        System.out.println("Khong tim thay nhan vien muon xoa.");
                    }
                    break;
                case 5:
                    System.out.print("Nhap ma nhan vien muon cap nhat: ");
                    String maNV_update = scanner.nextLine();
                    if (nhanVienService.capNhat(listNhanViens, maNV_update)) {
                        System.out.println("Cap nhat thanh cong.");
                    } else {
                        System.out.println("Cap nhat that bai.");
                    }
                    break;
                case 6:
                    System.out.print("Nhap luong max: ");
                    double max = Double.valueOf(scanner.nextLine());
                    System.out.print("Nhap luong min: ");
                    double min = Double.valueOf(scanner.nextLine());
                    ArrayList<NhanVien> findBySalary = nhanVienService.timNhanVienTheoLuong(listNhanViens, max, min);
                    if (!findBySalary.isEmpty()) {
                        findBySalary.forEach(nhanVien -> nhanVien.xuatThongTin());
                    } else {
                        System.out.println("Khong tim thay nhan vien.");
                    }
                    break;
                case 7:
                    nhanVienService.sapXepTheoTen(listNhanViens);
                    System.out.println("Danh sach da sap xep theo ten.");
                    break;
                case 8:
                    nhanVienService.sapXepTheoThuNhap(listNhanViens);
                    System.out.println("Danh sach da sap xep theo thu nhap.");
                    break;
                case 9:
                    if (!listNhanViens.isEmpty()) {
                        System.out.println("Top 5 nhan vien luong cao nhat: ");
                        nhanVienService.sapXepTheoThuNhap(listNhanViens);
                        int count = 0;
                        for (int i = listNhanViens.size() - 1; i >= 0; i--) {
                            listNhanViens.get(i).xuatThongTin();
                            count++;
                            if (count == 5) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Danh sach rong!");
                    }
                    break;
                case 0:
                    System.out.println("Thank kiu!");
                    break;
                default:
                    System.out.println("Chuc nang khong ton tai!");
            }
        } while (function != 0);
    }
}

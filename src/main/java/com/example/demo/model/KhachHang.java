package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho_ten")
    private String hoten;
    @Column(name = "dia_chi")
    private String diachi;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Column(name = "ngay_sua")
    private Date ngaysua;

    @Override
    public String toString() {
        return "KhachHang{" +
                "id=" + id +
                ", hoten='" + hoten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt=" + sdt +
                ", trangthai='" + trangthai + '\'' +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                '}';
    }
}

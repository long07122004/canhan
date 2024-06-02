package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ctsp")
@Entity
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idctsp;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanpham;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mausac;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private SizeSp sizesp;
    @Column(name = "gia_ban")
    private String giaban;
    @Column(name = "so_luong_ton")
    private String soluongton;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Column(name = "ngay_sua")
    private  Date ngaysua;

    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "id=" + idctsp +
                ", sanpham=" + sanpham +
                ", mausac=" + mausac +
                ", sizesp=" + sizesp +
                ", giaban=" + giaban +
                ", soluongton=" + soluongton +
                ", trangthai='" + trangthai + '\'' +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                '}';
    }
}

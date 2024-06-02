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
@Table(name ="hdct")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private ChiTietSanPham chiTietSanPham;
    @Column(name = "so_luong_mua")
    private String soluong;
    @Column(name = "gia_ban")
    private String giaban;
    @Column(name = "tong_tien")
    private Double tongtien;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Column(name = "ngay_sua")
    private  Date ngaysua;

    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "id=" + id +
                ", hoaDon=" + hoaDon +
                ", chiTietSanPham=" + chiTietSanPham +
                ", soluong='" + soluong + '\'' +
                ", giaban='" + giaban + '\'' +
                ", tongtien='" + tongtien + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                '}';
    }
}

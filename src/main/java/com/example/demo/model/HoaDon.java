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
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Column(name = "ngay_sua")
    private Date ngaysua;
    @Column(name = "dia_chi")
    private String diachi;
    @Column(name = "so_dien_thoai")
    private String sdt;
    @Column(name = "trang_thai")
    private String trangthai;

    @Override
    public String toString() {
        return "HoaDon{" +
                "id=" + id +
                ", khachHang=" + khachHang +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", trangthai='" + trangthai + '\'' +
                '}';
    }
}

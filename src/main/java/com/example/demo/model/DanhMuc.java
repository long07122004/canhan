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
@Table (name ="danh_muc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_danh_muc")
    private String madanhmuc;
    @Column(name = "ten_danh_muc")
    private String tendanhmuc;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Column(name = "ngay_sua")
    private Date ngaysua;

    @Override
    public String toString() {
        return "DanhMuc{" +
                "id=" + id +
                ", madanhmuc='" + madanhmuc + '\'' +
                ", tendanhmuc='" + tendanhmuc + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                '}';
    }
}

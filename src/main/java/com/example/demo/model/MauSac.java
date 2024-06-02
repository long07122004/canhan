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
@Table(name = "mau_sac")
@Entity
public class MauSac {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma_mau")
    private String mamau;
    @Column(name = "ten_mau")
    private  String tenmau;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_sua")
    private Date ngaysua;
    @Column(name = "ngay_tao")
    private Date ngaytao;

    @Override
    public String toString() {
        return "MauSac{" +
                "id=" + id +
                ", mamau='" + mamau + '\'' +
                ", tenmau='" + tenmau + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", ngaysua=" + ngaysua +
                ", ngaytao=" + ngaytao +
                '}';
    }
}

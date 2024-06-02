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
@Table(name = "size")
@Entity
public class SizeSp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma_size")
    private String masize;
    @Column(name = "ten_size")
    private  String tensize;
    @Column(name = "trang_thai")
    private String trangthai;
    @Column(name = "ngay_sua")
    private Date ngaysua;
    @Column(name = "ngay_tao")
    private Date ngaytao;

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", masize='" + masize + '\'' +
                ", tensize='" + tensize + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", ngaysua=" + ngaysua +
                ", ngaytao=" + ngaytao +
                '}';
    }
}

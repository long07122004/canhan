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
@Table(name = "san_pham")
@Entity
public class SanPham {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Integer id;
@Column(name = "ma_san_pham")
    private String masanpham;
    @Column(name = "ten_san_pham")
    private String tensanpham;
  @Column(name = "trang_thai")
    private String trangthai;
  @Column(name = "ngay_tao")
    private Date ngaytao;
  @Column(name = "ngay_sua")
    private  Date ngaysua;

@ManyToOne
@JoinColumn(name = "id_danh_muc")
    private DanhMuc danhmuc;

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", masanpham='" + masanpham + '\'' +
                ", tensanpham='" + tensanpham + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", ngaytao=" + ngaytao +
                ", ngaysua=" + ngaysua +
                ", danhmuc=" + danhmuc +
                '}';
    }
}

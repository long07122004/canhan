package com.example.demo.views;

import com.example.demo.Repostory.ChiTietSanPhamRep;
import com.example.demo.Repostory.HoaDonChiTietRep;
import com.example.demo.Repostory.HoaDonRep;
import com.example.demo.Repostory.KhachHangRep;
import com.example.demo.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "asmServlet", value = {"/asm/trangchu", "/taohoadon", "/taohoadon/detal", "/hoadonchitiet/add"})
public class asmServlet extends HttpServlet {
    HoaDonRep hoaDonRep = new HoaDonRep();
    ChiTietSanPhamRep chiTietSanPhamRep = new ChiTietSanPhamRep();
    HoaDonChiTietRep hoaDonChiTietRep = new HoaDonChiTietRep();
      KhachHangRep khachHangRep = new KhachHangRep();

    ArrayList<HoaDon> listHoaDon;
    ArrayList<HoaDonChiTiet> listHoaDonChiTiet;
    ArrayList<ChiTietSanPham> listChiTietSanPham;
    ArrayList<KhachHang> listkhachhang;
    HoaDon hoaDondetal;

    Integer idhoadon;
    Double tongtien;



    public asmServlet() {
        listHoaDon = new ArrayList<>();
        listHoaDonChiTiet = new ArrayList<>();
        listChiTietSanPham = new ArrayList<>();
        hoaDondetal = new HoaDon();
        listkhachhang = new ArrayList<>();
        idhoadon = 0;
        tongtien = (double) 0L;


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/asm/trangchu")) {
            listHoaDon = hoaDonRep.getList();
               listkhachhang = khachHangRep.getList();
            listChiTietSanPham = chiTietSanPhamRep.getList();
              listHoaDonChiTiet = hoaDonChiTietRep.getList(idhoadon);
            request.setAttribute("listHoaDon", listHoaDon);
            request.setAttribute("listkhachhang", listkhachhang);
            request.setAttribute("listChiTietSanPham", listChiTietSanPham);
            request.setAttribute("listHoaDonChiTiet", listHoaDonChiTiet);
            request.setAttribute("hoaDondetal", hoaDondetal);
            request.setAttribute("tongtien", tongtien);

            request.getRequestDispatcher("/views/x.jsp").forward(request, response);


        } else if (uri.contains("/taohoadon/detal")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            idhoadon = id;
            hoaDondetal = hoaDonRep.getDetal(id);



            listHoaDonChiTiet = hoaDonChiTietRep.getList(id);
            tongtien = (double) 0;
            for (HoaDonChiTiet hoaDonChiTiet : listHoaDonChiTiet) {
                tongtien += hoaDonChiTiet.getTongtien();
            }




            response.sendRedirect("/asm/trangchu");
        }else if(uri.contains("/hoadonchitiet/add")){
            Integer idctsp = Integer.parseInt(request.getParameter("idctsp"));
//             idhoadon = Integer.parseInt(request.getParameter("idhoadon"));
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRep.getDetal(idctsp);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(idhoadon);
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setChiTietSanPham(chiTietSanPham);
            hoaDonChiTiet.setGiaban(chiTietSanPham.getGiaban());
            hoaDonChiTiet.setSoluong(String.valueOf(1));
            hoaDonChiTiet.setNgaysua(new Date());
            hoaDonChiTiet.setNgaytao(new Date());
            hoaDonChiTiet.setTongtien(Double.valueOf(chiTietSanPham.getGiaban()));
            hoaDonChiTietRep.add(hoaDonChiTiet);
            response.sendRedirect("/asm/trangchu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/taohoadon")) {
            double tongtienrep = Double.parseDouble(request.getParameter("tongtien"));
            if (tongtienrep == 0) {


 Integer idkhachhang = Integer.parseInt(request.getParameter("khachHang"));

                KhachHang kh =  khachHangRep.getDetal(idkhachhang);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setNgaysua(new Date());
                hoaDon.setNgaytao(new Date());
                hoaDon.setKhachHang(kh);

                hoaDon.setTrangthai("Chua thanh toan");

                hoaDonRep.add(hoaDon);
                response.sendRedirect("/asm/trangchu");
            }else {
                Integer idhoadon = Integer.parseInt(request.getParameter("idhoadon"));
                HoaDon hoaDonDetal = hoaDonRep.getDetal(idhoadon);
                hoaDonDetal.setNgaysua(new Date());
                hoaDonDetal.setTrangthai("Da thanh toan");
                hoaDonRep.add(hoaDonDetal);
                response.sendRedirect("/asm/trangchu");

            }
        }

    }
}

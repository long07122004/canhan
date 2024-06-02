package com.example.demo.views;

import com.example.demo.Repostory.HoaDonRep;
import com.example.demo.Repostory.KhachHangRep;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.HoaDon;
import com.example.demo.model.KhachHang;
import com.example.demo.model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "HoaDonServlet", value ={"/hoadon/trangchu","/hoadon/add","/hoadon/delete","/hoadon/detal","/hoadon/update"})
public class HoaDonServlet extends HttpServlet {
    ArrayList<KhachHang> khachHang = new ArrayList<>();
    KhachHangRep khachHangRep = new KhachHangRep();
    HoaDonRep hoaDonRep = new HoaDonRep();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/hoadon/trangchu")){
            ArrayList<HoaDon> listhd = hoaDonRep.getList();
            khachHang = khachHangRep.getList();
            request.setAttribute("khachHang",khachHang);
            request.setAttribute("listhd",listhd);
            request.getRequestDispatcher("/views/HoaDon.jsp").forward(request,response);
        }else if(uri.contains("/hoadon/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            HoaDon hoaDon = hoaDonRep.getDetal(id);
            hoaDonRep.delete(hoaDon);
            response.sendRedirect("/hoadon/trangchu");

        }else if(uri.equals("/hoadon/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            ArrayList<HoaDon> listhd = hoaDonRep.getList();
            khachHang = khachHangRep.getList();


            request.setAttribute("khachHang",khachHang);
            request.setAttribute("detal",hoaDonRep.getDetal(id));
            request.getRequestDispatcher("/detal/hoadondetal.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/hoadon/add")){
            String khachhang = request.getParameter("khachHang");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sdt");
            String trangthai = request.getParameter("trangthai");


            //   System.out.println(ten);

            HoaDon hd = new HoaDon();
            KhachHang khachHang1 = new KhachHang();
            khachHang1.setId(Integer.parseInt(khachhang));
            hd.setNgaytao(new Date());
            hd.setKhachHang(khachHang1);
            hd.setDiachi(diachi);
            hd.setSdt(sdt);
            hd.setTrangthai(trangthai);



            hoaDonRep.add(hd);
            response.sendRedirect("/hoadon/trangchu");
        }
        else if(uri.equals("/hoadon/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
//            ArrayList<SanPham> listsp = sanPhamRep.getList();
            khachHang = khachHangRep.getList();

            String khachhang = request.getParameter("khachHang");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sdt");
            String trangthai = request.getParameter("trangthai");

            //  System.out.println(ten);


            for (HoaDon hoaDon : hoaDonRep.getList()){
                if(hoaDon.getId().equals(id)){
                    KhachHang khachHang1 = new KhachHang();
                    khachHang1.setId(Integer.parseInt(khachhang));
                    hoaDon.setNgaytao(new Date());
                    hoaDon.setKhachHang(khachHang1);
                    hoaDon.setDiachi(diachi);
                    hoaDon.setSdt(sdt);
                    hoaDon.setTrangthai(trangthai);
                    hoaDonRep.update(hoaDon);
                }

            }


            response.sendRedirect("/hoadon/trangchu");



        }


    }
}

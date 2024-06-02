package com.example.demo.views;

import com.example.demo.Repostory.*;
import com.example.demo.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "chitiethoadonServlet", value = {"/hdct/trangchu","/hdct/add","/hdct/delete","/hdct/detal","/hdct/update"})
public class chitiethoadonServlet extends HttpServlet {
    ArrayList<HoaDon> hoaDon = new ArrayList<>();
    ArrayList<ChiTietSanPham> chiTietSanPham = new ArrayList<>();

    HoaDonRep hoaDonRep = new HoaDonRep();
    ChiTietSanPhamRep chiTietSanPhamRep = new ChiTietSanPhamRep();
    Integer idhoadon = 0;

    private final HoaDonChiTietRep hoaDonChiTietRep = new HoaDonChiTietRep();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/hdct/trangchu")){
            ArrayList<HoaDonChiTiet> listhdct = hoaDonChiTietRep.getList(idhoadon);
            hoaDon = hoaDonRep.getList();
            chiTietSanPham = chiTietSanPhamRep.getList();

            request.setAttribute("hoaDon",hoaDon);
            request.setAttribute("chiTietSanPham",chiTietSanPham);

            request.setAttribute("listhdct",listhdct);
            request.getRequestDispatcher("/views/HoaDonChiTiet.jsp").forward(request,response);
        }else if(uri.contains("/hdct/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRep.getDetal(id);
            hoaDonChiTietRep.delete(hoaDonChiTiet);
            response.sendRedirect("/hdct/trangchu");

        }else if(uri.equals("/hdct/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            ArrayList<HoaDonChiTiet> listhdct = hoaDonChiTietRep.getList(id);
            hoaDon = hoaDonRep.getList();
            chiTietSanPham = chiTietSanPhamRep.getList();



            request.setAttribute("hoaDon",hoaDon);
            request.setAttribute("chiTietSanPham",chiTietSanPham);

            request.setAttribute("detal",hoaDonChiTietRep.getDetal(id));
            request.getRequestDispatcher("/detal/HoaDonChiTietDetal.jsp").forward(request,response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/hdct/add")){
            String hoadoon = request.getParameter("hoaDon");
            String chitietsanpham = request.getParameter("chiTietSanPham");
            String soluongmua = request.getParameter("soluong");
            String giaban = request.getParameter("giaban");

            String trangthai = request.getParameter("trangthai");


            //   System.out.println(ten);

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

            HoaDon hoaDon1 = new HoaDon();
            hoaDon1.setId(Integer.parseInt(hoadoon));
            hoaDonChiTiet.setHoaDon(hoaDon1);

            ChiTietSanPham chiTietSanPham1 = new ChiTietSanPham();
            chiTietSanPham1.setIdctsp(Integer.parseInt(chitietsanpham));
            hoaDonChiTiet.setChiTietSanPham(chiTietSanPham1);



            hoaDonChiTiet.setSoluong(soluongmua);
            hoaDonChiTiet.setGiaban(giaban);
            hoaDonChiTiet.setTrangthai(trangthai);
            hoaDonChiTiet.setNgaytao(new Date());


            hoaDonChiTietRep.add(hoaDonChiTiet);
            response.sendRedirect("/hdct/trangchu");
        }
        else if(uri.equals("/hdct/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
//            ArrayList<SanPham> listsp = sanPhamRep.getList();
            hoaDon = hoaDonRep.getList();
            chiTietSanPham = chiTietSanPhamRep.getList();


            String hoadoon = request.getParameter("hoaDon");
            String chitietsanpham = request.getParameter("chiTietSanPham");
            String soluongmua = request.getParameter("soluong");
            String giaban = request.getParameter("giaban");

            String trangthai = request.getParameter("trangthai");

            //  System.out.println(ten);


            for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietRep.getList(id)){
                if(hoaDonChiTiet.getId().equals(id)){
                    HoaDon hoaDon1 = new HoaDon();
                    hoaDon1.setId(Integer.parseInt(hoadoon));
                    hoaDonChiTiet.setHoaDon(hoaDon1);

                    ChiTietSanPham chiTietSanPham1 = new ChiTietSanPham();
                    chiTietSanPham1.setIdctsp(Integer.parseInt(chitietsanpham));
                    hoaDonChiTiet.setChiTietSanPham(chiTietSanPham1);



                    hoaDonChiTiet.setSoluong(soluongmua);
                    hoaDonChiTiet.setGiaban(giaban);
                    hoaDonChiTiet.setTrangthai(trangthai);
                    hoaDonChiTiet.setNgaysua(new Date());

                    hoaDonChiTietRep.update(hoaDonChiTiet);
                }

            }


            response.sendRedirect("/hdct/trangchu");



        }
    }
}

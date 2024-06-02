package com.example.demo.views;

import com.example.demo.Repostory.KhachHangRep;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", value = {"/khachhang/trangchu","/khachhang/delete","/khachhang/add","/khachhang/detal","/khachhang/update"})
public class KhachHangServlet extends HttpServlet {
    KhachHangRep khachHangRep = new KhachHangRep();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/khachhang/trangchu")){
            ArrayList<KhachHang> listkh = khachHangRep.getList();
            request.setAttribute("listkh",listkh);
            request.getRequestDispatcher("/views/KhachHang.jsp").forward(request,response);
        }else if(uri.contains("/khachhang/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            KhachHang khachHang = khachHangRep.getDetal(id);
            khachHangRep.delete(khachHang);
            response.sendRedirect("/khachhang/trangchu");
        }else if(uri.equals("/khachhang/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            //ArrayList<DanhMuc> listdm = danhMucRep.getList();

            request.setAttribute("detal",khachHangRep.getDetal(id));
            request.getRequestDispatcher("/detal/KhachHangdetal.jsp").forward(request,response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/khachhang/add")){
            String ten = request.getParameter("hoten");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sdt");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

            KhachHang kh = new KhachHang();
            kh.setHoten(ten);
            kh.setDiachi(diachi);
            kh.setSdt(sdt);
            kh.setTrangthai(trangthai);
            kh.setNgaytao(new Date());

            khachHangRep.add(kh);
            response.sendRedirect("/khachhang/trangchu");
        }else if(uri.equals("/khachhang/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            String ten = request.getParameter("hoten");
            String diachi = request.getParameter("diachi");
            String sdt = request.getParameter("sdt");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);


            for (KhachHang khachHang : khachHangRep.getList()){
                if(khachHang.getId().equals(id)){
                    khachHang.setHoten(ten);
                    khachHang.setDiachi(diachi);
                    khachHang.setSdt(sdt);
                    khachHang.setTrangthai(trangthai);
                    khachHangRep.update(khachHang);
                }
            }


            response.sendRedirect("/khachhang/trangchu");
        }
    }
}

package com.example.demo.views;

import com.example.demo.Repostory.DanhMucRep;
import com.example.demo.Repostory.SanPhamRep;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SanPhamServlet", value ={"/sanpham/trangchu","/sanpham/add","/sanpham/delete","/sanpham/detal","/sanpham/update"} )
public class SanPhamServlet extends HttpServlet {

    ArrayList<DanhMuc> listdanhmuc = new ArrayList<>();
    DanhMucRep danhMucRep = new DanhMucRep();
    SanPhamRep sanPhamRep = new SanPhamRep();


   // ArrayList<SanPham> listsp = rep.getList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/sanpham/trangchu")){
          ArrayList<SanPham> listsp = sanPhamRep.getList();
            listdanhmuc = danhMucRep.getList();
            request.setAttribute("listdanhmuc",listdanhmuc);
            request.setAttribute("listsp",listsp);
            request.getRequestDispatcher("/views/san-pham.jsp").forward(request,response);
        }else if(uri.contains("/sanpham/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = sanPhamRep.getDetal(id);
            sanPhamRep.delete(sanPham);
            response.sendRedirect("/sanpham/trangchu");

        }else if(uri.equals("/sanpham/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));
          //  SanPham sanPham = sanPhamRep.getDetal(id);
            ArrayList<SanPham> listsp = sanPhamRep.getList();
            listdanhmuc = danhMucRep.getList();


            request.setAttribute("listdanhmuc",listdanhmuc);
            request.setAttribute("spdetal",sanPhamRep.getDetal(id));
            request.getRequestDispatcher("/detal/san-pham-detal.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/sanpham/add")){
            String ma = request.getParameter("masanpham");
            String ten = request.getParameter("tensanpham");
            String trangthai = request.getParameter("trangthai");
          String iddanhmuc = request.getParameter("danhmuc");

      //   System.out.println(ten);

            SanPham sp = new SanPham();
            sp.setMasanpham(ma);
            sp.setTensanpham(ten);
            sp.setTrangthai(trangthai);
            sp.setNgaytao(new Date());
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setId(Integer.parseInt(iddanhmuc));
            sp.setDanhmuc(danhMuc);

            sanPhamRep.add(sp);
            response.sendRedirect("/sanpham/trangchu");
        }
        else if(uri.equals("/sanpham/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
//            ArrayList<SanPham> listsp = sanPhamRep.getList();
            listdanhmuc = danhMucRep.getList();

            String ma = request.getParameter("masanpham");
            String ten = request.getParameter("tensanpham");
            String trangthai = request.getParameter("trangthai");
            String iddanhmuc = request.getParameter("danhmuc");

          //  System.out.println(ten);


            for (SanPham sanPham : sanPhamRep.getList()){
                if(sanPham.getId().equals(id)){
                    sanPham.setMasanpham(ma);
                    sanPham.setTensanpham(ten);
                    sanPham.setTrangthai(trangthai);
                    sanPham.setNgaytao(new Date());
                    DanhMuc danhMuc = new DanhMuc();
                    danhMuc.setId(Integer.parseInt(iddanhmuc));
                    sanPham.setDanhmuc(danhMuc);
                    sanPhamRep.update(sanPham);
                }

            }


            response.sendRedirect("/sanpham/trangchu");



        }
    }
}

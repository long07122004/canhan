package com.example.demo.views;

import com.example.demo.Repostory.*;
import com.example.demo.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ChiTietSanPhamServlet", value = {"/ctsp/trangchu","/ctsp/add","/ctsp/delete","/ctsp/detal","/ctsp/update"} )
public class ChiTietSanPhamServlet extends HttpServlet {
    ArrayList<SanPham> sanPham = new ArrayList<>();
    ArrayList<MauSac> mauSac = new ArrayList<>();
    ArrayList<SizeSp> sizeSp = new ArrayList<>();
    SanPhamRep sanPhamRep = new SanPhamRep();
    MauSacRep mauSacRep = new MauSacRep();
    SizeRep sizeRep = new SizeRep();

    private final ChiTietSanPhamRep chiTietSanPhamRep = new ChiTietSanPhamRep();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/ctsp/trangchu")){
            ArrayList<ChiTietSanPham> listctsp = chiTietSanPhamRep.getList();
            sanPham = sanPhamRep.getList();
            mauSac = mauSacRep.getList();
            sizeSp = sizeRep.getList();
            request.setAttribute("sanPham",sanPham);
            request.setAttribute("mauSac",mauSac);
            request.setAttribute("sizeSp",sizeSp);
            request.setAttribute("listctsp",listctsp);
            request.getRequestDispatcher("/views/Chi-tiet-san-pham.jsp").forward(request,response);
        }else if(uri.contains("/ctsp/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRep.getDetal(id);
            chiTietSanPhamRep.delete(chiTietSanPham);
            response.sendRedirect("/ctsp/trangchu");

        }else if(uri.equals("/ctsp/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            ArrayList<ChiTietSanPham> listctsp = chiTietSanPhamRep.getList();
            sanPham = sanPhamRep.getList();
            mauSac = mauSacRep.getList();
            sizeSp = sizeRep.getList();


            request.setAttribute("sanPham",sanPham);
            request.setAttribute("mauSac",mauSac);
            request.setAttribute("sizeSp",sizeSp);
            request.setAttribute("detal",chiTietSanPhamRep.getDetal(id));
            request.getRequestDispatcher("/detal/chitietsanphandetal.jsp").forward(request,response);
        }





    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/ctsp/add")){
            String sanpham = request.getParameter("sanpham");
            String mausac = request.getParameter("mausac");
            String sizesp = request.getParameter("sizesp");
            String giaban = request.getParameter("giaban");
            String soluongton = request.getParameter("soluongton");
            String trangthai = request.getParameter("trangthai");


               System.out.println(giaban);

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

            SanPham sanPham1 = new SanPham();
            sanPham1.setId(Integer.parseInt(sanpham));
            chiTietSanPham.setSanpham(sanPham1);

            MauSac mauSac1 = new MauSac();
            mauSac1.setId(Integer.parseInt(mausac));
            chiTietSanPham.setMausac(mauSac1);

            SizeSp sizeSp1 = new SizeSp();
            sizeSp1.setId(Integer.parseInt(sizesp));
            chiTietSanPham.setSizesp(sizeSp1);

            chiTietSanPham.setGiaban(giaban);
            chiTietSanPham.setSoluongton(soluongton);
            chiTietSanPham.setTrangthai(trangthai);
            chiTietSanPham.setNgaytao(new Date());


            chiTietSanPhamRep.add(chiTietSanPham);
            response.sendRedirect("/ctsp/trangchu");
        }
        else if(uri.equals("/ctsp/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));
//            ArrayList<SanPham> listsp = sanPhamRep.getList();
            sanPham = sanPhamRep.getList();
            mauSac = mauSacRep.getList();
            sizeSp = sizeRep.getList();

            String sanpham = request.getParameter("sanpham");
            String mausac = request.getParameter("mausac");
            String sizesp = request.getParameter("sizesp");
            String giaban = request.getParameter("giaban");
            String soluongton = request.getParameter("soluongton");
            String trangthai = request.getParameter("trangthai");




            for (ChiTietSanPham chiTietSanPham : chiTietSanPhamRep.getList()){
                if(chiTietSanPham.getIdctsp().equals(id)){
                    SanPham sanPham1 = new SanPham();
                    sanPham1.setId(Integer.parseInt(sanpham));
                    chiTietSanPham.setSanpham(sanPham1);

                    MauSac mauSac1 = new MauSac();
                    mauSac1.setId(Integer.parseInt(mausac));
                    chiTietSanPham.setMausac(mauSac1);

                    SizeSp sizeSp1 = new SizeSp();
                    sizeSp1.setId(Integer.parseInt(sizesp));
                    chiTietSanPham.setSizesp(sizeSp1);

                    chiTietSanPham.setGiaban(giaban);
                    chiTietSanPham.setSoluongton(soluongton);
                    chiTietSanPham.setTrangthai(trangthai);

                    chiTietSanPham.setNgaysua(new Date());

                    chiTietSanPhamRep.update(chiTietSanPham);
                }

            }


            response.sendRedirect("/ctsp/trangchu");



        }
    }
}

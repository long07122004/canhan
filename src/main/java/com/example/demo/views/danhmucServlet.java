package com.example.demo.views;

import com.example.demo.Repostory.DanhMucRep;
import com.example.demo.model.DanhMuc;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "Servlet2", value = {"/danhmuc/trangchu","/danhmuc/delete","/danhmuc/add","/danhmuc/detal","/danhmuc/update"})
public class danhmucServlet extends HttpServlet {

    private final DanhMucRep danhMucRep = new DanhMucRep();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/danhmuc/trangchu")){
            ArrayList<DanhMuc> listdm = danhMucRep.getList();
            request.setAttribute("listdm",listdm);
            request.getRequestDispatcher("/views/danh-muc.jsp").forward(request,response);
        }else if(uri.contains("/danhmuc/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc danhMuc = danhMucRep.getDetal(id);
            danhMucRep.delete(danhMuc);
            response.sendRedirect("/danhmuc/trangchu");
        }else if(uri.equals("/danhmuc/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            //ArrayList<DanhMuc> listdm = danhMucRep.getList();

            request.setAttribute("detal",danhMucRep.getDetal(id));
            request.getRequestDispatcher("/detal/danh-muc-detal.jsp").forward(request,response);


        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uri = request.getRequestURI();
     if(uri.equals("/danhmuc/add")){
         String ma = request.getParameter("madanhmuc");
         String ten = request.getParameter("tendanhmuc");
         String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

         DanhMuc dm = new DanhMuc();
         dm.setMadanhmuc(ma);
         dm.setTendanhmuc(ten);
         dm.setTrangthai(trangthai);
         dm.setNgaytao(new Date());

         danhMucRep.add(dm);
         response.sendRedirect("/danhmuc/trangchu");
     }else if(uri.equals("/danhmuc/update")){
         Integer id = Integer.parseInt(request.getParameter("id"));

         String ma = request.getParameter("madanhmuc");
         String ten = request.getParameter("tendanhmuc");
         String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

         for (DanhMuc danhMuc : danhMucRep.getList()){
             if(danhMuc.getId().equals(id)){
                 danhMuc.setMadanhmuc(ma);
                 danhMuc.setTendanhmuc(ten);
                 danhMuc.setTrangthai(trangthai);
                 danhMucRep.update(danhMuc);
             }
         }


         response.sendRedirect("/danhmuc/trangchu");
     }



    }
}

package com.example.demo.views;

import com.example.demo.Repostory.DanhMucRep;
import com.example.demo.Repostory.MauSacRep;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "MauSacServlet", value = {"/mausac/trangchu","/mausac/add","/mausac/delete","/mausac/detal","/mausac/update"})
public class MauSacServlet extends HttpServlet {
    private final MauSacRep mauSacRep = new MauSacRep();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/mausac/trangchu")){
            ArrayList<MauSac> listms = mauSacRep.getList();
            request.setAttribute("listms",listms);
            request.getRequestDispatcher("/views/mau-sac.jsp").forward(request,response);
        }else if(uri.contains("/mausac/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            MauSac mauSac = mauSacRep.getDetal(id);
            mauSacRep.delete(mauSac);
            response.sendRedirect("/mausac/trangchu");
        }else if(uri.equals("/mausac/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));


            request.setAttribute("detal",mauSacRep.getDetal(id));
            request.getRequestDispatcher("/detal/mausacdetal.jsp").forward(request,response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/mausac/add")){
            String ma = request.getParameter("mamau");
            String ten = request.getParameter("tenmau");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

            MauSac ms = new MauSac();
            ms.setMamau(ma);
            ms.setTenmau(ten);
            ms.setTrangthai(trangthai);
            ms.setNgaytao(new Date());

            mauSacRep.add(ms);
            response.sendRedirect("/mausac/trangchu");
        }else if(uri.equals("/mausac/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            String ma = request.getParameter("mamau");
            String ten = request.getParameter("tenmau");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

            for (MauSac mauSac : mauSacRep.getList()){
                if(mauSac.getId().equals(id)){
                    mauSac.setMamau(ma);
                    mauSac.setTenmau(ten);
                    mauSac.setTrangthai(trangthai);
                    mauSacRep.update(mauSac);
                }
            }


            response.sendRedirect("/mausac/trangchu");
        }
    }
}

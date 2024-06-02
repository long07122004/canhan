package com.example.demo.views;

import com.example.demo.Repostory.SizeRep;
import com.example.demo.model.MauSac;
import com.example.demo.model.SizeSp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SizeServlet", value = {"/size/trangchu","/size/add","/size/delete","/size/detal","/size/update"})
public class SizeServlet extends HttpServlet {
    private final SizeRep sizeRep = new SizeRep();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/size/trangchu")){
            ArrayList<SizeSp> listsz = sizeRep.getList();
            request.setAttribute("listsz",listsz);
            request.getRequestDispatcher("/views/size.jsp").forward(request,response);
        }else if(uri.contains("/size/delete")){
            Integer id = Integer.parseInt(request.getParameter("id"));
            SizeSp sizeSp = sizeRep.getDetal(id);
            sizeRep.delete(sizeSp);
            response.sendRedirect("/size/trangchu");
        }else if(uri.equals("/size/detal")){
            Integer id = Integer.parseInt(request.getParameter("id"));


            request.setAttribute("detal",sizeRep.getDetal(id));
            request.getRequestDispatcher("/detal/Sizedetal.jsp").forward(request,response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/size/add")){
            String ma = request.getParameter("masize");
            String ten = request.getParameter("tensize");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

            SizeSp s = new SizeSp();
            s.setMasize(ma);
            s.setTensize(ten);
            s.setTrangthai(trangthai);
            s.setNgaytao(new Date());

            sizeRep.add(s);
            response.sendRedirect("/size/trangchu");
        }else if(uri.equals("/size/update")){
            Integer id = Integer.parseInt(request.getParameter("id"));

            String ma = request.getParameter("masize");
            String ten = request.getParameter("tensize");
            String trangthai = request.getParameter("trangthai");
//         System.out.println(ten);

            for (SizeSp sizeSp : sizeRep.getList()){
                if(sizeSp.getId().equals(id)){
                    sizeSp.setMasize(ma);
                    sizeSp.setTensize(ten);
                    sizeSp.setTrangthai(trangthai);
                    sizeRep.update(sizeSp);
                }
            }


            response.sendRedirect("/size/trangchu");
        }

    }
}

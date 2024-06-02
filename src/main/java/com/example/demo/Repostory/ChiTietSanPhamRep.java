package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ChiTietSanPhamRep {
    public ArrayList<ChiTietSanPham> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<ChiTietSanPham> list = (ArrayList<ChiTietSanPham>) session.createQuery("FROM ChiTietSanPham ").list();
        session.close();
        return list;
    }
    public void add(ChiTietSanPham chiTietSanPham){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public ChiTietSanPham getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        ChiTietSanPham chiTietSanPham = (ChiTietSanPham) session.createQuery("FROM ChiTietSanPham where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return chiTietSanPham;
    }
    public void delete(ChiTietSanPham chiTietSanPham) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(ChiTietSanPham chiTietSanPham) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<ChiTietSanPham> list = new ChiTietSanPhamRep().getList();
        for (ChiTietSanPham ctsp: list){
            System.out.println(ctsp.toString());
        }
    }
}

package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachHangRep {
    public ArrayList<KhachHang> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) session.createQuery("FROM KhachHang ").list();
        session.close();
        return list;
    }
    public void add(KhachHang khachHang){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public KhachHang getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        KhachHang khachHang = (KhachHang) session.createQuery("FROM KhachHang where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return khachHang;
    }
    public void delete(KhachHang khachHang) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(KhachHang khachHang) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<KhachHang> list = new KhachHangRep().getList();
        for (KhachHang khachHang: list){
            System.out.println(khachHang.toString());
        }
    }
}

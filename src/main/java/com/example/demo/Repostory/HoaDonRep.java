package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonRep {
    public ArrayList<HoaDon> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery("FROM HoaDon where trangthai='Chua thanh toan' ").list();
        //where trangthai='Chua thanh toan'
        session.close();
        return list;
    }
    public void add(HoaDon hoaDon){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public HoaDon getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        HoaDon hoaDon = (HoaDon) session.createQuery("FROM HoaDon where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return hoaDon;
    }
    public void delete(HoaDon hoaDon) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(HoaDon hoaDon) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(hoaDon);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<HoaDon> list = new HoaDonRep().getList();
        for (HoaDon hoaDon: list){
            System.out.println(hoaDon.toString());
        }
    }
}

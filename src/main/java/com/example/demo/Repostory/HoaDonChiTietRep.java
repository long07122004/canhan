package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonChiTietRep {
    public ArrayList<HoaDonChiTiet> getList(Integer idhoadon){
        Session session = HibernateUtil.getFACTORY().openSession();
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(idhoadon);
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) session.createQuery("FROM HoaDonChiTiet where hoaDon =:hoadon1").setParameter("hoadon1",hoaDon).list();
        session.close();
        return list;
    }
    public void add(HoaDonChiTiet hoaDonChiTiet){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public HoaDonChiTiet getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        HoaDonChiTiet hoaDonChiTiet = (HoaDonChiTiet) session.createQuery("FROM HoaDonChiTiet where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return hoaDonChiTiet;
    }
    public void delete(HoaDonChiTiet hoaDonChiTiet) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(HoaDonChiTiet hoaDonChiTiet) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(hoaDonChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
//    public static void main (String[] args){
//        ArrayList<HoaDonChiTiet> list = new HoaDonChiTietRep().getList();
//        for (HoaDonChiTiet hoaDonChiTiet: list){
//            System.out.println(hoaDonChiTiet.toString());
//        }
//    }
}

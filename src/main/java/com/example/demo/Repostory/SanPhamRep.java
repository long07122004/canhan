package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;

import com.example.demo.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class  SanPhamRep {
    public ArrayList<SanPham> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham ").list();
        session.close();
        return list;
    }
    public void add(SanPham sanPham){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public SanPham getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        SanPham sanPham = (SanPham) session.createQuery("FROM SanPham where id = :id_1").setParameter("id_1" ,id).getSingleResult();
        session.close();
        return sanPham;
    }
    public void delete(SanPham sp) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(SanPham sanPham){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<SanPham> list = new SanPhamRep().getList();
        for (SanPham sanPham: list){
            System.out.println(sanPham.toString());
        }
    }


}

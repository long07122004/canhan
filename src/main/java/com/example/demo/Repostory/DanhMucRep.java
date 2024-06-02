package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRep {
    public ArrayList<DanhMuc> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc ").list();
        session.close();
        return list;
    }
    public void add(DanhMuc danhMuc){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public DanhMuc getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        DanhMuc danhMuc = (DanhMuc) session.createQuery("FROM DanhMuc where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return danhMuc;
    }
    public void delete(DanhMuc danhMuc) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(DanhMuc danhMuc) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static void main (String[] args){
        ArrayList<DanhMuc> list = new DanhMucRep().getList();
        for (DanhMuc danhMuc: list){
            System.out.println(danhMuc.toString());
        }
    }


}

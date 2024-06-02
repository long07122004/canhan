package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class MauSacRep {
    public ArrayList<MauSac> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<MauSac> list = (ArrayList<MauSac>) session.createQuery("FROM MauSac").list();
        session.close();
        return list;
    }
    public void add(MauSac mauSac){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public MauSac getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        MauSac mauSac = (MauSac) session.createQuery("FROM MauSac where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return mauSac;
    }
    public void delete(MauSac mauSac) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(MauSac mauSac) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<MauSac> list = new MauSacRep().getList();
        for(MauSac mausac :list){
            System.out.println(mausac.toString());
        }
    }
}

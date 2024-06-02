package com.example.demo.Repostory;

import com.example.demo.Hibernate.HibernateUtil;
import com.example.demo.model.DanhMuc;
import com.example.demo.model.SizeSp;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SizeRep {
    public ArrayList<SizeSp> getList(){
        Session session = HibernateUtil.getFACTORY().openSession();
        ArrayList<SizeSp> list = (ArrayList<SizeSp>) session.createQuery("FROM SizeSp ").list();
        session.close();
        return list;
    }
    public void add(SizeSp sizeSp){
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sizeSp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public SizeSp getDetal(Integer id){
        Session session = HibernateUtil.getFACTORY().openSession();
        SizeSp sizeSp = (SizeSp) session.createQuery("FROM SizeSp where id =: x ").setParameter("x",id).getSingleResult();
        session.close();
        return sizeSp;
    }
    public void delete(SizeSp sizeSp) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sizeSp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(SizeSp sizeSp) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(sizeSp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public static void main (String[] args){
        ArrayList<SizeSp> list = new SizeRep().getList();
        for(SizeSp size :list){
            System.out.println(size.toString());
        }
    }
}

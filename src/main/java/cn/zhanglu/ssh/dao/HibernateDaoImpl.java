package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.Emp;
import cn.zhanglu.ssh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDaoImpl implements EmpDao{
    @Override
    public List<Emp> findAll() {
        System.out.println("find All");
        String hql = "from Emp";
        Session session = HibernateUtil.getSession();
        // Q
        Query<Emp> query = session.createQuery(hql);
        // exe
        List<Emp> list = query.list();
        return list;
    }

    @Override
    public List<Emp> findNowEmp() {



        return null;
    }

    @Override
    public void deleteEmp(int emp_id) {

    }

    @Override
    public Emp findByName(String name) {
        return null;
    }

    @Override
    public Emp findById(int emp_id) {
        return null;
    }

    @Override
    public void addEmp(Emp emp) {
        Session session = HibernateUtil.getSession();
        Transaction ts = session.beginTransaction();
        try{
            session.save(emp);
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
            ts.rollback();
        }
    }

    @Override
    public void updateEmp(Emp emp) {

    }
}

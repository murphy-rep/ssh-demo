package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.Emp;
import cn.zhanglu.ssh.dao.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("empDao")
public class HibernateDaoImpl implements EmpDao{

    private void show(){
        System.out.println("info: emp dao");
    }

    @Override
    public List<Emp> findAll() {
        String hql = "from Emp";
        Session session = HibernateUtil.getSession();
        // Q
        Query<Emp> query = session.createQuery(hql);
        // exe
        List<Emp> list = query.list();

        show();
        return list;
    }

    @Override
    public List<Emp> findByPage(int currentPage,int pageSize) {
        String hql = "from Emp";
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(hql)
                .setMaxResults(pageSize)
                .setFirstResult((currentPage-1)*pageSize);
        List<Emp> list = query.list();


        show();
        return list;
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


    @Override
    public void test() {
        System.out.println("spring: emp dao");
    }
}

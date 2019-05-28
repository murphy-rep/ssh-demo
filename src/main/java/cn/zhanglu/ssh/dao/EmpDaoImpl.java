package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.Emp;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao{

    //依赖注入
    @Resource
    private HibernateTemplate hibernateTemplate;


    //-------------------------------------------------------------
    @Override
    public List<Emp> findAll() {

//        Session session = HibernateUtil.getSession();
//
//        String hql = "from Emp";
//        Query query = session.createQuery(hql);
//
//        List list = query.list();
//
//        return list;
        String hql = "from Emp";
        return (List<Emp>) hibernateTemplate.find(hql);
    }

    @Override
    public List<Emp> findByPage(final int currentPage,final int pageSize) {

//        Session session = HibernateUtil.getSession();
//
//        String hql = "from Emp";
//        Query query = session.createQuery(hql)
//                .setMaxResults(pageSize)
//                .setFirstResult((currentPage-1)*pageSize);
//
//        List list = query.list();
//
//        return list;
        return (List<Emp>) hibernateTemplate.executeFind(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "from Emp";
                 Query query = session.createQuery(hql)
                         .setMaxResults(pageSize)
                         .setFirstResult((currentPage-1)*pageSize);
                 List<Emp> list = query.list();
                 return query.list();
            }
        });
    }

    @Override
    public int findTotalPage(int pageSize) {
//        Session session = HibernateUtil.getSession();
//        String hql = "select count(*) from Emp";
//        Query query = session.createQuery(hql);
//        int rowCount = Integer.valueOf(query.uniqueResult().toString());
//        if(rowCount%pageSize == 0) {
//            return rowCount/pageSize;
//        }else {
//            return rowCount/pageSize+1;
//        }

//        System.out.println(hibernateTemplate.getClass());
        String hql="select count(*) from Emp";
        List list = hibernateTemplate.find(hql);
        int rows =Integer.valueOf(list.get(0).toString()) ;
        if(rows%pageSize == 0) {
            return rows/pageSize;
        }else {
            return rows/pageSize+1;
        }
    }


    //
    @Override
    public void deleteEmp(int emp_id) {
        hibernateTemplate.delete(emp_id);
    }

    @Override
    public void addEmp(Emp emp) {

//        Session session = HibernateUtil.getSession();
//        Transaction ts = session.beginTransaction();
//        try{
//            session.save(emp);
//            ts.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            ts.rollback();
//        }

        hibernateTemplate.save(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        hibernateTemplate.update(emp);
    }



    //
    @Override
    public Emp findByName(String name) {
        return null;
    }

    @Override
    public Emp findById(int emp_id) {
        return null;
    }
}

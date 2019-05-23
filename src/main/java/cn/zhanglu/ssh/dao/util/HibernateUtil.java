package cn.zhanglu.ssh.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sf;

    static{
        //load config
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //generate session factory
        sf = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        return sf.openSession();
    }

}

package daoT;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.dao.HibernateDaoImpl;
import cn.zhanglu.ssh.entity.Emp;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TestData {
    @Test
    public void test(){
        EmpDao hello = new HibernateDaoImpl();
        List<Emp> ao = hello.findAll();
        Iterator<Emp> it = ao.iterator();
        while(it.hasNext()){
            Emp now = it.next();
            System.out.println(now.toString());
        }
    }
}

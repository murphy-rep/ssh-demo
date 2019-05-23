package daoT;

import cn.zhanglu.ssh.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class TestDao {

    @Resource(name="empDao")
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Test
    public void demo01(){
        empDao.test();
    }


    @Test
    public void demo02(){
        String xmlPath= "src/main/webapp/WEB-INF/applicationContext.xml";
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext(xmlPath);
        EmpDao empDao  =(EmpDao)applicationContext.getBean("empDao");
        empDao.findByPage(1,5);
    }
}

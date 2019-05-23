package serviceT;

import cn.zhanglu.ssh.entity.Emp;
import cn.zhanglu.ssh.services.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

public class TestService {


    @Resource(name="empService")
    public EmpService empService;

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @Test
    public void demo01(){


        List<Emp> ao = empService.getEmpsByPage(1,5);
        Iterator<Emp> it = ao.iterator();
        while(it.hasNext()){
            Emp now = it.next();
            System.out.println(now.toString());
        }
    }

    @Test
    public void demo02(){
        String xmlPath= "src/main/webapp/WEB-INF/applicationContext.xml";
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("empService"));
        EmpService empService = (EmpService) applicationContext.getBean("empService");
        empService.getEmpsByPage(1,5);


    }
}

package actionT;

import cn.zhanglu.ssh.view.action.EmpAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAction {
    @Test
    public void test(){
        String xmlPath= "src/main/webapp/WEB-INF/applicationContext.xml";
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext(xmlPath);

        System.out.println("empAction 对象：  "+applicationContext.getBean("empAction"));
        EmpAction empAction = (EmpAction) applicationContext.getBean("empAction");
        empAction.list();

//        System.out.println("loginAction 对象：  "+applicationContext.getBean("loginAction"));
//        LoginAction loginAction = (LoginAction)applicationContext.getBean("loginAction");
//        loginAction.start();
    }
}

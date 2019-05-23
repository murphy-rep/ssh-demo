package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.entity.Emp;
import cn.zhanglu.ssh.services.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    //依赖注入
    @Resource(name="empDao")
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public void addEmp() {
        System.out.println("info: emp service");
    }

    @Override
    public List<Emp> getEmpsByPage(int currentPage, int pageSize) {
        System.out.println("info: emp service");

//        String xmlPath= "applicationContext.xml";
//        ApplicationContext applicationContext=
//                new ClassPathXmlApplicationContext(xmlPath);
//        empDao  =(EmpDao)applicationContext.getBean("empDao");

        System.out.println("注入到 empService 的 empDao : "+empDao);
        return empDao.findByPage(currentPage,pageSize);
    }

    @Override
    public void test() {
        empDao.test();
        System.out.println("spring: emp service");
    }
}



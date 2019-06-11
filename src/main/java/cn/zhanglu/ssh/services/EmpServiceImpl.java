package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.entity.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    //依赖注入
    @Resource(name="empDao")
    private EmpDao empDao;

//    public void setEmpDao(EmpDao empDao) {
//        this.empDao = empDao;
//    }

    //------------------------------------------------------------------

    @Override
    public List<Emp> getEmpsByPage(int currentPage, int pageSize) {

//        String xmlPath= "spring-web.xml";
//        ApplicationContext applicationContext=
//                new ClassPathXmlApplicationContext(xmlPath);
//        empDao  =(EmpDao)applicationContext.getBean("empDao");

        return empDao.findByPage(currentPage,pageSize);
    }

    @Override
    public int findTotalPage(int pageSize) {
        return empDao.findTotalPage(pageSize);
    }


    //

    @Override
    public void deleteEmp(int emp_id) {
        empDao.deleteEmp(emp_id);
    }

    @Override
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    //


    @Override
    public Emp findById(int emp_id) {
        return empDao.findById(emp_id);

    }
}



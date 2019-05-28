package cn.zhanglu.ssh.view.action;

import cn.zhanglu.ssh.entity.Emp;
import cn.zhanglu.ssh.services.EmpService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("empAction")
@Scope("prototype")
public class EmpAction extends ActionSupport {

    //依赖注入
    @Resource(name="empService")
    private EmpService empService;

//    public void setEmpService(EmpService empService) {
//        this.empService = empService;
//    }


    //input
    private int pageSize;
    private int currentPage;

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    //output
    private List<Emp> emps;
    private int totalPages;

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<Emp> getEmps(){
        return emps;
    }
    public void setEmps(List<Emp> emps){
        this.emps = emps;
    }


    //methods
    public String list(){

//        String xmlPath= "spring-web.xml";
//        ApplicationContext applicationContext=
//                new ClassPathXmlApplicationContext(xmlPath);
//        empService = (EmpService) applicationContext.getBean("empService");

        emps = empService.getEmpsByPage(currentPage,pageSize);


        totalPages=empService.findTotalPage(pageSize);
        return "emp";
    }

    public void test() {
        System.out.println("spring: emp action");
    }
}

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
    private Emp emp;
    private Integer emp_id;

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
    public Emp getEmp() {
        return emp;
    }
    public void setEmp(Emp emp) {
        this.emp = emp;
    }
    public Integer getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
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


    //显示列表
    public String list(){

//        String xmlPath= "spring-web.xml";
//        ApplicationContext applicationContext=
//                new ClassPathXmlApplicationContext(xmlPath);
//        empService = (EmpService) applicationContext.getBean("empService");

        emps = empService.getEmpsByPage(currentPage,pageSize);
        totalPages=empService.findTotalPage(pageSize);
        return "emp";
    }

    //添加emp
    public String addEmpGet(){
        return "addEmp";
    }

    public String addEmpGetP(){
        empService.addEmp(emp);
        emps = empService.getEmpsByPage(currentPage,5);
        totalPages=empService.findTotalPage(5);
        return "emp";
    }

    //修改emp
    public String updateEmpGet(){
        emp = empService.findById(emp_id);
        return "updateEmp";
    }

    public String updateEmpGetP(){
        empService.updateEmp(emp);
        emps = empService.getEmpsByPage(currentPage,5);
        totalPages=empService.findTotalPage(5);
        return "emp";
    }

    //delete
    public String deleteEmpGet(){
        empService.deleteEmp(emp_id);
        return "emp";
    }


}

package cn.zhanglu.ssh.action;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.dao.HibernateDaoImpl;
import cn.zhanglu.ssh.entity.Emp;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class EmpAction {
    //receive
    private int num;
    //send
    private List<Emp> emps;

    public List<Emp> getEmps(){
        return emps;
    }

    public void setEmps(List<Emp> emps){
        this.emps = emps;
    }


    public String list(){
        EmpDao hello = new HibernateDaoImpl();
        emps = hello.findAll();
        System.out.println(" list ");
        return "emp";
    }
}

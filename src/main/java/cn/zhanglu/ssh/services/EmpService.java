package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.entity.Emp;

import java.util.List;

public interface EmpService {
    public void addEmp();
    public List<Emp> getEmpsByPage(int currentPage, int pageSize);

    public void test();
}

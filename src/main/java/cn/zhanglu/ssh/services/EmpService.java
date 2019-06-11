package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.dao.EmpDao;
import cn.zhanglu.ssh.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> getEmpsByPage(int currentPage, int pageSize);
    int findTotalPage(int pageSize);

    void deleteEmp(int emp_id);
    void addEmp(Emp emp);
    void updateEmp(Emp emp);

    Emp findById(int emp_id);
}

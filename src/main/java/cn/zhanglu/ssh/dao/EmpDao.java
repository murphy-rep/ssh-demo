package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> findAll();
    List<Emp> findByPage();
    void deleteEmp(int emp_id);
    Emp findByName(String name);
    Emp findById(int emp_id);
    void addEmp(Emp emp);
    void updateEmp(Emp emp);
}
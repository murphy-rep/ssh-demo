package cn.zhanglu.ssh.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Emp {
    private Integer emp_id;
    private Integer dept_id;
    private String name;
    private int age;
    private boolean marry;
    private double salary;
    private Date birthday;
    private Timestamp lastLoginTime;


    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", dept_id=" + dept_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marry='" + marry + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}

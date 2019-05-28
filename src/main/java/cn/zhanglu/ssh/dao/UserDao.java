package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.User;

public interface UserDao {
    User findByName(String username);
}

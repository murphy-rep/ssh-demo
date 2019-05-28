package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.entity.User;

public interface UserService {
    User findByName(String username);
}

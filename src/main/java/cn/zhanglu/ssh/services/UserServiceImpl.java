package cn.zhanglu.ssh.services;

import cn.zhanglu.ssh.dao.UserDao;
import cn.zhanglu.ssh.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.naming.Name;

@Repository("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}

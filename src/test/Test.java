import cn.zhanglu.ssh.dao.UserDao;

import javax.annotation.Resource;

public class Test{


    @Resource(name = "userDao")
    private UserDao userDao;

    @org.junit.jupiter.api.Test
    void doTest(){


        System.out.println(userDao);
        System.out.println(userDao.findByName("李大嘴"));

    }


}




package cn.zhanglu.ssh.action;

import cn.zhanglu.ssh.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Map;

public class LoginAction implements ModelDriven<User> {

    User user = new User();

    public User getModel(){
        return user;
    }

    public String start(){
        System.out.println("hello");
        return "login";
    }

    public String login(){
        System.out.println("try to login");
        if(user.getUsername().equals("zhanglu")&&user.getPassword().equals("000000")){
            System.out.println(user.getUsername() + " login success");

            Map<String,Object> session =  ActionContext.getContext().getSession();
            session.put("user",user);

            return "success";
        }else{
            System.out.println(user.getName() + " login failed");
            return "error";
        }
    }


}

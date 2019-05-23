package cn.zhanglu.ssh.view.action;

import cn.zhanglu.ssh.entity.User;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("loginAction")
@Scope("prototype")
public class LoginAction  {

    //input
    User user = new User();

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



    //methods
    public String start(){
        System.out.println("hello Welcome to emp system");
        return "login";
    }

    public String login(){
        System.out.println("info: " + user.getUsername()+" -> log in...");
        if(user.getUsername().equals("zhanglu")&&user.getPassword().equals("000000")){
            System.out.println("info: " + user.getUsername() + " -> log in success!");

            Map<String,Object> session =  ActionContext.getContext().getSession();
            session.put("user",user);

            return "success";
        }else{
            System.out.println("info: " + user.getName() + " -> log in fail!");
            return "error";
        }
    }


}

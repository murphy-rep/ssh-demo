package cn.zhanglu.ssh.view.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

public class CheckInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("前处理");
        Map<String,Object> session = ActionContext.getContext().getSession();
        if(session.get("user")!=null){
            actionInvocation.invoke();
        }
        System.out.println("后处理");
        return "login";
    }


}

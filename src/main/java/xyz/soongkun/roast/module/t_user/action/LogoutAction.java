package xyz.soongkun.roast.module.t_user.action;import com.opensymphony.xwork2.ActionSupport;import org.apache.shiro.SecurityUtils;import org.apache.shiro.subject.Subject;import org.springframework.context.annotation.Scope;import org.springframework.stereotype.Controller;@Controller@Scope("prototype")public class LogoutAction extends ActionSupport {    public LogoutAction() {    }    public String execute() {        Subject currentUser = SecurityUtils.getSubject();        if (currentUser.isAuthenticated()) {            currentUser.logout();        }        return "success";    }}
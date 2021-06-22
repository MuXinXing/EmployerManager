package com.mx.controller.login;

import com.mx.dao.EmployerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MX
 */
@WebServlet(name = "BossLoginServlet",value = "/employer/boss")
public class BossLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bossName;
        String bossPassword;
        EmployerDao employerDao=new EmployerDao();
        int result=0;

        bossName=req.getParameter("bossName");
        bossPassword=req.getParameter("bossPassword");

        result=employerDao.bossLogin(bossName,bossPassword);
        if (result==1){
            resp.sendRedirect("/jsp/bossMenu.jsp");
        }else{
            String msg="登陆失败，姓名/密码错误";
            req.getSession().setAttribute("msg",msg);
            resp.sendRedirect("/jsp/bossLogin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

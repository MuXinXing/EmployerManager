package com.mx.controller.login;

import com.mx.dao.EmployerDao;
import com.mx.entity.Employer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MX
 */
@WebServlet(name = "LoginServlet",value = "/employer/employerLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerName;
        String employerPhone;
        int employerId;
        int result=0;

        EmployerDao employerDao=new EmployerDao();
        Employer employer=null;

        employerName=req.getParameter("employerName");
        employerPhone=req.getParameter("employerPhone");

        result=employerDao.employerLogin(employerName,employerPhone);
        if (result==1){
            employerId=employerDao.getEmployerLoginId(employerName,employerPhone);
            employer=employerDao.showEmployerById(String.valueOf(employerId));
            req.getSession().setAttribute("employerId",employer.getEmployerId());
            req.getSession().setAttribute("employerName",employer.getEmployerName());
            req.getSession().setAttribute("employerPhone",employer.getEmployerPhone());
            req.getSession().setAttribute("employerDept",employer.getEmployerDept());
            req.getSession().setAttribute("employerPosition",employer.getEmployerPosition());
            req.getSession().setAttribute("employerSalary",employer.getEmployerSalary());
            String msg="登录成功";
            req.getSession().setAttribute("msg",msg);
            resp.sendRedirect("/jsp/guestMenu.jsp");
        }else{
            String msg="登陆失败，姓名/密码错误";
            req.getSession().setAttribute("msg",msg);
            resp.sendRedirect("/jsp/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

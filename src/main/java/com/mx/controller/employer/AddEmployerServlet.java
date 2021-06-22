package com.mx.controller.employer;

import com.mx.dao.EmployerDao;
import com.mx.entity.Employer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MX
 */
@WebServlet(name = "AddEmployerServlet",value = "/employer/add")
public class AddEmployerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployerDao employerDao=new EmployerDao();
        Employer employer=null;
         String employerName=req.getParameter("employerName");
         String employerPhone=req.getParameter("employerPhone");
         String employerDept=req.getParameter("employerDept");
         String employerPosition= req.getParameter("employerPosition");
         String employerSalary=req.getParameter("employerSalary");
         employer=new Employer(null,employerName,employerPhone,employerDept,employerPosition,Float.valueOf(employerSalary) );
         int result=employerDao.addEmployer(employer);
         if (result==1){
             resp.sendRedirect("/jsp/bossMenu.jsp");
         }else {
             resp.sendRedirect("/jsp/error.jsp");
         }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

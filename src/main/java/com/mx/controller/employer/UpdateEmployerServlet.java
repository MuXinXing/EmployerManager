package com.mx.controller.employer;

import com.mx.dao.EmployerDao;
import com.mx.entity.Employer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author MX
 */
@WebServlet(name = "UpdateEmployerServlet",value = "/employer/update")
public class UpdateEmployerServlet extends HttpServlet {
    private EmployerDao employerDao=new EmployerDao();
    private Employer employer=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result=0;
        String employerId=req.getParameter("employerId");
        String employerName=req.getParameter("employerName");
        String employerPhone=req.getParameter("employerPhone");
        String employerDept=req.getParameter("employerDept");
        String employerPosition= req.getParameter("employerPosition");
        String employerSalary=req.getParameter("employerSalary");
        employer=new Employer(Integer.valueOf(employerId),employerName,employerPhone,employerDept,employerPosition,Float.valueOf(employerSalary) );
        result=employerDao.updateEmployer(employer);
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

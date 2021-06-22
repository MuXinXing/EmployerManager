package com.mx.controller.employer;

import com.mx.dao.EmployerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author MX
 */
@WebServlet(name = "DeleteEmployer",value = "/employer/delete")
public class DeleteEmployer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerId=req.getParameter("employerId");
        EmployerDao employerDao=new EmployerDao();
        int result=employerDao.deleteEmployer(employerId);
        if(result==1){
            PrintWriter printWriter= resp.getWriter();
            printWriter.print("<script language='javascript'>alert('删除成功')</script>");
            resp.sendRedirect("/jsp/bossMenu.jsp");
        }else{
            resp.sendRedirect("/jsp/bossMenu.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package com.mx.controller.leave;

import com.mx.dao.EmployerLeaveDao;
import com.mx.entity.Employer;
import com.mx.entity.EmployerLeave;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MX
 */
@WebServlet(name = "AgreeLeave",value = "/leaves/agree")
public class AgreeLeave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerId=req.getParameter("employerId");
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        int result=employerLeaveDao.AgreeLeave(employerId);
        if(result==1){
            resp.sendRedirect("/jsp/showLeave.jsp");
        }else{
            resp.getWriter().print("Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

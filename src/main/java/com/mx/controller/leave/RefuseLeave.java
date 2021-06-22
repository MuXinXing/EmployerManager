package com.mx.controller.leave;

import com.mx.dao.EmployerLeaveDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MX
 */
@WebServlet(name = "RefuseLeave",value = "/leaves/refuse")
public class RefuseLeave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerId=req.getParameter("employerId");
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        int result=employerLeaveDao.RefuseLeave(employerId);
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

package com.mx.controller.employer;

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
@WebServlet(name = "DeleteMyLeaveServlet",value = "/leave/delete")
public class DeleteMyLeaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerId=req.getParameter("employerId");
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        int result=employerLeaveDao.deleteMyLeave(employerId);
        if(result==1){
            resp.sendRedirect("/jsp/showMyLeave.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

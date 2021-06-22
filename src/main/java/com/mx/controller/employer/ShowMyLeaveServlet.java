package com.mx.controller.employer;

import com.mx.dao.EmployerLeaveDao;

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
@WebServlet(name = "ShowMyLeaveServlet",value = "/employer/leave/show")
public class ShowMyLeaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employerId=req.getParameter("employerId");
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        employerLeaveDao.showMyLeave(employerId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

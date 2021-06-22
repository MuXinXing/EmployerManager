package com.mx.controller.leave;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MX
 */
@WebServlet(name = "DownLoadLeaveFile",value = "/leaves/download")
public class DownLoadLeaveFile extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("file");
        resp.addHeader("content-Type","application/octet-stream");
        resp.addHeader("content-Disposition","attachment;file="+filename);
        String fileAll="C:\\Users\\MX\\Desktop\\Java\\apache-tomcat-9.0.40\\webapps\\upload\\"+filename;
        InputStream inputStream = getServletContext().getResourceAsStream(fileAll);
            ServletOutputStream servletOutputStream = resp.getOutputStream();
            byte[] bytes = new byte[100];
            int len = -1;
            while ((len = inputStream.read(bytes)) != -1) {
                servletOutputStream.write(bytes, 0, len);
            }
            servletOutputStream.close();
            inputStream.close();
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package com.mx.controller.leave;

import com.mx.dao.EmployerLeaveDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


/**
 * @author MX
 */
@WebServlet(name = "AddEmployerLeave",value = "/leaves/add")
public class AddEmployerLeave extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployerLeaveDao employerLeaveDao = new EmployerLeaveDao();
        String employerId=null;
        String employerLeaveReason=null;
        int result=0;
        try {
            boolean multipartContent = ServletFileUpload.isMultipartContent(req);
            if (multipartContent) {
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
                List<FileItem> fileItemList = upload.parseRequest(req);
                Iterator<FileItem> fileItemIterator = fileItemList.iterator();

                while (fileItemIterator.hasNext()) {
                    FileItem fileItem = fileItemIterator.next();
                    String iterName = fileItem.getFieldName();

                    if (fileItem.isFormField()) {
                        if (iterName.equals("employerId")) {
                            employerId=fileItem.getString();
                        } else if (iterName.equals("employerLeaveReason")) {
                            employerLeaveReason=fileItem.getString("utf-8");
                        } else {
                            System.out.println("Error");
                        }
                    }else {
                        String fileName=fileItem.getName();
                        String filePath="C:\\Users\\MX\\Desktop\\Java\\apache-tomcat-9.0.40\\webapps\\upload";
                        String fileAllPath=fileName;
                        req.getSession().getServletContext().getRealPath(filePath);
                        File file=new File(filePath,fileName);
                        fileItem.write(file);
                        System.out.println(fileName+" 上传至"+filePath+" 成功");
                        result=employerLeaveDao.addEmployerLeave(employerId, employerLeaveReason,fileAllPath);
                    }
                }
            }
        }catch (FileUploadException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result==1){
            String rightMsg="1";
            req.getSession().setAttribute("right",rightMsg);
            resp.sendRedirect("/jsp/guestMenu.jsp");
        }else {
            String errorMsg="0";
            req.getSession().setAttribute("right",errorMsg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

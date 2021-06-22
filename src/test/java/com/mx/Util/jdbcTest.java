package com.mx.Util;

import com.mx.dao.EmployerDao;
import com.mx.dao.EmployerLeaveDao;
import com.mx.entity.Employer;
import org.junit.Test;

import java.util.List;

public class jdbcTest {
    @Test
    public void test(){
        EmployerDao employerDao=new EmployerDao();
        Employer employer=new Employer(null,"1","1","后勤部","老师",20000);
        employerDao.addEmployer(employer);
    }

    @Test
    public void showAll(){
        EmployerDao employerDao=new EmployerDao();
        List list= employerDao.showAllEmployer();
        System.out.println(list);
    }

    @Test
    public void showByIdTest(){
        EmployerDao employerDao=new EmployerDao();
        Employer employer= employerDao.showEmployerById("5");
        System.out.println(employer.getEmployerName());
    }

    @Test
    public void addLeaveTest(){
        String employerId="8";
        String employerLeave="回家掏鸟窝";
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        employerLeaveDao.addEmployerLeave(employerId,employerLeave,null);
    }

    @Test
    public void showDownFileNameTest(){
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        String filePath=null;
        List list=employerLeaveDao.downLoadEmployerFile("13");
        for (int i=0;i< list.size();i++){
            filePath= String.valueOf(list.get(i));
        }

        System.out.println(filePath);
    }
}

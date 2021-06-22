package com.mx.dao;

import com.mx.entity.Employer;
import com.mx.entity.EmployerLeave;
import com.mx.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MX
 */
public class EmployerDao {
    private JdbcUtil jdbcUtil=new JdbcUtil();

    public int employerLogin(String employerName, String employerPhone){
        int result=0;
        String sql="select count(*) from employer where employerName=? and employerPhone=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;

        try {
            preparedStatement.setString(1,employerName);
            //设置sql语句中的?占位符，1为第一个?占位符
            preparedStatement.setString(2,employerPhone);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                result=resultSet.getInt("count(*)");
            }
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return result;
    }

    public int getEmployerLoginId(String employerName,String employerPhone){
        String sql="select employerId from employer where employerName=? and employerPhone=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        int result=0;
        ResultSet resultSet=null;

        try {
            preparedStatement.setString(1,employerName);
            preparedStatement.setString(2,employerPhone);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                result=resultSet.getInt("employerId");
            }
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return result;
    }

    public int bossLogin(String bossName,String bossPassword){
        int result=0;
        String sql="select count(*) from boss where bossName=? and bossPassword=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;

        try {
            preparedStatement.setString(1,bossName);
            preparedStatement.setString(2,bossPassword);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                result=resultSet.getInt("count(*)");
            }
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return result;
    }

    public int addEmployer(Employer employer){
        int result=0;
        String sql="insert into employer(employerName,employerPhone,employerDept,employerPosition,employerSalary) values(?,?,?,?,?)";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);

        try {
            preparedStatement.setString(1,employer.getEmployerName());
            preparedStatement.setString(2,employer.getEmployerPhone());
            preparedStatement.setString(3, employer.getEmployerDept());
            preparedStatement.setString(4, employer.getEmployerPosition());
            preparedStatement.setFloat(5,employer.getEmployerSalary());
            result= preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }
        return result;
    }

    public int deleteEmployer(String employerId){
        int result=0;
        String sql="delete from employer where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);

        try {
            preparedStatement.setInt(1,Integer.valueOf(employerId));
            result=preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }
        return result;
    }

    public int updateEmployer(Employer employer){
        String sql="update employer set employerName=?,employerPhone=?,employerDept=?,employerPosition=?,employerSalary=? where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        int result=0;
        try {
            preparedStatement.setString(1,employer.getEmployerName());
            preparedStatement.setString(2,employer.getEmployerPhone());
            preparedStatement.setString(3, employer.getEmployerDept());
            preparedStatement.setString(4, employer.getEmployerPosition());
            preparedStatement.setFloat(5,employer.getEmployerSalary ());
            preparedStatement.setInt(6,employer.getEmployerId());
            result= preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }
        return result;
    }

    public List showAllEmployer(){
        String sql="select * from employer";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;
        List employerList=new ArrayList();
        try {
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer employerId= resultSet.getInt("employer.employerId");
                String employerName= resultSet.getString("employer.employerName");
                String employerPhone= resultSet.getString("employer.employerPhone");
                String employerDept= resultSet.getString("employer.employerDept");
                String employerPosition= resultSet.getString("employer.employerPosition");
                float employerSalary=resultSet.getFloat("employer.employerSalary");
                Employer employer=new Employer(employerId,employerName,employerPhone,employerDept,employerPosition,employerSalary);
                employerList.add(employer);
            }
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return employerList;
    }

    public Employer showEmployerById(String employerID){
        Employer employer=null;
        String sql="select * from employer where employerId=?";
        PreparedStatement preparedStatement=jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;
        try {

            preparedStatement.setInt(1,Integer.valueOf(employerID));
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer employerId= resultSet.getInt("employerId");
                String employerName= resultSet.getString("employerName");
                String employerPhone= resultSet.getString("employerPhone");
                String employerDept= resultSet.getString("employerDept");
                String employerPosition= resultSet.getString("employerPosition");
                float employerSalary=resultSet.getFloat("employerSalary");
                /*String employerLeave= resultSet.getString("employerLeave");*/
                employer=new Employer(employerId,employerName,employerPhone,employerDept,employerPosition,employerSalary);
            }
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return employer;
    }

}

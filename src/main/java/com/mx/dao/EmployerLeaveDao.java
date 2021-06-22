package com.mx.dao;

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
public class EmployerLeaveDao {
    private JdbcUtil jdbcUtil=new JdbcUtil();

    public List showMyLeave(String employerIds){
        String sql="select * from employers.employerleaves where employerId=?";
        List leavesList=new ArrayList();

        EmployerLeave employerLeave=null;
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;

        try {
            preparedStatement.setInt(1,Integer.valueOf(employerIds));
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer employerId= resultSet.getInt("employerId");
                String employerName= resultSet.getString("employerName");
                String employerPhone=resultSet.getString("employerPhone");
                String employerDept= resultSet.getString("employerDept");
                String employerPosition= resultSet.getString("employerPosition");
                String employerLeaves= resultSet.getString("employerLeave");
                String employerLeavesStatus= resultSet.getString("employerLeaveStatus");
                employerLeave=new EmployerLeave(employerId,employerName,employerPhone,employerDept,employerPosition,employerLeaves,employerLeavesStatus);
                leavesList.add(employerLeave);
                System.out.println(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return leavesList;
    }

    public List showLeaves(){
        String sql="select * from employerleaves";
        EmployerLeave employerLeave=null;
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;
        List leavesList=new ArrayList();

        try {
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer employerId= resultSet.getInt("employerId");
                String employerName= resultSet.getString("employerName");
                String employerPhone=resultSet.getString("employerPhone");
                String employerDept= resultSet.getString("employerDept");
                String employerPosition= resultSet.getString("employerPosition");
                String employerLeaves= resultSet.getString("employerLeave");
                String employerLeavesStatus= resultSet.getString("employerLeaveStatus");
                String employerLeavesFile= resultSet.getString("employerLeaveFileName");
                employerLeave=new EmployerLeave(employerId,employerName,employerPhone,employerDept,employerPosition,employerLeaves,employerLeavesStatus,employerLeavesFile);
                leavesList.add(employerLeave);
                System.out.println(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return leavesList;
    }

    public int AgreeLeave(String employerId){
        int result=0;
        String sql="update employers.employerleaves set employerLeaveStatus='批准' where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        try {
            preparedStatement.setInt(1,Integer.valueOf(employerId));
            result= preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }
        return result;
    }

    public int RefuseLeave(String employerId){
        int result=0;
        String sql="update employers.employerleaves set employerLeaveStatus='拒绝' where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        try {
            preparedStatement.setInt(1,Integer.valueOf(employerId));
            result= preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }

        return result;
    }

    public int addEmployerLeave(String employerId,String employerLeave,String employerLeaveFileName){
        int result=0;
        int result2=0;
        String sql="INSERT INTO employers.employerleaves(employerId,employerName,employerPhone,employerDept,employerPosition)\n" +
                "SELECT employerId,employerName,employerPhone,employerDept,employerPosition FROM employers.employer\n" +
                "WHERE employer.employerId=?";
        String sql2="update employerleaves set employerLeave=? , employerLeaveFileName=? where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        PreparedStatement preparedStatement1=jdbcUtil.getPreparedStatement(sql2);
        try {
            preparedStatement.setInt(1,Integer.valueOf(employerId));
            preparedStatement1.setInt(3,Integer.valueOf(employerId));
            preparedStatement1.setString(1,employerLeave);
            preparedStatement1.setString(2,employerLeaveFileName);
            result=preparedStatement.executeUpdate();
            result2=preparedStatement1.executeUpdate();
            System.out.println(sql+"\n"+sql2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close();
        }

        if (result==1||result2==1){
            return result=1;
        }
        return result;
    }

    public int deleteMyLeave(String employerId){
        int result=0;
        String sql="delete from employerleaves where employerId=?";

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

    public List downLoadEmployerFile(String employerId){
        String sql="select employerLeaveFileName from employerleaves where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        ResultSet resultSet=null;
        List<String> list=new ArrayList<>();
        try {
            preparedStatement.setInt(1,Integer.valueOf(employerId));
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String employerLeavesFileName= resultSet.getString("employerLeaveFileName");
                list.add(employerLeavesFileName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.Close(resultSet);
        }
        return list;
    }

}

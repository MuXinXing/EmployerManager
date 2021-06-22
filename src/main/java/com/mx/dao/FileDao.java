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
public class FileDao {

    JdbcUtil jdbcUtil=new JdbcUtil();
    EmployerLeave employerLea=null;
    List<EmployerLeave> leaveList=null;
    /**
     * 上传文件图片
     * */
    public void UpFile(String employerId,String fileName) throws SQLException{
        String sql="insert into employerLeaves(employerLeaveFileName) values(?) where employerId=?";
        PreparedStatement preparedStatement= jdbcUtil.getPreparedStatement(sql);
        preparedStatement.setString(1,fileName);
        preparedStatement.setInt(2,Integer.valueOf(employerId));
        preparedStatement.executeUpdate();
    }
    /**
     *下载查看文件
     * */
    public List<EmployerLeave> FindFIle(String context) throws SQLException {
        leaveList = new ArrayList<>();
        String sql = "select * from Img where employerLeaveFileName like '%" + context + "%' or employerLeaveFileName like '%" + context + "%' or employerId like '%" + context + "%'";
        PreparedStatement preparedStatement = jdbcUtil.getPreparedStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            employerLea = new EmployerLeave();
            employerLea.setEmployerId(rs.getInt("employerId"));
            employerLea.setEmployerLeaveFile(rs.getString("employerLeaveFileName"));
            leaveList.add(employerLea);
        }
        return leaveList;
    }
}

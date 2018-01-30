package com.sample.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.domain.User;
import com.sample.util.JDBCUtils;

public class UserDao {

	public User queryUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取连接
			conn = JDBCUtils.getConnection();
			//获得发送SQL对象
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			//设置参数
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			//执行SQL
			rs = ps.executeQuery();
			while (rs.next()) {		//如果有，只可能有一个，也可以用if
				//进来说明查询到结果
				User existUser = new User();
				existUser.setId(rs.getInt("id"));
				existUser.setUsername(rs.getString("username"));
				existUser.setPassword(rs.getString("password"));
				return existUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(conn, ps, rs);
		}
		//没有查到
		return null;
	}

}

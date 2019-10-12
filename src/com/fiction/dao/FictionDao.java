package com.fiction.dao;

import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.FictionEntity;
import com.fiction.util.JdbcUtil;

import java.sql.*;
public class FictionDao {
	public List<FictionEntity> getAllById(String name,int id) {
		JdbcUtil jdbc = new JdbcUtil();
		List<FictionEntity> list = new ArrayList<FictionEntity>();
		Connection conn = jdbc.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from "+name+" where text_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				FictionEntity fe = new FictionEntity();
				fe.setId(rs.getInt("text_id"));
				fe.setTitle(rs.getString("text_title"));
				fe.setContent(rs.getString("text_content"));
				list.add(fe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
		
	}
}

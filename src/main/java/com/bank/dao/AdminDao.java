package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.model.AdminModel;

public class AdminDao {
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveData(AdminModel a)
	{
		String query="insert into gr13_Admin values('"+a.getId()+"','"+a.getName()+"')";
		return jdbcTemplate.update(query);
	}
	
	public List<AdminModel> getAllInfo(AdminModel am){  
		 String sql="select * from gr13_Admin"; 
		 return jdbcTemplate.query(sql, new RowMapper<AdminModel>(){  
			 public AdminModel mapRow(ResultSet rs, int rownumber) throws SQLException {  
	AdminModel a = new AdminModel();  
	a.setId(rs.getString(1));
	a.setName(rs.getString(2));
	  return a;  
	
	 }
		 });
	}

	
public int deleteData(String id) {
	String query= "delete from gr13_Admin where id =?";
	return jdbcTemplate.update(query, new Object[] {id});
}}


/*public int saveData1(AdminModel a) {
	String query = "insert into G13_Account values('"+a.getId()+"','"+a.getName()+"')";
	return jdbcTemplate.update(query);
}*/


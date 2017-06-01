package com.perinfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.perinfo.controller.Login;
import com.perinfo.controller.Perinfo;
import com.perinfo.controller.SignIn;
import com.perinfo.model.Restinfo;

public class PerinfoDaoImpl implements PerinfoDao {
	private JdbcTemplate jdbcTemp;

	public PerinfoDaoImpl(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	public int authenticateUser(Login ln) {
		//Integer count = 0;
		//System.out.println(""+count);
		String sql = "SELECT count(*) COUNT FROM login WHERE uname = ? and pword=?";
		// @SuppressWarnings("deprecation")
		// int count =jdbcTemp.queryForInt("select count(*) from login " +"
		// where uname = ? and password = ?",ln.getUname(),ln.getPword());
		String[] values = { ln.getUname(), ln.getPword() };
		int[] types = { Types.VARCHAR, Types.VARCHAR };
		Map<String, Object> resultMap = jdbcTemp.queryForMap(sql, values, types);
	    Integer count = 0;
		if (resultMap != null && resultMap.containsKey("COUNT")) {
			//count = (Integer) resultMap.get("COUNT");
			count =((Long) resultMap.get("COUNT")).intValue();
		}
		System.out.println(""+count);
		return count;

	}
	public void addNewuser(SignIn si) {
		String qry = "INSERT INTO login (uname ,pword ,cnfmpword) VALUES (?,?,?)";
		String[] values = { si.getUname(), si.getPword(), si.getCnfmpword() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		jdbcTemp.update(qry, values, types);
	}

	public void addPerinfo(Perinfo pr) {
		String qry = "INSERT INTO perinfo4 (fname ,lname ,addr ,phno ,pin) VALUES (?,?,?,?,?)";
		String[] values = { pr.getFname(), pr.getLname(), pr.getAddr(), pr.getPhno(), pr.getPin() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		jdbcTemp.update(qry, values, types);
	}

	public List<Restinfo> getAllLocation() {
		return jdbcTemp.query("select * from locinfo", new ResultSetExtractor<List<Restinfo>>() {
			public List<Restinfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Restinfo> list = new ArrayList<Restinfo>();
				while (rs.next()) {
					Restinfo e = new Restinfo();
					e.setLabel(rs.getString(1));
					e.setValue(rs.getString(2));

					list.add(e);
				}
				return list;
			}
		});
	}

	/*
	 * public List<Restinfo> getAllLocation(){ return jdbcTemp.query(
	 * "select * from location",new RowMapper<Restinfo>(){ public Restinfo
	 * mapRow(ResultSet rs, int rownumber) throws SQLException { Restinfo c=new
	 * Restinfo(); c.setlabel(rs.getString(1)); c.setvalue(rs.getString(2));
	 * return c; } }); }
	 * 
	 * /*public List<Perinfo> getAllStudents() { String qry =
	 * "SELECT * FROM perinfo";
	 * 
	 * List<Map<String, Object>> list = jdbcTemp.queryForList(qry);
	 * List<Perinfo> perinfosList = new ArrayList<Perinfo>(); for(Map<String,
	 * Object> map : list) {
	 * 
	 * } return perinfosList; }
	 */

}

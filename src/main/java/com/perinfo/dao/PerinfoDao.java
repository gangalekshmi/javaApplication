package com.perinfo.dao;

import java.util.List;

import com.perinfo.controller.Login;
import com.perinfo.controller.Perinfo;
import com.perinfo.controller.SignIn;
import com.perinfo.model.Restinfo;

public interface PerinfoDao {
	public void addPerinfo(Perinfo pr);
	
   public List<Restinfo> getAllLocation();
   public int authenticateUser(Login ln);
	public void addNewuser(SignIn si);

  /* public Perinfo getStudent(String  fname);
   public void updateStudent(Perinfo pr);
   public void deleteStudent(Perinfo pr);	 		*/
}  
package com.perinfo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;

import com.perinfo.dao.PerinfoDao;
import com.perinfo.model.Restinfo;  
  
@RestController  
public class  Restcontroller{  
	@Autowired
	PerinfoDao perinfoDao;
	
 @RequestMapping(value = "/location", method = RequestMethod.GET,headers="Accept=application/json")  
 public List<Restinfo> getLocinfo()  
 {  
  List<Restinfo> rest = new ArrayList<Restinfo>();  
  rest=perinfoDao.getAllLocation();  
  return rest;  
 }  
}  


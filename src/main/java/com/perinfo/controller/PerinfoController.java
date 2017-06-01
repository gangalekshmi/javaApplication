package com.perinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.perinfo.dao.PerinfoDao;

 
@Controller
public class PerinfoController {
	
	@Autowired
	PerinfoDao perinfoDao;
	
	
	/*String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("per");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;*/
	@RequestMapping(value = "/perinfo", method = RequestMethod.GET)
	   public ModelAndView perinfo() {
		System.out.println(" In perinfo controller  ");
	      return new ModelAndView("perinfo", "command", new Perinfo());
	   }
	   
	/*@RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("login") Login login) {
        if (login != null && login.getUname() != null & login.getPword() != null) {
            if (login.getUname().equals("chandra") && login.getPword().equals("chandra123")) {
                model.addAttribute("msg", "welcome" + login.getUname());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }*/
	@RequestMapping(value ="/submit", method = RequestMethod.POST)
    public String  submit(@ModelAttribute("login") Login ln, ModelMap model) {
		System.out.println(" In perinfo controller  "+ ln.getUname());
		   System.out.println(" In perinfo controller  "+ ln.getPword());
        int value=perinfoDao.authenticateUser(ln);

        if(value>0)
        {

        return "Infm";

        }
        else
        {
            return "failure";
        }
    }
	
	 @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")SignIn si, ModelMap model) {
		 
		   System.out.println(" In adduser "+ si.getUname());
		   System.out.println(" In adduser  "+ si.getPword());
		   System.out.println(" In adduser  " + si.getCnfmpword());
		   perinfoDao.addNewuser(si);

		 model.addAttribute("uname", si.getUname());
	      model.addAttribute("pword", si.getPword());
	      model.addAttribute("cnfmpword", si.getCnfmpword());
	      return "Signin";
	 }
	 
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Perinfo pi, ModelMap model) {
		   
		   System.out.println(" In perinfo controller  "+ pi.getFname());
		   System.out.println(" In perinfo controller  "+ pi.getLname());
		   System.out.println(" In perinfo controller  " + pi.getAddr());
		   System.out.println(" In perinfo controller  "+ pi.getPhno());
		   System.out.println(" In perinfo controller  "+ pi.getPin());
		   perinfoDao.addPerinfo(pi);
		   
		//String fname = request.getParameter("firstname");
		 //  String lname = request.getParameter("lastname");
		 //  String addr = request.getParameter("addr");
		 //  String phno = request.getParameter("phno");
		 //  String pin = request.getParameter("pin");
		   
	      model.addAttribute("fname", pi.getFname());
	      model.addAttribute("lname", pi.getLname());
	      model.addAttribute("addr", pi.getAddr());
	      model.addAttribute("phno", pi.getPhno());
	      model.addAttribute("pin", pi.getPin());
	      return "per";
	}
}

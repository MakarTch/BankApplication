package com.example.application;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankApplicationController {

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}	
	
	@GetMapping("/createAccount")
	public String createAccount() {
		return "createAccount.jsp";
	}
	
	@GetMapping("/verifyAccount")
	public String accountActions(@RequestParam int user_id, @RequestParam String password, HttpSession session) throws IOException {
		if(UserDAOClass.verification(user_id, password) == true) {
			session.setAttribute("user", user_id);
			return "accountActions.jsp";
		}
		return "errorLogin.jsp";
	}
	
	@GetMapping("/recentTransactions")
	public ModelAndView recentTransactions(HttpSession session) {
		ModelAndView mv = new ModelAndView("recentTransactions.jsp");
		mv.addObject("user", session.getAttribute("user"));
		mv.addObject("obj", new Transaction());
		return mv;
	}
	
	@GetMapping("/displayUserInformation")
	public ModelAndView displayUserInformation(HttpSession session) {
		ModelAndView mv = new ModelAndView("displayUserInformation.jsp");
		mv.addObject("obj", new User());
		mv.addObject("user", session.getAttribute("user"));
		return mv;
	}
	
	@GetMapping("/displayAccounts")
	public ModelAndView displayAccounts(HttpSession session) {
		ModelAndView mv = new ModelAndView("displayAccounts.jsp");
		mv.addObject("obj", new Account());
		mv.addObject("user", session.getAttribute("user"));
		return mv;
	}
	
	@GetMapping("/deposit")
	public ModelAndView deposit(HttpSession session) {
		ModelAndView mv = new ModelAndView("deposit.jsp");
		
		return mv;
	}
	@GetMapping("/depositAction")
	public String depositAction(HttpSession session, @RequestParam String account, @RequestParam int deposit) {
		System.out.println(account + deposit);
		Account a = new Account();
		a.deposit(account,deposit);
		return "displayAccounts.jsp";
	}
	

}




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
	
	@GetMapping("/accountCreated")
	public String accountCreated() {
		//insert a bunch of methods here
		//insert into user
		//insert into account
		//insert into transactions
		//jeez I totally forgot to insert transactions for every thing I do
		return "accountCreated.jsp";
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
	public String deposit(HttpSession session) {
		return "deposit.jsp";
	}
	
	@GetMapping("/depositAction")
	public String depositAction(HttpSession session, @RequestParam String account, @RequestParam int deposit) {
		Object user = session.getAttribute("user");
		boolean success = Account.deposit(user,account,deposit);
		if (success) {
			return "success.jsp";
		}
		return "error.jsp";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw.jsp";
	}
	
	@GetMapping("/withdrawAction")
	public String withdrawAction(HttpSession session, @RequestParam String account, @RequestParam int withdraw) {
		Object user = session.getAttribute("user");
		boolean success = Account.withdraw(user,account,withdraw);
		if (success) {
			return "success.jsp";
		}
		return "error.jsp";
	}
	@GetMapping("/transfer")
	public String transfer() {
		return "transfer.jsp";
	}
	
	@GetMapping("/transferAction")
	public String transferAction(HttpSession session, @RequestParam int amount, @RequestParam String accountTo ) {
		Object userId = session.getAttribute("user");
		boolean success = Account.transfer(userId, amount, accountTo);
		if (success) {
			return "success.jsp";
		}
		return "error.jsp";
	}
}

///block password from showing in url


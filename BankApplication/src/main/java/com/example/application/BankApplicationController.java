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
	
	@GetMapping("/loggingOff")
	public String login(HttpSession session) {
		session.setAttribute("user", null);
		return "home.jsp";
	}
	
	@GetMapping("/createAccount")
	public String createAccount() {
		return "createAccount.jsp";
	}
	
	@GetMapping("/accountCreated")
	public ModelAndView accountCreated(User user) throws IOException {
		ModelAndView mv = new ModelAndView();
		boolean success1 = User.createUser(user);
		user = UserDAOClass.getUserByContactNumber(user.getContactNumber());
		boolean success2 = Account.createAccount(user);
		boolean success3 = Transaction.initialDeposit(user);
		if (success1 && success2 && success3) {
			mv.setViewName("accountCreated.jsp");
			mv.addObject(user);
			return mv;
		}
		mv.setViewName("error.jsp");
		return mv;
	}
	
	@GetMapping("/accountActions")
	public String accountActions() {
		return "accountActions.jsp";
	}
	
	
	@GetMapping("/verifyAccount")
	public String accountActions(@RequestParam int userId, @RequestParam String password, HttpSession session) throws IOException {
		if(UserDAOClass.verification(userId, password) == true) {
			session.setAttribute("user", userId);
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
		boolean success = Account.deposit(user,account,deposit, false);
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
		boolean success = Account.withdraw(user,account,withdraw, false);
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

//block password from showing in url
//add dollar signs to the table views
//Change all ids so that theyre like 101, 1001, you know
package com.example.library.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.library.entities.Admin;
import com.example.library.entities.Constants;
import com.example.library.entities.Message;

@Service
public class HelperService {

	@Autowired
	TransactionService service;

	public HelperService() {

	}

	public String verifyAdmin(Admin admin, Model model, HttpSession session) {
		if (admin.getUsername().equals(Constants.USERNAME) && admin.getPassword().equals(Constants.PASSWORD)) {

			model.addAttribute("title", "Dashboard");
			service.updateFineContinuously();
			session.setAttribute(Constants.SESSION_ADMIN, Constants.USERNAME);		
			return "Basic/dashboard";
		} else {
			model.addAttribute("title", "Login");
			model.addAttribute("admin", admin);
			session.setAttribute("message", new Message("Wrong Username or Password", "alert-danger"));
			return "Basic/login";
		}
	}

}

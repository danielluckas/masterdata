package de.schuelkeonline.masterdata.app.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class ErrorController {

	// Error page
//	@RequestMapping("/error")
	public String error(HttpServletRequest request, Model model) {
		model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String errorMessage = null;
		if (throwable != null) {
			errorMessage = throwable.getMessage();
		}
		model.addAttribute("errorMessage", errorMessage);
		return "error.html";
	}

}

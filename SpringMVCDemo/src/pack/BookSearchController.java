package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import bookbean.Book;

public class BookSearchController implements Controller {
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		//Read the requested data from client
		int bookid = Integer.parseInt(req.getParameter("t1"));
		Book b1 = new Book();
		b1.setBookId(bookid); // Data retrieval.
		
		ModelAndView modelAndView = new ModelAndView("/bookResults.jsp");	
		modelAndView.addObject("bookResults",b1);
		return modelAndView;
	}

}

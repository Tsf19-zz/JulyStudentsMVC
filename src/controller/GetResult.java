package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

//@WebServlet("/GetResult")
public class GetResult extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Creating Object of Model");
		Model m = new Model();
		String usn = request.getParameter("usn");
		m.setUsn(usn);
		m.getResult();
		
		String usn2 = m.getUsn();
		String name2 = m.getName();
		int marks12 = m.getMarks1();
		int marks22 = m.getMarks2();
		int marks32 = m.getMarks3();
		float avg2 = m.getAvg();
		
		HttpSession hs = request.getSession(true);
		hs.setAttribute("USN", usn2);
		hs.setAttribute("NAME", name2);
		hs.setAttribute("MARKS1", marks12);
		hs.setAttribute("MARKS2", marks22);
		hs.setAttribute("MARKS3", marks32);
		hs.setAttribute("AVG", avg2);
		
		try {
			//Give Full Path in sendRedirect
			response.sendRedirect("/JulyStudentsMVC/ViewResult.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

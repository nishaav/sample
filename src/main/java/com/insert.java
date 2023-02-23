package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.User;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public insert() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("age"));
        String result=insertData(name,age);
		
		//Float.parseFloat
		//Double.parseDouble
		if(result.equalsIgnoreCase("success"))
		{
			out.println("<!doctype html>"
				+ "<html>"
				+ "<head></head>"
				+ "<body>"
				+ "Welcome "+name+"<br>"
				+ "Your age is "+age+"<br>"
				+ "</body>"
				+ "</html>");
		
		}
		else
		{
			out.println("<!doctype html>"
					+ "<html>"
					+ "<head></head>"
					+ "<body>"
					+ "Unable to insert data in database"
					+ "</body>"
					+ "</html>");	
		}

		
	}	
	
	String insertData(String name,int age)
	{
		try
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("db1");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			User user=new User();
			user.setUserName(name);
			user.setUserAge(age);
			em.persist(user);//insert query
			et.commit();
			em.close();
			return "success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failure";
	}
	
	/*String updateReord(User user) {
		try {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("db1");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			User u=em.find(User.class, user.getUserId());
			et.begin();
			u.setUserName("preeti");
			u.set
			)
			
		}
	}*/


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

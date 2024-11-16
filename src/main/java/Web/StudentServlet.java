package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;
import Model2.Student;



@WebServlet("/")

public class StudentServlet extends HttpServlet  {

	  private StudentDao StudentDao;

	    public void init() {
	    	StudentDao = new StudentDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertUser(request, response);
	                    break;
	                case "/delete":
	                    deleteUser(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateUser(request, response);
	                    break;
	                default:
	                    listUser(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
}
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        List < Student > listStudent = StudentDao.getAllStudents();
	    	        request.setAttribute("listUser", listStudent);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Student.jsp");
	    	        dispatcher.forward(request, response);
	    	    }

	    	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Student-form.jsp");
	    	        dispatcher.forward(request, response);
	    	    }

	    	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, ServletException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        Student existingUser = StudentDao.getStudent(id);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Student-form.jsp");
	    	        request.setAttribute("user", existingUser);
	    	        dispatcher.forward(request, response);

	    	    }

	    	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        String name = request.getParameter("name");
	    	        String country = request.getParameter("country");
	    	        Student newUser = new Student(name,country);
	    	        StudentDao.saveStudent(newUser);
	    	        response.sendRedirect("list");
	    	    }

	    	    private void updateUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        String name = request.getParameter("name");
	    	        String country = request.getParameter("country");

	    	        Student user = new Student(id, name, country);
	    	        StudentDao.updateStudent(user);
	    	        response.sendRedirect("list");
	    	    }

	    	    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        StudentDao.deleteStudent(id);
	    	        response.sendRedirect("list");
	    	    }
}

		

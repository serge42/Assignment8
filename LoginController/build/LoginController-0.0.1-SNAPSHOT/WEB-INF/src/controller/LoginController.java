package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.commands.AbstractCommand;
import controller.commands.UnknownCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("TEST");
		//retrieve command name
		String commandName = request.getParameter("command");
		commandName = "controller.commands." + commandName + "Command";
		
		//retrieve command implementation
		//using reflection the front controller works for any
		//number of implemented commands 
		Class commandClass;
		try {
			commandClass = Class.forName(commandName);
		} catch (ClassNotFoundException e) {
			commandClass = UnknownCommand.class;
		}
		
		//create command
		AbstractCommand command;
		try {
			command = (AbstractCommand) commandClass.newInstance();
		} catch (InstantiationException e) {
			getServletContext().getRequestDispatcher("/failToCreateCommand.jsp").forward(request, response);
			return;
		} catch (IllegalAccessException e) {
			getServletContext().getRequestDispatcher("/failToCreateCommand.jsp").forward(request, response);
			return;
		}
		
		
		//run command
		command.init(getServletContext(), request, response);
		command.process();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.commands;

import java.io.IOException;


import javax.servlet.ServletException;


public class UnknownCommand extends AbstractCommand {


	@Override
	public void process() throws ServletException, IOException{
		sc.getRequestDispatcher("/unknownCommand.jsp").forward(request, response);
	}

}

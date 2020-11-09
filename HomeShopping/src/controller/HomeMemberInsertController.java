package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDAO;

public class HomeMemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeMemberDAO dao = new HomeMemberDAO();
		
		int mmxx = dao.getMaxCustNo();
		req.getRequestDispatcher("/view/memberInsert.jsp").forward(req, resp);
	}

}

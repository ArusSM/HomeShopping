package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDAO;
import vo.MemberMoneyVO;

public class MemberMoneyListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeMemberDAO dao = new HomeMemberDAO();
		ArrayList<MemberMoneyVO> list = dao.getMoneyList();
		
		if(list != null) {
			req.setAttribute("moneyList", list);
			req.getRequestDispatcher("/view/memberMoneyList.jsp").forward(req, resp);
		}
	}

}

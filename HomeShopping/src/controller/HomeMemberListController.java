package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDAO;
import vo.MemberVO;

public class HomeMemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeMemberDAO dao = new HomeMemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		if(list != null) {
			req.setAttribute("memberList", list);
			req.getRequestDispatcher("/view/memberList.jsp").forward(req, resp);
		}
		
	}

}

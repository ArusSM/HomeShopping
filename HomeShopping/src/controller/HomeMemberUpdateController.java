package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HomeMemberDAO;
import vo.MemberVO;

public class HomeMemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals("GET")) {
			int custno = Integer.parseInt(req.getParameter("custno"));

			HomeMemberDAO dao = new HomeMemberDAO();
			MemberVO vo = dao.getMemberData(custno);

			if (vo != null) {
				req.setAttribute("memberData", vo);
				req.getRequestDispatcher("/view/memberUpdate.jsp").forward(req, resp);
			}
		} else if (req.getMethod().equals("POST")) {
			// 파라미터 추출
			MemberVO vo = new MemberVO();
			HomeMemberDAO dao = new HomeMemberDAO();
			int custno = Integer.parseInt(req.getParameter("custno"));
			String custname = req.getParameter("custname");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			Date joindate = Date.valueOf(req.getParameter("joindate"));
			String grade = req.getParameter("grade");
			String city = req.getParameter("city");

			// VO 객체에게 데이터 바인딩
			vo.setCustno(custno);
			vo.setCustname(custname);
			vo.setPhone(phone);
			vo.setAddress(address);
			vo.setJoindate(joindate);
			vo.setGrade(grade);
			vo.setCity(city);
			// 모델에게 일 시키기
			int n = dao.updateMember(vo);

			if (n > 0) {
				System.out.println("성공");
				resp.sendRedirect("/memberList.do");
			} else {
				System.out.println("실패");
			}
		}

	}

}

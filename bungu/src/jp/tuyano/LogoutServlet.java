package jp.tuyano;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException {
		UserService userService = UserServiceFactory.getUserService();

	    String thisUrl = req.getRequestURI();
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html");
	    if (req.getUserPrincipal() != null) {
	      resp.getWriter().println("<a href=\""
	          + userService.createLogoutURL(thisUrl)
	          + "\">ログアウトしてね</a>.</p><br>");
	      resp.getWriter().println("<a href=\"" + "index.html" + "\">注文画面へ戻るよ<a>");
	    } else {
	    	resp.sendRedirect("/top.html");
	    }
	 }
}

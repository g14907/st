package jp.tuyano;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException {
		UserService userService = UserServiceFactory.getUserService();

	    String thisUrl = req.getRequestURI();
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html");
	    if (req.getUserPrincipal() != null) {
	      resp.getWriter().println("<p> "
	          + req.getUserPrincipal().getName()
	          + "さん、こんにちは！</p><br>");
	      resp.getWriter().println("<a href=\"" + "index.html" + "\">注文画面へ<a>");
	    } else {
	    	resp.sendRedirect(userService.createLoginURL(thisUrl));
	      /*resp.getWriter().println("<p><a href=\""
	            + userService.createLoginURL(thisUrl)
	            + "\">ログイン</a>してください</p>");*/
	    }
	 }
}

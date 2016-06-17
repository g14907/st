package jp.tuyano;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("入力されていません。");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String msg = "";
        String[] product = req.getParameterValues("product");
        String st = "";
		if (product.length == 0) {
			resp.sendRedirect("/index.html");
		} else {
			for (int i = 0; i < product.length; i++) {
				st += product[i] + ", ";
				msg += product[i] + "<br>";
			}
		}
        String goukei = req.getParameter("goukei");
        Date date = Calendar.getInstance().getTime();
        LinkData data = new LinkData(st,goukei,date);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        //resp.sendRedirect("/check.html");
        PrintWriter out = resp.getWriter();
        
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>注文内容確認</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>注文内容確認</h1>");
            out.println(msg);
            out.println("<br>合計");
            out.println(goukei);
            out.println("<br>注文時間");
            out.println(date);
            out.println("<br><a href=/LogoutServlet>完了</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }
}
package New;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class serv2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(false);
            Object s = session.getAttribute("todo");
            ArrayList<String> list = (ArrayList<String>) (ArrayList<?>) (s);

            String btn = request.getParameter("btn");
            String list2 = request.getParameter("checked");

            switch (btn) {
                case "Add": {
                    RequestDispatcher rd = request.getRequestDispatcher("/operate.html");
                    out.println("<h1>To Do List-1</h1>");
                    for (String i : list) {
                        out.println("<input type=\"checkbox\" name=\"list\" value=\"" + i + "\">" + i + "<br>");
                    }
                    list.add(list2);
                    out.println("<input type=\"checkbox\" name=\"list\" value=\"" + list2 + "\">" + list2 + "<br><br>");
                    session.setAttribute("todo", list);
                    rd.include(request, response);
                    break;
                }
                
                case "Mark as Done": {
                    RequestDispatcher rd = request.getRequestDispatcher("/operate.html");
                    out.println("<h1>To Do List-1</h1>");
                    String values[] = request.getParameterValues("list");
                    for (String j : values) {
                        if (list.contains(j)) {
                            list.remove(j);
                        }
                    }
                    session.setAttribute("todo", list);
                    for (String l : list) {
                    out.println("<input type=\"checkbox\" name=\"list\" value=\"" + l + "\">" + l + "<br>");}
                    rd.include(request, response);
                    break;
                }
                
                case "logout": {
                    RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                    out.println("<h1>Logged out Successfully</h1>");
                    rd.include(request, response);
                    break;
                }
            }
        }
    }
}

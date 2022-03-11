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

public class ser1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            ArrayList<String> list = new ArrayList();
            out.println("<form method=\"get\" action=\"serv2\">");
            
            
            if (name.equals("Admin") && password.equals("1234")) 
            {
            RequestDispatcher rd = request.getRequestDispatcher("/operate.html");
            HttpSession session = request.getSession();   
                
                //to-do list
                String c1 = "Release Result";
                String c2 = "Freeze marks";
                out.println("<h1>To Do List</h1>");
                list.add(c1);
                list.add(c2);

                out.println("<input type=\"checkbox\" name=\"list\" value=\"" + c1 + "\">" + c1 + "<br>");
                out.println("<input type=\"checkbox\" name=\"list\" value=\"" + c2 + "\">" + c2 + "<br><br>");

                session.setAttribute("todo", list);
                rd.include(request, response);  
            } 
            
            
            else if (name.equals("User") && password.equals("5678")) 
            {
               RequestDispatcher rd = request.getRequestDispatcher("/operate.html");
               HttpSession session = request.getSession();
               
                //to-do list
                String c1 = "View Marks";
                String c2 = "Submit Assignment";
                list.add(c1);
                list.add(c2);
                              
                out.println("<h1>To Do List</h1>");
                out.println("<input type=\"checkbox\" name=\"list\" value=\"" + c1 + "\">" + c1 + "<br>");
                out.println("<input type=\"checkbox\" name=\"list\" value=\"" + c2 + "\">" + c2 + "<br><br>");

                session.setAttribute("todo", list);
                rd.include(request, response);
            } 
            else if (name.equals("User") || !password.equals("1234")) {
                out.print("Password Incorrect");
                request.getRequestDispatcher("index.html").include(request, response);
            } 
            else if (name.equals("Admin") || !password.equals("5678")) {
                out.print("Password Incorrect");
                request.getRequestDispatcher("index.html").include(request, response);
            } 
            else if (!name.equals("User") || password.equals("1234")) {
                    out.print("Username Incorrect");
                    request.getRequestDispatcher("index.html").include(request, response);
            }
            else if (!name.equals("Admin") || password.equals("5678")) {
                    out.print("Username Incorrect");
                    request.getRequestDispatcher("index.html").include(request, response);
            }
            else{
                out.print("Username and password Incorrect");
                    request.getRequestDispatcher("index.html").include(request, response);
            }
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
                out.close();

            }
        }
    }


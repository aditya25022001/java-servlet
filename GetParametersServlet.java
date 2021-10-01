import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetParametersServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>";
        writer.println("<html>");
        writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
        writer.println("<body>");
        writer.println("<table class='table table-bordered m-5' style='width:max-content;'>");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th scope='col'>Parameter</th>");
        writer.println("<th scope='col'>Value</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        writer.println("<tr>");
        writer.println("<td scope='row'>First Name</td>");
        writer.println("<td>"+request.getParameter("fname")+"</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td scope='row'>Last Name</td>");
        writer.println("<td>"+request.getParameter("lname")+"</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td scope='row'>Email</td>");
        writer.println("<td>"+request.getParameter("email")+"</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td scope='row'>Roll Number</td>");
        writer.println("<td>"+request.getParameter("rollno")+"</td>");
        writer.println("</tr>");
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }
}

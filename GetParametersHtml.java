import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetParametersHtml extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
        writer.println("<html>");
        writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
        writer.println("<body>");
        writer.println("<form action='/ssp/getParameter' style='width:max-content;' class='mx-auto border mt-5 py-4 px-5'>");
        writer.println("<h6>Servlet Form Data</h6><h6>using getParameters()</h6>");
        writer.println("<div class='m-2'><div><label for='fname'>First Name</label></div><input type='text' name='fname'/></div>");
        writer.println("<div class='m-2'><div><label for='lname'>Last Name</label></div><input type='text' name='lname'/></div>");
        writer.println("<div class='m-2'><div><label for='email'>Email</label></div><input type='email' inputmode='email' name='email'/></div>");
        writer.println("<div class='m-2'><div><label for='rollno'>Roll No.</label></div><input type='text' name='rollno'/></div>");
        writer.println("<div class='m-2 mt-3'><input class='w-100' type='submit' value='Submit'/></div>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Counter extends HttpServlet{
    int counter = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
        PrintWriter writer = response.getWriter();
        counter++;
        writer.println("<html><head>"+link+"</head><body><h4>Counter!</h4><div>The current value of the counter is : "+ counter +"</div></body></html>");
    }   
}

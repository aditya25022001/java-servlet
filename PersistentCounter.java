import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PersistentCounter extends HttpServlet{
  int countServlet;
  public void init() throws ServletException{
    try{
      BufferedReader counter = new BufferedReader(new FileReader("D:\\counter.txt"));
      int count = Integer.parseInt(counter.readLine());
      countServlet = count;
      counter.close();
      return;
    }
    catch(Exception e){}
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
    countServlet++;
    PrintWriter writer = response.getWriter();
    String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
    writer.println("<html>");
    writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
    writer.println("<body>");
    writer.println("Counter value = "+countServlet);
    writer.println("</body>");
    writer.println("</head>");
  }
  public void destroy(){
    try {
      BufferedWriter counter = new BufferedWriter(new FileWriter("D:\\counter.txt"));
      counter.write(Integer.toString(countServlet));
      counter.close();
    } catch (Exception e) {}
  }
}
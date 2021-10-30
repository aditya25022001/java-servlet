import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignIn extends HttpServlet{
    public Boolean authenticate(String email, String password){
        Boolean unique = false;
        try{
            BufferedReader users = new BufferedReader(new FileReader("D:\\users.txt"));
            while(users.read()!=-1){
                String user = users.readLine();
                unique = user.split("########")[1].equals(email) && user.split("########")[2].equals(password);
                if(unique)
                    break;
            }
            users.close();   
        }
        catch(Exception e) { }   
        return unique;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
        if(authenticate(request.getParameter("email"), request.getParameter("password"))){
            writer.println("<html>");
            writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
            writer.println("<body>");
            writer.println("<div class='pl-5 mt-5'><h4>Signed In Successfully!</h4></div>");
            writer.println("<div class='pl-5 mt-2'>Email : "+request.getParameter("email")+"</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
        else{
            writer.println("<html>");
            writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
            writer.println("<body>");
            writer.println("<div class='pl-5 mt-5'>Invalid data</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }  
}

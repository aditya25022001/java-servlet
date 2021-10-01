import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignUp extends HttpServlet {
    public Boolean checkAvailability(String email){
        Boolean unique = true;
        try{
            BufferedReader users = new BufferedReader(new FileReader("D:\\users.txt"));
            while(users.read()!=-1){
                String user = users.readLine();
                String userEmail = user.split("########")[1];
                unique = !email.equals(userEmail);
            }
            users.close();   
        }
        catch(Exception e) { }
        return unique;
    }
    public Boolean matchPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        if(checkAvailability(request.getParameter("email")) && matchPassword(request.getParameter("password"), request.getParameter("cnfpassword"))){
            try{
                BufferedWriter users = new BufferedWriter(new FileWriter("D:\\users.txt", true));
                users.write(request.getParameter("name")+"########"+request.getParameter("email")+"########"+request.getParameter("password")+'\n');
                users.close();
                String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
                writer.println("<html>");
                writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
                writer.println("<body>");
                writer.println("<div class='pl-5 mt-5'><h4>Signed Up Successfully!</h4></div>");
                writer.println("<div class='pl-5 mt-2'>Name : "+request.getParameter("name")+"</div>");
                writer.println("<div class='pl-5 mt-2'>Email : "+request.getParameter("email")+"</div>");
                writer.println("</body>");
                writer.println("</html>");
            }
            catch(Exception e){
                String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
                writer.println("<html>");
                writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
                writer.println("<body>");
                writer.println("<div class='pl-5 mt-5'>Some Error occured</div>");
                writer.println("</body>");
                writer.println("</html>");
            }
        }
        else{
            String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>"; 
            writer.println("<html>");
            writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
            writer.println("<body>");
            writer.println("<div class='pl-5 mt-5'>Used Credentials or invalid data</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    };
}

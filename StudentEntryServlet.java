import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;

public class StudentEntryServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String link = "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU' crossorigin='anonymous'>";
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, String> paramDict = new HashMap<String, String>();
        paramDict.put("fname","First Name");
        paramDict.put("lname","Last Name");
        paramDict.put("email","College Email");
        paramDict.put("rollno","Roll Number");
        paramDict.put("about","About");
        paramDict.put("gender","Gender");
        paramDict.put("branch","Branch");
        paramDict.put("sem","Semester");
        paramDict.put("languages","Languages");
        paramDict.put("elective","Elective");
        writer.println("<html>");
        writer.println("<head>"+link+"<title>getParameters() Method</title></head>");
        writer.println("<body>");
        writer.println("<table class='table table-bordered m-5' style='width:93vw;'>");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th scope='col'>Parameter</th>");
        writer.println("<th scope='col'>Value</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        while(paramNames.hasMoreElements()){
            writer.println("<tr>");
            String param = paramNames.nextElement();
            writer.println("<td scope='row'>"+paramDict.get(param)+"</td>");
            if(paramDict.get(param)=="Languages"){
                String[] languages = request.getParameterValues(param);
                writer.println("<td>");
                for(int i=0;i<languages.length;++i) {
                    writer.println("<li>"+languages[i]+"</li>");
                }
                writer.println("</td>");
            }else{
                writer.println("<td>"+request.getParameter(param)+"</td>");
            }
            writer.println("</tr>");
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }
}

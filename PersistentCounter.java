import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PersistentCounter extends HttpServlet {
  int count;
  public void init() throws ServletException {
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      fileReader = new FileReader("InitDestroyCounter.initial");
      bufferedReader = new BufferedReader(fileReader);
      String initial = bufferedReader.readLine();
      count = Integer.parseInt(initial);
      return;
    }
    catch (FileNotFoundException ignored) { }  
    catch (IOException ignored) { }            
    catch (NumberFormatException ignored) { }  
    finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      }
      catch (IOException ignored) { }
    }
    String initial = getInitParameter("initial");                    
    try {                                                            
      count = Integer.parseInt(initial);                             
      return;                                                        
    }                                                                
    catch (NumberFormatException ignored) { }
    count = 0;                                                       
  }                                                                  
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain");                                
    PrintWriter out = res.getWriter();                               
    count++;                                                         
    out.println("Since the beginning, this servlet has been accessed " + count + " times.");                                  
  }                                                                 
                                                                     
  public void saveState() {                                          
    FileWriter fileWriter = null;
    PrintWriter printWriter = null;
    try {                                                            
      fileWriter = new FileWriter("InitDestroyCounter.initial");
      printWriter = new PrintWriter(fileWriter);         
      printWriter.println(count);                                  
      return;                                                        
    }                                                                
    catch (IOException e) {}
    finally {
      if (printWriter != null) {
        printWriter.close();
      }
    }
  }
}
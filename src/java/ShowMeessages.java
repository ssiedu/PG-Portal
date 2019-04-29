import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMeessages extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email=(String)request.getSession().getAttribute("userid");
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Inbox For : "+email+"</h3>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<th>MsgId</th>");
            out.println("<th>Sender</th>");
            out.println("<th>Message</th>");
            out.println("<th>Date</th>");
            out.println("</tr>");
            
            try{
                String sql="select * from messages where receipt=?";
                Connection con=mypkg.Util.connect();
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,email);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                String s1=rs.getString("msgid");
                String s2=rs.getString("sender");
                String s3=rs.getString("message");
                String s4=rs.getString("mdate");
                String s5=rs.getString("pcode");
                out.println("<tr>");
                out.println("<td>"+s1+"</td>");
                out.println("<td>"+s2+"</td>");
                out.println("<td>"+s3+"</td>");
                out.println("<td>"+s4+"</td>");
                out.println("<td><a href=PropertyDetails?code="+s5+">P-Details</a></td>");
                out.println("</tr>");
                }
                con.close();
            }catch(Exception e){
                out.println(e);
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=ownerdashboard.jsp>OwnerPage</a>");
            out.println("</body>");
            out.println("</html>");
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

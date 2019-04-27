import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OwnerDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String code=request.getParameter("code");
        String sql="select email,name,hno,street,city,state,mobile from users where email=(select email from property where pcode=?)";
        try{
            Connection con=mypkg.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(code));
            ResultSet rs=ps.executeQuery();
            rs.next();
            String email=rs.getString(1);
            String name=rs.getString(2);
            String address=rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6);
            String mobile=rs.getString(7);
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Owner-Details For PCode : "+code+"</h3>");
            out.println("<hr>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td>"+name+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Address</td>");
            out.println("<td>"+address+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Email</td>");
            out.println("<td>"+email+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Mobile</td>");
            out.println("<td>"+mobile+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=messageform.jsp?owneremail="+email+">Send-Message</a><br>");
            out.println("<a href=customerdashboard.jsp>Customer-Dashboard</a>");
            out.println("</body>");
            out.println("</html>");
            
            
            
            con.close();
        }catch(Exception e){
            out.println(e);
        }

        
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

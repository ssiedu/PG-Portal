import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowUnactivatedOwners extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Property Onwners Who Applied For Account<h3>");
        out.println("<hr>");
        out.println("<table border=2>");
        out.println("<tr>");
        out.println("<th align=left>Email</th>");
        out.println("<th align=left>Name</th>");
        out.println("<th align=left>Address</th>");
        out.println("<th align=left>Mobile</th>");
        out.println("<tr>");
        String sql="select * from users where utype='owner' and status='applied'";
        try{
            Connection con=mypkg.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String email=rs.getString("email");
                String name=rs.getString("name");
                String address=rs.getString("hno")+","+rs.getString("street")+","+rs.getString("city")+","+rs.getString("state");
                String mobile=rs.getString("mobile");        
                out.println("<tr>");
                out.println("<td>"+email+"</td>");
                out.println("<td>"+name+"</td>");
                out.println("<td>"+address+"</td>");
                out.println("<td>"+mobile+"</td>");
                out.println("<td><a href=ChangeOwnerStatus?id="+email+">Activate</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=admindashboard.jsp>Admin-Dashboard</a>");
            out.println("</body>");
            out.println("</html>");
            
            con.close();
        }catch(Exception e){
            out.println(e);
        }
        
        
        out.close();
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

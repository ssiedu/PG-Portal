
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowAllProperties extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sql = "select pcode,ptype,ftype,fdesc,rent,ctype,hno,street,city,state,status from property where status='vacant'";
        out.println("<html><body>");
        out.println("<h3>Your Property Details</h3>");
        out.println("<hr>");
        out.println("<table border=2>");
        out.println("<tr>");
        out.println("<th>PCode</th>");
        out.println("<th>PType</th>");
        out.println("<th>FType</th>");
        out.println("<th>FDesc</th>");
        out.println("<th>Rent</th>");
        out.println("<th>Address</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        try {
            Connection con = mypkg.Util.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pcode = rs.getString(1);
                String ptype = rs.getString(2);
                String ftype = rs.getString(3);
                String fdesc = rs.getString(4);
                String rent = rs.getString(5);
                String ctype = rs.getString(6);
                String address = rs.getString(7) + "," + rs.getString(8) + "," + rs.getString(9) + "," + rs.getString(10);
                String status = rs.getString(11);
                out.println("<tr>");
                out.println("<td>"+pcode+"</td>");
                out.println("<td>"+ptype+"</td>");
                out.println("<td>"+ftype+"</td>");
                out.println("<td>"+fdesc+"</td>");
                out.println("<td>"+rent+"</td>");
                out.println("<td>"+address+"</td>");
                out.println("<td>"+status+"</td>");
                out.println("<td><img width=50 height=50 src=\"ImageLoader?code="+pcode+"\"/></td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (Exception e) {
            out.println(e);
        }

        out.println("<hr>");
        out.println("<a href=customerdashboard.jsp>Customer-Dashboard</a>");
        out.println("</body></html>");

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

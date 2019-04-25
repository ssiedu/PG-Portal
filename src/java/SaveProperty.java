import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveProperty extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //reading email from session
        HttpSession session=request.getSession();
        String email=(String) session.getAttribute("userid");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String ptype=request.getParameter("ptype");
        String ftype=request.getParameter("ftype");
        String fdesc=request.getParameter("fdesc");
        String rent=request.getParameter("rent");
        String ctype=request.getParameter("ctype");
        String hno=request.getParameter("hno");
        String street=request.getParameter("street");
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        String sql="insert into property(email,ptype,ftype,fdesc,rent,ctype,hno,street,city,state,status) values(?,?,?,?,?,?,?,?,?,?,'vacant')";
        try{
            Connection con=mypkg.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,ptype);
            ps.setString(3,ftype);
            ps.setString(4,fdesc);
            ps.setInt(5,Integer.parseInt(rent));
            ps.setString(6,ctype);
            ps.setString(7,hno);
            ps.setString(8,street);
            ps.setString(9,city);
            ps.setString(10,state);
            ps.executeUpdate();
            con.close();

            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Property Added</h3>");
            out.println("<h5><a href=propertyentry.jsp>Add-More</a></h5>");
            out.println("<h5><a href=ownerdashboard.jsp>Owner-Dashboard</a></h5>");
            out.println("</body>");
            out.println("</html>");
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

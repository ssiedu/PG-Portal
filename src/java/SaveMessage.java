import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveMessage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String receipt=request.getParameter("messageto");
        String messagetext=request.getParameter("messagetext");
        String code=request.getParameter("code");
        HttpSession session=request.getSession();
        String sender=(String)session.getAttribute("userid");
        java.util.Date dt=new java.util.Date();
        java.sql.Date sqldate=new java.sql.Date(dt.getTime());
        String sql="insert into messages(sender,receipt,message,mdate,pcode) values(?,?,?,?,?)";
        try{
            Connection con=mypkg.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,sender);
            ps.setString(2,receipt);
            ps.setString(3,messagetext);
            ps.setDate(4, sqldate);
            ps.setInt(5,Integer.parseInt(code));
            ps.executeUpdate();
            con.close();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Message Delivered</h3>");
            out.println("<h4><a href=customerdashboard.jsp>Customer-Dashboard</a></h4>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception e){
            
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

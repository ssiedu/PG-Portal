import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //reads the data
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String uname=request.getParameter("uname");
            String utype=request.getParameter("utype");
            String hno=request.getParameter("hno");
            String street=request.getParameter("street");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String mobile=request.getParameter("mobile");
            
        //process the data (storing the data to DB (JDBC)
        try{
            Connection con=mypkg.Util.connect();
            String sql="insert into users values(?,?,?,?,?,?,?,?,?,'applied')";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, uname);
            ps.setString(4, utype);
            ps.setString(5, hno);
            ps.setString(6, street);
            ps.setString(7, city);
            ps.setString(8, state);
            ps.setString(9, mobile);
            ps.executeUpdate();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //provides the response
        PrintWriter out=response.getWriter();
        out.println("Registration Completed Successfully");
        
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

<%
    String owneremail=request.getParameter("owneremail");
    String code=request.getParameter("code");
%>
<html>
    <body>
        <h3>Message-Sending-Form</h3>
        <hr>
        <form action="SaveMessage">
            <pre>
            To  <input type="text" name="messageto" value="<%=owneremail%>"/>
            Msg <input type="text" name="messagetext"/>
                <input type="hidden" name="code" value="<%=code%>">
                <input type="submit" value="Send"/>
            </pre>
        </form>
        <hr>
        <a href="customerdashboard.jsp">Customer-Dashboard</a>
    </body>
</html>

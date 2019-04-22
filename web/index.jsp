<html>
    <body>
        <h3>Paying-Guest-Portal</h3>
        <hr>
        <form action="VerifyUser">
            <pre>
            Email       <input type="text" name="email"/>
            Password    <input type="password" name="password"/>
            UType       <select name="utype">
                        <option>owner</option>
                        <option>customer</option>
                        <option>admin</option>
                        </select>
                        <input type="submit" value="Login"/>
            </pre>
        </form>    
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>

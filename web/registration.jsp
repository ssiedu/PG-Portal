<html>
    <body>
        <h3>Paying-Guest-Portal</h3>
        <h4>New-User-Registration</h4>
        <hr>
        <form action="SaveUser">
            <pre>
            Email       <input type="text" name="email"/>
            Password    <input type="password" name="password"/>
            Username    <input type="text" name="uname"/>
            UType       <select name="utype">
                        <option>owner</option>
                        <option>customer</option>
                        </select>
            HouseNo     <input type="text" name="hno"/>
            Street      <input type="text" name="street"/>
            City        <select name="city">
                        <option>bhopal</option>
                        <option>chennai</option>
                        <option>delhi</option>
                        <option>indore</option>
                        <option>mumbai</option>
                        <option>pune</option>
                        </select>
            State       <select name="state">
                        <option>MP</option>
                        <option>MH</option>
                        <option>UP</option>
                        </select> 
            Mobile      <input type="text" name="mobile"/>            
                        <input type="submit" value="Register"/>
            </pre>
        </form>    
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>

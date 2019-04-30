<html>
    <body>
        <h3>Paying-Guest-Portal</h3>
        <h4>Property-Registration</h4>
        <hr>
        <form action="StoreProperty" method="post" enctype="multipart/form-data">
            <pre>
            Prop-Type   <select name="ptype"/>
                            <option>Room</option>
                            <option>Flat</option>
                            <option>Aprt</option>
                        </select>
            Food-Type   <select name="ftype"/>
                            <option>Veg</option>
                            <option>NonVeg</option>
                            <option>NotProvided</option>
                        </select>
            Facilities  <input type="text" name="fdesc"/>            
            Rent        <input type="text" name="rent"/>
            CustType    <select name="ctype">
                        <option>student-male</option>
                        <option>student-female</option>
                        <option>working-male</option>
                        <option>working-female</option>
                        <option>family</option>
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
            Picture     <input type="file" name="pimg"/>         
                        <input type="submit" value="Save-Details"/>
            </pre>
        </form>    
        <hr>
        <a href="ownerdashboard.jsp">Owner-Home</a>
    </body>
</html>

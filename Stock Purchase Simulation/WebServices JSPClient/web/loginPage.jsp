<%-- 
    Document   : loginPage
    Created on : 14-Jan-2018, 21:33:42
    Author     : Toby Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <style>
    body {
        background-color: rgb(168, 191, 244);
    }
    </style>
    <body>
        <center>

            <h2> Login</h2>
            <form method="get" action="loginPage.jsp"  > 
            Username: <input id="loginUsername" type="text" name="loginUsername" value="username"  required="required"> <br />
            Password: <input  id="loginPassword" type="password" name="loginPassword" value="password"  required="required"> <br />
            <input type="submit" id="btnLogin"  value="Login" ><br/>
            </form>
            
               
            <%
            String loginMessage = "";
            java.lang.Boolean userValidationSuccess = false;

            try {
                org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();
                 // TODO initialize WS operation arguments here
                //loginMessage = request.getParameter("loginUsername");
                if (!(request.getParameter("loginUsername").equals("username"))){
                    java.lang.String username = request.getParameter("loginUsername");
                    java.lang.String password = request.getParameter("loginPassword");

                    // TODO process result here
                    userValidationSuccess = port.userLogin(username, password);
                    //out.println("Result = "+result);

                    if (userValidationSuccess == true){
                        loginMessage = "Login Success";
                        out.print("<script> location.href = 'sellStock.jsp'; </script> ");
                    } else if (userValidationSuccess == false){
                        loginMessage = "Username and/or password not valid";
                    }
 
                }else{
                   loginMessage = "Please enter your username and password"; 
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                //System.out.println("");
            }
            %>
            
            
            <p> <%= loginMessage %> </p>
            
            <hr/> <hr/>

            <h2> Create User </h2>
            <form action="loginPage.jsp" >
            Username: <input id="username" type="text" name="username"  required="required"> <br />
            Password: <input  id="password" type="password" name="password"  required="required"> <br />
            First Name <input  id="fname" type="text" name="fname"  required="required"> <br />
            <input type="submit" id="btnCreateUser"  value="Create User"  required="required"><br/>
            </form>
            

            <%
                String outputMessage = "";
                
            try {
                org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();
                 // TODO initialize WS operation arguments here
                 if ((request.getParameter("username") != null) && (request.getParameter("username") != "username") 
                         && (request.getParameter("password") != "password")){
                    java.lang.String username = request.getParameter("username");
                    java.lang.String password = request.getParameter("password");
                    java.lang.String firstname = request.getParameter("fname");
                 
                    // TODO process result here
                    if (port.addUser(username, password, firstname) == true )
                    {
                        outputMessage = "User created successfully";
                    } else {
                        outputMessage = "Username already exists";
                    }
                 } else {
                     outputMessage = "Username and password cannot be blank. Username cannot be username and Password cannot be password";
                 }
                //out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
             <p> <%= outputMessage %> </p>
            <hr/><hr/> 

        </center>
    
    
        
        
        
    </body>
</html>

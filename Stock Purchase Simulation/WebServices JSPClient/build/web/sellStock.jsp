<%-- 
    Document   : sellStock
    Created on : 15-Jan-2018, 08:44:06
    Author     : Toby Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Shares</title>
    </head>
    <style>
    body {
        background-color: rgb(168, 191, 244);
    }
    </style>
    <body>
    <center>
        <h1>Sell your Stock to Toby's Exchange</h1>

        <form method="get"  > 
            Company Name: <input id="companyName" type="text" name="companyName" required="required" > <br /><br/>
            Symbol: <input  id="companySymbol" type="text" name="companySymbol" required="required"> <br /> <br/>
            Volume: <input id="volume" type="bumber" name="volume" min="1" required="required"> <br /> <br/>
            Value: <input  id="value" type="number" name="value"  min="0" step="any" required="required"> <br /> <br/>
            <input type="submit" id="btnSaveSahre"  value="Create Share"><br/>
        </form>
        <br /><br/>
        
        <input type="button" onclick="location.href='index.jsp';" value="Home" /> 
        
            <%-- start web service invocation --%><hr/>
            <%
            String output = "";
            try {
                org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();
                 // TODO initialize WS operation arguments here
                java.lang.String name = request.getParameter("companyName");
                java.lang.String symbol = request.getParameter("companySymbol");
                int volume = Integer.parseInt(request.getParameter("volume"));
                int value = Integer.parseInt(request.getParameter("value"));
                // TODO process result here
                out.print(name+symbol+value+volume);
                Boolean result = port.addStock(name, symbol, volume, value);
                //out.println("Result = "+output);
                
                if (result == true){
                    output = "Your stock was successfully saved";
                } else if (result == false){
                    output = "You stock already exists";
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                //out.print("There seems to be an issue with creating stock. Please try again later");
                
            }
            %>
            <%-- end web service invocation --%><hr/>

            <p> <%= output %> </p>
    </center>
    
    
    </body>
</html>

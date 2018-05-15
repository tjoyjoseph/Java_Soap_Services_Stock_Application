<%-- 
    Document   : index
    Created on : 22-Dec-2017, 12:25:22
    Author     : Toby Joseph
--%>

<%@page import="org.netbeans.xml.schema.shows.CompanyShare"%>

<%@page import="com.sun.xml.rpc.processor.util.StringUtils"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javafx.scene.control.cell.PropertyValueFactory"%>
<%@page import="javafx.scene.control.TableColumn"%>
<%@page import="javafx.scene.control.TableView"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page import="javafx.collections.FXCollections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="8" />
        <title>Toby's Stock Exchange</title>

        
    </head>
    <style>
    body {
        background-color: rgb(168, 191, 244);
    }
    </style>
        <h1><center>Toby's Stock Exchange</center></h1>
        
        <input type="button" onclick="location.href='loginPage.jsp';" value="Admin Login" />
        

        <script>
            //alert(sessionStorage.getItem("sortTypeValue")); 
            if (sessionStorage.getItem("sortTypeValue") == '0')
            {
                //alert("hello");
                r1checked = 'checked';
            }
            
           // alert(selectedSort);
            
        </script>
        
    <center>   
        <form action="index.jsp" >
        Company Name: <input id="companyName" type="text" name="companyName" >
        Shares Wanted: <input  id="sharesRequired" type="number" name="sharesRequired" min="1">
        <input type="submit" id="btnBuyShares"  value="Buy"><br/>
        </form>
        
        <br/>
    
        <form id="sortForm"  name="sortForm" method="get" action="index.jsp" onsubmit="onSortFormSelection()">
            <INPUT TYPE="radio" name="sortType" id="LHSort" value="0"   />Low to High (Price)
            <INPUT TYPE="radio" name="sortType" id="HLSort" value="1"  />High to Low (Price)
            <INPUT TYPE="radio" name="sortType" id="ASort" value="2"  />Alphabetical 
            <br/><br/>
            Filter: <input id="filterValue" type="text" name="companyFilterValue" >
            Preferred Currency Format: 
            <select name="currencyType" id="currencyType">
                    <%-- start web service invocation --%><hr/>
                <%
                try {
                    org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                    org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();
                    // TODO process result here
                    java.util.List<java.lang.String> result = port.getCurrencyNames();
                    //out.println("Result = "+result);
                    
                    for (int i = 0; i < result.size(); i++){
                        String tempString = result.get(i).substring(0, 3);
                        
                        out.println("<option value=\""+tempString+"\">"+tempString+"</option>");
                        
                    }
                    
                    
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                %>
                <%-- end web service invocation --%><hr/>
             </select>
            <INPUT  TYPE="submit" value="Filter"  />
        </form>
            
        <script>
            
            //function document.getElementById('sortForm').onsubmit(){
            //document.getElementById('sortForm').onsubmit() = function() {myFunction();};
            
            if (sessionStorage.getItem("sortTypeValue") == '0'){
                document.getElementById('LHSort').checked = true;
            } else if (sessionStorage.getItem("sortTypeValue") == '0'){
               document.getElementById('HLSort').checked = true; 
            } else {
                document.getElementById('ASort').checked = true;
            }
            document.getElementById("filterValue").value = sessionStorage.getItem("filterValue");
            document.getElementById("currencyType").value = sessionStorage.getItem("currencyType");
            

            function onSortFormSelection() {
                var sortFormType = document.getElementsByName('sortType');
                
                for (var i = 0; i < sortFormType.length; i++){
                    if (sortFormType[i].checked){
                        sessionStorage.setItem("sortTypeValue",sortFormType[i].value.toString()) ;
                        //alert(sortFormType[i].value);
                    }
                }
                sessionStorage.setItem("filterValue",document.getElementById("filterValue").value); 
                sessionStorage.setItem("currencyType",document.getElementById("currencyType").value); 
                
               
            }   
        </script>

        <script>
            document.getElementById(btnBuyShares).onclick()
            {
                <% 
                   out.println("document.getElementById('getSharesOutput').innerHTML = "+ request.getParameter("sharesRequired")); 
                %>  
            };
        </script>
        
 
        <%
        String companyName = "";
        String sharesWanted = "";
        if ((request.getParameter("companyName") != null) && (request.getParameter("sharesRequired") != null)) {
                companyName = request.getParameter("companyName");
  
                sharesWanted = request.getParameter("sharesRequired");

                try {
                    org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                    org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();

                    // TODO process result here
                    java.lang.String output = port.buyShares(companyName, Integer.parseInt(sharesWanted));
                    out.println(output);//+" <script> document.sortingOptions.submit() </scipt>");
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                    out.println("Please ensure Company Name is a valid text and Amount of Shares is a valid number");
                }

            }

            //out.println("document.getElementById('getSharesOutput').innerHTML = document.getElementById('companyName').value + '  ' + document.getElementById('sharesRequired').value");
            // out.println(companyName+" "+sharesWanted);
        %> 
    </center>
    <p> </p>
    <div id="StockTable">

        <div id="table-wrapper" >
          <div id="table-scroll" >
              <center>
            <table width="50%" height="10px" overflow:auto >
                <thead>
                    <tr>
                        <th><span class="text">Company Name         </span></th>
                        <th><span class="text">Symbol               </span></th>
                        <th><span class="text">Volume               </span></th>
                        <th><span class="text">Currency             </span></th>
                        <th><span class="text">Price                </span></th>
                        <th><span class="text">Last Updated          </span></th>
                    </tr>
                </thead>
                <tbody>
                  <!-- etc... -->
                            <%-- start web service invocation --%><hr/>
                 <%
                    
                    List<CompanyShare> companyShares = new ArrayList<CompanyShare>();
                    //java.util.List<java.util.List<java.lang.String>> allShares = new ArrayList<java.util.List<String>>();
                    CompanyShare tempShare = new CompanyShare();
                    try {
                        org.me.shares.PurchaseShares_Service service = new org.me.shares.PurchaseShares_Service();
                        org.me.shares.PurchaseShares port = service.getPurchaseSharesPort();
                        int arg0 = 0;
                        
                        String filterValue = request.getParameter("companyFilterValue"); //request.getParameter("filterValue");
                        if (filterValue == ""){filterValue = null;}
                        //out.println(filterValue);
                        
                        //String[] currencies = {"AED","ARS","AUD","BGN","BRL","BWP",
                            //"CAD","CHF","CLP","CNY","COP","DKK","EEK","EGP","EUR",
                            //"GBP","HKD","HRK","HUF","ILS","INR","ISK","JPY","KRW",
                            //"KZT","LKR","LTL","LVL","LYD","MXN","MYR","NOK","NPR",
                            //"NZD","OMR","PKR","QAR","RON","RUB","SAR","SDG","SEK",
                            //"SGD","THB","TRY","TTD","TWD","UAH","USD","VEB","ZAR"};
                        //java.util.List<java.lang.String> listOfCurrency = new ArrayList<java.lang.String>();
                        //Collections.addAll(listOfCurrency, currencies);
                        
                        String currencyType = request.getParameter("currencyType");
                        if (currencyType == "")
                        {currencyType = null;}
                        
                        companyShares = port.getShares(filterValue, currencyType);
                        
                        
                        

//                        while (port.getShares(filterValue,currencyType).get(0) != null)
//                        {
//                            tempShare = port.getShares(arg0,filterValue,currencyType);
//                            allShares.add(tempShare);
//                            out.println("<p hidden> "+allShares.get(arg0).get(4)+" </p>");
//                            arg0++; 
//                        }                         

                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                        //out.println(ex);
                    }

                    String sortType = request.getParameter("sortType");
                    if(companyShares.size() > 0){
                        if(sortType != (null)){
                            for (int i = 0; i < companyShares.size(); i++)
                            {
                                for (int x = 1; x < (companyShares.size() - i); x++)
                                { 
                                    if (sortType.charAt(0) == '0')
                                    {
                                        if(Double.valueOf(companyShares.get(x-1).getSharePrice().getValue()) > Double.valueOf(companyShares.get(x).getSharePrice().getValue()))
                                        {
                                            tempShare = companyShares.get(x-1);
                                            companyShares.set(x-1, companyShares.get(x));
                                            companyShares.set(x,tempShare);
                                        }
                                    }
                                    else if(sortType.charAt(0) == '1')
                                    {
                                        if(Double.valueOf(companyShares.get(x-1).getSharePrice().getValue()) < Double.valueOf(companyShares.get(x).getSharePrice().getValue()))
                                        {
                                            tempShare = companyShares.get(x-1);
                                            companyShares.set(x-1, companyShares.get(x));
                                            companyShares.set(x,tempShare);
                                        }
                                    }
                                }
                            } 
                        }

                        for (int i = 0; i < companyShares.size(); i++)
                        {
//                            if (!("".equals(companyShares.get(i).getCompanyName())))
//                            {
                                out.println("<tr><td><center>"+companyShares.get(i).getCompanyName()
                                        +"</center></td><td><center>"+companyShares.get(i).getCompanySymbol()
                                        +"</center></td><td><center>"+companyShares.get(i).getNumOfAvailShares()
                                        +"</center></td><td><center>"+companyShares.get(i).getSharePrice().getCurrency()
                                        +"</center></td><td><center>"+companyShares.get(i).getSharePrice().getValue()
                                        +"</center></td><td><center>"+companyShares.get(i).getSharePrice().getDateOfLastUpdate()
                                        +"</center></td> </tr>");
                            //}
                        }
                    }else{
                        out.println("No companies to be displayed");
                    }
                 %>
                </tbody>
            </table>
            </center>
          </div>
        </div>
    </div>
                <script>
                    function updateDiv()
                    { 
                       // $( "#StockTable" ).load(window.location.href + " #StockTable" );
                        $("#StockTable").load("index.jsp");// a function which will load data from other file after x seconds
                    }, 10000);
                    
                    //setInterval('updateDiv()', 1000); // refresh div after 5 secs
                </script>
                

        
    </body>
</html>

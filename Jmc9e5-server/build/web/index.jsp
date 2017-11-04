<%-- 
    Document   : index
    Created on : Nov 4, 2017, 3:26:50 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #sentMessage {
                color: red;
            }
            
            #receivedMessage {
                color: green;
            }
        </style>
        <script type="text/javascript">
            function send() {
                var mesaj = document.getElementById("msgInput").value;
                var text = document.getElementById("display").innerHTML;        
                document.getElementById("display").innerHTML = text + "<p id='sentMessage'>" + mesaj + "</p>";
                myapp.sendMessage(mesaj);
            }
            
            function receive(mesaj) {
                var text = document.getElementById("display").innerHTML;     
                document.getElementById("display").innerHTML = text + "<p id='receivedMessage'>" + mesaj + "</p>";
            }
            
        </script>
    </head>
    <body>
        <input type="text" id="msgInput" />
        <button onclick="send()">SEND</button>
        
        <div id="display">
            
        </div>
    </body>
</html>

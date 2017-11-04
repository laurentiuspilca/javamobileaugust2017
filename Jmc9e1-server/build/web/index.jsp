<%-- 
    Document   : index
    Created on : Nov 4, 2017, 1:47:30 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function makeRed() {
                document.getElementById("hello").style.color = '#FF0000'
            }
            
            function afisareToast() {
                myapp.afisareMesaj();
            }
        </script>
    </head>
    <body>
        <h1 id="hello">Hello World! V2</h1>
        
        <a href="javascript:makeRed()">RED</a>
        <a href="javascript:afisareToast()">SHOW TOAST</a>
    </body>
</html>

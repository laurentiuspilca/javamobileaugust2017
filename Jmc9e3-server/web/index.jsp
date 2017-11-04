<%-- 
    Document   : index
    Created on : Nov 4, 2017, 2:34:06 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function setText(x,y,z) {
                document.getElementById("x").innerHTML = "X: " + x;
                document.getElementById("y").innerHTML = "Y: " + y;
                document.getElementById("z").innerHTML = "Z: " + z;
            }
            
        </script>
    </head>
    <body>
        <h1 id="x">X: 0</h1>
        <h1 id="y">Y: 0</h1>
        <h1 id="z">Z: 0</h1>
    </body>
</html>

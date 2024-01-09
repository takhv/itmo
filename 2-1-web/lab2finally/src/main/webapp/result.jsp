<%@ page import="listOfDots.Dots" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Result</title>
        <link rel="stylesheet" href="./styles.css" />
    </head>
    <body>
        <h2>Result:</h2>
        <table class="resultTable">
            <thead>
            <td>X</td>
            <td>Y</td>
            <td>R</td>
            <td>RESULT</td>
            </thead>
            <tbody id="tableOut">
                <%
                    if (!Dots.points.isEmpty()) {
                        for (int i = 0; i < Dots.points.size()-1; i++) {
                            out.println(Dots.points.get(i).toString());
                        }
                    }
                %>
            </tbody>
        </table><br>

        <button type="button" onclick="backReturn()">Return</button>
    </body>
<script src="script.js"></script>
</html>
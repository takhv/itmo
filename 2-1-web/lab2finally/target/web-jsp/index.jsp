<%@ page import="listOfDots.Dots" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title> lab2 </title>
    <link rel="stylesheet" href="./styles.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <!-- who made this shit -->
    <div id="header">
			<span class="name">
				<h3>Выполнил: <b><u>Тахватулин Михаил Витальевич</u></b><br></h3>
			</span>
        <span class="group">
				<h4>Группа: <b><u>P3207</u></b></h4>
			</span>
        <span class="variant">
				<h4>Вариант: <b><u>17124</u></b></h4>
			</span>
    </div>

    <!-- shit is working -->
    <div class="lab">
        <!-- picture with graphics -->

        <!-- getting some fucking values and put them to purple elephant language -->
        <div id="values">

            <form method="post" id="form" action="controller">
                <b>Y:</b>
                <input id="y" class="input js-input-y" type="text" name="y" size="10" placeholder="From -3 to 5"><br><br>

                <b>Radius:</b>
                <input id="r" class="input js-input-r" type="text" name="radius" size="10" placeholder="From 2 to 5"><br>

                <br><b>X:</b><br>
                <ul>
                    <li><input id="x9" type="radio" name="x" value="-4"> -4 </li>
                    <li><input id="x1" type="radio" name="x" value="-3"> -3 </li>
                    <li><input id="x2" type="radio" name="x" value="-2"> -2 </li>
                    <li><input id="x3" type="radio" name="x" value="-1"> -1 </li>
                    <li><input id="x4" type="radio" name="x" value="0" checked> 0 </li>
                    <li><input id="x5" type="radio" name="x" value="1"> 1 </li>
                    <li><input id="x6" type="radio" name="x" value="2"> 2 </li>
                    <li><input id="x7" type="radio" name="x" value="3"> 3 </li>
                    <li><input id="x8" type="radio" name="x" value="4"> 4 </li>
                </ul><br>
                <input type="submit" value="send" class="btn">
            </form>
        </div>
    </div>

    <!-- totally final ending table -->
    <div class="finaltable">
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
        <button class="btn">Clear table</button>
    </div>
</div>
<script src="script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
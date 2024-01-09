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
				<h3>Выполнил: <b><u>Тахватулин Михаил Витальевич</b></u><br></h3>
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
			<img src="task2.jpg" alt="">

			<!-- getting some fking values and put them to purple elephant language -->
			<div id="values">
				
				<form action="../java/servlets/AreaCheckServlet.java" id="zapros" method="post" onsubmit="return false" class="js-form">
					<b>Y:</b>
					<input id="y" class="input js-input-y" type="text" name="y" size="10" placeholder="From -3 to 3"><br><br>

					<b>Radius:</b>
					<input id="r" class="input js-input-r" type="text" name="r" size="10" placeholder="From 1 to 4"><br>

					<br><b>X:</b><br>
					<ul>
						<li><input id="x1" type="radio" name="x" value="-3"> -3 </li>
						<li><input id="x2" type="radio" name="x" value="-2"> -2 </li>
						<li><input id="x3" type="radio" name="x" value="-1"> -1 </li>
						<li><input id="x4" type="radio" name="x" value="0" checked> 0 </li>
						<li><input id="x5" type="radio" name="x" value="1"> 1 </li>
						<li><input id="x6" type="radio" name="x" value="2"> 2 </li>
						<li><input id="x7" type="radio" name="x" value="3"> 3 </li>
						<li><input id="x8" type="radio" name="x" value="4"> 4 </li>
						<li><input id="x9" type="radio" name="x" value="5"> 5 </li>
					</ul><br>
					<input type="submit" accesskey="r" class="btn" value="send">
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
					<td>Current time</td>
					<td>Computation time</td>
				</thead>
				<tbody id="tableOut">
				</tbody>
			</table><br>
			<button class="btn" onclick="clearTable()">Clear table</button>
		</div>
	</div>
	<script src="./script.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	</body>
</html>
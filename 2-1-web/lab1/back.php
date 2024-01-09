<?php

$starttime = microtime();
$x = !empty($_POST['x']) ? $_POST['x']:'0';
$y = !empty($_POST['y']) ? $_POST['y']:'0';
$r = !empty($_POST['r']) ? $_POST['r']:'0';
$answer = '';
$flag = false;
$out = '';

preg_match('/\-?\d+\.?\d{0,}/', $x, $matches);
if (count($matches) == 1 && $matches[0] == $x) {
	$x = (float)$x;
} else {
	exit("X должен быть float");
}

preg_match('/\-?\d+\.?\d{0,}/', $y, $matches);
if (count($matches) == 1 && $matches[0] == $y) {
	$y = (float)$y;
} else {
	exit("Y должен быть float");
}

preg_match('/\-?\d+\.?\d{0,}/', $r, $matches);
if (count($matches) == 1 && $matches[0] == $r) {
	$r = (float)$r;

	if ($r <= 0) {
		exit("R должен быть больше 0");
	}
} else {
	exit("R должен быть float");
}

if ($x <= -3 || $x >= 5) {
	$vremya = date('h:i:s A');
	exit("<tr><td>X вне диапазона (-3; 5)</td><td>-</td><td>-</td><td>Ошиб очка</td><td>$vremya</td><td>$starttime</td></tr>");
}
if ($y <= -3 || $y >= 3) {
	exit("");
	$vremya = date('h:i:s A');
	#exit("<tr><td>-</td><td>Y вне диапазона (-5; 3)</td><td>-</td><td>Ошиб очка</td><td>$vremya</td><td>$starttime</td></tr>");
}
if ($r <= 1 || $r >= 4) {
	echo "<script>rErr();</script>";
	$vremya = date('h:i:s A');
	exit("<tr><td>-</td><td>-</td><td>R вне диапазона (1; 4)</td><td>Ошиб очка</td><td>$vremya</td><td>$starttime</td></tr>");
}


if (
	($x >= 0 && $y >= 0 && ($y + 2 * $x) <= $r) ||
	($x <= 0 && $y >= 0 && $x >= ((-1)* $r) && (2 * $y) <= $r) ||
	($x <= 0 && $y <= 0 && ($x * $x + $y * $y) <= ($r * $r / 4))
) {
	$answer = 'Входит';
} else {
	$answer = 'Не входит';
}

$out .= "<tr>";
$out .= "<td>$x</td>";
$out .= "<td>$y</td>";
$out .= "<td>$r</td>";
$out .= "<td>$answer</td>";
$vremya = date('h:i:s A');
$out .= "<td>$vremya</td>";
$out .= "<td>$starttime</td>";
$out .= "</tr>";
echo $out;

?>

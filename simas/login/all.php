<?php
$dbHost='localhost';
$dbUser='root';
$dbPass='';
$dbName='gudang';
	
$pdo=new PDO("mysql:dbname=".$dbName.";host=".$dbHost,$dbUser, $dbPass);
$stmt = $pdo->prepare("SELECT * FROM barang;");
$stmt->execute();
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);
echo json_encode($results);
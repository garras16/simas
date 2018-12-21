<?php
	include "connection.php";

	$id = $_GET['id'];

	$query = mysqli_query($con, "SELECT * FROM barang WHERE kode=".$id);
	$json_resp = array();

	if(mysqli_num_rows($query) != 0) {
		while ($data = mysqli_fetch_assoc($query)) {
			$json_resp[] = $data;
		}
		$hasil = array("barang" => $json_resp);
		echo json_encode($hasil);

	}
?>
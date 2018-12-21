<?php
	require_once('connection.php');
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['kode'];
		$jumlah = $_POST['jumlah'];

		$select_sql = "SELECT jumlah FROM barang WHERE kode=$id";
		$query = mysqli_query($con, $select_sql);
		$data = mysqli_fetch_array($query);

		$total = $data['jumlah']-$jumlah;
		
		//Membuat SQL Query
		$sql = "UPDATE barang SET jumlah = '$total' WHERE kode = $id";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Barang';
		}else{
			echo 'Gagal Update Data Barang';
		}
		
		mysqli_close($con);
	}
?>
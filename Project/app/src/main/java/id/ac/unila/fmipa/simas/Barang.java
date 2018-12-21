package id.ac.unila.fmipa.simas;

public class Barang {
    private String kode;
    private String nama;
    private String deskripsi;
    private String jumlah;
    private String gambar;

    public Barang(String kode, String nama, String deskripsi, String jumlah, String gambar) {
        this.kode = kode;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
        this.gambar = gambar;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getGambar() {
        return gambar;
    }
}

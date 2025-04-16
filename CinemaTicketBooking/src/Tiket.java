@SuppressWarnings("FieldMayBeFinal")
public class Tiket { //merepresentasikan data pemesanan tiket oleh customer
    private Jadwal jadwal; // atribut classnya ada jadwal (menyimpan objek jadwal yang dipilih oleh customer), jumlah tiket yang harus dipesan oleh customer, dan harga total yang diambil dari harga x jumlah
    private int jumlah;
    private double hargaTotal;

    // Constructor
    public Tiket(Jadwal inputJadwal, int inputJumlah) { // berfungsi untuk inputan parameter yang ditentukan
        this.jadwal = inputJadwal; // set nilai atribut, menyimpan variable jadwal dan jumlah ke tiket
        this.jumlah = inputJumlah;
        this.hargaTotal = jadwal.getFilm().getHarga() * jumlah; // mengambil harga film dan mengalikan dengan jumlah tiket untuk memperoleh harga total dan menyimpannya

        // update kapasitas & tiket terjual secara otomatis
        jadwal.getFilm().kurangKapasitas(jumlah); //digunakan untuk mengupdate data pada film dengan menginformasikan pengurangan kapasitas dan mencatat bahwa tiket telah dipesan
        jadwal.getFilm().tambahTiketTerjual(jumlah);
    }

    // Getter mengambil data private
    public Jadwal getJadwal() { //mengambil variable jadwal, jumlah, dan harga total
        return jadwal;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHargaTotal() {
        return hargaTotal;
    }

    // Method tampilkan tiket
    public void tampilkanTiket() {
        System.out.println("========= Tiket Pemesanan =========");
        System.out.println("Judul Film     : " + jadwal.getFilm().getJudul());
        System.out.println("Tanggal Tayang : " + jadwal.getTanggal());
        System.out.println("Waktu Tayang   : " + jadwal.getWaktu());
        System.out.println("Ruangan        : " + jadwal.getFilm().getRuangan());
        System.out.println("Jumlah Tiket   : " + jumlah);
        System.out.println("Total Harga    : Rp" + hargaTotal);
        System.out.println("===================================");
    }
}
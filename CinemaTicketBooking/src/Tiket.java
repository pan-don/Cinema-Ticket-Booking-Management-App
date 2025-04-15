@SuppressWarnings("FieldMayBeFinal")
public class Tiket {
    private Jadwal jadwal;
    private int jumlah;
    private double hargaTotal;

    // Constructor
    public Tiket(Jadwal inputJadwal, int inputJumlah) {
        this.jadwal = inputJadwal;
        this.jumlah = inputJumlah;
        this.hargaTotal = jadwal.getFilm().getHarga() * jumlah;

        // update kapasitas & tiket terjual secara otomatis
        jadwal.getFilm().kurangKapasitas(jumlah);
        jadwal.getFilm().tambahTiketTerjual(jumlah);
    }

    // Getter
    public Jadwal getJadwal() {
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
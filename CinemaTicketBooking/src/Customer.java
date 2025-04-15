import java.util.*;

public class Customer extends Person {
<<<<<<< HEAD
    // Deklarasi atribut private: userId untuk identitas pengguna
    // riwayatPemesanan untuk menyimpan daftar tiket yang telah dipesan
    private List<Tiket> riwayatPesanan;

    // Konstruktor Customer memanggil konstruktor dari superclass (Person)
    // dan menginisialisasi userId serta membuat list kosong untuk riwayat pemesanan
    public Customer(String inputId, String inputUsername, String inputPassword) {
        super(inputId, inputUsername, inputPassword); // Memanggil konstruktor dari class Personn
=======
    private String userId;
    private List<Tiket> riwayatPemesanan;

    public Customer(String username, String password, String userId) {
        super(username, password);
        this.userId = userId;
>>>>>>> 15addf18c1a8eb2b127f7db61168baa01ca9ebfe
        this.riwayatPemesanan = new ArrayList<>();
    }

    public void Pemesanan(List<Jadwal> daftarJadwal, Scanner scanner) {
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < daftarJadwal.size(); i++) {
            Jadwal jadwal = daftarJadwal.get(i);
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() +
                               " - " + jadwal.getWaktu() +
                               " | Kapasitas: " + jadwal.getFilm().getKapasitas());
        }

        System.out.print("Pilih nomor film: ");
        int pilihan = scanner.nextInt() - 1;

        if (pilihan < 0 || pilihan >= daftarJadwal.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Jadwal jadwalDipilih = daftarJadwal.get(pilihan);

        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        if (jadwalDipilih.getFilm().getKapasitas() >= jumlahTiket) {
            Tiket tiket = new Tiket(jadwalDipilih, jumlahTiket);
            riwayatPemesanan.add(tiket);
            System.out.println("Pemesanan berhasil. Total: Rp" + tiket.getHargaTotal() + " (Belum Dibayar)");
        } else {
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    public void Pembayaran(Scanner scanner) {
        boolean adaYangBelumDibayar = false;

        for (Tiket t : riwayatPemesanan) {
            if (!t.isLunas()) {
                adaYangBelumDibayar = true;
                System.out.println("Pesanan: " + t.getJadwal().getFilm().getJudul() +
                                   " | Jadwal: " + t.getJadwal().getWaktu() +
                                   " | Total: Rp" + t.getHargaTotal());
            }
        }

        if (!adaYangBelumDibayar) {
            System.out.println("Tidak ada pesanan yang belum dibayar.");
            return;
        }

        scanner.nextLine(); // Buang newline sebelumnya
        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        String metode = scanner.nextLine();

        for (Tiket t : riwayatPemesanan) {
            if (!t.isLunas()) {
                System.out.println("Memproses pembayaran untuk: " + t.getJadwal().getFilm().getJudul());
                System.out.println("Metode: " + metode + " | Total: Rp" + t.getHargaTotal());
                t.setLunas(true);
                System.out.println("Pembayaran berhasil!\n");
            }
        }
    }

    public void LihatRiwayat() {
<<<<<<< HEAD
        // Jika belum ada pemesanan
        if (riwayatPesanan.isEmpty()) {
=======
        if (riwayatPemesanan.isEmpty()) {
>>>>>>> 15addf18c1a8eb2b127f7db61168baa01ca9ebfe
            System.out.println("Riwayat pemesanan kosong.");
        } else{
            // Menampilkan setiap pemesanan yang telah dilakukan
            System.out.println("========== Riwayat Pemesanan ==========");
            for (Tiket t : riwayatPesanan) {
                System.out.println("- Film: " + t.getJadwal().getFilm().getJudul() +
                                   " | Jadwal: " + t.getJadwal().getWaktu() +
                                   " | Total: " + t.getHargaTotal() +
                                   " | Status: " + (t.isLunas() ? "Lunas" : "Belum Dibayar"));
            }  
        }

<<<<<<< HEAD
=======
        System.out.println("Riwayat Pemesanan:");
        for (Tiket t : riwayatPemesanan) {
            System.out.println("- Film: " + t.getJadwal().getFilm().getJudul() +
                               " | Jadwal: " + t.getJadwal().getWaktu() +
                               " | Total: Rp" + t.getHargaTotal() +
                               " | Status: " + (t.isLunas() ? "Lunas" : "Belum Dibayar"));
        }
>>>>>>> 15addf18c1a8eb2b127f7db61168baa01ca9ebfe
    }
}


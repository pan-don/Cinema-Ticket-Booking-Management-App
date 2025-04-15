import java.util.*;

// Class Customer merupakan turunan dari class Person
public class Customer extends Person {
    private String userId; // ID unik untuk masing-masing customer
    private List<Pemesanan> riwayatPemesanan; // Menyimpan daftar pemesanan customer

    // Constructor untuk inisialisasi objek Customer
    public Customer(String userId) {
        this.userId = userId;
        this.riwayatPemesanan = new ArrayList<>(); // Inisialisasi list pemesanan
    }

    // Metode untuk melakukan pemesanan tiket
    public void pemesanan(List<Jadwal> daftarJadwal, Scanner scanner) {
        // Tampilkan daftar jadwal film yang tersedia
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < daftarJadwal.size(); i++) {
            Jadwal jadwal = daftarJadwal.get(i);
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() + " - " +
                               jadwal.getWaktu() + " | Kapasitas: " + jadwal.getKapasitas());
        }

        // Input: pilih jadwal film berdasarkan nomor
        System.out.print("Pilih nomor film: ");
        int pilihan = scanner.nextInt() - 1;
        Jadwal jadwalDipilih = daftarJadwal.get(pilihan);

        // Input: jumlah tiket yang ingin dibeli
        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        // Validasi ketersediaan kapasitas
        if (jadwalDipilih.getKapasitas() >= jumlahTiket) {
            // Hitung total harga tiket
            double totalHarga = jadwalDipilih.getHarga() * jumlahTiket;
            // Kurangi kapasitas pada jadwal sesuai jumlah tiket yang dipesan
            jadwalDipilih.kurangiKapasitas(jumlahTiket);

            // Buat objek pemesanan dan simpan ke riwayat
            Pemesanan pesanan = new Pemesanan(jadwalDipilih.getFilm(), jadwalDipilih.getWaktu(), jumlahTiket, totalHarga);
            riwayatPemesanan.add(pesanan);

            System.out.println("Pemesanan berhasil. Total: " + totalHarga + " (Belum Dibayar)");
        } else {
            // Tampilkan pesan jika kapasitas tidak cukup
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    // Metode untuk melakukan pembayaran dari pesanan yang belum dibayar
    public void pembayaran(Scanner scanner) {
        boolean adaYangBelumDibayar = false;

        // Tampilkan daftar pesanan yang belum dibayar
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) {
                adaYangBelumDibayar = true;
                System.out.println("Pesanan: " + p.getFilm().getJudul() + " | " + p.getJadwal() +
                                   " | Tiket: " + p.getJumlahTiket() + " | Total: " + p.getTotalHarga());
            }
        }

        // Jika semua pesanan sudah dibayar, tampilkan pesan dan keluar dari metode
        if (!adaYangBelumDibayar) {
            System.out.println("Tidak ada pesanan yang belum dibayar.");
            return;
        }

        // Input: pilih metode pembayaran
        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        scanner.nextLine(); // Konsumsi newline sisa input sebelumnya
        String metode = scanner.nextLine();

        // Simulasi proses pembayaran untuk setiap pesanan yang belum lunas
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) {
                System.out.println("Memproses pembayaran untuk: " + p.getFilm().getJudul());
                System.out.println("Metode: " + metode + " | Total: " + p.getTotalHarga());
                p.setLunas(true); // Tandai pesanan sebagai lunas
                System.out.println("Pembayaran berhasil!\n");
            }
        }
    }

    // Metode untuk melihat riwayat pemesanan (baik yang sudah dibayar maupun belum)
    public void lihatRiwayat() {
        // Jika tidak ada riwayat, tampilkan pesan
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Riwayat pemesanan kosong.");
            return;
        }

        // Tampilkan semua riwayat pemesanan
        System.out.println("Riwayat Pemesanan:");
        for (Pemesanan p : riwayatPemesanan) {
            System.out.println("- Film: " + p.getFilm().getJudul() +
                               " | Jadwal: " + p.getJadwal() +
                               " | Tiket: " + p.getJumlahTiket() +
                               " | Total: " + p.getTotalHarga() +
                               " | Status: " + (p.isLunas() ? "Lunas" : "Belum Dibayar"));
        }
    }
}

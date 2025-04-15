import java.util.*; // Mengimpor semua class dari package java.util (termasuk List dan Scanner)

public class Customer extends Person { // Customer adalah subclass dari Person, mewarisi semua atribut & metode dari Person
    private String userId; // ID unik untuk masing-masing customer
    private List<Pemesanan> riwayatPemesanan; // List untuk menyimpan riwayat pemesanan tiket

    // Konstruktor untuk membuat objek Customer baru
    public Customer(String userId) {
        this.userId = userId; // Set ID pengguna
        this.riwayatPemesanan = new ArrayList<>(); // Inisialisasi list riwayat pemesanan
    }

    // Metode untuk melakukan pemesanan tiket
<<<<<<< HEAD
    public void pemesanan(List<temp> daftarJadwal, Scanner scanner) { // Scaner scaner digunakan agar pengguna dapat memilih film, menentukan jumlah tiket, dan memilih petode pembayaran
        // Tampilkan daftar jadwal film yang tersedia
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < daftarJadwal.size(); i++) {
            temp jadwal = daftarJadwal.get(i);
=======
    public void pemesanan(List<Jadwal> daftarJadwal, Scanner scanner) {
        // Menampilkan seluruh daftar film dan jadwal yang tersedia
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < daftarJadwal.size(); i++) {
            Jadwal jadwal = daftarJadwal.get(i); // Mengambil objek Jadwal berdasarkan indeks
>>>>>>> 0325e774dbee4f5291031b3f01a2939dc38136a8
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() + " - " +
                               jadwal.getWaktu() + " | Kapasitas: " + jadwal.getKapasitas());
        }

        // Input pilihan film dari pengguna (berdasarkan nomor)
        System.out.print("Pilih nomor film: ");
<<<<<<< HEAD
        int pilihan = scanner.nextInt() - 1;
        temp jadwalDipilih = daftarJadwal.get(pilihan);
=======
        int pilihan = scanner.nextInt() - 1; // Dikurangi 1 karena indeks list dimulai dari 0
        Jadwal jadwalDipilih = daftarJadwal.get(pilihan); // Menyimpan jadwal yang dipilih
>>>>>>> 0325e774dbee4f5291031b3f01a2939dc38136a8

        // Input jumlah tiket yang ingin dibeli
        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        // Mengecek apakah kapasitas mencukupi untuk jumlah tiket yang diinginkan
        if (jadwalDipilih.getKapasitas() >= jumlahTiket) {
            // Menghitung total harga tiket
            double totalHarga = jadwalDipilih.getHarga() * jumlahTiket;

            // Mengurangi kapasitas sesuai jumlah tiket yang dipesan
            jadwalDipilih.kurangiKapasitas(jumlahTiket);

            // Membuat objek Pemesanan baru dan menambahkannya ke riwayat
            Pemesanan pesanan = new Pemesanan(
                jadwalDipilih.getFilm(), // pilih film
                jadwalDipilih.getWaktu(), // pilih waktu tayang film
                jumlahTiket,
                totalHarga
            );
            riwayatPemesanan.add(pesanan); // Tambahkan ke riwayat

            // Konfirmasi bahwa pemesanan berhasil
            System.out.println("Pemesanan berhasil. Total: " + totalHarga + " (Belum Dibayar)");
        } else {
            // Tampilkan pesan jika kapasitas tidak cukup
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    // Metode untuk membayar semua pemesanan yang belum dibayar
    public void pembayaran(Scanner scanner) {
        boolean adaYangBelumDibayar = false; // Flag untuk mengecek apakah ada pesanan yang belum lunas

        // Tampilkan daftar pesanan yang belum dibayar
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) { // Cek apakah pesanan belum lunas
                adaYangBelumDibayar = true;
                System.out.println("Pesanan: " + p.getFilm().getJudul() + " | " + p.getJadwal() +
                                   " | Tiket: " + p.getJumlahTiket() + " | Total: " + p.getTotalHarga());
            }
        }

        // Jika semua pesanan sudah lunas
        if (!adaYangBelumDibayar) {
            System.out.println("Tidak ada pesanan yang belum dibayar.");
            return; // Keluar dari metode
        }

        // Input metode pembayaran dari pengguna
        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        scanner.nextLine(); // Membersihkan newline dari input sebelumnya
        String metode = scanner.nextLine(); // Menerima input string metode pembayaran

        // Proses pembayaran untuk setiap pesanan yang belum lunas
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) {
                System.out.println("Memproses pembayaran untuk: " + p.getFilm().getJudul());
                System.out.println("Metode: " + metode + " | Total: " + p.getTotalHarga());
                p.setLunas(true); // Tandai sebagai lunas
                System.out.println("Pembayaran berhasil!\n");
            }
        }
    }

    // Metode untuk menampilkan seluruh riwayat pemesanan
    public void lihatRiwayat() {
        // Cek apakah riwayat masih kosong
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Riwayat pemesanan kosong.");
            return;
        }

        // Tampilkan semua data pemesanan
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
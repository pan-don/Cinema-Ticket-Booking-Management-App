// Mengimpor library utilitas Java, termasuk List dan Scanner
import java.util.*;

// Mendeklarasikan class Customer yang merupakan turunan dari class Person
public class Customer extends Person {
    // Deklarasi atribut private: userId untuk identitas pengguna
    // riwayatPemesanan untuk menyimpan daftar tiket yang telah dipesan
    private String userId;
    private List<Tiket> riwayatPemesanan;

    // Konstruktor Customer memanggil konstruktor dari superclass (Person)
    // dan menginisialisasi userId serta membuat list kosong untuk riwayat pemesanan
    public Customer(String username, String password, String userId) {
        super(username, password); // Memanggil konstruktor dari class Person
        this.userId = userId;
        this.riwayatPemesanan = new ArrayList<>();
    }

    // Metode untuk melakukan pemesanan tiket
    // Parameter: daftarJadwal berisi jadwal film yang tersedia
    //            scanner digunakan untuk input dari pengguna
    public void Pemesanan(List<Jadwal> daftarJadwal, Scanner scanner) {
        System.out.println("Daftar Jadwal Film:");
        
        // Menampilkan semua jadwal film yang tersedia
        for (int i = 0; i < daftarJadwal.size(); i++) {
            Jadwal jadwal = daftarJadwal.get(i);
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() +
                               " - " + jadwal.getWaktu() +
                               " | Kapasitas: " + jadwal.getKapasitas());
        }

        // Meminta pengguna memilih film berdasarkan nomor
        System.out.print("Pilih nomor film: ");
        int pilihan = scanner.nextInt() - 1;
        
        // Validasi input pilihan
        if (pilihan < 0 || pilihan >= daftarJadwal.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Mengambil jadwal yang dipilih
        Jadwal jadwalDipilih = daftarJadwal.get(pilihan);

        // Meminta jumlah tiket yang ingin dibeli
        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        // Mengecek apakah kapasitas mencukupi
        if (jadwalDipilih.getKapasitas() >= jumlahTiket) {
            // Menghitung total harga dan mengurangi kapasitas
            double totalHarga = jadwalDipilih.getHarga() * jumlahTiket;
            jadwalDipilih.kurangiKapasitas(jumlahTiket);

            // Membuat objek Tiket dan menambahkannya ke riwayat pemesanan
            Tiket tiket = new Tiket(jadwalDipilih, totalHarga);
            riwayatPemesanan.add(tiket);

            // Menampilkan informasi bahwa pemesanan berhasil
            System.out.println("Pemesanan berhasil. Total: " + totalHarga + " (Belum Dibayar)");
        } else {
            // Jika kapasitas tidak cukup
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    // Metode untuk melakukan pembayaran terhadap tiket yang belum lunas
    public void Pembayaran(Scanner scanner) {
        boolean adaYangBelumDibayar = false;

        // Mengecek tiket yang belum dibayar
        for (Tiket t : riwayatPemesanan) {
            if (!t.isLunas()) {
                adaYangBelumDibayar = true;
                System.out.println("Pesanan: " + t.getJadwal().getFilm().getJudul() +
                                   " | Jadwal: " + t.getJadwal().getWaktu() +
                                   " | Total: " + t.getHargaTotal());
            }
        }

        // Jika semua tiket sudah lunas
        if (!adaYangBelumDibayar) {
            System.out.println("Tidak ada pesanan yang belum dibayar.");
            return;
        }

        // Meminta metode pembayaran
        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        scanner.nextLine(); // membersihkan newline sisa input sebelumnya
        String metode = scanner.nextLine();

        // Memproses pembayaran dan mengubah status tiket menjadi lunas
        for (Tiket t : riwayatPemesanan) {
            if (!t.isLunas()) {
                System.out.println("Memproses pembayaran untuk: " + t.getJadwal().getFilm().getJudul());
                System.out.println("Metode: " + metode + " | Total: " + t.getHargaTotal());
                t.setLunas(true);
                System.out.println("Pembayaran berhasil!\n");
            }
        }
    }

    // Metode untuk menampilkan semua riwayat pemesanan
    public void LihatRiwayat() {
        // Jika belum ada pemesanan
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Riwayat pemesanan kosong.");
            return;
        }

        // Menampilkan setiap pemesanan yang telah dilakukan
        System.out.println("Riwayat Pemesanan:");
        for (Tiket t : riwayatPemesanan) {
            System.out.println("- Film: " + t.getJadwal().getFilm().getJudul() +
                               " | Jadwal: " + t.getJadwal().getWaktu() +
                               " | Total: " + t.getHargaTotal() +
                               " | Status: " + (t.isLunas() ? "Lunas" : "Belum Dibayar"));
        }
    }
}

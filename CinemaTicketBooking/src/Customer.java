import java.util.*;

public class Customer extends Person {
    private String userId;
    private List<Pemesanan> riwayatPemesanan;

    public Customer(String userId) {
        this.userId = userId;
        this.riwayatPemesanan = new ArrayList<>();
    }

    // Metode untuk melakukan pemesanan tiket
    public void pemesanan(List<Jadwal> daftarJadwal, Scanner scanner) {
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < daftarJadwal.size(); i++) {
            Jadwal jadwal = daftarJadwal.get(i);
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() + " - " + jadwal.getWaktu() + " | Kapasitas: " + jadwal.getKapasitas());
        }

        System.out.print("Pilih nomor film: ");
        int pilihan = scanner.nextInt() - 1;
        Jadwal jadwalDipilih = daftarJadwal.get(pilihan);

        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        if (jadwalDipilih.getKapasitas() >= jumlahTiket) {
            double totalHarga = jadwalDipilih.getHarga() * jumlahTiket;
            jadwalDipilih.kurangiKapasitas(jumlahTiket);

            Pemesanan pesanan = new Pemesanan(jadwalDipilih.getFilm(), jadwalDipilih.getWaktu(), jumlahTiket, totalHarga);
            riwayatPemesanan.add(pesanan);

            System.out.println("Pemesanan berhasil. Total: " + totalHarga + " (Belum Dibayar)");
        } else {
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    // Metode untuk memproses pembayaran
    public void pembayaran(Scanner scanner) {
        boolean adaYangBelumDibayar = false;
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) {
                adaYangBelumDibayar = true;
                System.out.println("Pesanan: " + p.getFilm().getJudul() + " | " + p.getJadwal() + " | Tiket: " + p.getJumlahTiket() + " | Total: " + p.getTotalHarga());
            }
        }

        if (!adaYangBelumDibayar) {
            System.out.println("Tidak ada pesanan yang belum dibayar.");
            return;
        }

        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        scanner.nextLine(); // konsumsi newline
        String metode = scanner.nextLine();

        // Simulasi pembayaran
        for (Pemesanan p : riwayatPemesanan) {
            if (!p.isLunas()) {
                System.out.println("Memproses pembayaran untuk: " + p.getFilm().getJudul());
                System.out.println("Metode: " + metode + " | Total: " + p.getTotalHarga());
                p.setLunas(true);
                System.out.println("Pembayaran berhasil!\n");
            }
        }
    }

    // Melihat riwayat pemesanan
    public void lihatRiwayat() {
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Riwayat pemesanan kosong.");
            return;
        }

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

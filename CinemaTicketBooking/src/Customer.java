import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class Customer extends Person {
    private List<Tiket> riwayatPemesanan;
    private Tiket tiketPesanan;

    public Customer(String inputId, String inputUsername, String inputPassword) {
        super(inputId, inputUsername, inputPassword);
        this.riwayatPemesanan = new ArrayList<>();
    }

    public void pemesanan(List<Jadwal> listJadwal, Scanner scanner) {
        System.out.println("Daftar Jadwal Film:");
        for (int i = 0; i < listJadwal.size(); i++) {
            Jadwal jadwal = listJadwal.get(i);
            System.out.println((i + 1) + ". " + jadwal.getFilm().getJudul() +
                               " | Jadwal: " + jadwal.getWaktu() +
                               " | Kapasitas: " + jadwal.getFilm().getKapasitas()+
                               " | Harga: " + jadwal.getFilm().getHarga());
        }

        System.out.print("Pilih nomor film: ");
        int pilihan = scanner.nextInt() - 1;
        scanner.nextLine();

        if (pilihan < 0 || pilihan >= listJadwal.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Jadwal jadwalDipilih = listJadwal.get(pilihan);

        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();
        scanner.nextLine();

        if (jadwalDipilih.getFilm().getKapasitas() >= jumlahTiket) {
            Tiket tiket = new Tiket(jadwalDipilih, jumlahTiket);
            this.tiketPesanan = tiket;
            riwayatPemesanan.add(tiket);
            System.out.println("Pemesanan berhasil (Belum dibayar)");
        } else {
            System.out.println("Kapasitas tidak mencukupi.");
        }
    }

    public void pembayaran(Scanner scanner) {
        if(riwayatPemesanan.isEmpty()){
            System.out.println("Belum ada pesanan.");
        }
        
        scanner.nextLine(); 
        System.out.print("Pilih metode pembayaran (e.g., Dana/Ovo/Transfer): ");
        String metode = scanner.nextLine();
        System.out.println("Total harga pesanan: Rp."+tiketPesanan.getHargaTotal());
        System.out.println("Masukan uang pembayaran: ");
        double totalBayar = scanner.nextDouble();

        for (Tiket t : riwayatPemesanan) {
            double totalHarga = t.getHargaTotal();
            System.out.println("Memproses pembayaran untuk: " + t.getJadwal().getFilm().getJudul());
            System.out.println("Metode: " + metode + " | Total: Rp" + t.getHargaTotal());
            if(totalBayar >= totalHarga){
                System.out.println("Pembayaran berhasil!\n");
            } else{
                System.out.println("Pembayaran gagal!!!. Jumlah yang dibayarkan kurang.");
            }
        }
    }

    public void lihatRiwayat() {
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Riwayat pemesanan kosong.");
        } else{
            // Menampilkan setiap pemesanan yang telah dilakukan
            System.out.println("========== Riwayat Pemesanan ==========");
            for (Tiket t : riwayatPemesanan) {
                System.out.println("- Film: " + t.getJadwal().getFilm().getJudul() +
                                   " | Ruangan: "+ t.getJadwal().getFilm().getRuangan() +
                                   " | Jadwal: " + t.getJadwal().getWaktu() +
                                   " | Total: " + t.getHargaTotal());
            }  
        }

    }
}
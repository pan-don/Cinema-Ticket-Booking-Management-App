import java.time.LocalDate;
import java.time.LocalTime;

public class Jadwal {
    private String idJadwal;
    private Film film;           
    private LocalDate tanggal;
    private LocalTime waktu;

    public Jadwal(String idJadwal, Film film, LocalDate tanggal, LocalTime waktu) {
        this.idJadwal = idJadwal;
        this.film = film;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    // Getter dan Setter
    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public LocalTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalTime waktu) {
        this.waktu = waktu;
    }

    // Method tampilkanJadwal()
    public void tampilkanJadwal() {
        System.out.println("ID Jadwal      : " + idJadwal);
        System.out.println("Judul Film     : " + film.getJudul());
        System.out.println("Ruangan        : " + film.getRuangan());
        System.out.println("Tanggal Tayang : " + tanggal);
        System.out.println("Waktu Tayang   : " + waktu);
        System.out.println("---------------------------------");
    }

    // Method cekJadwalBentrok()
    public boolean cekJadwalBentrok(Jadwal jadwalLain) {
        return this.tanggal.equals(jadwalLain.getTanggal()) &&
               this.waktu.equals(jadwalLain.getWaktu()) &&
               this.film.getRuangan().equals(jadwalLain.getFilm().getRuangan());
    }
}

//import library bawaan java untuk tipe data tanggal
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
//kelas nya, buat tau kapan film diputar

public class Jadwal {
    //atribut idjadwal, nyimpen id jadwalnya
    private String idJadwal;
    //atribut film, nyimpen data film apa yang ditayangkan di jadwal ini. objeknya dari class film jadi ini kehubung sama class film
    private Film film;  
    //atribut tanggal, nyimpan tanggal dari library yang sudah di import         
    private LocalDate tanggal;
    //atribut waktu, sama aja cuma jam nyaa
    private LocalTime waktu;

    //konstruktor
    public Jadwal(String idJadwal, Film film, LocalDate tanggal, LocalTime waktu) {
        this.idJadwal = idJadwal;   //id jawal
        this.film = film;           //film
        this.tanggal = tanggal;     //tanggal
        this.waktu = waktu;         //waktu
    }

    // getter setter jadwal buat ngambil dan mengubah nilai dari atribut idJadwal
    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    //getter setter film, sama aja kaya jadwal tapi ini buat filmm
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    //getter setter tanggal, sama aja buat mengambil atau mengubah tanggal film tayang
    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    //getter setter waktu, sama pokoknya
    public LocalTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalTime waktu) {
        this.waktu = waktu;
    }

    // method tampilkanJadwal(), untuk menampilkan semua yang ingin di tampilkan kaya atribut yang di proposal
    public void tampilkanJadwal() {
        System.out.println("ID Jadwal      : " + idJadwal);             //menampilkan id jadwal
        System.out.println("Judul Film     : " + film.getJudul());      //menampilkan judul film
        System.out.println("Ruangan        : " + film.getRuangan());    //menampilkan ruangan
        System.out.println("Tanggal Tayang : " + tanggal);              //menampilkan tanggal
        System.out.println("Waktu Tayang   : " + waktu);                //menampilkan waktu
        System.out.println("---------------------------------");
    }

    public static boolean cekJadwalBentrok(List<Jadwal> listJadwal, Jadwal jadwalBaru){
        for(Jadwal s: listJadwal){
            if(s.tanggal.equals(jadwalBaru.tanggal)
            && s.waktu.equals(jadwalBaru.waktu)
            && s.film.getRuangan().equalsIgnoreCase(jadwalBaru.film.getRuangan())
            ){return true;}
        }
        return false;
    }
}
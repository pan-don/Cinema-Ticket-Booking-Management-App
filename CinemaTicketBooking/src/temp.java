//import library bawaan java untuk tipe data tanggal
import java.time.LocalDate;
// sama tapi buat waktu atau jamnya
import java.time.LocalTime;

//kelas nya, buat tau kapan film diputar
public class temp {
    //atribut idjadwal, nyimpen id jadwalnya
    private String idJadwal;
    //atribut film, nyimpen data film apa yang ditayangkan di jadwal ini. objeknya dari class film jadi ini kehubung sama class film
    private Film film;  
    //atribut tanggal, nyimpan tanggal dari library yang sudah di import         
    private LocalDate tanggal;
    //atribut waktu, sama aja cuma jam nya
    private LocalTime waktu;

    //konstruktor
    public temp(String idJadwal, Film film, LocalDate tanggal, LocalTime waktu) {
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

    // method cekJadwalBentrok(), buat melihat jadwalnya bentrok apa engga kan?
    public boolean cekJadwalBentrok(temp jadwalLain) {
        return this.tanggal.equals(jadwalLain.getTanggal()) &&      //tanggal atau jam sama, pake equals karena tadi aku pake localdate sama localtime library bawaan java bukan int
               this.waktu.equals(jadwalLain.getWaktu()) &&
               this.film.getRuangan().equals(jadwalLain.getFilm().getRuangan()); //mengecek apakah ruangan sama, pake equals karena string
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
class Admin extends Person{
    private List<Film> listFilm;
    private List<Jadwal> listJadwal;
    private int idFilm = 1;
    private int idJadwal = 1;

    public Admin(String inputId, String inputUsername, String inputPassword){
        super(inputId, inputUsername, inputPassword);
        this.listFilm = new ArrayList<>();
        this.listJadwal = new ArrayList<>();
    }

    public void tambahFilm(Scanner scanner){
        scanner.nextLine();
        String idFilmBaru = generateIdFilm();
        System.out.println("Judul       : ");
        String judul = scanner.nextLine();
        System.out.println("Genre       : ");
        String genre = scanner.nextLine();
        System.out.println("Durasi      : ");
        int durasi = scanner.nextInt();
        System.out.println("Sinopsis    : ");
        String sinopsis = scanner.nextLine();
        System.out.println("Harga       : ");
        double harga = scanner.nextDouble();
        System.out.println("Kapasitas   : ");
        int kapasitas = scanner.nextInt();
        System.out.println("Ruangan     : ");
        String ruangan = scanner.nextLine();

        Film filmBaru = new Film(idFilmBaru, judul, genre, durasi, sinopsis, harga, kapasitas, ruangan);
        listFilm.add(filmBaru);
        System.out.println("Film \""+ filmBaru.getJudul() +"\" berhasil ditambahkan.");
    }


    public void updateFilm(Scanner scanner){
        tampilkanDaftarFilm();
        System.out.println("Pilih nomor film: ");
        int index = scanner.nextInt();

        if(index >= 0 && index < listFilm.size()){
            Film filmLama = listFilm.get(index);

            System.out.println("========== UPDATE FILM "+ filmLama.getJudul() +"==========");
            System.out.println("Judul       : ");
            String judul = scanner.nextLine();
            System.out.println("Genre       : ");
            String genre = scanner.nextLine();
            System.out.println("Durasi      : ");
            int durasi = scanner.nextInt();
            System.out.println("Sinopsis    : ");
            String sinopsis = scanner.nextLine();
            System.out.println("Harga       : ");
            double harga = scanner.nextDouble();
            System.out.println("Kapasitas   : ");
            int kapasitas = scanner.nextInt();
            System.out.println("Ruangan     : ");
            String ruangan = scanner.nextLine();
    
            Film filmBaru = new Film(filmLama.getIdFilm(), judul, genre, durasi, sinopsis, harga, kapasitas, ruangan);
            listFilm.set(index, filmBaru);
            System.out.println("Film berhasil diperbaharui.");
        } else{
            System.out.println("Indeks tidak valid.");
        }
    }

    public void hapusFilm(Scanner scanner){
        tampilkanDaftarFilm();
        System.out.println("Pilih nomor film: ");
        int index = scanner.nextInt();

        if(index >= 0 && index < listFilm.size()){
            Film filmRemoved = listFilm.remove(index);
            System.out.println("Film \""+ filmRemoved.getJudul()+"\" berhasil dihapus.");
        } else{
            System.out.println("Indeks tidak valid. Film gagal dihapus!!!");
        }
    }

    public void tambahJadwal(Scanner scanner){
        if(listFilm.isEmpty()){
            System.out.println("Tidak ada film yang dijadwalkan.");
            return;
        }

        tampilkanDaftarFilm();
        System.out.println("Pilih nomor film: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if(index < 0 || index >= listFilm.size()){
            System.out.println("Indeks tidak valid.");
            return;
        }

        Film film = listFilm.get(index);
        String idJadwalBaru = generateIdJadwal();
        System.out.println("Masukan tanggal tayang : ");
        String tanggalInput = scanner.nextLine();
        LocalDate tanggal = LocalDate.parse(tanggalInput, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Masukan waktu tayang   : "); 
        String waktuInput = scanner.nextLine();
        LocalTime waktu = LocalTime.parse(waktuInput, DateTimeFormatter.ofPattern("HH:mm"));

        Jadwal jadwalBaru = new Jadwal(idJadwalBaru, film, tanggal, waktu);
        if(Jadwal.cekJadwalBentrok(listJadwal, jadwalBaru)){
            System.out.println("Jadwal bentrok!!! Ganti waktu yang lain.");
        } else{
            listJadwal.add(jadwalBaru);
            System.out.println("Jadwal film \""+ jadwalBaru.getFilm().getJudul()+"\" berhasil ditambahkan.");
        }
    }

    public void hapusJadwal(Scanner scanner){
        tampilkanJadwal();
        System.out.println("Pilih nomor film: ");
        int index = scanner.nextInt();

        if(index >= 0 && index < listJadwal.size()){
            Jadwal jadwalRemoved = listJadwal.remove(index);
            System.out.println("Film \""+ jadwalRemoved.getFilm().getJudul()+"\" berhasil dihapus.");
        } else{
            System.out.println("Indeks tidak valid. Film gagal dihapus!!!");
        }   
    }

    public void laporanPenjualan(){
        System.out.println("========== Laporan Penjualan ==========");
        for(Film f: listFilm){
            System.out.println("Film            : "+f.getJudul());
            System.out.println("Tiket terjual   : "+f.getTiketTerjual());
            System.out.println("Total pendapatan: "+(f.getHarga()*f.getTiketTerjual()));
        }
    }

    public void tampilkanDaftarFilm(){
        System.out.println("========== Daftar Film ==========");
        for(int i=0; i < listFilm.size(); i++){
            System.out.println(i+".  "+listFilm.get(i).getJudul());
        }
    }

    public void tampilkanJadwal(){
        System.out.println("========== Jadwal Film ==========");
        for(int i=0; i < listJadwal.size(); i++){
            Jadwal jadwal = listJadwal.get(i);
            System.out.println(i+".  "+jadwal.getFilm().getJudul()+" | "+jadwal.getTanggal());
        }
    }

    public List<Film> getListFilm(){
        return  listFilm;
    }

    public  List<Jadwal> getListJadwal(){
        return listJadwal;
    }

    private String generateIdFilm(){
        return String.format("F%03d", idFilm++);
    }

    private String generateIdJadwal(){
        return String.format("J%03d", idJadwal++);
    }
}
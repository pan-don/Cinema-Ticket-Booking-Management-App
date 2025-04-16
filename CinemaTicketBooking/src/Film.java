@SuppressWarnings("FieldMayBeFinal")
public class Film { //class yang menyimpan semua informasi dari sebuah film di dalam sistem
    private String id_film; // menyimpan data atau informasi yang diinputkan tentang film
    private String judul;
    private String genre;
    private int durasi;
    private String sinopsis;
    private double harga;
    private int kapasitas;
    private String ruangan;
    private int tiketTerjual;
    
    public Film(String id_film, String judul, String genre, int durasi, String sinopsis,
                double harga, int kapasitas, String ruangan) { // konstruktor dipanggil saat akan membuat objek film, disini atribut akan diinisialisasi berdasarkan nilai yang diberikan saat pemanggilan konstruktor,tiket di set default 0 karena tiket belum terjual saat film dibuat
        this.id_film = id_film;
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.sinopsis = sinopsis;
        this.harga = harga;
        this.kapasitas = kapasitas;
        this.ruangan = ruangan;
        this.tiketTerjual = 0;
    }

    public void tampilkanFilm() { // method ini berfungsi untuk menampilkan informai lengkap tentang film 
        System.out.println("ID Film            : " + id_film);
        System.out.println("Judul              : " + judul);
        System.out.println("Genre              : " + genre);
        System.out.println("Durasi             : " + durasi + " menit");
        System.out.println("Sinopsis           : " + sinopsis);
        System.out.println("Harga              : Rp " + harga);
        System.out.println("Ruangan            : " + ruangan);
        System.out.println("Kapasitas Tersedia : " + kapasitas);
        System.out.println("Tiket Terjual      : " + tiketTerjual);
    }
    
    public void kurangKapasitas(int jumlah) { // method Digunakan untuk mengurangi jumlah kapasitas kursi saat tiket dipesan, kalau nilainya negatif (penuh) akan langsung muncul peringatan kapasitas tidak cukup
        if (kapasitas >= jumlah) {
            kapasitas -= jumlah;
        } else {
            System.out.println("Kapasitas tidak cukup!");
        }
    }
    
    public void tambahTiketTerjual(int jumlah) { // Menambahkan jumlah tiket yang berhasil terjual, method ini dipanggil saat pemesanan tiket berhasil dilakukan
        tiketTerjual += jumlah;
    }
    
    public double getHarga() { //getter disini digunakan untuk mengakses nilai atribut private
        return harga; // mengambil harga tiket, judul film, jumlah kursi yang tersisa, id film, jumlah tiket terjual, nomor ruangan
    }
    
    public String getJudul() {
        return judul;
    }
    
    public int getKapasitas() {
        return kapasitas;
    }
    
    public String getIdFilm() {
        return id_film;
    }
    
    public int getTiketTerjual() {
        return tiketTerjual;
    }

    public String getRuangan(){
        return  ruangan;
    }
}
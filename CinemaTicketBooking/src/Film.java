public class Film {
    private String id_film;
    private String judul;
    private String genre;
    private int durasi;
    private String sinopsis;
    private double harga;
    private int kapasitas;
    private String ruangan;
    private int tiketTerjual;
    
    public Film(String id_film, String judul, String genre, int durasi, String sinopsis,
                double harga, int kapasitas, String ruangan) {
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

    public void tampilkanFilm() {
        System.out.println("ID Film: " + id_film);
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Harga: Rp " + harga);
        System.out.println("Ruangan            : " + ruangan);
        System.out.println("Kapasitas Tersedia : " + kapasitas);
        System.out.println("Tiket Terjual      : " + tiketTerjual);
    }
    
    public void kurangKapasitas(int jumlah) {
        if (kapasitas >= jumlah) {
            kapasitas -= jumlah;
        } else {
            System.out.println("Kapasitas tidak cukup!");
        }
    }
    
    public void tambahTiketTerjual(int jumlah) {
        tiketTerjual += jumlah;
    }
    
    public double getHarga() {
        return harga;
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

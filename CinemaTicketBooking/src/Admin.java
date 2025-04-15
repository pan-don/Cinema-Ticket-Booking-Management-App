import java.util.*;

class Admin extends Person{
    private List<Film> listFilm;
    private List<Jadwal> listJadwal;

    public Admin(String inputId, String inputUsername, String inputPassword){
        super(inputId, inputUsername, inputPassword);
        this.listFilm = new ArrayList<>();
        this.listJadwal = new ArrayList<>();
    }

    public void tambahFilm(Film inputFilm){
        listFilm.add(inputFilm);
        System.out.println("Film \""+ inputFilm.getJudul() +"\" berhasil ditambahkan.");
    }

    public void updateFilm(int index, Film filmBaru){
        if(index >= 0 && index < listFilm.size()){
            listFilm.set(index, filmBaru);
            System.out.println("Indeks film "+index+" berhasil diupdate.");
        } else{
            System.out.println("Indeks tidak valid. Film gagal diupdate!!!");
        }
    }

    public void hapusFilm(int index){
        if(index >= 0 && index < listFilm.size()){
            Film filmRemoved = listFilm.remove(index);
            System.out.println("Film \""+ filmRemoved.getJudul()+"\" berhasil dihapus.");
        } else{
            System.out.println("Indeks tidak valid. Film gagal dihapus!!!");
        }
    }

    public void tambahJadwal(Jadwal jadwalBaru){
        if(Jadwal.cekJadwalBentrok(jadwalBaru)){
            System.out.println("Jadwal bentrok!!! Ganti waktu yang lain.");
        } else{
            listJadwal.add(jadwalBaru);
            System.out.println("Jadwal film \""+ jadwalBaru.getFilm().getJudul()+"\" berhasil ditambahkan.");
        }
    }

    public void hapusJadwal(String namaFilm){
        for(int i=0; i < listJadwal.size(); i++){
            if(listJadwal.get(i).getFilm().getJudul().equalsIgnoreCase(namaFilm)){
                listJadwal.remove(i);
                System.out.println("Jadwal film \""+ namaFilm +"\" berhasil dihapus");
            }
        }
    }


    public void laporanPenjualan(){
        System.out.println("========== Laporan Penjualan ==========");
        for(Film f: listFilm){
            System.out.println("Film: "+f.getJudul() +" | Tiket Terjual: "+ f.getTiketTerjual() + " | Total Pendapatan: Rp."+(f,getHarga() * f.getTiketTerjual()));
        }
    }

    public List<Film> getListFilm(){
        return  listFilm;
    }

    public  List<Jadwal> getListJadwal(){
        return listJadwal;
    }

    private int getHarga() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

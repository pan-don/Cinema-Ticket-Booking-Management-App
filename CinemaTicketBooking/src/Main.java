import java.util.*;


@SuppressWarnings("FieldMayBeFinal")
public class Main {
    private static List<Customer> daftarCustomers = new ArrayList<>();
    private static Admin admin = new Admin("001", "admin", "admin123");

    // fungsi untuk login sebagai admin
    private static void loginAdmin(Scanner scanner){
        scanner.nextLine();
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        
        if(admin.getUsername().equals(username) && admin.getPassoword().equals(password)){
            menuAdmin(scanner, admin);
        } else{
            System.out.println("Login gagal");
        }
    }

    private static void menuAdmin(Scanner scanner, Admin admin){
        boolean lanjut = true;
        while(lanjut){
            System.out.println("========== MENU ADMIN ==========");
            System.out.println("1.  Tambah film");
            System.out.println("2.  Hapus film");
            System.out.println("3.  Update film");
            System.out.println("4.  Tambah jadwal");
            System.out.println("5.  Hapus jadwal");
            System.out.println("6.  Laporan Penjualan");
            System.out.println("7.  Logout");
            System.out.println("Pilih menu: ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    admin.tambahFilm(scanner);
                case 2:
                    admin.hapusFilm(scanner);
                case 3:
                    admin.updateFilm(scanner);
                case 4:
                    admin.tambahJadwal(scanner);
                case 5:
                    admin.hapusJadwal(scanner);
                case 6:
                    admin.laporanPenjualan();
                case 7:
                    System.out.println("Logout dari admin...");
                    lanjut = false;
                    default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    
    private static void loginCustomer(Scanner scanner){
        scanner.nextLine();
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        
        for(Customer i: daftarCustomers){
            if(i.getUsername().equals(username) && i.getPassoword().equals(password)){
                menuCustomer(scanner, i);
            }   
        }
        System.out.println("Login gagal");
    }

    private static void menuCustomer(Scanner scanner, Customer customer){
        boolean lanjut = true;
        while(lanjut){
            System.out.println("========== MENU ADMIN ==========");
            System.out.println("1.  Pemesanan film");
            System.out.println("2.  Pembayaran film");
            System.out.println("3.  Riwayat pemesanan");
            System.out.println("4.  Logout");
            System.out.println("Pilih menu: ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    customer.pemesanan(admin.getListJadwal(), scanner);
                case 2:
                    customer.pembayaran(scanner);
                case 3:
                    customer.lihatRiwayat();
                case 4:
                    System.out.println("Logout dari customer...");
                    lanjut = false;
                    default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    
    // fungsi untuk registrasi customer
    private static void registrasiCustomer(Scanner scanner){
        scanner.nextLine();
        System.out.println("Input ID customer: ");
        String idBaru = scanner.nextLine();
        System.out.println("Input username baru: ");
        String usernameBaru = scanner.nextLine();
        System.out.println("Input password baru: ");
        String passwordBaru = scanner.nextLine();
    
        for (Customer i : daftarCustomers) {
            if (i.getId().equals(idBaru) || i.getUsername().equals(usernameBaru)) {
                System.out.println("Registrasi gagal. ID atau username sudah digunakan.");
                return;
            }
        }

        Customer c = new Customer(idBaru, usernameBaru, passwordBaru);
        daftarCustomers.add(c);
        System.out.println("Registrasi berhasil.");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // sistem login
        while(running){
            System.out.println("========== SISTEM PEMESANAN TIKET BIOSKOP ==========");
            System.out.println("1. Login sebagai admin");
            System.out.println("2. Login sebagai customer");
            System.out.println("3. Registrasi customer");
            System.out.println("4. Keluar");
            System.out.println("Pilih: ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    loginAdmin(scanner);
                case 2:
                    loginCustomer(scanner);
                case 3:
                    registrasiCustomer(scanner);
                case 4:
                    System.out.println("Logout berhasil!!!");
                    running = false;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
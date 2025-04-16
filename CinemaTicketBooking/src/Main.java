import java.util.*;

public class Main {
    private static List<Customer> daftaCustomers = new ArrayList<>();
    private static Admin admin = new Admin("001", "admin", "admin123");
    private static Customer customer = new Customer(" ", " ", " ");

    // fungsi untuk login sebagai admin
    private static void loginAdmin(Scanner scanner){
        scanner.nextLine();
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        
        if(admin.getUsername().equals(username) && admin.getPassoword().equals(password)){
            // menuAdmin(scanner);
        } else{
            System.out.println("Login gagal");
        }
        
        
    }

    // fungsi untuk login sebagai customer
    private static void loginCustomer(Scanner scanner){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // sistem login
        while(running){
            System.out.println("========== SISTEM PEMESANAN TIKET BIOSKOP ==========");
            System.out.println("1. Pemesanan");
            System.out.println("2. Pembayaran");
            System.out.println("3. Lihat Riwayat");
            System.out.println("4. Keluar");
            System.out.println("Pilih: ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    pemesanan(List<Jadwal> listJadwal, Scanner scanner);
                case 2:
                    pembayaran(Scanner scanner);
                case 3:
                    LihatRiwayat();
                case 4:
                    System.out.println("Logout berhasil!!!");
                    running = false;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    
    // fungsi untuk registrasi customer
    private static void registrasiCustomer(Scanner scanner){
        scanner.nextLine();
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        
        if(Customer.getUsername().equals(username) && Customer.getPassoword().equals(password)){
            // menuCustomer(scanner);
        } else{
            System.out.println("Login gagal");
        }
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

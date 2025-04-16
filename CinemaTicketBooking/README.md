## PEMBUATAN APLIKASI MANAJEMEN PEMESANAN TIKET BIOSKOP BERBASIS WEBSITE  
## A. Tujuan
Melakukan pengembangan aplikasi berbasis website untuk mempermudah proses pemesanan tiket bioskop secara digital. Aplikasi ini memungkinkan pelanggan untuk memilih film, melihat jadwal tayang, memesan tiket, serta melakukan pembayaran. Sementara itu, admin dapat mengelola daftar film, jadwal tayang, dan melakukan pelaporan penjualan tiket.
## B. List Fitur 
Pada aplikasi ini terdapat beberapa fitur untuk menunjang fungsi pada penyelesaian tugas booking tiket bioskop. Fitur-fitur tersebut diantaranya adalah : 
#### 1. Manajemen Pengguna (User dan Admin): 
Kelas terkait person, customer, admin dengan atribut seperti username dan password serta user Id. Manajemen ini berguna untuk dapat berinteraksi dalam proses login dan registrasi dalam user dan admin. Admin juga dapat mengelola informasi mengenai film yang ingin di tayangkan serta jadwal tayang. Fitur ini memungkinkan pengguna melakukan melakukan login Customer atau pelanggan dapat melakukan pemesanan tiket film yang ingin di tonton dan melakukan pembayaran. 
##### 2. Pemesanan Tiket : Kelas terkait customer, tiket, Jadwal. Customer atau pelanggan dapat memilih jadwal film lalu melakukan pemesanan tiket. Sistem menghitung total harga dan mengurangi kapasitas sesuai kapasitas kursi yang tersedia, dan menambahkan jumlah tiket yang telah terjual.  
##### 3. Manajemen Film : Kelas terkait film, admin dapat menambahkan, memperbarui dan menghapus data film yang sedang ditayangkan. Fitur ini dijalankan oleh admin yang diatur untuk hanya dapat dilihat oleh customer. Fitur ini juga menampilkan daftar film lengkap ke customer.   

##### 4. Manajemen pembayaran: Menampilkan pembayaran, metode pembayarannya yakni cashless (dana, ovo, transfer bank), dan detail transaksi
##### 5. Manajemen Jadwal:  Kelas terkait Jadwal dan film, admin mengatur  jadwal  
tayang film, admin juga menyesuaikan tiket dengan kapasitas ruangan serta jadwal yang tersedia, dan sistem akan mengecek apakah terjadi bentrok jadwal antar film. 
## C. Class
### 1.Person 
Class Person berperan sebagai kelas induk (abstract class) yang menjadi dasar bagi semua jenis pengguna dalam sistem, seperti Admin dan Customer. Konsep pewarisan digunakan di sini untuk menghindari penulisan ulang atribut dan fungsi yang sama pada setiap tipe user.
Atribut yang dimiliki : 
- id→ menyimpan identitas unik pengguna.
- username → nama pengguna yang digunakan untuk login.
- password → kata sandi untuk autentikasi.
### 2. Customer
Class Customer adalah turunan dari class Person. Artinya, Customer akan mewarisi atribut id, username, dan password dari class Person. Pada kelas ini dapat melakukan :
- Melakukan pemesanan tiket film
- Melakukan pembayaran
- Melihat riwayat pemesanannya
	Cara kerja Program : 
1. Saat objek `Customer` dibuat, sistem menyimpan identitas user dan membuat daftar kosong untuk riwayat pesanan
2. Saat `pemesanan()` dipanggil:
 - Customer melihat film yang tersedia dan memilih salah satu.
 - Sistem cek apakah kapasitas cukup.
 - Jika ya, sistem mencatat pemesanan.
3. Kemudian customer bisa melanjutkan ke `pembayaran()`: dapat memilih metode pembayaran dan mencocokkan jumlah pembayaran yang dilakukan.
4. Terakhir, customer bisa cek kembali pesanannya melalui `LihatRiwayat()`.
### 3. Film
Class film adalah representasi dari entitas film yang tersedia dalam sistem. Class ini menyimpan seluruh informasi penting mengenai sebuah film, seperti judul, genre, harga tiket, kapasitas kursi, serta ruangan tempat penayangan. Objek dari class ini digunakan untuk ditampilkan kepada Customer dan digunakan oleh Admin dalam manajemen data film.

Atribut Utama
Saat objek film dibuat, sistem menyimpan:
ID unik film, Judul film, Genre, Durasi tayang (dalam menit), Sinopsis atau ringkasan cerita, Harga tiket, Kapasitas kursi yang tersedia, Nama atau nomor ruangan/studio, Jumlah tiket yang sudah terjual (diinisialisasi ke 0)

Cara Kerja Program : 
Saat tampilkanFilm() dipanggil:
1. Sistem akan menampilkan seluruh informasi tentang film, seperti judul, genre, durasi, harga, dan sisa kapasitas.
2. Method ini berguna agar customer bisa melihat detail film sebelum memutuskan untuk memesan.

Saat 'kurangKapasitas(jumlah)' dipanggil:
1. Sistem akan mengecek apakah kapasitas cukup untuk jumlah tiket yang ingin dibeli.
2. Jika ya, kapasitas akan dikurangi sebanyak jumlah tiket yang dipesan.
3. Jika tidak, sistem menampilkan pesan "Kapasitas tidak cukup!".


Saat 'tambahTiketTerjual(jumlah)' dipanggil:
1. Sistem menambahkan jumlah tiket yang sudah terjual berdasarkan pemesanan terbaru.
2. Data ini juga dapat digunakan untuk laporan penjualan oleh admin.

### 4.Jadwal
Class Jadwal bekerja dengan cara menyimpan dan mengatur informasi jadwal penayangan film, seperti ID jadwal, data film (judul dan ruangan), tanggal, dan waktu tayang. Saat objek Jadwal dibuat, informasi tersebut langsung diatur melalui konstruktor.
Melalui method `tampilkanJadwal()`, sistem bisa menampilkan detail jadwal kepada pengguna. Sedangkan method ‘cekJadwalBentrok()’ digunakan untuk mengecek apakah jadwal baru yang ingin ditambahkan memiliki bentrok dengan jadwal yang sudah ada (tanggal, waktu, dan ruangan yang sama). Fungsi ini penting untuk mencegah konflik pemutaran film di ruangan yang sama.

### 5.Tiket 
Class Tiket merepresentasikan tiket bioskop yang berhasil dipesan oleh Customer. Objek dari class ini menyimpan informasi penting seperti jadwal film yang dipilih dan total harga berdasarkan jumlah tiket yang dipesan. Class ini menjadi penghubung antara data pemesanan dengan detail film dan jadwal tayang.

Atribut Utama
Saat objek Tiket dibuat, sistem akan menyimpan:
1. Objek Jadwal yang berisi informasi film, tanggal, dan waktu tayang
2. Total harga dari tiket yang dipesan (dihitung dari harga film × jumlah tiket)

Cara Kerja Program
Saat Tiket dibuat (melalui constructor):
1. Sistem menerima jadwal tayang dan jumlah tiket yang dipesan dari Customer.
2. Sistem mengambil harga tiket dari jadwal.getFilm().getHarga() dan mengalikan dengan jumlah tiket → menghasilkan hargaTotal.
3. Sistem memanggil:
- film.kurangKapasitas(jumlah) → mengurangi kapasitas kursi film
- film.tambahTiketTerjual(jumlah) → mencatat jumlah tiket yang terjual


Saat 'tampilkanTiket()' dipanggil:
1. Sistem akan menampilkan detail tiket secara lengkap:
- Judul film
- Tanggal dan waktu tayang
- Total harga tiket
  
## D. Relasi Antar Kelas
1. Inheritance (Pewarisan) : Person adalah parent yang mewariskan atribut username dan password ke admin dan customer. 
2. Asosiasi
- Kelas Customer memiliki hubungan asosiasi dengan kelas Tiket, di mana setiap pelanggan dapat melakukan pemesanan tiket: Customer akan berinteraksi langsung dengan objek dari kelas Tiket, khususnya dalam proses pembelian tiket melalui method pemesanan()
- Kelas Tiket memiliki asosiasi dengan kelas Jadwal: setiap tiket yang dibeli oleh pelanggan mengacu pada satu jadwal tayang tertentu yang disediakan dalam sistem. Hal ini terlihat dari atribut jadwal yang bertipe Jadwal pada kelas Tiket. 
- Kelas Jadwal sendiri memiliki asosiasi dengan kelas Film: setiap jadwal tayang pasti berkaitan dengan satu film yang ditayangkan. Dengan kata lain, setiap objek Jadwal menyimpan referensi ke satu objek Film, yang merepresentasikan film yang dijadwalkan untuk ditayangkan. Hal ini menciptakan hubungan satu-ke-satu antara Jadwal dan film dalam satu instance, namun satu film dapat memiliki beberapa jadwal tayang berbeda. 
- Kelas Admin memiliki asosiasi dengan kelas Film dan Jadwal: admin bertanggung jawab dalam mengelola data film dan jadwal penayangan. Melalui method seperti tambahFilm(), updateFilm(), dan hapusFilm(), admin dapat memodifikasi data film dalam sistem. Begitu pula dengan jadwal penayangan, di mana admin dapat menambahkan, memperbarui, maupun menghapus jadwal melalui method yang tersedia di kelas Admin 
3. Dependensi 
- Customer bergantung pada kelas Tiket dalam pelaksanaan proses pemesanan, di mana method pemesanan() kemungkinan akan menciptakan atau menggunakan objek dari kelas Tiket. Kelas Customer juga memiliki dependensi terhadap kelas Penjadwalan, karena pemesanan tiket selalu didasarkan pada data jadwal film yang tersedia. 
- Admin juga menunjukkan dependensi terhadap kelas Film dan Penjadwalan, karena method yang dijalankannya seperti ‘tambahFilm()’ atau ‘tambahJadwal()’ akan melibatkan manipulasi objek-objek dari dua kelas tersebut


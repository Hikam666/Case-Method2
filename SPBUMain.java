import java.util.Scanner;

public class SPBUMain {
    //keyword          method  parameter
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //tipe data      variabel       objek
        AntrianKendaraan antrian = new AntrianKendaraan();
        //tipe data      variabel       objek
        QueueTransaksi riwayat = new QueueTransaksi(10);

        int pilihan;
        do {
            System.out.println("\n================================= ");
            System.out.println("\n----------- MENU SPBU ----------- ");
            System.out.println("\n================================= ");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Jumlah Antrian");
            System.out.println("4. Layani Kendaraan & Catat Transaksi");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Kosongkan Antrian Transaksi");
            System.out.println("7. Cari Transaksi Berdasarkan Jumlah Liter");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor : ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan Tipe Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merek Kendaraan: ");
                    String merek = sc.nextLine();
                    antrian.tambah(new kendaraan(plat, tipe, merek));
                    System.out.println(">>> Kendaraan Masuk Antrian <<<");
                    break;
                case 2:
                    antrian.tampilkan();
                    break;
                case 3:
                    System.out.println(">>> Ada " + antrian.ukuran() + " Antrian Kendaraan <<<");
                    break;
                case 4:
                    kendaraan dilayani = antrian.layanan();
                    if (dilayani == null) {
                    System.out.println(">>> Tidak Ada Kendaraan <<<");
                    break;
                    }
                    System.out.println(">>> Petugas Melayani <<<");
                    dilayani.tampilkanInformasi();
                    System.out.print("Masukkan Jenis BBM: ");
                    String jenis = sc.nextLine();

                    System.out.print("Masukkan Harga Per Liter: ");
                    double harga;
                    do {
                    harga = sc.nextDouble();
                    if (harga <= 0) {
                    System.out.print("Harga harus lebih dari 0. Masukkan lagi: ");
                    }
                    } while (harga <= 0);

                    System.out.print("Masukkan Jumlah Liter: ");
                    double liter;
                    do {
                    liter = sc.nextDouble();
                    if (liter <= 0) {
                    System.out.print("Jumlah liter harus lebih dari 0. Masukkan lagi: ");
                    }
                    } while (liter <= 0);
                    sc.nextLine();

                    BBM bbm = new BBM(jenis, harga);
                    TransaksiPengisian t = new TransaksiPengisian(dilayani, bbm, liter);
                    riwayat.enqueue(t);
                    System.out.println(">>> Transaksi Tercatat <<<");
                    break;
                    
                case 5:
                    riwayat.tampilkanTransaksi();
                    break;
                case 0:
                    System.out.println(">>> Terima Kasih <<<");
                    break;
                default:
                    System.out.println(">>> Pilihan Tidak Valid <<<");
                    
                // Modifikasi UAS
                case 6:
                    riwayat.kosongkan();
                    System.out.println(">>> Antrian Transaksi Telah Dikosongkan <<<");
                    break;
                case 7:
                    System.out.print("Masukkan Jumlah Liter yang Dicari: ");
                    double cariLiter = sc.nextDouble();
                    riwayat.cariTransaksiBerdasarkanLiter(cariLiter);
                    break;
            }

        } while (pilihan != 0);
    }
}
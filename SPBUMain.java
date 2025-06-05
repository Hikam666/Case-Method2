import java.util.Scanner;

public class SPBUMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKendaraan antrian = new AntrianKendaraan();
        QueueTransaksi riwayat = new QueueTransaksi(10);

        int pilihan;
        do {
            System.out.println("\n--- MENU SPBU --- ");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Jumlah Antrian");
            System.out.println("4. Layani Kendaraan & Catat Transaksi");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Plat Nomor : ");
                    String plat = sc.nextLine();
                    System.out.print("Tipe Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Merek Kendaraan: ");
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
                    System.out.println(">>> Melayani <<<");
                    dilayani.tampilkanInformasi();
                    System.out.print("Jenis BBM: ");
                    String jenis = sc.nextLine();
                    System.out.print("Harga Per Liter: ");
                    double harga = sc.nextDouble();
                    System.out.print("Jumlah Liter: ");
                    double liter = sc.nextDouble();
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
                    System.out.println("> Pilihan Tidak Valid <<<");
            }
        } while (pilihan != 0);
    }
}
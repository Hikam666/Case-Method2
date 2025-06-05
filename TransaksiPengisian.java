public class TransaksiPengisian {
    kendaraan kendaraan;
    BBM bbm;
    double jumlahLiter, totalHarga;

    public TransaksiPengisian(kendaraan kendaraan, BBM bbm, double jumlahLiter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.jumlahLiter = jumlahLiter;
        this.totalHarga = jumlahLiter * bbm.hargaPerLiter;
    }

    public void tampilkanTransaksi() {
        System.out.println("Transaksi Pengisian BBM:");
        System.out.println("Jenis BBM: " + bbm.namaBBM);
        System.out.println("Jumlah Liter: " + jumlahLiter);
        System.out.println("Total Harga: Rp" + totalHarga);
    }
}
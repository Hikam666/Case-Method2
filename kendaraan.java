public class kendaraan {
    String platNomor;
    String tipe;
    String merek;

    public kendaraan(String plat, String tipe, String merek) {
        platNomor = plat;
        this.tipe = tipe;
        this.merek = merek;
    }

    public void tampilkanInformasi () {
        System.out.println(platNomor + " - " + tipe + " - " + merek);
    }
}
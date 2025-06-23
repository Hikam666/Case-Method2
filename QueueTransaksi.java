public class QueueTransaksi {
    // tipedata | variable
    TransaksiPengisian[] queue;
    int front, rear, size, capacity;

    public QueueTransaksi(int capacity) {
        //referensi | atribut kelas | parameter | indeks
        this.capacity = capacity;
        this.queue = new TransaksiPengisian[capacity]; // inisialisasi antrian
        this.front = 0; //posisi depan antrian
        this.rear = -1; //posisi belakang antrian
        this.size = 0; //ukuran antrian
    }

    public void enqueue(TransaksiPengisian transaksi) {
        if (size == capacity) {
            System.out.println("Transaksi penuh, tidak bisa menambahkan transaksi baru");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = transaksi;
        size++;
    }

    public void tampilkanTransaksi() {
        if (size == 0) {
            System.out.println("Transaksi masih kosong");
            return;
        }
        System.out.println("Transaksi dalam antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            queue[index].tampilkanTransaksi();
        }
    }

    //modifikasi UAS
    public void kosongkan() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian transaksi telah dikosongkan");
    }

    // Modifikasi UAS
    public void cariTransaksiBerdasarkanLiter(double liter) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            if (queue[index].jumlahLiter == liter) {
                queue[index].tampilkanTransaksi();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada transaksi dengan jumlah liter " + liter);
        }
    }
}
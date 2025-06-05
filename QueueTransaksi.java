public class QueueTransaksi {
    TransaksiPengisian[] queue;
    int front, rear, size, capacity;

    public QueueTransaksi(int capacity) {
        this.capacity = capacity;
        this.queue = new TransaksiPengisian[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
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
}

public class AntrianKendaraan { //linked list
    // tipedata | variable
    Node head, tail;
    int size;

    public void tambah(kendaraan k) {
        Node baru = new Node(k);
        if (head == null) { //Mengecek apakah antrian kosong
            head = tail = baru; //Jika kosong, maka node baru (baru) menjadi head dan tail sekaligus, karena hanya ada satu elemen dalam antrian.
        } else {
            tail.next = baru; //Node terakhir saat ini (tail) menunjuk ke node baru.
            tail = baru; //Node baru menjadi node terakhir dalam antrian.
        }
        size++; //Menambah ukuran antrian
    }

    public kendaraan layanan() {
        if (head == null) return null; //Jika antrian kosong, tidak ada kendaraan yang bisa dilayani
        //Mengambil data dari head (kendaraan yang akan dilayani)
        kendaraan data = head.data; // Data kendaraan yang akan dilayani
        //Memindahkan head ke node berikutnya
        head = head.next; // Node head sekarang menjadi node berik4utnya dalam antrian
        if (head == null) tail = null; // Jika head menjadi null, berarti antrian sekarang kosong, jadi tail juga harus di-set ke null.
        size--; //Mengurangi ukuran antrian
        return data; // Mengembalikan data kendaraan yang dilayani
    }

    public void tampilkan() {
        if (head == null) {
            System.out.println("-- Antrian Kosong --");
            return;
        }
        Node current = head; // Memulai dari head
        while (current != null) { // Selama current tidak null, artinya masih ada kendaraan dalam antrian
            current.data.tampilkanInformasi();
            current = current.next; // Pindah ke node berikutnya
        }
    }

    //Modifikasi UAS
    public int ukuran() {
        return size;
    }

    public void kosongkan() {
        head = tail = null;
        size = 0;
    }
}
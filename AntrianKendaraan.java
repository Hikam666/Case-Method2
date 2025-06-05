public class AntrianKendaraan {
    Node head, tail;
    int size;

    public void tambah(kendaraan k) {
        Node baru = new Node(k);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
    }

    public kendaraan layanan() {
        if (head == null) return null;
        kendaraan data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public void tampilkan() {
        if (head == null) {
            System.out.println("-- Antrian Kosong --");
            return;
        }
        Node current = head;
        while (current != null) {
            current.data.tampilkanInformasi();
            current = current.next;
        }
    }

    public int ukuran() {
        return size;
    }
}
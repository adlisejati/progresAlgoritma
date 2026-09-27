package modul5;

import java.util.Scanner;

public class DLL {

    Node head, tail;
    int size = 0;

    void inisialisasi() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void insertAfter(Object key, Node input) {
        Node current = head;

        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
        } else if (current == tail) {
            addLast(input);
        } else {
            input.next = current.next;
            input.prev = current;
            current.next.prev = input;
            current.next = input;
            size++;
        }
    }

    Node search(Object key) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(key)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    void printForward() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    void printBackward() {
        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }

    void insertSorted(Mahasiswa mahasiswa) {

        Node input = new Node(mahasiswa);

        if (isEmpty()) {
            addFirst(input);
            return;
        }

        Mahasiswa first = (Mahasiswa) head.data;

        if (mahasiswa.getIpk() < first.getIpk()) {
            addFirst(input);
            return;
        }

        Node current = head;

        while (current.next != null) {
            Mahasiswa nextMahasiswa = (Mahasiswa) current.next.data;

            if (mahasiswa.getIpk() < nextMahasiswa.getIpk()) {
                break;
            }

            current = current.next;
        }

        if (current == tail) {
            addLast(input);
        } else {
            input.next = current.next;
            input.prev = current;
            current.next.prev = input;
            current.next = input;
            size++;
        }
    }

    void printAscending() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        Node current = head;

        while (current != null) {
            Mahasiswa mahasiswa = (Mahasiswa) current.data;
            System.out.println(mahasiswa);
            current = current.next;
        }
    }

    void printDescending() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        Node current = tail;

        while (current != null) {
            Mahasiswa mahasiswa = (Mahasiswa) current.data;
            System.out.println(mahasiswa);
            current = current.prev;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DLL list = new DLL();

        System.out.print("Jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlah; i++) {

            System.out.println("\nMahasiswa ke-" + (i + 1));

            System.out.print("NIM   : ");
            String nim = sc.nextLine();

            System.out.print("Nama  : ");
            String nama = sc.nextLine();

            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, ipk);

            list.insertSorted(mahasiswa);
        }

        System.out.println("\n=== DATA MAHASISWA - ASCENDING (IPK terkecil ke terbesar) ===");
        list.printAscending();

        System.out.println("\n=== DATA MAHASISWA - DESCENDING (IPK terbesar ke terkecil) ===");
        list.printDescending();

        sc.close();
    }
}
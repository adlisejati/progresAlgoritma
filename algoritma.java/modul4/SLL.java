package modul4;

import java.util.Scanner;
import modul5.Mahasiswa;

public class SLL {

    Node1 head, tail;
    int size = 0;

    // 1. Inisialisasi
    void inisialisasi() {
        head = null;
        tail = null;
        size = 0;
    }

    // 2. isEmpty
    boolean isEmpty() {
        return size == 0;
    }

    // 3. Size
    int size() {
        return size;
    }

    void addFirst(Node1 input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }

        size++;
    }

    void addLast(Node1 input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }

        size++;
    }

    boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }

        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return true;
    }

    boolean removeLast() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return true;
        }

        Node1 current = head;

        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;
        size--;

        return true;
    }

    void insertSorted(Mahasiswa mahasiswa) {

        Node1 input = new Node1(mahasiswa);

        if (isEmpty()) {
            head = input;
            tail = input;
            size++;
            return;
        }

        Mahasiswa first = (Mahasiswa) head.data;

        if (mahasiswa.getIpk() < first.getIpk()) {
            addFirst(input);
            return;
        }

        Node1 current = head;

        while (current.next != null) {

            Mahasiswa nextMahasiswa = (Mahasiswa) current.next.data;

            if (mahasiswa.getIpk() < nextMahasiswa.getIpk()) {
                break;
            }

            current = current.next;
        }

        input.next = current.next;
        current.next = input;

        if (input.next == null) {
            tail = input;
        }

        size++;
    }

    void printList() {

        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }

        Node1 current = head;

        while (current != null) {
            Mahasiswa mahasiswa = (Mahasiswa) current.data;

            System.out.println(
                    mahasiswa.getNim() + " - "
                            + mahasiswa.getNama() + " - IPK: "
                            + mahasiswa.getIpk());

            current = current.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SLL list = new SLL();

        System.out.print("Jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlah; i++) {

            System.out.println("\nMahasiswa ke-" + (i + 1));

            System.out.print("NIM: ");
            String nim = sc.nextLine();

            System.out.print("Nama: ");
            String nama = sc.nextLine();

            System.out.print("IPK: ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, ipk);

            list.insertSorted(mahasiswa);
        }

        System.out.println("\n=== DATA MAHASISWA BERDASARKAN IPK ===");
        list.printList();

        sc.close();
    }
}
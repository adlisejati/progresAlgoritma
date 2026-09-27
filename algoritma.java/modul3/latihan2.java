
package modul3;

public class latihan2 {
    public static void main(String[] args) {

        // Data awal
        int[] data = {
                30, 87, 90, 3, 1,
                50, 23, 4, 25, 23,
                40, 35, 47, 2, 33
        };

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {

                if (data[j] > data[j + 1]) {
                    int sementara = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = sementara;
                }
            }
        }

        System.out.println("\n1. Data Setelah Diurutkan:");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

        int jumlah = 0;

        for (int i = 0; i < data.length; i++) {
            jumlah += data[i];
        }

        double rataRata = (double) jumlah / data.length;

        System.out.println("\n\n2. Rata-rata Data:");
        System.out.printf("%.2f%n", rataRata);

        int nilaiMaksimal = data[0];
        int nilaiMinimal = data[0];

        for (int i = 1; i < data.length; i++) {

            if (data[i] > nilaiMaksimal) {
                nilaiMaksimal = data[i];
            }

            if (data[i] < nilaiMinimal) {
                nilaiMinimal = data[i];
            }
        }

        System.out.println("\n3. Nilai Maksimal dan Minimal:");
        System.out.println("Nilai maksimal = " + nilaiMaksimal);
        System.out.println("Nilai minimal  = " + nilaiMinimal);

        System.out.println("\n4. Bilangan Ganjil:");

        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 != 0) {
                System.out.print(data[i] + " ");
            }
        }

        System.out.println("\n\n   Bilangan Prima:");

        for (int i = 0; i < data.length; i++) {

            int jumlahPembagi = 0;

            for (int j = 1; j <= data[i]; j++) {
                if (data[i] % j == 0) {
                    jumlahPembagi++;
                }
            }

            if (jumlahPembagi == 2) {
                System.out.print(data[i] + " ");
            }
        }

        int[][] data2D = new int[3][5];
        int posisiData = 0;

        for (int baris = 0; baris < data2D.length; baris++) {
            for (int kolom = 0; kolom < data2D[baris].length; kolom++) {

                data2D[baris][kolom] = data[posisiData];
                posisiData++;
            }
        }

        System.out.println("\n\n5. Array 2 Dimensi (3 x 5):");

        for (int baris = 0; baris < data2D.length; baris++) {
            for (int kolom = 0; kolom < data2D[baris].length; kolom++) {
                System.out.printf("%-5d", data2D[baris][kolom]);
            }
            System.out.println();
        }

        System.out.println("======================================");
    }
}
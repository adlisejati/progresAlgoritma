package modul3;

public class latihan1 {
    public static void main(String[] args) {

        // Membuat array dan memasukkan data
        int[] data = {
                30, 87, 90, 3, 1,
                50, 23, 4, 25, 23,
                40, 35, 47, 2, 33
        };

        System.out.println("Data Array Sebelum Diurutkan:");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Index " + i + " = " + data[i]);
        }

     
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {

                if (data[j] > data[j + 1]) {
                    int sementara = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = sementara;
                }
            }
        }

   
        System.out.println("\nData Array Setelah Diurutkan:");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Index " + i + " = " + data[i]);
        }
    }
}

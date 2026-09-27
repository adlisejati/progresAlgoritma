package modul3;

public class Larik {
    private int sizeH;
    private double[] itemDt;

    public Larik(int size) {
        sizeH = size;
        itemDt = new double[sizeH];
    }

    public int getSizeH() {
        return sizeH;
    }

    public double getItem(int id) {
        return itemDt[id];
    }

    public void isiItem(int id, double dt) {
        itemDt[id] = dt;
    }

    public static double LarikKaliLarik(Larik L1, Larik L2) {
        double hasil = 0;

        for (int i = 0; i < L1.getSizeH(); i++) {
            hasil += L1.getItem(i) * L2.getItem(i);
        }

        return hasil;
    }

    public void cetak(String kom) {
        System.out.println(kom);

        for (int i = 0; i < sizeH; i++) {
            System.out.printf("%.2f ", itemDt[i]);
        }

        System.out.println();
    }
}
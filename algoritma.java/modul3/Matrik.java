package modul3;

public class Matrik {
    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] A) {
        this(A.length, A[0].length);

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                itemDt[i][j] = A[i][j];
            }
        }
    }

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        itemDt[idB][idK] = dt;
    }

    public static Matrik tambah(Matrik A, Matrik B) {
        Matrik C = new Matrik(A.getNBaris(), A.getNKolom());

        for (int i = 0; i < A.getNBaris(); i++) {
            for (int j = 0; j < A.getNKolom(); j++) {
                C.setItem(i, j, A.getItem(i, j) + B.getItem(i, j));
            }
        }

        return C;
    }

    public static Matrik tranpos(Matrik A) {
        Matrik T = new Matrik(A.getNKolom(), A.getNBaris());

        for (int i = 0; i < A.getNBaris(); i++) {
            for (int j = 0; j < A.getNKolom(); j++) {
                T.setItem(j, i, A.getItem(i, j));
            }
        }

        return T;
    }

    public Larik getBaris(int idBaris) {
        Larik I = new Larik(nKolom);

        for (int i = 0; i < nKolom; i++) {
            I.isiItem(i, getItem(idBaris, i));
        }

        return I;
    }

    public Larik getKolom(int idKolom) {
        Larik I = new Larik(nBaris);

        for (int i = 0; i < nBaris; i++) {
            I.isiItem(i, getItem(i, idKolom));
        }

        return I;
    }

    public static Larik VektorKaliMatrik(Larik L, Matrik M) {
        Larik IHasil = null;

        if (L.getSizeH() == M.getNBaris()) {
            IHasil = new Larik(M.getNKolom());

            for (int i = 0; i < M.getNKolom(); i++) {
                Larik IKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L, IKolom);

                System.out.println(hasil);
                IHasil.isiItem(i, hasil);
            }
        }

        return IHasil;
    }

    public void cetak(String kom) {
        System.out.println(kom);

        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                System.out.printf("%.2f ", itemDt[i][j]);
            }

            System.out.println();
        }
    }
}
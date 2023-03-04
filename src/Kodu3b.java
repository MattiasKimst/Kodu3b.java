/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 3b
 * Teema: Täiarvumassiivi töötlemine
 *
 * Autor: Mattias Kimst
 *
 **********************************/
public class Kodu3b {

    /**
     * Meetod, mis leiab massiivist arvud, mis esinevad igas reas.
     * @param a sisend täisarvude massiiv suurusega n*n
     * @return täisarvude massiiv, mis on mittekahanevalt sorteeritud ja milles leidub mingit
     * arvu täpselt k korda, kui sisendmassiivi igas reas on seda arvu vähemalt k korda
     */
    public static int[] korduvadRead(int[][] a) {

        for (int i = 0; i < a[0].length - 1; i++) { // sorteerib esimese rea kasvavas järjestuses
            for (int j = i + 1; j < a[0].length; j++) {
                if (a[0][i] > a[0][j]) {
                    int ajutine = a[0][i];
                    a[0][i] = a[0][j];
                    a[0][j] = ajutine;
                }
            }
        }

        int elemendiEsinemisteArv;
        int reasEsinemisteArv;
        int[] lõppMassiiv;
        int[] ajutineMassiiv = new int[a[0].length];
        int massiiviSeninePikkus = 0;
        int vaadeldavElement;

        for (int i = 0; i < a[0].length; i++) {
            vaadeldavElement = a[0][i];
            if (i > 0) { // et sama elementi mitu korda ei vaataks
                if (a[0][i] == a[0][i - 1]) {
                    continue;
                }
            }
            elemendiEsinemisteArv = 0;
            // leiab, mitu korda elementi esineb
            for (int j = 0; j < a[0].length; j++) {
                if (vaadeldavElement == a[0][j])
                    elemendiEsinemisteArv++;
            }

            for (int k = 1; k < a.length; k++) { // käib läbi kõik read
                reasEsinemisteArv = 0;
                for (int l = 0; l < a[k].length; l++) {
                    if (a[k][l] == vaadeldavElement) {
                        reasEsinemisteArv++;
                    }
                }
                if (reasEsinemisteArv < elemendiEsinemisteArv) {
                    elemendiEsinemisteArv = reasEsinemisteArv;
                }
            }
            for (int n = massiiviSeninePikkus; n < massiiviSeninePikkus + elemendiEsinemisteArv; n++) {
                ajutineMassiiv[n] = vaadeldavElement;
            }
            massiiviSeninePikkus += elemendiEsinemisteArv;
        }
        lõppMassiiv = new int[massiiviSeninePikkus];
        for (int i = 0; i < massiiviSeninePikkus; i++) {
            lõppMassiiv[i] = ajutineMassiiv[i];
        }
        return lõppMassiiv;
    }


    public static void main(String[] args) {
        int[][] a =
                {{1, 1, 2, 1},
                        {1, 2, 1, 1},
                        {2, 1, 1, 1},
                        {1, 2, 1, 1}};
        for (int i : korduvadRead(a)) {
            System.out.println(i);

        }

    }//main

}//klass
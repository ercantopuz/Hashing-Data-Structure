
package hashing;

class dugum {

    int deger;
    dugum ileri;

    dugum(int deger) {
        this.deger = deger;
        ileri = null;
    }
}

public class SeparateChaining {

    dugum tablo[];
    int boyut;
    int sayac = 0;
    SeparateChaining(int boyut) {
        this.boyut = boyut;
        tablo = new dugum[boyut];
        for (int i = 0; i < boyut; i++) {
            tablo[i] = null;
        }

    }

    public void ekle(int sayi) {
        int mod = sayi % boyut;

        if (tablo[mod] == null) {
            tablo[mod] = new dugum(sayi);
        } else {
            dugum konum = tablo[mod];
            while (konum.ileri != null) {
                konum = konum.ileri;
            }
            konum.ileri = new dugum(sayi);
        }
        sayac++;
    }

    public void goster() {
        int i = 0;
        while (i < boyut) {
            System.out.print("tablo  " + i + " :   ");
            dugum konum = tablo[i];
            while (konum != null) {
                System.out.print(konum.deger + "-> ");
                konum = konum.ileri;
            }
            System.out.println();
            i++;
        }

    }

    public boolean bul(int sayi) {
        int i = 0;

        while (i < boyut) {
            dugum konum = tablo[i];
            while (konum != null) {
                if (konum.deger == sayi) {
                    return true;
                }
                konum = konum.ileri;
            }
            i++;

        }
        return false;
    }

    public void sil(int sayi) {
        if (!bul(sayi)) {
            System.out.println("Sayı yok");
        } else {
            int i = 0;
            while (i < boyut) {
                dugum konum1 = null;
                dugum konum2 = tablo[i];
                while (konum2 != null) {
                    if (konum2.deger==sayi) {
                         konum1.ileri = konum2.ileri;
                         return;
                    }
                     konum1 = konum2;
                     konum2 = konum2.ileri;
                }
                 i++; 
            }
        }
    }

    public static void main(String[] args) {
        SeparateChaining m = new SeparateChaining(10);
        m.ekle(19);
        m.ekle(12);
        m.ekle(23);
        m.ekle(798);
        m.ekle(34);

        m.ekle(86);

        m.ekle(22);
        m.ekle(128);
        m.ekle(8);
        m.ekle(68);
        m.ekle(11);
        m.ekle(10);
        m.ekle(15);
        m.ekle(17);
        m.goster();
        m.sil(8);
        m.goster();
        System.out.println(m.bul(19));
        

    }

}

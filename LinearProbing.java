package hashing;

class HashTablosu {

    int deger;

    HashTablosu(int deger) {
        this.deger = deger;
    }
}

public class LinearProbing {

    HashTablosu tablo[];
    int boyut;
    int sayac = 0;

    LinearProbing(int boyut) {
        this.boyut = boyut;
        tablo = new HashTablosu[boyut];
        for (int i = 0; i < boyut; i++) {
            tablo[i] = null;
        }
    }

    public void ekle(int deger) {
        if (sayac == boyut) {
            System.out.println("Ekleme yapılamaz dolu");
        } else {
            int mod = deger % boyut;
            if (tablo[mod] == null) {
                tablo[mod] = new HashTablosu(deger);
            } else {
                while (tablo[mod] != null) {
                    mod = (mod + 1) % boyut;

                }
                tablo[mod] = new HashTablosu(deger);

            }
            sayac++;
        }

    }

    public void sil(int deger) {

        if (sayac == 0) {
            System.out.println("Tablo boş");
            return;
        } else {
            int mod = deger % boyut;

            while (true) {

                if (tablo[mod].deger != deger) {
                    mod = (mod + 1) % boyut;
                } else {
                    tablo[mod] = null;
                    break;
                    }

            }

        }
        sayac--;

    }

    public void goster() {
        int i = 0;
        while (i < boyut) {
            System.out.print("tablo :" + i + "  ");
            if (tablo[i] != null) {
                System.out.print(tablo[i].deger);

            }
            System.out.println("");
            i++;
        }
    }

    public static void main(String[] args) {
        LinearProbing z = new LinearProbing(10);
        z.ekle(12);
        z.ekle(34);
        z.ekle(57);
        z.ekle(78);
        z.ekle(32);
        z.ekle(45);
        z.ekle(44);
        z.ekle(90);
        z.ekle(13);
        z.goster();
        z.sil(44);

        z.goster();
        z.ekle(130);
        z.ekle(1223);
        z.ekle(22113);
        z.ekle(12313);
        z.goster();

    }

}

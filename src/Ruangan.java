import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {

    private Pintu objPintu;
    private NPC objNPC;
    private Item objRoti;
    private ArrayList<Thing> arrThing = new ArrayList<Thing>();
    private String deskripsi;
    private Scanner sc = new Scanner(System.in);
    private GameInfo objGameInfo;

    // objgame juga diset pada thing yang ada di dalam array
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        for (Thing objThing : arrThing) {
            objThing.setObjGameInfo(objGameInfo);
        }
    }

    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu("Pintu", "Pintu berwarna merah dengan tulisan 'EXIT' di atas ", this.objGameInfo);
        objNPC = new NPC("NPC", "Halo saya penjaga pintu ini", this.objGameInfo);
        objRoti = new Item("Roti", "Roti rasa coklat dalam bungkusan plastik", this.objGameInfo);
        objRoti.setObjRuangan(this);
        // tambah item ke array
        arrThing.add(objRoti);
        arrThing.add(objPintu);
        arrThing.add(objNPC);
    }

    // aksi yang dapat dilakukan di ruangan
    // agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di
    // game engine)
    // hardcode menu dikurangi
    public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0; // item, pintu
        int subPil; // aksinya

        // aksi2 thing
        System.out.println("Thing di ruangan");
        for (Thing objThing : arrThing) {
            urutPil++;
            subPil = 0; // sistem penomorannya 11 12 13 dst
            System.out.println(objThing.getNama());
            // ambil pilihannya
            ArrayList<String> arrPil = objThing.getArrAksi();
            // print pilihan
            for (String strPil : arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        System.out.print("Pilihan anda? ");
        String strPil = sc.next();
        System.out.println("--");

        // split pilihan dan subpilihan

        int pil = Integer.parseInt(strPil.substring(0, 1)); // ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil = Integer.parseInt(strPil.substring(1, 2)); // ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        Thing objThingPilih = arrThing.get(pil - 1);
        objThingPilih.prosesAksi(subPil);
    }

    // hapus thing di ruangan berdasarkan namanya
    // digunakan saat suatu thing diambil oleh player misalnya
    public void hapusThing(Thing objThing) {
        arrThing.remove(objThing); // buang thing
    }

    public void addThing(Thing objThing) {
        arrThing.add(objThing);
    }

    // setter & getter
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public ArrayList<Thing> getArrThing() {
        return arrThing;
    }

    public void setArrThing(ArrayList<Thing> arrThing) {
        this.arrThing = arrThing;
    }

}

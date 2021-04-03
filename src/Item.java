import java.util.ArrayList;

public class Item extends Thing {

    private Ruangan objRuangan; // ruangan tempat item, jika null artinya item dipegang npc atau player

    // constructor
    public Item(String nama, String deskripsi, GameInfo objGameInfo) {
        super(nama, deskripsi, objGameInfo);
    }

    @Override
    public void prosesAksi(int pil) {
        // pilihan user untuk aksi yang akan diambil
        // urutan harus sama dengan isi arrAksi
        if (pil == 1) {
            describe();
        } else if (pil == 2) { // bisa ambil atau buang
            if (objRuangan == null) {
                // dipegang player, buang ke ruangan
                dibuang();
            } else {
                // ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().hapusItem(this); // hapus dari player
        objGameInfo.getObjRuangan().addThing(this); // tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan(); // set ruangan
    }

    // pindahkan item dari ruangan ke player
    private void diambil() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this); // tambahkan objek ini (this) pada player
        objRuangan.hapusThing(this); // hapus dari ruangan
        objRuangan = null;
    }

    @Override
    public ArrayList<String> getArrAksi() {
        // aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if (objRuangan == null) {
            // ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            // ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return (arrOut);
    }

    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

}

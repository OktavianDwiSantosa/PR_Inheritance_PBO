import java.util.ArrayList;

public class Thing {
    protected String nama;
    protected String deskripsi;
    protected GameInfo objGameInfo;
    protected ArrayList<String> arrAksi = new ArrayList<String>();

    // constructor
    public Thing(String nama, String deskripsi, GameInfo objGameInfo) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.objGameInfo = objGameInfo;
    }

    // methods
    public void prosesAksi(int pil) {
        // pilihan user untuk aksi yang akan diambil
        // urutan harus sama dengan isi arrAksi
        // harus di override
    }

    public void describe() {
        // untuk mencetak deskripsi objek
        System.out.println(deskripsi);
    }

    // setter & getter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public ArrayList<String> getArrAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }

}

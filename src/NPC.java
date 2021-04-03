public class NPC extends Thing {
    // kunci dipindahkan dari ruangan
    private Item objKunci;
    private boolean isKenal = false;

    public NPC(String nama, String deskripsi, GameInfo objGameInfo) {
        super(nama, deskripsi, objGameInfo);
        // init kunci
        objKunci = new Item("Kunci", "Sebuah kunci kecil yang sudah agak berkarat", this.objGameInfo);
        // aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");

    }

    @Override
    public void prosesAksi(int subPil) {
        // 1: perkenalan dengan npc
        // 2: buka pintu
        if (subPil == 1) {
            describe();
            isKenal = true;
        } else if (subPil == 2) {
            if (isKenal) {
                // berikan kunci pada player
                if (objKunci == null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else {
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci); // tambahkan objek ini pada player
                    objKunci = null;
                }
            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

}

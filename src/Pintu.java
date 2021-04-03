public class Pintu extends Thing {

    // constructor
    public Pintu(String nama, String deskripsi, GameInfo objGameInfo) {
        super(nama, deskripsi, objGameInfo);
        // init pilihan
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    @Override
    public void prosesAksi(int subPil) {
        // 1: deskripsikan
        // 2: buka pintu
        if (subPil == 1) {
            describe();
        } else if (subPil == 2) {
            // cek apakah mempunyai kunci
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                // kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); // game over
            } else {
                // kunci tidak ada
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }

}

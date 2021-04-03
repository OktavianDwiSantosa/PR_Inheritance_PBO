# Kelompok 8
### __Nama: Oktavian Dwi Santosa__  
### __NIM: 1902793__  
---
Modifikasi/Tambahan:  
1. Class `Thing` sebagai ___superclass___ dari ___subclass___ `Item` , `Pintu` dan `NPC`.

2. Method `prosesAksi()` disetiap ___subclass___ `Thing` __harus dioverride__, karena implementasi di ___superclass___-nya belum ada. Tujuannya, agar setiap ___subclass___ lebih fleksibel dalam memproses aksinya.

3. Terdapat method `describe()` di dalam class `Thing` yang berfungsi untuk mendeskripsikan objek.

4. Atribut `arrItem` pada class `Ruangan` diganti menjadi `arrThing` agar bisa menampung objek dari class `Item` , `Pintu` dan `NPC`.

5. Method `hapusItem()` dan `addItem()` yang terdapat di dalam class `Ruangan`, diganti menjadi `hapusThing()` dan `addThing()`. Tujuannya, agar `Ruangan` bisa menghapus dan menambahkan objek dari class `Item` , `Pintu` dan `NPC` ke dalam `arrThing`.

6. Penghapusan hardcode atribut dan method ___subclass___, yang sudah tersedia di dalam ___superclass___ `Thing`.
package com.example.p5.data

import com.example.p5.model.KategoriResep
import com.example.p5.model.Resep
import com.example.p5.model.StatusResep

val daftarKategori = listOf(
    KategoriResep(1, "Hemat Banget", "Di bawah Rp10.000"),
    KategoriResep(2, "Tanpa Kompor", "Cukup rice cooker atau air panas"),
    KategoriResep(3, "Teman Begadang", "Cepat jadi buat malam hari")
)

val resepContoh = listOf(
    Resep(
        id = 1,
        nama = "Nasi Goreng Telur",
        deskripsi = "Andalan akhir bulan",
        bahan = listOf("Nasi", "Telur", "Kecap", "Bawang putih"),
        langkah = listOf("Tumis bawang", "Masukkan telur", "Masukkan nasi dan kecap"),
        waktuMasakMenit = 10,
        estimasiBiaya = 8000,
        porsi = 1,
        alatMasak = "Penggorengan",
        kategori = daftarKategori[0],
        status = StatusResep.Diajukan
    ),
    Resep(
        id = 2,
        nama = "Mie Rebus Spesial",
        deskripsi = "Mie instan plus sayur dan telur",
        bahan = listOf("Mie instan", "Telur", "Sawi"),
        langkah = listOf("Rebus air", "Masukkan mie dan sayur", "Pecahkan telur"),
        waktuMasakMenit = 7,
        estimasiBiaya = 6000,
        porsi = 1,
        alatMasak = "Panci",
        kategori = daftarKategori[2],
        status = StatusResep.Disetujui,
        fotoUrl = "https://contoh.com/mie.jpg"
    ),
    Resep(
        id = 3,
        nama = "Nasi Liwet Rice Cooker",
        deskripsi = "Sekali masak langsung wangi",
        bahan = listOf("Beras", "Teri", "Daun salam", "Serai"),
        langkah = listOf("Cuci beras", "Masukkan semua bahan", "Tekan tombol masak"),
        waktuMasakMenit = 30,
        estimasiBiaya = 12000,
        porsi = 2,
        alatMasak = "Rice cooker",
        kategori = daftarKategori[1],
        status = StatusResep.Disetujui
    ),
    Resep(
        id = 4,
        nama = "Telur Dadar Kornet",
        deskripsi = "Lauk cepat buat sarapan",
        bahan = listOf("Telur", "Kornet", "Daun bawang"),
        langkah = listOf("Kocok telur dan kornet", "Goreng sampai matang"),
        waktuMasakMenit = 8,
        estimasiBiaya = 9000,
        porsi = 1,
        alatMasak = "Penggorengan",
        kategori = daftarKategori[0],
        status = StatusResep.Disetujui
    ),
    Resep(
        id = 5,
        nama = "Oatmeal Pisang",
        deskripsi = "Sarapan kenyang tanpa nyalakan kompor",
        bahan = listOf("Oat instan", "Pisang", "Susu kental manis"),
        langkah = listOf("Seduh oat dengan air panas", "Tambahkan pisang dan susu"),
        waktuMasakMenit = 5,
        estimasiBiaya = 7000,
        porsi = 1,
        alatMasak = "Dispenser",
        kategori = daftarKategori[1],
        status = StatusResep.Diajukan
    ),
    Resep(
        id = 6,
        nama = "Tumis Kangkung Bawang",
        deskripsi = "Sayur murah meriah",
        bahan = listOf("Kangkung", "Bawang merah", "Bawang putih", "Saus tiram"),
        langkah = listOf("Tumis bawang", "Masukkan kangkung", "Beri saus tiram"),
        waktuMasakMenit = 10,
        estimasiBiaya = 5000,
        porsi = 2,
        alatMasak = "Penggorengan",
        kategori = daftarKategori[0],
        status = StatusResep.Disetujui
    ),
    Resep(
        id = 7,
        nama = "Roti Bakar Teflon",
        deskripsi = "Camilan tengah malam pas tugas numpuk",
        bahan = listOf("Roti tawar", "Margarin", "Meses"),
        langkah = listOf("Olesi roti dengan margarin", "Panggang di teflon", "Taburi meses"),
        waktuMasakMenit = 6,
        estimasiBiaya = 10000,
        porsi = 1,
        alatMasak = "Teflon",
        kategori = daftarKategori[2],
        status = StatusResep.Ditolak
    ),
    Resep(
        id = 8,
        nama = "Sup Sosis Rice Cooker",
        deskripsi = "Hangat buat musim hujan",
        bahan = listOf("Sosis", "Wortel", "Kentang", "Kaldu bubuk"),
        langkah = listOf("Potong semua bahan", "Masukkan ke rice cooker dengan air", "Masak sampai empuk"),
        waktuMasakMenit = 25,
        estimasiBiaya = 15000,
        porsi = 2,
        alatMasak = "Rice cooker",
        kategori = daftarKategori[1],
        status = StatusResep.Diajukan,
        fotoUrl = "https://contoh.com/sup.jpg"
    ),
    Resep(
        id = 9,
        nama = "Tempe Goreng Tepung",
        deskripsi = "Lauk sejuta umat anak kos",
        bahan = listOf("Tempe", "Tepung bumbu", "Minyak goreng"),
        langkah = listOf("Iris tempe", "Celup ke adonan tepung", "Goreng sampai kering"),
        waktuMasakMenit = 15,
        estimasiBiaya = 6000,
        porsi = 2,
        alatMasak = "Penggorengan",
        kategori = daftarKategori[0],
        status = StatusResep.Disetujui,
        fotoUrl = "https://contoh.com/tempe.jpg"
    ),
    Resep(
        id = 10,
        nama = "Mie Goreng Keju",
        deskripsi = "Mie instan versi naik kelas",
        bahan = listOf("Mie goreng instan", "Keju parut", "Telur"),
        langkah = listOf("Rebus mie", "Tiriskan dan beri bumbu", "Taburi keju"),
        waktuMasakMenit = 7,
        estimasiBiaya = 9500,
        porsi = 1,
        alatMasak = "Panci",
        kategori = daftarKategori[2],
        status = StatusResep.Diajukan
    ),
    Resep(
        id = 11,
        nama = "Bubur Ayam Instan Plus",
        deskripsi = "Bubur sachet ditambah suwiran ayam",
        bahan = listOf("Bubur instan", "Ayam suwir", "Kerupuk", "Bawang goreng"),
        langkah = listOf("Seduh bubur dengan air panas", "Tambahkan topping"),
        waktuMasakMenit = 4,
        estimasiBiaya = 11000,
        porsi = 1,
        alatMasak = "Dispenser",
        kategori = daftarKategori[1],
        status = StatusResep.Ditolak
    ),
    Resep(
        id = 12,
        nama = "Indomie Telur Kornet Pedas",
        deskripsi = "Penyelamat saat kiriman belum datang",
        bahan = listOf("Mie instan", "Telur", "Kornet", "Cabai rawit"),
        langkah = listOf("Tumis cabai dan kornet", "Masukkan air dan mie", "Pecahkan telur"),
        waktuMasakMenit = 9,
        estimasiBiaya = 13000,
        porsi = 1,
        alatMasak = "Panci",
        kategori = daftarKategori[2],
        status = StatusResep.Disetujui
    )
)

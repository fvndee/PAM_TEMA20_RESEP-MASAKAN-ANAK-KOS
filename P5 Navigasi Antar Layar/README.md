# P5 Navigasi Antar Layar

Tema 20: Resep Masakan Anak Kos

## Anggota Kelompok 6

| Nama | NIM | Bagian |
| :- | :- | :- |
| Hanung Akbar Pramusintho | 124140207 | |
| Rajendra Rifandy | 124140099 | |
| Firman Luthfiansyah | 124140044 | |

## Peta navigasi

```
Menu bawah:  [Beranda]  [Asisten]  [Profil]

Beranda
  ketuk kartu, bawa id       =>  Detail resep, RuteDetail(id)
  tombol +                   =>  Form resep, RuteForm

Form resep
  simpan, bawa id baru       =>  Detail resep baru
                                 form dibuang dari tumpukan,
                                 Kembali langsung ke Beranda

Detail resep
  Kembali                    =>  layar sebelumnya
```

| Rute | Layar | Dibuka dari |
| :- | :- | :- |
| `RuteBeranda` | Daftar resep | Tab Beranda, layar pertama |
| `RuteAsisten` | Asisten resep, fitur AI diisi di Modul 9 | Tab Asisten |
| `RuteProfil` | Profil kelompok | Tab Profil |
| `RuteDetail(id)` | Detail satu resep | Ketuk kartu di daftar, atau setelah form disimpan |
| `RuteForm` | Tambah resep | Tombol + di daftar |

## Isi

| Berkas | Isi |
| :- | :- |
| `nav/Rute.kt` | Lima rute bertipe dengan `@Serializable` |
| `nav/Tab.kt` | Tiga tab menu bawah |
| `nav/PindahTab.kt` | Pindah tab dengan `popUpTo` dan `saveState`, `launchSingleTop`, `restoreState` |
| `App.kt` | `Scaffold` dengan `NavigationBar` dan satu `NavHost` |
| `ui/DetailViewModel.kt` | Sealed class `DetailUiState` (Memuat, Ada, TidakDitemukan) dan ViewModel yang mengambil resep dari `PenyimpananResep` berdasarkan id |
| `ui/LayarDetail.kt` | Bahan, langkah, dan tombol Setujui atau Tolak untuk resep berstatus Diajukan |
| `ui/LayarDaftar.kt` | Daftar resep, hanya menerima lambda `bukaDetail` dan `bukaForm` |
| `ui/LayarAsisten.kt`, `ui/LayarProfil.kt` | Layar tab yang masih sementara |

Layar tidak menerima `NavController`. Layar hanya mengirim event, lalu `App.kt` yang memutuskan pindah ke mana. Detail menerima id, bukan objek resep, jadi saat status diubah lewat tombol Setujui, data di detail dan daftar ikut berubah.

## Checkpoint minggu 5

| No | Yang diselesaikan | Letak |
| :- | :- | :- |
| 1 | NavHost dengan lima rute bertipe | `nav/Rute.kt`, `App.kt` |
| 2 | Kartu di daftar membuka detail yang memuat datanya sendiri | `DetailViewModel`, `LayarDetail` |
| 3 | Tiga tab dengan `popUpTo`, `saveState`, dan `restoreState` | `nav/PindahTab.kt` |

## Dokumentasi

Tangkapan layar kelima layar:

![Daftar](./dokumentasi/daftar.jpeg)
![Detail](./dokumentasi/detail.jpeg)
![Form](./dokumentasi/form.jpeg)
![Asisten](./dokumentasi/asisten.jpeg)
![Profil](./dokumentasi/profil.jpeg)

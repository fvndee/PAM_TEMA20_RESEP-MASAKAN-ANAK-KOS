# P4 State dan MVVM

Tema 20: Resep Masakan Anak Kos

## Anggota Kelompok 6

| Nama | NIM | Bagian |
| :- | :- | :- |
| Hanung Akbar Pramusintho | 124140207 | |
| Rajendra Rifandy | 124140099 | |
| Firman Luthfiansyah | 124140044 | |

## Form resep baru

Layar kedua setelah daftar resep P3. Isi form disimpan di ViewModel, sehingga tidak hilang saat layar diputar. Resep yang disimpan langsung muncul di paling atas daftar.

| Lapisan | Berkas | Tugasnya |
| :- | :- | :- |
| View | `ui/FormResepScreen.kt` | Menampilkan `uiState` dan meneruskan ketikan ke ViewModel |
| View | `ui/KolomTeks.kt` | Kolom isian tanpa state, dipakai untuk semua kolom form |
| ViewModel | `ui/FormResepViewModel.kt` | `MutableStateFlow` private, `StateFlow` publik, validasi sebelum simpan |
| ViewModel | `ui/FormResepUiState.kt` | Satu data class untuk seluruh layar, `bisaSimpan` dihitung dengan `get()` |
| Model | `data/PenyimpananResep.kt` | Daftar resep dalam `MutableStateFlow`, dibaca form dan daftar |
| Model | `data/ResepContoh.kt` | 12 resep contoh dan 3 kategori dari P3 |

Aturan yang dijaga ViewModel:

| Kolom | Aturan |
| :- | :- |
| Nama | Minimal 3 huruf, maksimal 40 karakter |
| Bahan | Dipisah koma, minimal satu bahan |
| Langkah | Satu langkah per baris, minimal satu langkah |
| Menit, porsi, biaya | Hanya angka dan lebih dari nol |
| Deskripsi, alat masak | Tidak boleh kosong |

## Checkpoint minggu 4

| No | Yang diselesaikan | Letak |
| :- | :- | :- |
| 1 | Layar form resep memakai `KolomTeks` tanpa state | `FormResepScreen`, `KolomTeks` |
| 2 | UiState dan ViewModel dengan StateFlow, simpan hanya bila valid | `FormResepUiState`, `FormResepViewModel` |
| 3 | Resep baru masuk tempat penyimpanan dan tampil di daftar | `PenyimpananResep`, `LayarUtama` |

Perpindahan daftar dan form masih memakai `if` di `App.kt`. Navigasi sungguhan dibuat di P5.

## Dokumentasi

Tangkapan layar form dan daftar setelah resep ditambah:

![Form resep](./dokumentasi/form.jpeg)
![Daftar setelah ditambah](./dokumentasi/daftar.jpeg)

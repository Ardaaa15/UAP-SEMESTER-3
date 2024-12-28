APLIKASI PENGELOLAHAN DATA PENGUNJUNG:

Aplikasi ini merupakan antarmuka grafis berbasis Java Swing yang digunakan untuk mengelola data pengunjung, meliputi penambahan, pengubahan, penghapusan, pencarian, dan penampilan data. Aplikasi ini bekerja bersama dengan PengunjungController sebagai backend untuk memproses data.

Fitur Utama
1. Menampilkan Data Pengunjung.

- Menampilkan semua data pengunjung yang telah tersimpan di tabel (JTable).

2. Menambah Data Pengunjung

- Memasukkan data pengunjung baru melalui formulir.
3. Memperbarui Data Pengunjung

- Memperbarui informasi pengunjung yang sudah ada.
4. Menghapus Data Pengunjung

- Menghapus data pengunjung berdasarkan pemilihan di tabel.
5. Mencari Data Pengunjung

- Mencari data pengunjung berdasarkan nomor kunjungan.
6. Validasi Input

- Validasi nomor kunjungan (hanya angka).

- Validasi nama pengunjung (hanya huruf dan spasi).


STRUKTUR PROGRAM:

Komponen Utama:

- clear()

Membersihkan semua input di formulir dan menyegarkan tabel data pengunjung.

- read()

Mengambil dan menampilkan semua data pengunjung dari controller ke tabel.

- validation()

Memastikan semua input yang diperlukan telah diisi sebelum data disimpan.

- save()

Menyimpan data pengunjung baru atau memperbarui data yang ada.

- loadData()

Memuat data pengunjung yang dipilih dari tabel untuk diedit.

- delete()

Menghapus data pengunjung yang dipilih dari tabel.

- search()

Mencari data pengunjung berdasarkan nomor kunjungan.

- getSelectedKendaraan()

Mengambil jenis kendaraan yang dipilih (Motor, Mobil, atau Lainnya).

- isValidName(String name)

Validasi apakah nama hanya mengandung huruf dan spasi.

- setKendaraanSelection(String kendaraan)

Menandai tombol radio yang sesuai dengan jenis kendaraan dari data pengunjung.

Alur Kerja Program:

1. Menampilkan Data

- Ketika aplikasi dibuka, data pengunjung langsung ditampilkan di tabel menggunakan metode read().

2. Menambah atau Memperbarui Data

- Pengguna memasukkan data ke formulir, kemudian klik tombol Simpan.

- Jika nomor kunjungan baru, data akan disimpan.

- Jika nomor kunjungan sudah ada, data akan diperbarui.

3. Menghapus Data

- Pengguna memilih baris di tabel, lalu klik tombol Hapus.

- Data yang dipilih akan dihapus setelah konfirmasi.

4. Mencari Data

- Pengguna memasukkan nomor kunjungan di kolom pencarian, kemudian klik tombol Cari.
- Data yang sesuai akan ditampilkan di tabel.

5. Validasi Input

- Nomor kunjungan harus berupa angka.

- Nama pengunjung hanya boleh mengandung huruf dan spasi.

- Semua input wajib diisi.

Antarmuka Program:

Antarmuka terdiri dari:

1. Formulir Input

- Nomor Kunjungan (TextField)

- Nama Pengunjung (TextField)

- Jenis Kendaraan (RadioButton: Motor, Mobil, Lainnya)

- Tujuan (ComboBox)

2. Tabel Data

- Menampilkan daftar pengunjung dengan kolom:

- Nomor Kunjungan

- Nama Pengunjung

- Jenis Kendaraan

- Tujuan

3. Tombol Aksi

- Simpan: Menyimpan data baru atau memperbarui data.

- Hapus: Menghapus data yang dipilih di tabel.

- Cari: Mencari data berdasarkan nomor kunjungan.

- Bersihkan: Menghapus semua input di formulir.

Teknologi yang Digunakan

- Java Swing

Untuk antarmuka grafis.

- JTable

Untuk menampilkan data pengunjung.

- JOptionPane

Untuk menampilkan dialog pesan atau konfirmasi.

- PengunjungController

Backend untuk memproses data CRUD.

CATATAN:

- Data disimpan sementara menggunakan memori (ArrayList). Data akan hilang jika aplikasi ditutup.

- Fitur validasi memastikan data yang dimasukkan sesuai aturan.

KONTRIBUTOR:
- NABILLAH RHAMADHAN S (2023-452)
- ARDINI WIDIANINGRUM (2023-453)

LISENSI:
Proyek ini dilisensikan di bawah Naungan Prodi Informatika Universitas Muhammadiyah Malang
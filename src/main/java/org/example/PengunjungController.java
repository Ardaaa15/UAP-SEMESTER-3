package org.example;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PengunjungController {
    private final String[] header = {"No.Kunjungan", "Nama Pengunjung", "Jenis Kendaraan", "Tujuan"};
    private final ArrayList<Pengunjung> list = new ArrayList<>();

    // Method untuk membaca dan menampilkan data pengunjung ke dalam JTable
    public void read(JTable jt) {
        try {
            if (jt == null) {
                throw new IllegalArgumentException("Tabel tidak boleh null");
            }
            DefaultTableModel pnj = new DefaultTableModel(null, header);
            for (Pengunjung pengunjung : list) {
                Object[] ob = new Object[4];
                ob[0] = pengunjung.getNomer();
                ob[1] = pengunjung.getNama();
                ob[2] = pengunjung.getKendaraan();
                ob[3] = pengunjung.getTujuan();
                pnj.addRow(ob);
            }
            jt.setModel(pnj);
        } catch (IllegalArgumentException e) {
            showMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            showMessage("Error: Terjadi kesalahan saat membaca data");
        }
    }


    // Method untuk menambah data pengunjung
    public void create(Pengunjung p) {
        try {
            if (p == null) {
                throw new IllegalArgumentException("Data pengunjung tidak boleh null");
            }
            list.add(p); // Menambahkan data ke ArrayList
            showMessage("Data Sudah Disimpan");
        } catch (IllegalArgumentException e) {
            showMessage("Error: " + e.getMessage());
        }
    }


    // Method untuk memperbarui data pengunjung
    public void update(Pengunjung p) {
        try {
            if (p == null) {
                throw new IllegalArgumentException("Data pengunjung tidak boleh null");
            }
            Pengunjung existing = findPengunjungByNomer(p.getNomer());
            if (existing != null) {
                list.set(list.indexOf(existing), p); // Memperbarui data di ArrayList
                showMessage("Data Berhasil Diubah");
            } else {
                throw new Exception("Data Tidak Ditemukan");
            }
        } catch (Exception e) {
            showMessage("Error: " + e.getMessage());
        }
    }


    // Method untuk menghapus data pengunjung
    public void delete(int Nomer) {
        try {
            Pengunjung pengunjung = findPengunjungByNomer(Nomer);
            if (pengunjung != null) {
                list.remove(pengunjung); // Menghapus data dari ArrayList
                showMessage("Data Berhasil Dihapus");
            } else {
                throw new Exception("Data Tidak Ditemukan");
            }
        } catch (Exception e) {
            showMessage("Error: " + e.getMessage());
        }
    }


    // Method untuk mencari pengunjung berdasarkan nomor
    public void search(JTable jt, int Nomer) {
        try {
            if (jt == null) {
                throw new IllegalArgumentException("Tabel tidak boleh null");
            }
            DefaultTableModel pnj = new DefaultTableModel(null, header);
            Pengunjung pengunjung = findPengunjungByNomer(Nomer);
            if (pengunjung != null) {
                Object[] ob = new Object[4];
                ob[0] = pengunjung.getNomer();
                ob[1] = pengunjung.getNama();
                ob[2] = pengunjung.getKendaraan();
                ob[3] = pengunjung.getTujuan();
                pnj.addRow(ob);
            } else {
                throw new Exception("Data Tidak Ditemukan");
            }
            jt.setModel(pnj);
        } catch (Exception e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    // Method untuk mencari pengunjung berdasarkan nomor
    private Pengunjung findPengunjungByNomer(int Nomer) {
        for (Pengunjung p : list) {
            if (p.getNomer() == Nomer) {
                return p;
            }
        }
        return null;
    }

    // Method untuk menampilkan pesan
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}


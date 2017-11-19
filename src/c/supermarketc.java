/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import m.aset;
import m.pembelian;
import m.pengolahan;
import m.player;
import v.insupermarket;
import v.mainmenu;
import v.pasarmap;

/**
 *
 * @author Farisya
 */
public class supermarketc {

    String username;
    insupermarket supermarket;
    pengolahan molah;
    pembelian mbelibahan;
    boolean statusGula = false;
    boolean statusTepungT = false;
    boolean statusMayo = false;
    boolean statusSirup = false;
    boolean statusMentega = false;
    boolean statusSusu = false;
    boolean statusMinyak = false;
    boolean statusPengembang = false;
    boolean statusTelur = false;
    boolean statusTepungB = false;
    int uang;
    int gula, minyak, telur, tepungterigu, mayo, sirup, mentega, susu, pengembang, tepungberas;
    int jml;
    AudioInputStream audio;
    Clip clip;
    aset maset;
    player mplayer;
    ActionListener g, mi, ma, me, si, su, t, tt, tb, p;
    boolean sg1, sg2, sg3, ss1, ss2, ss3, sm1, sm2, sm3;

    public supermarketc(String username) throws SQLException {
        this.username = username;
        supermarket = new insupermarket();
        maset = new aset();
        mplayer = new player();
        mbelibahan = new pembelian();
        molah = new pengolahan();
        supermarket.setVisible(true);
        supermarket.back(new acttombolkembali());
        supermarket.tombolBatal(new actionBatal());
        supermarket.tombolBeli(new actionBeli());
        supermarket.tombolMin(new acttombolMin());
        supermarket.tombolTambah(new acttombolTambah());
        acttombolBahan();
        klikBahan();
        getJmlBahan();
        setJmlBahan();
    }

    public void setJmlBahan() {
        supermarket.setJmlBahan(gula, minyak, mayo, mentega, sirup, telur, tepungterigu, tepungberas, pengembang, susu);
    }

    public void klikBahan() {
        supermarket.klikBahan(g, mi, ma, me, si, su, t, tt, tb, p);
        System.out.println("klik berhasil far");
    }

    public void acttombolBahan() {
        g = new acttombolGula();
        mi = new acttombolMinyak();
        ma = new acttombolMayonais();
        me = new acttombolMentega();
        si = new acttombolSirup();
        su = new acttombolSusu();
        t = new acttombolTelur();
        tt = new acttombolTepungTerigu();
        tb = new acttombolTepungBeras();
        p = new acttombolPengembang();
        System.out.println("woy");
    }

    public void getStatusPenghargaan() throws SQLException {
        sm1 = maset.cekAchv(username, "simanis", 0);
        sm2 = maset.cekAchv(username, "simanis", 1);
        sm3 = maset.cekAchv(username, "simanis", 2);
        ss3 = maset.cekAchv(username, "sisehat", 2);
        ss2 = maset.cekAchv(username, "sisehat", 1);
        ss1 = maset.cekAchv(username, "sisehat", 0);
        sg1 = maset.cekAchv(username, "sigembul", 0);
        sg2 = maset.cekAchv(username, "sigembul", 1);
        sg3 = maset.cekAchv(username, "sigembul", 2);
    }

    public void getJmlBahan() throws SQLException {
        uang = supermarket.setUang(maset.getUang(username));
        gula = maset.getJmlBahan(username, 1);
        tepungberas = maset.getJmlBahan(username, 2);
        tepungterigu = maset.getJmlBahan(username, 10);
        pengembang = maset.getJmlBahan(username, 9);
        susu = maset.getJmlBahan(username, 8);
        telur = maset.getJmlBahan(username, 7);
        mentega = maset.getJmlBahan(username, 4);
        mayo = maset.getJmlBahan(username, 6);
        sirup = maset.getJmlBahan(username, 5);
        minyak = maset.getJmlBahan(username, 3);
        jml = supermarket.getTeksJumlah();
    }

    private class acttombolkembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                pasarmap v = new pasarmap();
                pasarc c = new pasarc(username);
                supermarket.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolTepungTerigu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusTepungT = true; //untuk pengecekan di tombol belinya nanti
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/tepung2.png")));
            supermarket.setTeksJumlah("1");
            supermarket.min.setVisible(false);
        }

    }

    private class acttombolTepungBeras implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusTepungB = true; //untuk pengecekan di tombol belinya nanti
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/tepung.png")));
            supermarket.setTeksJumlah("1");
            supermarket.min.setVisible(false);
        }

    }

    private class acttombolGula implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusGula = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/gula.png")));
            supermarket.setTeksJumlah("1");
            supermarket.min.setVisible(false);
        }

    }

    private class acttombolSusu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusSusu = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/susu.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolTelur implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusTelur = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/telur.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolMinyak implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusMinyak = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/minyak.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolMentega implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusMentega = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/mentega.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolMayonais implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusMayo = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/mayones.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolPengembang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusPengembang = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/vanili.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }

    }

    private class acttombolSirup implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusSirup = true;
            supermarket.popup().setVisible(true);
            supermarket.disable();
            supermarket.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/sirup.png")));
            supermarket.min.setVisible(false);
            supermarket.setTeksJumlah("1");
        }
    }

    private void tepungBerasAction() throws SQLException {
        int id = 2;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 4000;
        int get = Integer.valueOf(supermarket.getjmltepungb());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                tepungberas = tepungberas + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(tepungberas, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);

            } else {
                statusTepungB = false;
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void pengembangAction() throws SQLException {
        getStatusPenghargaan();
        int id = 9;
        jml = supermarket.getTeksJumlah();
        int tot = jml * 4000;
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                pengembang = pengembang + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(pengembang, id, mplayer.getIdPlayer(username));
                mbelibahan.beliBahan(id, mplayer.getIdPlayer(username), jml); //gausa dimasukin sequence
                supermarket.tampilPesan2("Transaksi Berhasil");
                int bahan = mbelibahan.getBahan(username, id); //gausa masuk sequence
                if (sg1) {
                    System.out.println("masuk ga");
                    if (bahan >= 10) {
                        //                 maset.insertPenghargaan(mplayer.getIdPlayer(username), "sigembul");
                        maset.updatePenghargaan(mplayer.getIdPlayer(username), "sigembul", 1);
                        supermarket.tampilPesan2("SI GEMBUL rank 3!!\nAnda berhasil mendapatkan penghargaan ini!");
                        getStatusPenghargaan();
                    }
                }
                if (sg2) {
                    System.out.println("masuk gakkkkkkk hf");
                    if (bahan >= 25) {
                        System.out.println("yhaaaaaaaaa");
                        //                  maset.insertPenghargaan(mplayer.getIdPlayer(username), "sigembul2");
                        maset.updatePenghargaan(mplayer.getIdPlayer(username), "sigembul", 2);
                        supermarket.tampilPesan2("SI GEMBUL rank 2!!\nAnda berhasil mendapatkan penghargaan ini!");
                        getStatusPenghargaan();
                    }
                }
                if (sg3) {
                    System.out.println("masuk gakkkkkkk yo");
                    if (bahan >= 50) {
                        System.out.println("yhaaaaaaaaa");
                        //                  maset.insertPenghargaan(mplayer.getIdPlayer(username), "sigembul2");
                        maset.updatePenghargaan(mplayer.getIdPlayer(username), "sigembul", 3);
                        supermarket.tampilPesan2("SI GEMBUL rank 1!!\nAnda berhasil mendapatkan penghargaan ini!");
                    }
                }
                supermarket.popup().dispose();
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void telurAction() throws SQLException {
        int id = 7;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 1250;
        int get = Integer.valueOf(supermarket.getjmltelur());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                telur = telur + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(telur, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void mentegaAction() throws SQLException {
        int id = 4;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 3000;
        int get = Integer.valueOf(supermarket.getjmlmentega());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                mentega = mentega + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(mentega, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void sirupAction() throws SQLException {
        int id = 5;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 20000;
        int get = Integer.valueOf(supermarket.getjmlsirup());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                sirup = sirup + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(sirup, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void susuAction() throws SQLException {
        int id = 8;
        jml = supermarket.getTeksJumlah();
        int idbeli = mbelibahan.cekIdBeliBahan();
        int tot = jml * 1200;
        int get = Integer.valueOf(supermarket.getjmlsusu());
        if (uang > (tot)) {
            uang = uang - tot;
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                susu = susu + jml;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(susu, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                if (susu >= 500) {
//                    maset.insertPenghargaan(mplayer.getIdPlayer(username), "sisehat");
                    supermarket.tampilPesan2("SI SEHAT!!\nAnda berhasil mendapatkan penghargaan ini!");
                }
                supermarket.popup().dispose();
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void gulaAction() throws SQLException {
        int id = 1;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 120;
        int get = Integer.valueOf(supermarket.getjmlgula());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                gula = gula + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(gula, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                if (gula >= 1000) {
//                    maset.insertPenghargaan(mplayer.getIdPlayer(username), "simanis");
                    supermarket.tampilPesan2("SI MANIS!!\nAnda berhasil mendapatkan penghargaan ini!");
                }
                supermarket.popup().dispose();
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void mayoAction() throws SQLException {
        int id = 6;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 6000;
        int get = Integer.valueOf(supermarket.getjmlmayo());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                mayo = mayo + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(mayo, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void minyakAction() throws SQLException {
        int id = 3;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 11000;
        int get = Integer.valueOf(supermarket.getjmlminyak());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                minyak = minyak + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(minyak, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");
        }
    }

    private void tepungTeriguAction() throws SQLException {
        int id = 10;
        int idbeli = mbelibahan.cekIdBeliBahan();
        jml = supermarket.getTeksJumlah();
        int tot = jml * 90;
        int get = Integer.valueOf(supermarket.getjmltepungt());
        if (uang > (tot)) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                    + "\nAnda jadi membeli?", "Konfirmasi Pembelian", JOptionPane.YES_NO_OPTION);
            if (Pilih == 0) {
                tepungterigu = tepungterigu + jml;
                uang = uang - tot;
                maset.updateUang(uang, mplayer.getIdPlayer(username));
                mbelibahan.tambahPembelianBahan(tepungterigu, id, mplayer.getIdPlayer(username));
                supermarket.tampilPesan2("Transaksi Berhasil");
                supermarket.popup().setVisible(false);
            } else {
                jml = 1;
                supermarket.setTeksJumlah(jml + "");
                supermarket.popup().setVisible(true);
            }
        } else {
            supermarket.tampilPesan("Uang anda tidak cukup!");

        }
    }

    private class acttombolMin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jml <= 2) {
                supermarket.min.setVisible(false);
            }
            int jmlbaru = supermarket.getTeksJumlah();
            jml = jmlbaru - 1;
            supermarket.setTeksJumlah(jml + "");
        }
    }

    private class acttombolTambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            supermarket.min.setVisible(true);
            int jmlbaru = supermarket.getTeksJumlah();
            jml = jmlbaru + 1;
            supermarket.setTeksJumlah(jml + "");
        }
    }

    private class actionBeli implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            } catch (Exception ex) {
                Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (statusTepungT) {
                try {
                    tepungTeriguAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusGula) {
                try {
                    gulaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusMinyak) {
                try {
                    minyakAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusSirup) {
                try {
                    sirupAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusMayo) {
                try {
                    mayoAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusSusu) {
                try {
                    susuAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusMentega) {
                try {
                    mentegaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusPengembang) {
                try {
                    pengembangAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusTelur) {
                try {
                    telurAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusTepungB) {
                try {
                    tepungBerasAction();
                } catch (SQLException ex) {
                    Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            supermarket.setUang(uang);
            setJmlBahan();
            supermarket.enable();
            supermarket.setVisible(true);
            statusGula = false;
            statusMayo = false;
            statusMentega = false;
            statusMinyak = false;
            statusSirup = false;
            statusSusu = false;
            statusTelur = false;
            statusTepungT = false;
            statusTepungB = false;
            statusPengembang = false;
            jml = 1;
            //   popupbeli.setTeksJumlah(jml + "");
        }

    }

    private class actionBatal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            statusGula = false;
            statusMayo = false;
            statusMentega = false;
            statusMinyak = false;
            statusSirup = false;
            statusSusu = false;
            statusTelur = false;
            statusTepungT = false;
            statusTepungB = false;
            statusPengembang = false;
            jml = 1;
            supermarket.setTeksJumlah(jml + "");
            supermarket.popup().dispose();
            supermarket.setVisible(true);
            supermarket.enable();
        }

    }
}
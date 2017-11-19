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
import m.pengolahan;
import m.penjualan;
import m.player;
import v.buahagiashop;
import v.pasarmap;

/**
 *
 * @author Farisya
 */
public class penjualanc {

    AudioInputStream audio;
    Clip clip;
    String username;
    pengolahan molah;
    aset maset;
    penjualan mjual;
    buahagiashop vshop;
    player mplayer;
    int brownisterjual,kripikterjual,saleterjual;
    int uang, jml, kualitas = 1;
    int jusmelon, jusmangga, jusapel, juspisang, jussemangka, kripikapel, kripikpisang, kripikmangga;
    int brownismelon, brownisapel, brownismangga, brownispisang, brownissemangka, esbuah, saladbuah, sale;
    boolean statusBA = false, statusBMa = false, statusBMe = false, statusBS = false, statusBP = false;
    boolean statusJA = false, statusJMa = false, statusJMe = false, statusJP = false, statusJS = false;
    boolean statusKA = false, statusKP = false, statusKM = false;
    boolean statusEs = false, statusSale = false, statusSalad = false;
    boolean detail1 = false, detail2 = false;

    public penjualanc(String username) throws SQLException {
        this.username = username;
        this.vshop = new buahagiashop();
        this.mjual = new penjualan();
        this.maset = new aset();
        this.molah = new pengolahan();
        this.mplayer = new player();
        vshop.setVisible(true);
        uang = vshop.setJmlUang(maset.getUang(username));
        setStok();
        cekStok();
        vshop.klikBrownisMelon(new acttombolBrownisMelon());
        vshop.klikBrownisSemangka(new acttombolBrownisSemangka());
        vshop.klikBrownisApel(new acttombolBrownisApel());
        vshop.klikBrownisMangga(new acttombolBrownisMangga());
        vshop.klikBrownisPisang(new acttombolBrownisPisang());
        vshop.klikJusApel(new acttombolJusApel());
        vshop.klikJusMelon(new acttombolJusMelon());
        vshop.klikJusMangga(new acttombolJusMangga());
        vshop.klikJusSemangka(new acttombolJusSemangka());
        vshop.klikJusPisang(new acttombolJusPisang());
        vshop.klikKripikApel(new acttombolKripikApel());
        vshop.klikKripikPisang(new acttombolKripikPisang());
        vshop.klikKripikMangga(new acttombolKripikMangga());
        vshop.klikEsBuah(new acttombolEsBuah());
        vshop.klikSaladBuah(new acttombolSalad());
        vshop.klikSale(new acttombolSale());

        vshop.klikKembali(new acttombolkembali());
        vshop.klikKanan(new acttombolKanan());
        vshop.klikKiri(new acttombolKiri());
        vshop.klikAdd(new acttombolTambah());
        vshop.klikMin(new acttombolMin());
        vshop.klikNext(new acttombolnext());
        vshop.klikPrevious(new acttombolprevious());
        vshop.klikJual(new acttombolJual());
        vshop.klikBatal(new acttombolBatal());
        vshop.klikDetail1(new acttomboldetail1());
        vshop.klikDetail2(new acttomboldetail2());
        vshop.klikClose(new acttombolclose());
    }

    public void setStok() throws SQLException {
        brownisapel = vshop.setJmlBrownisApel(maset.getJmlProdukAll(username, 10));
        brownismangga = vshop.setJmlBrownisMangga(maset.getJmlProdukAll(username, 13));
        brownismelon = vshop.setJmlBrownisMelon(maset.getJmlProdukAll(username, 11));
        brownispisang = vshop.setJmlBrownisPisang(maset.getJmlProdukAll(username, 9));
        brownissemangka = vshop.setJmlBrownisSemangka(maset.getJmlProdukAll(username, 12));
        jusapel = vshop.setJmlJusApel(maset.getJmlProdukAll(username, 1));
        jusmangga = vshop.setJmlJusMangga(maset.getJmlProdukAll(username, 3));
        jusmelon = vshop.setJmlJusMelon(maset.getJmlProdukAll(username, 4));
        jussemangka = vshop.setJmlJusSemangka(maset.getJmlProdukAll(username, 5));
        juspisang = vshop.setJmlJusPisang(maset.getJmlProdukAll(username, 2));
        kripikapel = vshop.setJmlKripikApel(maset.getJmlProdukAll(username, 6));
        kripikmangga = vshop.setJmlKripikMangga(maset.getJmlProdukAll(username, 7));
        kripikpisang = vshop.setJmlKripikPisang(maset.getJmlProdukAll(username, 8));
        esbuah = vshop.setJmlEs(maset.getJmlProdukAll(username, 15));
        saladbuah = vshop.setJmlSalad(maset.getJmlProdukAll(username, 16));
        sale = vshop.setJmlSale(maset.getJmlProdukAll(username, 14));
    }


    public void cekStok() {
        if (brownismelon < 1) {
            vshop.btn_bme.setEnabled(false);
        } else if (brownismelon >= 1) {
            vshop.btn_bme.setEnabled(true);
        }
        if (brownismangga < 1) {
            vshop.btn_bma.setEnabled(false);
        } else if (brownismangga >= 1) {
            vshop.btn_bma.setEnabled(true);
        }
        if (brownisapel < 1) {
            vshop.btn_ba.setEnabled(false);
        } else if (brownisapel >= 1) {
            vshop.btn_ba.setEnabled(true);
        }
        if (brownispisang < 1) {
            vshop.btn_bp.setEnabled(false);
        } else if (brownispisang >= 1) {
            vshop.btn_bp.setEnabled(true);
        }
        if (brownissemangka < 1) {
            vshop.btn_bs.setEnabled(false);
        } else if (brownissemangka >= 1) {
            vshop.btn_bs.setEnabled(true);
        }
        if (jusapel < 1) {
            vshop.btn_ja.setEnabled(false);
        } else if (jusapel >= 1) {
            vshop.btn_ja.setEnabled(true);
        }
        if (jusmangga < 1) {
            vshop.btn_jma.setEnabled(false);
        } else if (jusmangga >= 1) {
            vshop.btn_jma.setEnabled(true);
        }
        if (jusmelon < 1) {
            vshop.btn_jme.setEnabled(false);
        } else if (jusmelon >= 1) {
            vshop.btn_jme.setEnabled(true);
        }
        if (jussemangka < 1) {
            vshop.btn_js.setEnabled(false);
        } else if (jussemangka >= 1) {
            vshop.btn_js.setEnabled(true);
        }
        if (juspisang < 1) {
            vshop.btn_jp.setEnabled(false);
        } else if (juspisang >= 1) {
            vshop.btn_jp.setEnabled(true);
        }
        if (kripikapel < 1) {
            vshop.btn_ka.setEnabled(false);
        } else if (kripikapel >= 1) {
            vshop.btn_ka.setEnabled(true);
        }
        if (kripikpisang < 1) {
            vshop.btn_kp.setEnabled(false);
        } else if (kripikpisang >= 1) {
            vshop.btn_kp.setEnabled(true);
        }
        if (kripikmangga < 1) {
            vshop.btn_km.setEnabled(false);
        } else if (kripikmangga >= 1) {
            vshop.btn_km.setEnabled(true);
        }
        if (esbuah < 1) {
            vshop.btn_es.setEnabled(false);
        } else if (esbuah >= 1) {
            vshop.btn_es.setEnabled(true);
        }
        if (saladbuah < 1) {
            vshop.btn_salad.setEnabled(false);
        } else if (saladbuah >= 1) {
            vshop.btn_salad.setEnabled(true);
        }
        if (sale < 1) {
            vshop.btn_sale.setEnabled(false);
        } else if (sale >= 1) {
            vshop.btn_sale.setEnabled(true);
        }
    }

    private class acttombolkembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                pasarmap v = new pasarmap();
                pasarc c = new pasarc(username);
                vshop.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(supermarketc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolnext implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vshop.setVisible(false);
            vshop.shop2().setVisible(true);
        }
    }

    private class acttombolprevious implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vshop.shop2().setVisible(false);
            vshop.setVisible(true);
        }
    }

    private class acttomboldetail1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                detail1 = true;
                vshop.detail1().setVisible(true);
                detailpenjualan();
                vshop.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttomboldetail2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                detail2 = true;
                vshop.detail2().setVisible(true);
                detailpenjualan();
                vshop.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolclose implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (detail1) {
                vshop.detail1().setVisible(false);
                detail1 = false;
                vshop.setVisible(true);
            } else if (detail2) {
                detail2 = false;
                vshop.detail2().setVisible(false);
                vshop.shop2().setVisible(true);
            }
        }
    }

    public void detailpenjualan() throws SQLException {
        if (detail1) {
            vshop.setBrownisMe1Terjual(mjual.getProdukTerjual(11, 1, mplayer.getIdPlayer(username)));
            vshop.setBrownisMe2Terjual(mjual.getProdukTerjual(11, 2, mplayer.getIdPlayer(username)));
            vshop.setBrownisMe3Terjual(mjual.getProdukTerjual(11, 3, mplayer.getIdPlayer(username)));
            vshop.setBrownisMa1Terjual(mjual.getProdukTerjual(13, 1, mplayer.getIdPlayer(username)));
            vshop.setBrownisMa2Terjual(mjual.getProdukTerjual(13, 2, mplayer.getIdPlayer(username)));
            vshop.setBrownisMa3Terjual(mjual.getProdukTerjual(13, 3, mplayer.getIdPlayer(username)));
            vshop.setBrownisP1Terjual(mjual.getProdukTerjual(9, 1, mplayer.getIdPlayer(username)));
            vshop.setBrownisP2Terjual(mjual.getProdukTerjual(9, 2, mplayer.getIdPlayer(username)));
            vshop.setBrownisP3Terjual(mjual.getProdukTerjual(9, 3, mplayer.getIdPlayer(username)));
            vshop.setBrownisS1Terjual(mjual.getProdukTerjual(12, 1, mplayer.getIdPlayer(username)));
            vshop.setBrownisS2Terjual(mjual.getProdukTerjual(12, 2, mplayer.getIdPlayer(username)));
            vshop.setBrownisS3Terjual(mjual.getProdukTerjual(12, 3, mplayer.getIdPlayer(username)));
            vshop.setBrownisA1Terjual(mjual.getProdukTerjual(10, 1, mplayer.getIdPlayer(username)));
            vshop.setBrownisA2Terjual(mjual.getProdukTerjual(10, 2, mplayer.getIdPlayer(username)));
            vshop.setBrownisA3Terjual(mjual.getProdukTerjual(10, 3, mplayer.getIdPlayer(username)));
            vshop.setEsBuah1Terjual(mjual.getProdukTerjual(15, 1, mplayer.getIdPlayer(username)));
            vshop.setEsBuah2Terjual(mjual.getProdukTerjual(15, 2, mplayer.getIdPlayer(username)));
            vshop.setEsBuah3Terjual(mjual.getProdukTerjual(15, 3, mplayer.getIdPlayer(username)));
            vshop.setSalad1Terjual(mjual.getProdukTerjual(16, 1, mplayer.getIdPlayer(username)));
            vshop.setSalad2Terjual(mjual.getProdukTerjual(16, 2, mplayer.getIdPlayer(username)));
            vshop.setSalad3Terjual(mjual.getProdukTerjual(16, 3, mplayer.getIdPlayer(username)));
            vshop.setSale1Terjual(mjual.getProdukTerjual(14, 1, mplayer.getIdPlayer(username)));
            vshop.setSale2Terjual(mjual.getProdukTerjual(14, 2, mplayer.getIdPlayer(username)));
            vshop.setSale3Terjual(mjual.getProdukTerjual(14, 3, mplayer.getIdPlayer(username)));
            vshop.setTotBrownisMe1();
            vshop.setTotBrownisMe2();
            vshop.setTotBrownisMe3();
            vshop.setTotBrownisA1();
            vshop.setTotBrownisA2();
            vshop.setTotBrownisA3();
            vshop.setTotBrownisMa1();
            vshop.setTotBrownisMa2();
            vshop.setTotBrownisMa3();
            vshop.setTotBrownisS1();
            vshop.setTotBrownisS2();
            vshop.setTotBrownisS3();
            vshop.setTotBrownisP1();
            vshop.setTotBrownisP2();
            vshop.setTotBrownisP3();
            vshop.setTotEs1();
            vshop.setTotEs2();
            vshop.setTotEs3();
            vshop.setTotSale1();
            vshop.setTotSale2();
            vshop.setTotSale3();
            vshop.setTotSalad1();
            vshop.setTotSalad2();
            vshop.setTotSalad3();
        } else if (detail2) {
            vshop.setJusMe1Terjual(mjual.getProdukTerjual(4, 1, mplayer.getIdPlayer(username)));
            vshop.setJusMe2Terjual(mjual.getProdukTerjual(4, 2, mplayer.getIdPlayer(username)));
            vshop.setJusMe3Terjual(mjual.getProdukTerjual(4, 3, mplayer.getIdPlayer(username)));
            vshop.setJusMa1Terjual(mjual.getProdukTerjual(3, 1, mplayer.getIdPlayer(username)));
            vshop.setJusMa2Terjual(mjual.getProdukTerjual(3, 2, mplayer.getIdPlayer(username)));
            vshop.setJusMa3Terjual(mjual.getProdukTerjual(3, 3, mplayer.getIdPlayer(username)));
            vshop.setJusP1Terjual(mjual.getProdukTerjual(2, 1, mplayer.getIdPlayer(username)));
            vshop.setJusP2Terjual(mjual.getProdukTerjual(2, 2, mplayer.getIdPlayer(username)));
            vshop.setJusP3Terjual(mjual.getProdukTerjual(2, 3, mplayer.getIdPlayer(username)));
            vshop.setJusS1Terjual(mjual.getProdukTerjual(5, 1, mplayer.getIdPlayer(username)));
            vshop.setJusS2Terjual(mjual.getProdukTerjual(5, 2, mplayer.getIdPlayer(username)));
            vshop.setJusS3Terjual(mjual.getProdukTerjual(5, 3, mplayer.getIdPlayer(username)));
            vshop.setJusA1Terjual(mjual.getProdukTerjual(1, 1, mplayer.getIdPlayer(username)));
            vshop.setJusA2Terjual(mjual.getProdukTerjual(1, 2, mplayer.getIdPlayer(username)));
            vshop.setJusA3Terjual(mjual.getProdukTerjual(1, 3, mplayer.getIdPlayer(username)));
            vshop.setKripikA1Terjual(mjual.getProdukTerjual(6, 1, mplayer.getIdPlayer(username)));
            vshop.setKripikA2Terjual(mjual.getProdukTerjual(6, 2, mplayer.getIdPlayer(username)));
            vshop.setKripikA3Terjual(mjual.getProdukTerjual(6, 3, mplayer.getIdPlayer(username)));
            vshop.setKripikP1Terjual(mjual.getProdukTerjual(8, 1, mplayer.getIdPlayer(username)));
            vshop.setKripikP2Terjual(mjual.getProdukTerjual(8, 2, mplayer.getIdPlayer(username)));
            vshop.setKripikP3Terjual(mjual.getProdukTerjual(8, 3, mplayer.getIdPlayer(username)));
            vshop.setKripikM1Terjual(mjual.getProdukTerjual(7, 1, mplayer.getIdPlayer(username)));
            vshop.setKripikM2Terjual(mjual.getProdukTerjual(7, 2, mplayer.getIdPlayer(username)));
            vshop.setKripikM3Terjual(mjual.getProdukTerjual(7, 3, mplayer.getIdPlayer(username)));
            vshop.setTotJusA1();
            vshop.setTotJusA2();
            vshop.setTotJusA3();
            vshop.setTotJusP1();
            vshop.setTotJusP2();
            vshop.setTotJusP3();
            vshop.setTotJusS1();
            vshop.setTotJusS2();
            vshop.setTotJusS3();
            vshop.setTotJusMa1();
            vshop.setTotJusMa2();
            vshop.setTotJusMa3();
            vshop.setTotJusMe1();
            vshop.setTotJusMe2();
            vshop.setTotJusMe3();
            vshop.setTotKripikA1();
            vshop.setTotKripikA2();
            vshop.setTotKripikA3();
            vshop.setTotKripikM1();
            vshop.setTotKripikM2();
            vshop.setTotKripikM3();
            vshop.setTotKripikP1();
            vshop.setTotKripikP2();
            vshop.setTotKripikP3();
        }
    }

    private class acttombolBrownisMelon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusBMe = true;
                vshop.setStok(maset.getJmlProduk(username, 11, 1));
                vshop.setJumlah("1");
                vshop.setHarga("18000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/brownismelon.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolBrownisMangga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusBMa = true;
                vshop.setStok(maset.getJmlProduk(username, 13, 1));
                vshop.setJumlah("1");
                vshop.setHarga("20000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/brownismangga.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolBrownisApel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusBA = true;
                vshop.setStok(maset.getJmlProduk(username, 10, 1));
                vshop.setJumlah("1");
                vshop.setHarga("30000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/brownisapel.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolBrownisSemangka implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusBS = true;
                vshop.setStok(maset.getJmlProduk(username, 12, 1));
                vshop.setJumlah("1");
                vshop.setHarga("17000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/brownissemangka.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolBrownisPisang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusBP = true;
                vshop.setStok(maset.getJmlProduk(username, 9, 1));
                vshop.setJumlah("1");
                vshop.setHarga("22000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/brownispisang.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolJusPisang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusJP = true;
                vshop.setStok(maset.getJmlProduk(username, 2, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/juspisang.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolJusMangga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusJMa = true;
                vshop.setStok(maset.getJmlProduk(username, 3, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/jusmangga.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolJusMelon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusJMe = true;
                vshop.setStok(maset.getJmlProduk(username, 4, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/jusmelon.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolJusApel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusJA = true;
                vshop.setStok(maset.getJmlProduk(username, 1, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/jusapel.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolJusSemangka implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusJS = true;
                vshop.setStok(maset.getJmlProduk(username, 5, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/jussemangka.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolKripikPisang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusKP = true;
                vshop.setStok(maset.getJmlProduk(username, 8, 1));
                vshop.setJumlah("1");
                vshop.setHarga("32000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/kripikpisang.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolKripikApel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusKA = true;
                vshop.setStok(maset.getJmlProduk(username, 6, 1));
                vshop.setJumlah("1");
                vshop.setHarga("35000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/kripikapel.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolKripikMangga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusKM = true;
                vshop.setStok(maset.getJmlProduk(username, 7, 1));
                vshop.setJumlah("1");
                vshop.setHarga("30000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/kripikmangga.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolEsBuah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusEs = true;
                vshop.setStok(maset.getJmlProduk(username, 15, 1));
                vshop.setJumlah("1");
                vshop.setHarga("6000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/esbuah.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolSale implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusSale = true;
                vshop.setStok(maset.getJmlProduk(username, 14, 1));
                vshop.setJumlah("1");
                vshop.setHarga("45000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/sale.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolSalad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                statusSalad = true;
                vshop.setStok(maset.getJmlProduk(username, 16, 1));
                vshop.setJumlah("1");
                vshop.setHarga("10000");
                vshop.setKualitas("Baik");
                vshop.popup().setVisible(true);
                vshop.disable();
                vshop.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/salad.png")));
                vshop.min.setVisible(false);
                vshop.left.setVisible(false);
                vshop.right.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void brownisMelonAction() throws SQLException {
        int id = 11;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(supermarketc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    brownismelon = brownismelon - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlBrownisMelon(brownismelon);
                    vshop.popup().dispose();
                    vshop.setVisible(true);
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusBMe = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void brownisApelAction() throws SQLException {
        int id = 10;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    brownisapel = brownisapel - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlBrownisApel(brownisapel);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusBA = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void brownisSemangkaAction() throws SQLException {
        int id = 12;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    brownissemangka = brownissemangka - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlBrownisSemangka(brownissemangka);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusBS = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void brownisManggaAction() throws SQLException {
        int id = 13;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    brownismangga = brownismangga - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlBrownisMangga(brownismangga);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusBMa = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void brownisPisangAction() throws SQLException {
        int id = 9;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    brownispisang = brownispisang - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlBrownisPisang(brownispisang);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusBP = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void jusPisangAction() throws SQLException {
        int id = 2;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    juspisang = juspisang - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlJusPisang(juspisang);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusJP = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void jusApelAction() throws SQLException {
        int id = 1;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    jusapel = jusapel - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlJusApel(jusapel);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusJA = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void jusMelonAction() throws SQLException {
        int id = 4;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    jusmelon = jusmelon - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlJusMelon(jusmelon);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusJMe = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void jusManggaAction() throws SQLException {
        int id = 7;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    jusmangga = jusmangga - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlJusMangga(jusmangga);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusJMa = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void jusSemangkaAction() throws SQLException {
        int id = 5;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    jussemangka = jussemangka - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlJusSemangka(jussemangka);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusJS = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void kripikApelAction() throws SQLException {
        int id = 6;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    kripikapel = kripikapel - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlKripikApel(kripikapel);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusKA = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void kripikManggaAction() throws SQLException {
        int id = 7;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    kripikmangga = kripikmangga - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlKripikMangga(kripikmangga);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusKM = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void kripikPisangAction() throws SQLException {
        int id = 8;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    kripikpisang = kripikpisang - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlKripikPisang(kripikpisang);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusKP = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void esBuahAction() throws SQLException {
        int id = 15;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    esbuah = esbuah - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlEs(esbuah);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusEs = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void saleAction() throws SQLException {
        int id = 14;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    sale = sale - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlSale(sale);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusSale = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);
        }
    }

    private void saladAction() throws SQLException {
        int id = 16;
        int harga = vshop.getTeksHarga();
        int kualitas = mjual.getIdKualitas(vshop.getKualitas());
        int stok = maset.getJmlProduk(username, id, kualitas);
        jml = vshop.getTeksJumlah();
        int tot = jml * harga;
        if (stok >= 1) {
            if (stok >= jml) {
                int Pilih = JOptionPane.showConfirmDialog(null, "Total: " + tot
                        + "\nAnda jadi menjual?", "Konfirmasi Penjualan", JOptionPane.YES_NO_OPTION);
                if (Pilih == 0) {
                    try {
                        audio = AudioSystem.getAudioInputStream(new File("src//ui export//Coin achieve.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();

                    } catch (Exception ex) {
                        Logger.getLogger(penjualanc.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    uang = uang + (harga * jml);
                    stok = stok - jml;
                    saladbuah = saladbuah - jml;
                    maset.updateUang(uang, mplayer.getIdPlayer(username));
                    mjual.updateStokProduk(id, kualitas, mplayer.getIdPlayer(username), stok);
                    mjual.insertPenjualan(id, mplayer.getIdPlayer(username), kualitas, jml);
                    vshop.tampilPesan("Transaksi Berhasil");
                    vshop.setJmlUang(maset.getUang(username));
                    vshop.setJmlSalad(saladbuah);
                    vshop.popup().dispose();
                    vshop.enable();
                    vshop.setJumlah(jml + "");
                    statusSalad = false;
                    this.kualitas = 1;
                    jml = 1;
                } else {
                    jml = 1;
                    vshop.setJumlah(jml + "");
                    vshop.popup().setVisible(true);
                }
            } else {
                jml = 1;
                vshop.setJumlah(jml + "");
                vshop.popup().setVisible(true);
                vshop.tampilPesan("Stok yang anda miliki kurang!");
            }
        } else {
            jml = 1;
            vshop.setJumlah(jml + "");
            vshop.tampilPesan("Anda tidak memiliki produk dengan kualitas " + vshop.getKualitas());
            vshop.popup().setVisible(true);

        }
    }

    private class acttombolMin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (jml <= 2) {
                vshop.min.setVisible(false);
            }
            int jmlbaru = vshop.getTeksJumlah();
            jml = jmlbaru - 1;
            vshop.setJumlah(jml + "");
        }
    }

    private class acttombolTambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vshop.min.setVisible(true);
            int jmlbaru = vshop.getTeksJumlah();
            jml = jmlbaru + 1;
            vshop.setJumlah(jml + "");
        }
    }

    private class acttombolKanan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vshop.left.setVisible(true);
            kualitas = kualitas + 1;
            if (kualitas == 2) {
                vshop.setKualitas("Sedang");
                if (statusBMe) {
                    try {
                        vshop.setHarga("15000");
                        vshop.setStok(maset.getJmlProduk(username, 11, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBMa) {
                    try {
                        vshop.setHarga("18000");
                        vshop.setStok(maset.getJmlProduk(username, 13, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBP) {
                    try {
                        vshop.setHarga("19000");
                        vshop.setStok(maset.getJmlProduk(username, 9, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBS) {
                    try {
                        vshop.setHarga("15000");
                        vshop.setStok(maset.getJmlProduk(username, 12, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBA) {
                    try {
                        vshop.setHarga("27000");
                        vshop.setStok(maset.getJmlProduk(username, 10, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJA) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 1, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJP) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 2, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJS) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 5, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMe) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 4, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMa) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 3, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKA) {
                    try {
                        vshop.setHarga("30000");
                        vshop.setStok(maset.getJmlProduk(username, 6, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKP) {
                    try {
                        vshop.setHarga("26000");
                        vshop.setStok(maset.getJmlProduk(username, 8, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKM) {
                    try {
                        vshop.setHarga("25000");
                        vshop.setStok(maset.getJmlProduk(username, 7, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSale) {
                    try {
                        vshop.setHarga("43000");
                        vshop.setStok(maset.getJmlProduk(username, 14, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSalad) {
                    try {
                        vshop.setHarga("9000");
                        vshop.setStok(maset.getJmlProduk(username, 16, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusEs) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 15, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (kualitas == 3) {
                vshop.right.setVisible(false);
                vshop.setKualitas("Rendah");
                if (statusBMe) {
                    try {
                        vshop.setHarga("13000");
                        vshop.setStok(maset.getJmlProduk(username, 11, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBMa) {
                    try {
                        vshop.setHarga("17000");
                        vshop.setStok(maset.getJmlProduk(username, 13, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBP) {
                    try {
                        vshop.setHarga("17000");
                        vshop.setStok(maset.getJmlProduk(username, 9, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBS) {
                    try {
                        vshop.setHarga("13000");
                        vshop.setStok(maset.getJmlProduk(username, 12, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBA) {
                    try {
                        vshop.setHarga("25000");
                        vshop.setStok(maset.getJmlProduk(username, 10, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJA) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 1, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJP) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 2, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJS) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 5, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMe) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 4, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMa) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 3, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKA) {
                    try {
                        vshop.setHarga("25000");
                        vshop.setStok(maset.getJmlProduk(username, 6, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKP) {
                    try {
                        vshop.setHarga("20000");
                        vshop.setStok(maset.getJmlProduk(username, 8, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKM) {
                    try {
                        vshop.setHarga("20000");
                        vshop.setStok(maset.getJmlProduk(username, 7, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSale) {
                    try {
                        vshop.setHarga("40000");
                        vshop.setStok(maset.getJmlProduk(username, 14, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSalad) {
                    try {
                        vshop.setHarga("8000");
                        vshop.setStok(maset.getJmlProduk(username, 16, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusEs) {
                    try {
                        vshop.setHarga("4000");
                        vshop.setStok(maset.getJmlProduk(username, 15, 3));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private class acttombolKiri implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vshop.right.setVisible(true);
            kualitas = kualitas - 1;
            if (kualitas == 1) {
                vshop.left.setVisible(false);
                vshop.setKualitas("Baik");
                if (statusBMe) {
                    try {
                        vshop.setHarga("18000");
                        vshop.setStok(maset.getJmlProduk(username, 11, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBMa) {
                    try {
                        vshop.setHarga("20000");
                        vshop.setStok(maset.getJmlProduk(username, 13, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBP) {
                    try {
                        vshop.setHarga("22000");
                        vshop.setStok(maset.getJmlProduk(username, 9, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBS) {
                    try {
                        vshop.setHarga("17000");
                        vshop.setStok(maset.getJmlProduk(username, 12, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBA) {
                    try {
                        vshop.setHarga("30000");
                        vshop.setStok(maset.getJmlProduk(username, 10, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJA) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 1, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJP) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 2, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJS) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 5, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMe) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 4, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMa) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 3, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKA) {
                    try {
                        vshop.setHarga("35000");
                        vshop.setStok(maset.getJmlProduk(username, 6, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKP) {
                    try {
                        vshop.setHarga("32000");
                        vshop.setStok(maset.getJmlProduk(username, 8, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKM) {
                    try {
                        vshop.setHarga("30000");
                        vshop.setStok(maset.getJmlProduk(username, 7, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSale) {
                    try {
                        vshop.setHarga("45000");
                        vshop.setStok(maset.getJmlProduk(username, 14, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSalad) {
                    try {
                        vshop.setHarga("10000");
                        vshop.setStok(maset.getJmlProduk(username, 16, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusEs) {
                    try {
                        vshop.setHarga("6000");
                        vshop.setStok(maset.getJmlProduk(username, 15, 1));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (kualitas == 2) {
                if (statusBMe) {
                    try {
                        vshop.setHarga("15000");
                        vshop.setStok(maset.getJmlProduk(username, 11, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBMa) {
                    try {
                        vshop.setHarga("18000");
                        vshop.setStok(maset.getJmlProduk(username, 13, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBP) {
                    try {
                        vshop.setHarga("19000");
                        vshop.setStok(maset.getJmlProduk(username, 9, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBS) {
                    try {
                        vshop.setHarga("15000");
                        vshop.setStok(maset.getJmlProduk(username, 12, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusBA) {
                    try {
                        vshop.setHarga("27000");
                        vshop.setStok(maset.getJmlProduk(username, 10, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJA) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 1, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJP) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 2, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJS) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 5, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMe) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 4, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusJMa) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 3, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKA) {
                    try {
                        vshop.setHarga("30000");
                        vshop.setStok(maset.getJmlProduk(username, 6, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKP) {
                    try {
                        vshop.setHarga("26000");
                        vshop.setStok(maset.getJmlProduk(username, 8, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusKM) {
                    try {
                        vshop.setHarga("25000");
                        vshop.setStok(maset.getJmlProduk(username, 7, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSale) {
                    try {
                        vshop.setHarga("43000");
                        vshop.setStok(maset.getJmlProduk(username, 14, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusSalad) {
                    try {
                        vshop.setHarga("9000");
                        vshop.setStok(maset.getJmlProduk(username, 16, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (statusEs) {
                    try {
                        vshop.setHarga("5000");
                        vshop.setStok(maset.getJmlProduk(username, 15, 2));
                    } catch (SQLException ex) {
                        Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private class acttombolJual implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (statusBMe) {
                try {
                    brownisMelonAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusBMa) {
                try {
                    brownisManggaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusBS) {
                try {
                    brownisSemangkaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusBP) {
                try {
                    brownisPisangAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusBA) {
                try {
                    brownisApelAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusJA) {
                try {
                    jusApelAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusJMa) {
                try {
                    jusManggaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusJMe) {
                try {
                    jusMelonAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusJS) {
                try {
                    jusSemangkaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusJP) {
                try {
                    jusPisangAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusKA) {
                try {
                    kripikApelAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusKM) {
                try {
                    kripikManggaAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusKP) {
                try {
                    kripikPisangAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusEs) {
                try {
                    esBuahAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusSalad) {
                try {
                    saladAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (statusSale) {
                try {
                    saleAction();
                } catch (SQLException ex) {
                    Logger.getLogger(penjualanc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private class acttombolBatal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vshop.enable();
            vshop.setJumlah(jml + "");
            vshop.popup().dispose();
            statusBA = false;
            statusBMa = false;
            statusBMe = false;
            statusBS = false;
            statusBP = false;
            statusJA = false;
            statusJMa = false;
            statusJMe = false;
            statusJP = false;
            statusJS = false;
            statusKA = false;
            statusKP = false;
            statusKM = false;
            statusEs = false;
            statusSale = false;
            statusSalad = false;
            kualitas = 1;
            jml = 1;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.aset;
import m.pembelian;
import m.pengolahan;
import m.player;
import v.login;
import v.mainmenu;
import v.map;

/**
 *
 * @author Farisya
 */
public class loginc {

    mapc vmap;
    player mplayer;
    aset maset;
    login vlogin;
    mainmenu vmain;
    cmenu menu;
    pembelian mbeli;
    pengolahan molah;

    public loginc() throws SQLException, InterruptedException {

        this.vlogin = new login();
        this.mplayer = new player();
        this.maset = new aset();
        this.mbeli = new pembelian();
        this.molah = new pengolahan();
        vlogin.setVisible(true);
        vlogin.klikLogin(new acttombolLogin());
        vlogin.klikKembali(new acttombolKembali());
        vlogin.klikBuatAkun(new acttombolCreate());
        vlogin.klikTambahAkun(new acttombolTambahAkun());
        vlogin.klikBatal(new acttombolBatal());
    }

    private class acttombolKembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vlogin.dispose();
//                mainmenu v = new mainmenu();
//                cmenu c = new cmenu(v);
        }
    }

    private class acttombolLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String uname = vlogin.getUsername();
                if (vlogin.getUsername().isEmpty()) {
                    vlogin.tampilPesan("Username gabole kosong");
                } else if (mplayer.getPlayer(vlogin.getUsername())) {
                    map v = new map();
                    new mapc(uname, v);
                    vlogin.dispose();
                    System.out.println(uname);

                } else {
                    vlogin.tampilPesan("Username/Password Salah");
                    vlogin.setUsername("");
                }
            } catch (SQLException ex) {
                System.out.println("ada sesuatu");
            }
        }

    }

    private class acttombolCreate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlogin.createAccount().setVisible(true);
            System.out.println("coba");
            vlogin.disable();
        }
    }

    private class acttombolTambahAkun implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idPlayer = mplayer.cekIdP();
                String uname = vlogin.getUsernameCreate();
                System.out.println("uname e " + uname);
                if (uname.equals("")) {
                    vlogin.tampilPesanCreate("username harus diisi");
                } else if (mplayer.cekUsername(uname)) {
                    vlogin.tampilPesanCreate("Username telah digunakan!");
                    vlogin.setUsernameCreate("");
                } else {
                    mplayer.insertPlayer(idPlayer, vlogin.getUsernameCreate());
                    maset.insertAset(idPlayer);
                    mbeli.insertBeliBuah(String.valueOf(idPlayer));
                    mbeli.insertBeliBahan(String.valueOf(idPlayer));
                    molah.insertHasilOlah(String.valueOf(idPlayer));
                    maset.insertPenghargaan(String.valueOf(idPlayer));
                    maset.insertResep(String.valueOf(idPlayer), "jusbuah");
                    maset.insertResep(String.valueOf(idPlayer), "brownis");
                    vlogin.tampilPesanCreate("Akun berhasil dibuat");
                    vlogin.setUsernameCreate("");
                    vlogin.createAccount().setVisible(false);
                    vlogin.setVisible(true);
                    vlogin.enable();
                    System.out.println("isine" + mplayer.cekUsername(uname));
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class acttombolBatal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vlogin.enable();
            vlogin.createAccount().dispose();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.SQLException;

/**
 *
 * @author Farisya
 */
public class penjualan extends func {

    public penjualan() throws SQLException {
    }

    public int cekIdPenjualan() throws SQLException {
        String query = "select idPenjualan from penjualan where idPenjualan = ";
        return checkId(query);
    }

    public int getIdKualitas(String kualitas) throws SQLException {
        String query = "select idKualitas from kualitas where Kualitas = '" + kualitas + "'";
        return getDataInt(query);
    }

    public int getProdukTerjual(int idProduk, int idKualitas, String idPlayer) throws SQLException {
        String query = "select sum(Jumlah) from penjualan where idProduk = '" + idProduk + "' "
                + "and idPlayer = '" + idPlayer + "' and idKualitas='" + idKualitas + "'";
        return getDataInt(query);
    }

    public boolean updateStokProduk(int idProduk, int idKualitas, String idPlayer, int jml) throws SQLException {
        String query = "UPDATE `hasilpengolahan` SET `Jumlah` = '" + jml + "' WHERE `idProduk` = '" + idProduk + "'"
                + " and idKualitas='" + idKualitas + "' and idPlayer='" + idPlayer + "'";
        System.out.println(query);
        return getStatusQuery(query);
    }

    public boolean insertPenjualan(int idProduk, String idPlayer, int idKualitas, int jml) {
        String query = "INSERT INTO `penjualan`(`idPenjualan`, `idPlayer`, `idProduk`,`idKualitas`,`Jumlah`) "
                + "VALUES(null,'" + idPlayer + "','" + idProduk + "','" + idKualitas + "','" + jml + "')";
        System.out.println(query);
        return getStatusQuery(query);
    }

    public int getBrownisTerjual(String username) throws SQLException {
        String query = "SELECT sum(Jumlah) FROM `penjualan` join player "
                + "ON player.idPlayer=penjualan.idPlayer "
                + "WHERE player.username='" + username + "' and idProduk in(9,10,11,12,13)";
        return getDataInt(query);
    }

    public int getKripikTerjual(String username) throws SQLException {
        String query = "SELECT sum(Jumlah) FROM `penjualan` join player "
                + "ON player.idPlayer=penjualan.idPlayer "
                + "WHERE player.username='" + username + "' and idProduk in(6,7,8)";
        return getDataInt(query);
    }

    public int getSaleTerjual(String username) throws SQLException {
        String query = "SELECT sum(Jumlah) FROM `penjualan` join player "
                + "ON player.idPlayer=penjualan.idPlayer "
                + "WHERE player.username='" + username + "' and idProduk=14";
        return getDataInt(query);
    }
}

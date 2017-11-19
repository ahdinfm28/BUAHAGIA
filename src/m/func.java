package m;
import java.sql.ResultSet;
import java.sql.SQLException;
//import koneksiDb.koneksiDB;

public class func extends koneksi{

    koneksi con;

    public func() throws SQLException {
        con = new koneksi();
    }

    protected int checkId(String query) throws SQLException {
        int id = 0;
        ResultSet hasil;
        do {
            id++;
            hasil = con.getResult(query + id);
        } while (hasil.next());
        return id;
    }

    public boolean getStatusQuery(String query) {
        boolean succesInput = false;
        try {
            con.executeQuery(query);
            succesInput = true;
        } catch (SQLException ex) {
            succesInput = false;
        }
        return succesInput;
    }

    public int getDataInt(String query) throws SQLException {
        ResultSet hasil = con.getResult(query);
        hasil.next();
        int data = hasil.getInt(1);
        return data;
    }
}

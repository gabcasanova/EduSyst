package sisescola_java.Objetos1;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DRIVER =  "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/edusyst";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeConnection(Connection con){
        if (con!= null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if (stmt!= null){
                stmt.close();
            }
        }catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if (rs!= null){
                rs.close();
            }
        }catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

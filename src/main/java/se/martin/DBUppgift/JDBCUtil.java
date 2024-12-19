package se.martin.DBUppgift;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class JDBCUtil {
    private static Properties properties = new Properties();

    static{
        try {
            InputStream stream =
                    JDBCUtil.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(stream);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Driver driver = new org.hsqldb.jdbcDriver();
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(url, user, password);
    }

    //Stänger en aktiv databasanslutning.
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Stänger ett aktivt Statement -objekt.
    public static void closeStatement(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Stänger ett aktivt ResultSet -objekt.
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Bekräftar och sparar ändringar i databasen.
    public static void commit(Connection conn) {
        try {
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Ångrar ändringar i databasen om något går fel.
    public static void rollback(Connection conn) {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String getDatabaseProductName(Connection conn) {
        try {
            DatabaseMetaData metadata = conn.getMetaData();
            return metadata.getDatabaseProductName();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

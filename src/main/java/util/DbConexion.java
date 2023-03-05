package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Warner Moscoso M.
 */
public class DbConexion implements DataSource {

    private static DbConexion instConexion;
    private final BasicDataSource DS;
    private Properties settings;

    private DbConexion() {
        DS = new BasicDataSource();
        readSettings();
        DS.setUrl(settings.getProperty("db.url"));
        DS.setUsername(settings.getProperty("db.username"));
        DS.setPassword(settings.getProperty("db.password"));
        /*Cantidad de conexiones inicializadas*/
        DS.setInitialSize(5);
        /*Cantidad de conexiones maximas, si es necesario crear mas conexiones
        la libreria se encargara de agregar más, mientras no supere este limt.*/
        DS.setMaxTotal(10);
        /*El maximo de conexiones inactivas en el pool, es decir; si existe
        una conexion inactiva de más esta se cerrará automaticamente*/
        DS.setMaxIdle(5);
    }

    private void readSettings() {
        InputStream input = null;
        try {
            settings=new Properties();
            input = new FileInputStream("../../resources/config/database.properties" );
            settings.load(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DbConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DbConexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(DbConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Verifica que solo exista una instancia Conexion esta parte es la
     * reponsable de aplicar el patron singlenton
     *
     * @return la unica instancia de Conexion
     */
    public static DbConexion getInstConexion() {
        if (instConexion == null) {
            instConexion = new DbConexion();
            return instConexion;
        } else {
            return DbConexion.instConexion;
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DS.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DS.getConnection(username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

}

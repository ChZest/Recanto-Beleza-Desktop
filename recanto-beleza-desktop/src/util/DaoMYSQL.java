package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.DadosException;

/* @author BIC-Jr Guia de Estilo */
public class DaoMYSQL {

    protected Connection conn = null;

    public Connection getConnection() throws DadosException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/escolar", "root", "");
        } catch (ClassNotFoundException e) {
            throw new DadosException("Biblioteca de acesso a dados não encontrada " + e.getClass().getName() + " - " + e.getMessage());
        } catch (SQLException e) {
            throw new DadosException("Não foi possível se conectar ao banco " + e.getClass().getName() + " - " + e.getMessage());
        } catch (Exception e) {
            throw new DadosException("Erro geral getConnection() " + e.getClass().getName() + " - " + e.getMessage());
        }
        return conn;
    }

    private void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
        if(rs != null){
            rs.close();
        }
        close(conn, ps);
    }
    
    private void close(Connection conn, PreparedStatement ps) throws SQLException{
        if(ps != null){
            ps.close();
        }
        close(conn);
    }
    
    private void close(Connection conn) throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
    
    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

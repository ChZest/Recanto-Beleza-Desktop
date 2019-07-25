package dados;

/* @author BIC-Jr Guia de Estilo */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dados {

    public static Connection getConnection() throws DadosException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bicJrGuiaEstiloV2", "root", "");
        } catch (ClassNotFoundException e) {
            throw new DadosException("<html><p>Erro 001<br>BIBLIOTECA DE ACESSO A DADOS NÃO ENCONTRADA</p><br>"
                    + e.getClass().getName() + "<br>" + e.getMessage() + "</html>");
        } catch (SQLException e) {
            throw new DadosException("<html><p>Erro 002<br>NÃO FOI POSSÍVEL SE CONECTAR AO BANCO DE DADOS</p><br>"
                    + e.getClass().getName() + "<br>" + e.getMessage() + "</html>");
        } catch (Exception e) {
            throw new DadosException("<html><p>Erro 003<br>ERRO GERAL getConnection()</p><br>"
                    + e.getClass().getName() + "<br>" + e.getMessage() + "</html>");
        }
        return conn;
    }
}

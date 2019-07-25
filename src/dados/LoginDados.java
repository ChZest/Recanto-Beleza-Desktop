package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Usuario;

/* @author BIC-Jr Guia de Estilo */
public abstract class LoginDados extends Dados {

    private static final String LOGAR
            = " select * from tbUsuario "
            + " where login = (?) ";

    public static Usuario getUsuarioFromRs(ResultSet rs) throws DadosException {
        Usuario usuario = new Usuario();
        try {
            usuario.setCdUsuario(rs.getInt("cdUsuario"));
            usuario.setLogin(rs.getString("login"));
            usuario.setPessoa(rs.getString("pessoa"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipo(rs.getInt("tipo"));
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        return usuario;
    }

    public static Usuario logar(String login) throws DadosException {
        Usuario usuario = null;

        PreparedStatement ps;
        ResultSet rs;
        Connection conn;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(LOGAR);
            ps.setString(1, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = getUsuarioFromRs(rs);
            }
        } catch (DadosException | SQLException e) {
            throw new DadosException(e.getMessage());
        }
        close(conn, ps, rs);
        return usuario;
    }

    protected static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn, ps);
    }

    protected static void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn);
    }

    protected static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
    }
}

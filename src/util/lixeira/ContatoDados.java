package util.lixeira;

/**
 * @author BIC-Jr Guia de Estilo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import dados.Dados;
import dados.DadosException;
import entidades.Contato;

public class ContatoDados extends Dados {

    private int autoNum = -1;
    private static final String SQL_INSERIR
            = " insert into tbContato "
            + " (telefone, observacao, cdCliente) "
            + " values (?, ?, ?) ";
    private static final String SQL_CONSULTAR_TODOS
            = " select * from tbContato "
            + " where cdCliente = (?) ";
    private static final String SQL_CONSULTAR_POR_ID
            = " select * from tbContato "
            + " where cdContato = (?) ";
    private static final String SQL_EXCLUIR
            = " delete from tbContato "
            + " where cdCliente = (?) ";

    public Contato getContatoFromRs(ResultSet rs) throws DadosException {
        Contato contato = new Contato();
        try {
            contato.setCdContato(rs.getInt("cdContato"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setObservacao(rs.getString("observacao"));
            contato.setCdCliente(rs.getInt("cdCliente"));
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        return contato;
    }

    public int inserir(Contato contato, int cdCliente) throws DadosException {

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contato.getTelefone());
            ps.setString(2, contato.getObservacao());
            ps.setInt(3, contato.getCdCliente());

            ps.execute();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DadosException("Erro ClienteDados.inserir(" + contato.getTelefone() + "):-" + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        close(conn, ps, rs);
        return autoNum;
    }

    public List<Contato> consultarTodos(int cdCliente) throws DadosException {
        List<Contato> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            ps.setInt(1, cdCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contato c = getContatoFromRs(rs);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
    }

    public Contato consultarPorCodigo(int codigo) throws DadosException {
        Contato cRet = null;

        PreparedStatement ps;
        ResultSet rs;
        Connection conn;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = getContatoFromRs(rs);
            }
        } catch (DadosException | SQLException e) {
            throw new DadosException("Erro ao procurar cliente (ClienteDados.consutarPorCodigo(" + codigo + ")]: " + e.getClass().getName() + " - " + e.getMessage());
        }
        close(conn, ps, rs);
        return cRet;
    }

    public boolean excluir(int codigo) throws DadosException {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = true;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            retorno = false;
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps);
        return retorno;
    }

    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn, ps);
    }

    protected void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn);
    }

    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                //nenhum tratamento a ser feito
            }
        }
    }

}

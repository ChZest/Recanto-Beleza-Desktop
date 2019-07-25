package dados;

/* @author BIC-Jr Guia de Estilo */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import entidades.Cliente;

public abstract class ClienteDados extends Dados {

    // <editor-fold defaultstate="collapsed" desc="Comandos SQL">
    private static int autoNum = -1;
    private static final String SQL_INSERIR
            = " insert into tbCliente "
            + " (nmCliente, sexo, dtNasc, cpf, rg, email, rua, numero, complemento, bairro, cep, cdCidade, telefone, observacao) "
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_CONSULTAR_TODOS
            = " select * from tbCliente c, tbCidade i "
            + " where c.cdCidade = i.cdCidade "
            + " order by nmCliente ";
    private static final String SQL_CONSULTAR_SERVICOS
            = " select * from tbServico "
            + " order by dtServico ";
    private static final String SQL_CONSULTAR_POR_ID
            = " select * from tbCliente c, tbCidade i "
            + " where cdCliente = (?) and c.cdCidade = i.cdCidade ";
    private static final String SQL_CONSULTAR_POR_CAMPOS
            = " select * from tbCliente, tbcidade "
            + " where nmCliente like CONCAT(?, '%') and tbCliente.cdCidade = tbcidade.cdCidade "
            + " union select * from tbCliente, tbcidade "
            + " where telefone like CONCAT('%', ?, '%') and tbCliente.cdCidade = tbcidade.cdCidade "
            + " union select * from tbCliente, tbcidade "
            + " where email like CONCAT(?, '%') and tbCliente.cdCidade = tbCidade.cdCidade "
            + " order by nmCliente ";
    private static final String SQL_CONSULTAR_POR_NOME
            = " select * from tbCliente c, tbcidade i "
            + " where nmCliente like CONCAT(?, '%') and c.cdCidade = i.cdCidade "
            + " order by nmCliente ";
    private static final String SQL_FILTRAR
            = " select * from tbCliente c, tbcidade i "
            + " where nmCliente like CONCAT(?, '%') and c.cdCidade = i.cdCidade "
            + " order by nmCliente limit  ";
    private static final String SQL_ALTERAR
            = " update tbCliente "
            + " set nmCliente = ?, "
            + " sexo = ?, "
            + " dtNasc = ?, "
            + " cpf = ?, "
            + " rg = ?, "
            + " email = ?, "
            + " rua = ?, "
            + " numero = ?, "
            + " complemento = ?, "
            + " bairro = ?, "
            + " cep = ?, "
            + " cdCidade = ? "
            + " where cdCliente = ? ";
    private static final String SQL_EXCLUIR
            = " delete from tbcliente "
            + " where cdcliente = ? ";
// </editor-fold>
    
    public static Cliente getClienteFromRs(ResultSet rs) throws DadosException {
        Cliente cliente = new Cliente();
        try {
            cliente.setCdCliente(rs.getInt("cdCliente"));
            cliente.setNmCliente(rs.getString("nmCliente"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setDtNasc(rs.getDate("dtNasc"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            cliente.setEmail(rs.getString("email"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumero(rs.getInt("numero"));
            cliente.setComplemento(rs.getString("complemento"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCdCidade(rs.getInt("i.cdCidade"));
            cliente.setNmCidade(rs.getString("nmCidade"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setObservacao(rs.getString("observacao"));
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        return cliente;
    }

    public static Cliente getClienteFromRsNome(ResultSet rs) throws DadosException {
        Cliente cliente = new Cliente();
        try {
            cliente.setCdCliente(rs.getInt("cdCliente"));
            cliente.setNmCliente(rs.getString("nmCliente"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setDtNasc(rs.getDate("dtNasc"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            cliente.setEmail(rs.getString("email"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumero(rs.getInt("numero"));
            cliente.setComplemento(rs.getString("complemento"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCdCidade(rs.getInt("cdCidade"));
            cliente.setNmCidade(rs.getString("nmCidade"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setObservacao(rs.getString("observacao"));
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName() + e.getMessage() + e);
        }
        return cliente;
    }

    public static entidades.Servico getServicoFromRs(ResultSet rs) throws DadosException {
        entidades.Servico servico = new entidades.Servico();
        try {
            servico.setDtServicos(rs.getDate("dtServico"));
            servico.setNmServico(rs.getString("nmServico"));
            servico.setValores(rs.getDouble("valor"));
            servico.setHorario(rs.getString("horario"));
            servico.setObservacao(rs.getString("observacao"));
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName() + e.getMessage() + e);
        }
        return servico;
    }

    public static int inserir(Cliente cliente) throws DadosException {

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNmCliente());
            ps.setString(2, cliente.getSexo());
            ps.setDate(3, new java.sql.Date(cliente.getDtNasc().getTime()));
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getRg());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getRua());
            ps.setInt(8, cliente.getNumero());
            ps.setString(9, cliente.getComplemento());
            ps.setString(10, cliente.getBairro());
            ps.setString(11, cliente.getCep());
            ps.setInt(12, cliente.getCdCidade());
            ps.setString(13, cliente.getTelefone());
            ps.setString(14, cliente.getObservacao());

            ps.execute();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DadosException("Erro ClienteDados.inserir(" + cliente.getNmCliente() + "):-" + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        close(conn, ps, rs);
        return autoNum;
    }

    public static List<Cliente> consultarTodos() throws DadosException {
        List<Cliente> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = getClienteFromRs(rs);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
    }

    public static Cliente consultarPorCodigo(int codigo) throws DadosException {
        Cliente cRet = null;

        PreparedStatement ps;
        ResultSet rs;
        Connection conn;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = getClienteFromRs(rs);
            }
        } catch (DadosException | SQLException e) {
            throw new DadosException("Erro ao procurar cliente (ClienteDados.consutarPorCodigo(" + codigo + ")]: " + e.getClass().getName() + " - " + e.getMessage());
        }
        close(conn, ps, rs);
        return cRet;
    }

    public static List<Cliente> consultarCampos(String nome) throws DadosException {
        List<Cliente> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CAMPOS);
            ps.setString(1, nome);
            ps.setString(2, nome);
            ps.setString(3, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = getClienteFromRsNome(rs);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
    }

    public static List<Cliente> consultarNome(String nome) throws DadosException {
        List<Cliente> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = getClienteFromRs(rs);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
    }

    public static List<Cliente> consultarNomeFiltrar(String nome) throws DadosException {
        List<Cliente> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = getClienteFromRs(rs);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
    }

    public static boolean alterar(Cliente cliente) throws DadosException {
        Connection conn;
        PreparedStatement ps;
        boolean retorno = true;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, cliente.getNmCliente());
            ps.setString(2, cliente.getSexo());
            ps.setDate(3, new java.sql.Date(cliente.getDtNasc().getTime()));
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getRg());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getRua());
            ps.setInt(8, cliente.getNumero());
            ps.setString(9, cliente.getComplemento());
            ps.setString(10, cliente.getBairro());
            ps.setString(11, cliente.getCep());
            ps.setInt(12, cliente.getCdCidade());
            ps.setInt(13, cliente.getCdCliente());
            ps.execute();
        } catch (SQLException e) {
            retorno = false;
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps);
        return retorno;
    }

    public static boolean excluir(int codigo) throws DadosException {
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

    public static List<entidades.Servico> consultarServicos() throws DadosException {
        List<entidades.Servico> cList = new ArrayList();

        Connection conn;
        ResultSet rs;
        PreparedStatement ps;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_SERVICOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                entidades.Servico s = getServicoFromRs(rs);
                cList.add(s);
            }
        } catch (SQLException e) {
            throw new DadosException(e.getClass().getName());
        }
        close(conn, ps, rs);
        return cList;
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

package entidades;

/**
 * @author BIC-Jr Guia de Estilo
 */
public class Contato {
    private int cdContato;
    private String telefone;
    private String observacao;
    private int cdCliente;

    public Contato() {
        
    }
    
    public Contato(String telefone, String observacao) {
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Contato(int cdContato, String telefone, String observacao, int cdCliente) {
        this.cdContato = cdContato;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cdCliente = cdCliente;
    }

    public int getCdContato() {
        return cdContato;
    }

    public void setCdContato(int cdContato) {
        this.cdContato = cdContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(int cdCliente) {
        this.cdCliente = cdCliente;
    }
}

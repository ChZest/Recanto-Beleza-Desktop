package entidades;

/* @author BIC-Jr Guia de Estilo */
public class Servico {

    private String nmServico;
    private String profissional;
    private String horario;
    private double valores;
    private java.util.Date dtServicos;
    private String observacao;

    public Servico() {

    }

    public Servico(java.util.Date data, String nmServico, String horario) {
        this.nmServico = nmServico;
        this.horario = horario;
        this.dtServicos = data;
    }

    public Servico(String nmServico, String profissional, String horario) {
        this.nmServico = nmServico;
        this.profissional = profissional;
        this.horario = horario;
    }

    public Servico(String nmServico, String profissional, double valor) {
        this.nmServico = nmServico;
        this.profissional = profissional;
        this.valores = valor;
    }

    public Servico(String nmServico, String profissional, double valor, String observacao) {
        this.nmServico = nmServico;
        this.profissional = profissional;
        this.valores = valor;
        this.observacao = observacao;
    }

    public Servico(String nmServico, String horario, String observacao, String profissional) {
        this.nmServico = nmServico;
        this.horario = horario;
        this.profissional = profissional;
        this.observacao = observacao;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public String getValor() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getValores() {
        return valores;
    }

    public void setValores(double valores) {
        this.valores = valores;
    }

    public java.util.Date getDtServicos() {
        return dtServicos;
    }

    public void setDtServicos(java.util.Date dtServicos) {
        this.dtServicos = dtServicos;
    }

    public String getDtServico() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

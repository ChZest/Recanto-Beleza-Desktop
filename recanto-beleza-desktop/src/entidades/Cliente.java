package entidades;

import java.util.Date;

/**
 * @author BIC-Jr Guia de Estilo
 */
public class Cliente {
    private int cdCliente;
    private String nmCliente;
    private String sexo;
    private Date dtNasc;
    private String cpf;
    private String rg;
    private String email;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cep;
    private int cdCidade;
    private String nmCidade;
    private String telefone;
    private String observacao;
    
    public Cliente() {
        
    }
    
    public Cliente(String nmCliente, String telefone, String email) {
        this.nmCliente = nmCliente;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Cliente(int codigo, String nmCliente, String telefone, String email) {
        this.nmCliente = nmCliente;
        this.telefone = telefone;
        this.email = email;
        this.cdCliente = codigo;
    }
    
    public Cliente(int codigo, String nmCliente, String telefone, String email, String observacao) {
        this.nmCliente = nmCliente;
        this.telefone = telefone;
        this.email = email;
        this.cdCliente = codigo;
        this.observacao = observacao;
    }
    
    

    public Cliente(int cdCliente, String nmCliente, String sexo, Date dtNasc, String cpf, String rg, String email, String rua, int numero, String complemento, String bairro, String cep, int cdCidade) {
        this.cdCliente = cdCliente;
        this.nmCliente = nmCliente;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cdCidade = cdCidade;
    }

    public Cliente(int cdCliente, String nmCliente, String sexo, Date dtNasc, String cpf, String rg, String email, String rua, int numero, String complemento, String bairro, String cep, int cdCidade, String telefone, String observacao) {
        this.cdCliente = cdCliente;
        this.nmCliente = nmCliente;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cdCidade = cdCidade;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public int getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(int cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(int cdCidade) {
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
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
    
    @Override
    public String toString() {
        return nmCliente;
    }
}

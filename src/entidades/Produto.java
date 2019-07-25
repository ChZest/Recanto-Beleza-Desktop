package entidades;

/**
 * @author BIC-Jr Guia de Estilo
 */
public class Produto {

    private String nmProduto;
    private int quantidade;
    private double valor;
    private double subtotal;

    public Produto() {

    }

    public Produto(String nmProduto, int quantidade, double valor, double subtotal) {
        this.nmProduto = nmProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.subtotal = subtotal;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}

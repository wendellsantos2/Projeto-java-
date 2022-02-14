
package entidade;

public class Aparelho {

    public int getIdAparelho() {
        return idAparelho;
    }

    public void setIdAparelho(int idAparelho) {
        this.idAparelho = idAparelho;
    }

    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    public int idAparelho;
    public String nomeAparelho;
    public String marca;
    public String descricao;
    public double valor;
    public Cliente cliente;
    
    public Aparelho(){
        
    }
    public Aparelho(int idAparelho,String nomeAparelho,
            String marca,String descricao,
            double valor,Cliente cliente){
        
    }

    
}

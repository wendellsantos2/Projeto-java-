
package entidade;

public class Usuario {

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    private String nomeUsuario;
    private String usuario;
    private String senha;
    private int idUsuario;
    
    public Usuario(){
        
    }
    public Usuario(String nomeUsuario,String usuario,
            String senha,int idUsuario){
        
    }
}

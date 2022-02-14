
package dao;

import conexao.Conexao;
import entidade.Usuario;
import javax.swing.*;
import java.sql.*;

public class UsuarioDao extends Conexao {
    
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public UsuarioDao(){
        this.conexao = Conexao.conexao();
    }
    
    public void adicionarUsuario(Usuario usuario){
        String sql = "insert into usuario"
                + "(nomeUsuario,usuario,senha) values"
                + "(?,?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog
        (null,"Erro no banco"+ e.getMessage());
        }
    }
    public boolean usuario(String usuario,String senha){
        boolean existe = false;
        String sql = "select usuario,senha from usuario "
                + "where usuario = ? and senha = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            linha = stmt.executeQuery();
            while(linha.next()){
                existe = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog
        (null,"Erro no banco"+ e.getMessage());
        }
        return existe;
    }
}

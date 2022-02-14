
package dao;

import java.sql.*;
import conexao.Conexao;
import entidade.Cliente;
import javax.swing.*;

public class ClienteDao extends Conexao{
    
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public ClienteDao(){
        this.conexao = Conexao.conexao();
    }
    
    public void adicionar(Cliente cliente){
        String sql = "insert into cliente"
                + "(nomeCliente,sobrenome, cpfCliente,emailCliente,"
                + "telefone,logradouro,rua,complemento,bairro,"
                + "cidade,uf) values(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpfCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getLogradouro());
            stmt.setInt(7, cliente.getRua());
            stmt.setString(8, cliente.getComplemento());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11, cliente.getUf());
            
            stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog
        (null,"Erro No Banco"+ e.getMessage());
        }
    }
   
    public Cliente consultar(String cpf){
        try{
            Cliente cliente = new Cliente();
            stmt = conexao.prepareStatement
        ("select * from cliente where cpfCliente = ?");
            stmt.setString(1, cpf);
            linha = stmt.executeQuery();
            if(linha.next()){
                cliente.setIdCliente(linha.getInt("idCliente"));
                cliente.setNomeCliente(linha.getString("nomeCliente"));
                cliente.setSobrenome(linha.getString("sobrenome"));
                cliente.setCpfCliente(linha.getString("cpfCliente"));
                cliente.setTelefone(linha.getString("telefone"));
                cliente.setEmailCliente(linha.getString("emailCliente"));
                cliente.setLogradouro(linha.getString("logradouro"));
                cliente.setRua(linha.getInt("rua"));
                cliente.setComplemento(linha.getString("complemento"));
                cliente.setBairro(linha.getString("bairro"));
                cliente.setCidade(linha.getString("cidade"));
                cliente.setUf(linha.getString("uf"));
                return cliente;
            }else{
                return null;
            }
            
        }catch(Exception e){
           return null;
        }
    }
  
   public void atualizar(Cliente cliente){
       try{
           stmt = conexao.prepareStatement
        ("update cliente set nomeCliente = ?,sobrenome = ?,"
                + "emailCliente = ?,telefone = ?,logradouro = ?,"
                + "rua = ?,complemento = ?,bairro = ?, cidade = ?,"
                + "uf = ? where cpfCliente = ?");
           
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getEmailCliente());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getLogradouro());
            stmt.setInt(6, cliente.getRua());
            stmt.setString(7, cliente.getComplemento());
            stmt.setString(8, cliente.getBairro());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getUf());
            stmt.setString(11, cliente.getCpfCliente());
           stmt.executeUpdate();
       }catch(Exception e){
            JOptionPane.showMessageDialog
        (null,"Erro No Banco"+ e.getMessage());
        }
   } 
   public boolean excluir(String cpf){
       try{
           stmt = conexao.prepareStatement
        ("delete from cliente where cpfCliente = ?");
           stmt.setString(1, cpf);
           stmt.executeUpdate();
           return true;
       }catch(Exception e){
           return false;
       }
   }
}

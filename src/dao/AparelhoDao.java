/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexao.Conexao;
import entidade.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;


public class AparelhoDao {
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public AparelhoDao(){
        this.conexao = Conexao.conexao();
    }
    
    public void adicionar(Aparelho aparelho){       
        String sql = "insert into aparelho"
        + "(nomeAparelho,marca,descricao,valor,idCliente) "
        + "values (?,?,?,?,?)";
        
       try{
         stmt = conexao.prepareStatement(sql);
         stmt.setString(1, aparelho.getNomeAparelho());
         stmt.setString(2, aparelho.getMarca());
         stmt.setString(3, aparelho.getDescricao());
         stmt.setDouble(4, aparelho.getValor());
         stmt.setInt(5, aparelho.getCliente().getIdCliente());
         stmt.executeUpdate();
         
       }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
        }

    }
    
   
    public List<Aparelho>Listar(String nome){
        List<Aparelho> lista = new ArrayList();
        String sql = "select * from aparelho inner join cliente"
                + " on aparelho.idCliente = cliente.idCliente "
                + " where nomeAparelho like ? order by idAparelho";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                 Aparelho aparelho = new Aparelho();
                Cliente cliente = new Cliente();
                aparelho.setCliente(cliente);
                aparelho.setIdAparelho(rs.getInt("idAparelho"));
                aparelho.setNomeAparelho(rs.getString("nomeAparelho"));
                aparelho.setMarca(rs.getString("marca"));
                aparelho.setDescricao(rs.getString("descricao"));
                aparelho.setValor(rs.getDouble("valor"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                lista.add(aparelho);
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
        }
        return lista;
       
    }
    public void atualizar(Aparelho aparelho){
        try{
        stmt = conexao.prepareStatement("update aparelho set "
                + "nomeAparelho = ?, marca = ?, descricao = ?, valor = ? "
                + "where idAparelho = ?");
        
        stmt.setString(1, aparelho.getNomeAparelho());
        stmt.setString(2, aparelho.getMarca());
        stmt.setString(3, aparelho.getDescricao());
        stmt.setDouble(4, aparelho.getValor());
        stmt.setInt(5, aparelho.getIdAparelho());
        stmt.executeUpdate();
   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro"+ e.getMessage());
        }
    }
}

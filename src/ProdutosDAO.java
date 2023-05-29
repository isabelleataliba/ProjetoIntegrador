/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos(nome, valor) VALUES "
                + "(?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }  
    }
    
    public boolean venderProduto(ProdutosDTO p) {
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos(status) VALUE "
                + "(?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.getStatus());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }  
    }
    public boolean listarProdutos(){
        String sql = "SELECT * FROM produtos where status = 'Vendido'";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    rs.getString("id");
                    rs.getString("nome");
                    rs.getInt("valor");
                    rs.getString("status")
                ;
            }
        } catch (Exception e) {
        }
        return false;
    } 
    
    public boolean consultarVendas() {
        String sql = "SELECT * FROM produtos where status = 'Vendido'";
        new conectaDAO();
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    rs.getString("id");
                    rs.getString("nome");
                    rs.getInt("valor");
                    rs.getString("status")
                ;
            }
        } catch (Exception e) {
        }
    }
}


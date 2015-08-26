/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ricardo.oliveira.exercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author daniel.rodrigues1
 */
public class Conexao {
    
  private Connection obterConexao() throws SQLException, ClassNotFoundException {
    Connection conn = null;
    // Passo 1: Registrar driver JDBC.
   
    Class.forName("org.apache.derby.jdbc.ClientDataSource");

    // Passo 2: Abrir a conexão
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/cadastro_contatos;SecurityMechanism=3",
            "git", // usuario
            "git"); // senha
    return conn;
  }

  public void listarPessoas() {
    Statement stmt = null;
    Connection conn = null;

    String sql = "SELECT NOME, DATA_NASCIMENTO, TELEFONE, EMAIL FROM CADASTRO_CONTATO";
    try {
      conn = obterConexao();
      stmt = conn.createStatement();
      ResultSet resultados = stmt.executeQuery(sql);

      

      while (resultados.next()) {

        String nome = resultados.getString("NOME");
        String dataNasc = resultados.getString("DATA_NASCIMENTO");
        String email = resultados.getString("EMAIL");
        String telefone = resultados.getString("TELEFONE");
        System.out.println(nome+ ", " +dataNasc+", "+email + ", " + telefone);
      }

    } catch (SQLException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  public void incluirPessoa() {
    PreparedStatement stmt = null;
    Connection conn = null;

    String nome;
    String email;
    String telefone;

    // ENTRADA DE DADOS
    Scanner entrada = new Scanner(System.in);
    System.out.print("Digite o nome da pessoa: ");
    nome = entrada.nextLine();

    System.out.print("Digite a data de nascimento no formato dd/mm/aaaa: ");
    String strDataNasc = entrada.nextLine();
   
    System.out.print("Digite o telefone: ");
    telefone = entrada.nextLine();

    System.out.print("Digite o e-mail: ");
    email = entrada.nextLine();

    String sql = "INSERT INTO CADASTRO_CONTATO (NOME, DATA_NASCIMENTO, TELEFONE, EMAIL) VALUES ('"+nome+"', '"+strDataNasc+"', '"+telefone+"', '"+email+"')";
    try {
       conn = obterConexao();
       Statement stm;
       stm = conn.createStatement();
       stm.executeUpdate(sql);

      System.out.println("Registro incluido com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }
 public void editarPessoa() {
    PreparedStatement stmt = null;
    Connection conn = null;

    String nome;
    String email;
    String telefone;

    // ENTRADA DE DADOS
    Scanner entrada = new Scanner(System.in);
    System.out.print("Digite o nome da pessoa: ");
    nome = entrada.nextLine();

    System.out.print("Digite a data de nascimento no formato dd/mm/aaaa: ");
    String strDataNasc = entrada.nextLine();
 
    System.out.print("Digite o telefone: ");
    telefone = entrada.nextLine();

    System.out.print("Digite o e-mail: ");
    email = entrada.nextLine();

    String sql = "UPDATE CADASTRO_CONTATO SET NOME='"+nome+"', DATA_NASCIMENTO='"+strDataNasc+"', TELEFONE='"+telefone+"', EMAIL='"+email+"' WHERE NOME = '"+nome+"'";
    try {
       conn = obterConexao();
       Statement stm;
       stm = conn.createStatement();
       stm.executeUpdate(sql);

      System.out.println("Registro alterado com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  public static void main(String[] args) {
 
  }
}

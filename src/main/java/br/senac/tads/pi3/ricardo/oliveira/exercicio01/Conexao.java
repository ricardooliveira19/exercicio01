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

    public Scanner entrada = new Scanner(System.in);

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
                System.out.println(nome + ", " + dataNasc + ", " + email + ", " + telefone);
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
        String nome, email, telefone;

        // ENTRADA DE DADOS
        System.out.print("Digite o nome da pessoa: ");
        nome = entrada.nextLine();
        System.out.print("Digite a data de nascimento no formato dd/mm/aaaa: ");
        String strDataNasc = entrada.nextLine();
        System.out.print("Digite o telefone: ");
        telefone = entrada.nextLine();
        System.out.print("Digite o e-mail: ");
        email = entrada.nextLine();

        String sql = "INSERT INTO CADASTRO_CONTATO (NOME, DATA_NASCIMENTO, TELEFONE, EMAIL) VALUES ('" + nome + "', '" + strDataNasc + "', '" + telefone + "', '" + email + "')";
        conecta(sql, "Registro incluido com sucesso!");

    }

    public void editarPessoa() {
        String nome, email, telefone;

        // ENTRADA DE DADOS
        System.out.print("Digite o nome da pessoa: ");
        nome = entrada.nextLine();
        System.out.print("Digite a data de nascimento no formato dd/mm/aaaa: ");
        String strDataNasc = entrada.nextLine();
        System.out.print("Digite o telefone: ");
        telefone = entrada.nextLine();
        System.out.print("Digite o e-mail: ");
        email = entrada.nextLine();

        String sql = "UPDATE CADASTRO_CONTATO SET NOME='" + nome + "', DATA_NASCIMENTO='" + strDataNasc + "', TELEFONE='" + telefone + "', EMAIL='" + email + "' WHERE NOME = '" + nome + "'";
        conecta(sql, "Registro alterado com sucesso!");
    }

    public void removerPessoa() {
        String nome;
        // REMOÇÃO
        System.out.print("Digite o nome da pessoa que sera removido: ");
        nome = entrada.nextLine();

        conecta("NOME, DATA_NASCIMENTO, TELEFONE, EMAIL FROM CADASTRO_CONTATO WHERE NOME='" + nome + "'", "Confirmar remoção?\n1-Sim\n2-Não");

        if (entrada.nextInt() == 1) { // Confirmação de exclusão
            conecta("DELETE FROM CADASTRO_CONTATO WHERE NOME='" + nome + "'", "Registro removido com sucesso!");
        } else {
            System.out.println("Operaçao cancelada!");
        }
    }

    // Função "conecta" criada para otimizar, e reduzir quantidade de códigos repetidos
    public void conecta(String sql, String retorno) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = obterConexao();
            Statement stm;
            stm = conn.createStatement();
            stm.executeUpdate(sql); // Comando de execução

            System.out.println(retorno); // Print na tela a mensagem de conclusão
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
}

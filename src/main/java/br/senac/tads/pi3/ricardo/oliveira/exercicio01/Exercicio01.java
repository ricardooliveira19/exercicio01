package br.senac.tads.pi3.ricardo.oliveira.exercicio01;

import java.util.Scanner;

/**
 * @author ricardo.oliveira5
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int opc;
        Conexao instancia = new Conexao();
        /*usuario:git senha:git*/
        do {
            System.out.println("1 - Cadastrar"); // Insert
            System.out.println("2 - Editar"); // Update
            System.out.println("3 - Remover"); // Delete
            System.out.println("4 - Listar"); // Select
            System.out.println("5 - Sair");
            opc = leitor.nextInt();

            if (opc == 1) {
                instancia.incluirPessoa();
            } else if (opc == 2) {
                instancia.editarPessoa();
            } else if (opc == 3) {
                instancia.listarPessoas();
                instancia.removerPessoa();
            } else if (opc == 4) {
                instancia.listarPessoas();
            }
        } while (opc != 5);
    }
}

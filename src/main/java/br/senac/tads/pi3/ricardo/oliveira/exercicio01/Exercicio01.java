/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ricardo.oliveira.exercicio01;

import java.util.Scanner;

/**
 *
 * @author ricardo.oliveira5
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int op;

        do {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Sair");
            op = leitor.nextInt();

            if (op == 1) {
                System.out.println("Nome");
                leitor.nextLine();
                String nome = leitor.nextLine();
                System.out.println("DataNascimento");
                int nasc = leitor.nextInt();
                System.out.println("E-mail");
                leitor.nextLine();
                String email = leitor.nextLine();
                System.out.println("Telefone");
                int tel = leitor.nextInt();

                System.out.println("\nNome: " + nome);
                System.out.println("Data de Nascimento: " + nasc);
                System.out.println("Email: " + email);
                System.out.println("Telefone: " + tel + "\n");
            }
        } while (op != 2);

    }
}

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
        int opc;
        Conexao instancia = new Conexao();
           /*usuario:git senha:git*/ 
        do {
            System.out.println("1 - Cadastrar");//insert
            System.out.println("2 - Editar");//update
            System.out.println("3 - Remover");//delete
            System.out.println("4 - Listar");//select
            System.out.println("5 - Sair");
            opc = leitor.nextInt();

            if (opc == 1) {
             instancia.incluirPessoa();
            }if(opc == 2){
             instancia.editarPessoa();
            }if(opc == 3){
            
            }if(opc == 4){
            instancia.listarPessoas();
            }
        
        }while (opc != 5);

    }
}

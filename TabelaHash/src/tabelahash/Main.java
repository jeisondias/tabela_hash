/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import static tabelahash.TabelaHash.entrada;
import tabelahash.TabelaHash.hash;
import static tabelahash.TabelaHash.tabela;
import static tabelahash.TabelaHash.tam;



/**
 *
 * @author Nuno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TabelaHash tabelaHash = new TabelaHash();
        
        int op, pos, num, i;

        for (i = 0; i < tam; i++) {
            tabela[i] = new hash();
            tabela[i].livre = 'L';
        }
        do {
            System.out.println("\nMENU DE OPÇÕES\n");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Mostar tabela hashing");
            System.out.println("3 - Excluir elemento");
            System.out.println("Digite sua opção:");
            op = entrada.nextInt();

            if (op < 1 || op > 4) {
                System.out.println("Opção inválida!");
            } else {
                switch (op) {
                    case 1:
                        System.out.println("Digite um número: ");
                        num = entrada.nextInt();
                        pos = tabelaHash.funcaohashing(num);
                        tabelaHash.inserir(pos, num); 
                        break;
                    case 2:
                        tabelaHash.mostrarHash();
                        break;
                    case 3:
                        System.out.println("Digite um número: ");
                        num = entrada.nextInt();
                        tabelaHash.remover(num);
                        break;
                }
            }
        } while (op != 4);
    }

   
}


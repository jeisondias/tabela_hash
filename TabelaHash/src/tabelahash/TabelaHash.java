/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import java.util.Scanner;

/**
 *
 * @author Nuno
 */
public class TabelaHash {
    
    static int tam = 8;
    static hash tabela[] = new hash[tam];
    static Scanner entrada = new Scanner(System.in);
    
    
    public static class hash{
        int chave;
        char livre;    
    }
    
    public static void inserir(int pos, int n){
        int i = 0;
        while(i < tam 
                && tabela[(pos +i) %tam].livre != 'L'
                && tabela[(pos +i) %tam].livre != 'R'){
            i = i + 1;
        }
        if (i < tam) {
            tabela[(pos +i) %tam].chave = n;
            tabela[(pos +i) %tam].livre = '0';
        }else{
            System.out.println("TABELA CHEIA !");
        }
    }
    
    public static void remover (int n){
        int posicao = buscar(n);
        if (posicao < tam) {
            tabela[posicao].livre = 'R';
        } else {
            System.out.println("Elemento não está presente");
        }
    }
    
    public static int funcaohashing(int num) { 
         return num % tam; 
    }
    
    public static int buscar (int n){
        int i = 0;
        int pos = funcaohashing(n);
        while(i < tam 
                && tabela[(pos +i) %tam].livre != 'L'
                && tabela[(pos +i) %tam].chave != n){
            i = i + 1;
        }
        if (tabela[(pos + i) % tam].livre == n
                && tabela[(pos + i) % tam].livre != 'R') {
            return (pos + i) % tam;
        } else {
            return tam;
        }
    }
    
    public void mostrarHash() {
        for (int i = 0; i< tam; i++){
            if (tabela[i].livre == 'O'){
                System.out.println("ESTRADA "+ i + ": " +tabela[i].chave + "" + tabela[i].livre);
            }
        }
    }
    
    
    
    
}

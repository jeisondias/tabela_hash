package tabelahash;

import java.util.Scanner;

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
    
 static void mostrarhash(){
     for(int i = 0; i < tam; i++){
         if(tabela[i].livre == '0'){
             System.out.println("Entrada "+i+": "+ tabela[i].chave+""+ tabela[i].livre);
         }
     }
 }
    
    
    
    
    
}

package appjogoforca;

import java.util.Arrays;
import java.util.Scanner;

public class GameEng {

    boolean running = true;
    int rodadas_max, num_rodada, tamanho_palavra, num_acertos;
    char[] array_acertos;
    String palavra_secreta;
    Scanner input;

    private int check_acerto(char letra , String palavra)
    {
        //  loop FOR para verificar se a letra existe na palavra
        // retorna o numero de vezes que a letra eh encontrada
        int acertos = 0;
        for(int i = 0; i < tamanho_palavra ; i++)
        {
           // letras_certas[i] = '_';

            if(palavra.charAt(i) == letra && array_acertos[i] != letra  )
            {
                array_acertos[i] = letra;
                acertos++;

            }
        }
        return acertos;
    }
    boolean check_vitoria(){
        for(int i = 0 ; i < tamanho_palavra; i++){
            if(array_acertos[i] != palavra_secreta.charAt(i)){
                return false;

            }
        }
        return true;
    }

    boolean check_derrota(int rodada){
        if(rodada > rodadas_max){
            return true;
        }
        return false;
    }


    public boolean game_loop()
    {
        char tentativa;

        //  input da  letra_chute
        while (true) {
            System.out.println("Digite uma letra");
            String input_string = input.nextLine();

            if(!input_string.isEmpty()) {
                tentativa = input_string.charAt(0);
                break;
            }

        }

        num_acertos += check_acerto(tentativa, palavra_secreta);

        String palavra = Arrays.toString(array_acertos);

        System.out.println(">>  " + palavra);

        // condição de vitória
        if(check_vitoria())
        {
            System.out.println("Você venceu");
            return false;
        }

        //condição de derrota
        if(check_derrota(num_rodada)){
            System.out.println("Você perdeu");
            return false;
        }

        num_rodada++;
        return true;
    }


    public void loading_game()
    {

        // mensagem de abertura
        System.out.println("Seja bem vindo ao Jogo da Forca por gravatinha");

        // define palavra
        palavra_secreta = "palavra";

        // inicializa variáveis
        rodadas_max = 5;
        num_rodada = 0;
        tamanho_palavra = palavra_secreta.length();
        array_acertos = new char[tamanho_palavra];
        num_acertos = 0;

        // zera array de acertos
        for(int i = 0; i < tamanho_palavra; i++)
        {
            array_acertos[i] = '_';
        }

        input = new Scanner(System.in);
    }
    
}

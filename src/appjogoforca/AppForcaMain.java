package appjogoforca;

//┌────────────────────────────────────────────────────────────────────────┐
//│            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
//│            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
//│            ║       ╚════╝   ╚═════        ║       ║    ║               │
//└────────────────────────────────────────────────────────────────────────┘
//┌────────────────────────────────────────────────────────────────────────┐
//│  Fundamentos da Programação Orientada a Objetos (11100010550_20242_20) │
//│  CURSO: Análise e Desenvolvimento de Sistemas                          │
//│  ALUNO: HANDERSON GLEBER DE LIMA CAVALCANTI (Gr4v4t1nh4)               │
//│  MATRÍCULA: 1112024201103                                              │
//└────────────────────────────────────────────────────────────────────────┘
//┌────────────────────────────────────────────────────────────────────────┐
//│   IMPLEMENTAÇÃO DE JOGO DA FORCA EM JAVA                               │
//└────────────────────────────────────────────────────────────────────────┘


import java.util.Scanner;

public class AppForcaMain {

    boolean running = true;
    int rodadas_max, num_rodada, tamanho_palavra, num_acertos;
    char[] array_acertos;
    String palavra_secreta;
    Scanner input;

    public static void main(String[] args)
    {

        AppForcaMain app = new AppForcaMain();

        app.loading_app();

        while(app.running)
        {
           app.running = app.game_loop();
        }
    }

    private int check_acerto(char letra , String palavra)
    {
        //  loop FOR para verificar se a letra existe na palavra
        // retorna o numero de vezes que a letra eh encontrada
        int acertos=0;

        for(int i = 0; i < tamanho_palavra ; i++)
        {
            if(palavra.charAt(i) == letra)
            {
                System.out.println(("[" + letra + "] LETRA CERTA "));
                array_acertos[i] = letra;
                acertos++;
            }
        }
        return acertos;
    }

    private boolean game_loop()
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

        num_acertos += check_acerto(tentativa, palavra_secreta) ;

        System.out.println(array_acertos);

        // condição de vitória
        if(num_acertos == tamanho_palavra)
        {
            System.out.println("Você venceu");
        }

        //condição de derrota
        if(num_rodada > rodadas_max){
            System.out.println("Você perdeu");
            return false;
        }



        //  num_rodada++;
        return true;
    }


    private void loading_app()
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
            array_acertos[i] = '0';
        }

        input = new Scanner(System.in);
    }

}

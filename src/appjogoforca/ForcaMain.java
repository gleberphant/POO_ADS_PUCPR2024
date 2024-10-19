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

package appjogoforca;


public class ForcaMain {


    public static void main(String[] args)
    {
        GameEng game = new GameEng();

        game.loading_game();

        game.run();

    }



}

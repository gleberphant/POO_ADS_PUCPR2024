package SEMANA01;//┌────────────────────────────────────────────────────────────────────────┐
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
//│ CLASSE PARA TESTES DE FUNÇÕES                                          │
//└────────────────────────────────────────────────────────────────────────┘


import java.util.Scanner;

public class exercicios_gerais {

    public static void main(String[] args)
    {

    String nome;
    int idade;
    float altura;

    Scanner input = new Scanner(System.in);

    System.out.print("\n Digite seu nome: ");
    nome = input.nextLine();

    System.out.print("\n Digite sua idade: ");
    idade = input.nextInt();

    System.out.print("\n Digite sua altura: ");
    altura = input.nextFloat();


    System.out.printf("Seu nome é nome "+ nome + ", sua idade é " + idade + " e sua altura %.2f.", altura);

    input.close();
    }
}

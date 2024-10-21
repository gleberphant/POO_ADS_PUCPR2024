package atividade01;

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
//│   atividade formativa nº 01                                            │
//└────────────────────────────────────────────────────────────────────────┘

/*b. Classe InterfaceUsuário:

i. Esta classe é responsável por lidar com a entrada de dados do usuário. Estes dados podem ser recebidos via entrada do usuário usando o Scanner.

ii. Métodos:

1. Pedir ao usuário o valor do imóvel: Ela deve conter um metodo o qual pede ao usuário para que digite o valor do imóvel, e retorne o valor digitado pelo usuário.

2. Pedir ao usuário o prazo do financiamento: Ela deve conter um metodo o qual pede ao usuário para que digite o prazo do financiamento em anos, e retorne o valor digitado pelo usuário.

3. Pedir ao usuário a taxa de juros: Ela deve conter um metodo o qual pede ao usuário para que digite a taxa de juros anual, e retorne o valor digitado pelo usuário.*/

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner input;


    public InterfaceUsuario()
    {
        this.input = new Scanner(System.in);
    }

    public double inputValorImovel()
    {
        System.out.println("Digite o VALOR do financiamento");
        return input.nextDouble();
    }

    public int inputPrazoFinanciamento()
    {
        System.out.println("Digite o PRAZO do financiamento");
        return input.nextInt();
    }

    public double inputTaxaJuros()
    {
        System.out.println("Digite o valor da TAXA DE JUROS ANUAL");
        return input.nextDouble();
    }

}

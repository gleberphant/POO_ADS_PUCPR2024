package AF_SEMANA2;

/*
┌────────────────────────────────────────────────────────────────────────┐
│            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
│            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
│            ║       ╚════╝   ╚═════        ║       ║    ║               │
└────────────────────────────────────────────────────────────────────────┘
┌────────────────────────────────────────────────────────────────────────┐
│  Fundamentos da Programação Orientada a Objetos (11100010550_20242_20) │
│  CURSO: Análise e Desenvolvimento de Sistemas                          │
│  ALUNO: HANDERSON GLEBER DE LIMA CAVALCANTI (Gr4v4t1nh4)               │
│  MATRÍCULA: 1112024201103                                              │
└────────────────────────────────────────────────────────────────────────┘
┌────────────────────────────────────────────────────────────────────────┐
│   atividade formativa nº 01                                            │
└────────────────────────────────────────────────────────────────────────┘
*/
/*
c. Classe Main:

i. Esta é a classe principal do programa.

ii. Ela deve conter o metodo main(), onde o fluxo principal do programa será implementado.

1. Dentro do metodo main() você deve usar os métodos da classe InterfaceUsuário para ler os dados do financiamento.

2. Após ler os dados do financiamento, instancie um objeto do tipo Financiamento para criar este financiamento.*/

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {


        InterfaceUsuario opcoes = new InterfaceUsuario();

        // invocar o metodo interface usuário para ler os dados
        double valor = opcoes.inputValorImovel();
        int prazo =  opcoes.inputPrazoFinanciamento();
        double juros = opcoes.inputTaxaJuros();


        //cria rum objeto financiamento com os dados passados pelo usuário
        Financiamento finan = new Financiamento(valor, prazo, juros);


        System.out.println(finan.getString());


    }

}

class InterfaceUsuario {
    Scanner input;


    public InterfaceUsuario()
    {
        this.input = new Scanner(System.in);
        System.out.println(getStringAbertura());
    }

    public String getStringAbertura(){
        return
        """                
        ┌──────────────────────────────────────────────┐
        │         SISTEMA DE FINANCIAMENTO POO         │
        │      por: HANDERSON GLEBER (gravatinha)      │
        └──────────────────────────────────────────────┘
        """;
    }


    public double inputValorImovel()
    {
        System.out.print("\n > Digite o VALOR do financiamento: ");
        return input.nextDouble();
    }

    public int inputPrazoFinanciamento()
    {
        System.out.print("\n > Digite o PRAZO do financiamento: ");
        return input.nextInt();
    }

    public double inputTaxaJuros()
    {
        System.out.print("\n > Digite o valor da TAXA DE JUROS ANUAL: ");
        return input.nextDouble();
    }

}


class Financiamento {

    private int prazoMeses;
    private double valorImovel;
    private double taxaJurosAno;


    public Financiamento(double valorImovel, int prazoMeses, double taxaJurosAno){
        this.setFinanciamento(valorImovel,prazoMeses, taxaJurosAno);
    }


    public void setFinanciamento(double valorImovel, int prazoMeses, double taxaJurosAno)
    {
        this.prazoMeses = prazoMeses;
        this.valorImovel = valorImovel;
        this.taxaJurosAno = taxaJurosAno;
    }


    private int getPrazoAnos(){
        return prazoMeses /12;
    }


    public double getParcelaMensal()
    {
        return (valorImovel / (getPrazoAnos() * 12)) * (1 + (taxaJurosAno / 12));
    }


    public double getPagamentoTotal()
    {
        return getParcelaMensal() * getPrazoAnos() * 12;
    }

    public String getString() {
        return String.format(
                """
                
                ┌──────────────────────────────────────────────┐
                │                FINANCIAMENTO                 │
                │  Prazo : %33d   │
                │  Valor do Financiamento : %16f   │
                │  Taxa Juros Ano: %25f   │
                │                                              │
                │  PAGAMENTO TOTAL R$ %-23f  │
                └──────────────────────────────────────────────┘
                """, prazoMeses, valorImovel, taxaJurosAno, getPagamentoTotal());
    }
}


package atividade01;

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

public class Main {


    public static void main(String[] args)
    {
        System.out.println("Sistema de financiamento puc");

        InterfaceUsuario opcoes = new InterfaceUsuario();

        // invocar o metodo interface usuário para ler os dados
        double juros = opcoes.inputTaxaJuros();
        double valor = opcoes.inputValorImovel();
        int prazo =  opcoes.inputPrazoFinanciamento();


        //cria rum objeto financiamento com os dados passados pelo usuário
        Financiamento finan = new Financiamento(prazo, valor, juros);


        System.out.println(finan.getString());
        System.out.println(">> Pagamento total R$" + finan.getPagamentoTotal());
    }



}

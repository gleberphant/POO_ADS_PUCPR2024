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

//Classe Financiamento:
//i. Esta classe representará um financiamento.
//
//ii. Ela deve conter três atributos: valorImovel (double), prazoFinanciamento (int) e taxaJurosAnual (double).
//
//iii. Deve conter pelo menos três métodos: um construtor para inicializar esses atributos, um metodo para calcular o pagamento mensal, e outro metodo para calcular o total do pagamento.
//
//iv. As fórmulas para calcular o pagamento mensal e total do pagamento serão:
//
//        1. Pagamento mensal = (valor do imóvel / (prazo do financiamento em anos * 12)) * (1 + (taxa anual / 12))
//
//        2. Total do pagamento = pagamento mensal * prazo do financiamento em anos * 12
*/


public class financiamento {

    int prazoFinanciamento;
    float valorImovel;
    float taxaJurosAnual;
    float parcelaMensal;


    private float converterPrazoAnos()
    {
        return (float) prazoFinanciamento/12;
    }

    private double getParcelaMensal()
    {
        return (valorImovel / (prazo_em_anos() * 12)) * (1 + (taxaJurosAnual / 12));

    }
    private int prazo_em_anos(){
        return 0;
    }
    private double getPagamentoTotal()
    {
        return parcelaMensal * prazo_em_anos() * 12;
    }

}

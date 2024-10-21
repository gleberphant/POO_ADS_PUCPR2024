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


public class Financiamento {

    private int prazoMeses;
    private double valorImovel;
    private double taxaJurosAno;


    public Financiamento(){
        this.setFinanciamento( 12, 10.000, 0.1);
    }


    public Financiamento(int prazoMeses, double valorImovel, double taxaJurosAno){
        this.setFinanciamento(prazoMeses, valorImovel, taxaJurosAno);
    }


    public void setFinanciamento(int prazoMeses, double valorImovel, double taxaJurosAno)
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
        return "Financiamento{" +
                "prazoMeses=" + prazoMeses +
                ", valorImovel=" + valorImovel +
                ", taxaJurosAno=" + taxaJurosAno +
                '}';
    }
}

/**
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
 * │            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
 * │            ║       ╚════╝   ╚═════        ║       ║    ║               │
 * └────────────────────────────────────────────────────────────────────────┘
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │ Análise e Desenvolvimento de Sistemas                                  │
 * │ Fundamentos da Programação Orientada a Objetos (11100010550_20242_20)  │
 * └────────────────────────────────────────────────────────────────────────┘
 *
 * @author HANDERSON GLEBER DE LIMA CAVALCANTI (1112024201103)
 * @version af_semana_003

Um banco geralmente faz tipos diferentes de financiamento. Casas, apartamentos e terrenos possuem características diferentes e, naturalmente, regras diferentes. Agora será a hora de colocar tais regras em nosso projeto.

O que devo desenvolver?

1. Todos os requisitos das semanas anteriores.

2. Crie três subclasses para Financiamento:

a. Casa:

i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.

ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros. Ou seja: este valor adicional não substitui os juros, mas é uma taxa extra.

b. Apartamento:

i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.

ii. Por isso, substitua a equação do cálculo do pagamento mensal para apartamentos. A nova fórmula deverá ser:

1. Vamos calcular primeiro a taxa mensal. Ela é:



2. Vamos calcular o valor em meses do financiamento. Ela é:

3. A nova fórmula será:



c. Terreno:

i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.

ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.

3. No mé_todo main() substitua os quatro financiamentos de financiamento por dois financiamentos de casa, dois financiamentos de apartamento e um de terreno.

a. Todos os financiamentos deverão permanecer em um único ArrayList.

b. Digitar todas as informações a cada teste é chato. Somente peça os dados do usuário para um financiamento.

c. Para os demais financiamentos você poderá informar os dados diretamente no código dentro do seu método main().

d. Mantenha ainda o texto que mostra a soma dos valores dos imóveis e a soma dos valores dos financiamentos.
 */

package semana05heranca.main;


import semana05heranca.model.Loan;
import semana05heranca.util.UserInterface;
import semana05heranca.util.LoanBuilder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 *
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {

        // declaração de variáveis
        double propertyPrice;
        int loanTerm, countLoan = 1;
        double loanFee;
        boolean running = true;
        double totalPriceProperty = 0f, totalPriceLoan = 0f;

        // declaração de array de financiamentos
        List<Loan> listLoans = new ArrayList<>();

        // inicialização da interface
        UserInterface appInterface = UserInterface.getInstance().initialize();

        appInterface.viewOpening();

        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {

            // leitura dos dados do financiamento
            try {

                input_and_create_loan(appInterface, listLoans, countLoan);

                countLoan++;

            } catch (IllegalArgumentException e) {
                appInterface.viewException(e);

            } catch (InputMismatchException e) {

                appInterface.viewException(e);
                continue;
            }

            for (Loan item : listLoans) {
                appInterface.viewLoan(item);
                totalPriceLoan += item.getPaymentValueTotal();
                totalPriceProperty += item.getPrice();
            }

            appInterface.viewTotals(totalPriceProperty, totalPriceLoan);

            // pergunta se o usuário deseja sair
            running = appInterface.promptExit();

        } while (running);

        // encerramento da aplicação
        appInterface.viewClosure();

    }

    public static void input_and_create_loan(UserInterface appInterface, List<Loan> loanList, int id)
    {
        loanList.add(new LoanBuilder()
                .Type((char) ('0' + appInterface.Input().type()))
                .Id(id)
                .Price(appInterface.Input().price())
                .Term(appInterface.Input().term())
                .Fee(appInterface.Input().fee())
                .build() );

    }

//    public void testLoanBuilder2(List<Loan> list, int count )
//    {
////        switch (count){
////            case 1:
////                list.add(new LoanBuilder2()
////                        .Type('h')
////                        .Id(count)
////                        .Price(2.0)
////                        .Term(2)
////                        .Fee(1.0)
////                        .build() );
////        }
//
//    }
}



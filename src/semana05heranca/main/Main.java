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
 * <br>
 * REQUISITOS
 * <br>
 * 1. Todos os requisitos das semanas anteriores.
 * <br>
 * 2. No main(), adicione quatro financiamentos em um ArrayList. Cada financiamento será um objeto instanciado da classe financiamento.
 * <br>
 * 3. Após adicionar todos os financiamentos, mostre na tela o valor total de todos os imóveis e o valor total de todos os financiamentos.
 * a. Exemplo:
 * i. Financiamento 1 – valor do imóvel: R$ 200000, valor do financiamento: R$ 220000.
 * ii. Financiamento 2 – valor do imóvel: R$ 300000, valor do financiamento: R$ 380000.
 * iii. Financiamento 3 – valor do imóvel: R$ 150000, valor do financiamento: R$ 155000.
 * iv. Financiamento 4 – valor do imóvel: R$ 250000, valor do financiamento: R$ 275000.
 * Total de todos os imóveis: R$ 900000, total de todos os financiamentos: R$ 1030000.
 */

package semana05heranca.main;


import semana05heranca.model.Loan;
import semana05heranca.model.LoanBuilder;
import semana05heranca.util.UserInterface;

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

                propertyPrice = appInterface.getInput().price();
                loanTerm = appInterface.getInput().term();
                loanFee = appInterface.getInput().fee();

                // criar objeto financiamento e mostra seus dados

                listLoans.add(new LoanBuilder()
                        .Id(countLoan)
                        .Price(propertyPrice)
                        .Term(loanTerm)
                        .Fee(loanFee)
                        .build());

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
}



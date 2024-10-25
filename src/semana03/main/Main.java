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
 *
 * REQUISITOS

 * 1 Reorganize as classes em pacotes (packages):
 *     i. modelo 1. Classe: a. Financiamento
 *     ii. util 1. Classe: a. InterfaceUsuario
 *     iii. main 1. Classe: a. Main
 * 2 Classe Financiamento (no pacote modelo):
 *     i. Todos os atributos devem ser privados.
 *     ii. Todos os métodos devem ser públicos.
 *     iii. Inclua um getter para cada um dos atributos privados.
 * 3 Classe InterfaceUsuario (no pacote util):
 *     i. Ajuste os métodos de entrada de dados (valor do imóvel, prazo de financiamento e taxa de juros) para que usem estruturas condicionais (como if/else ou switch) dentro dos seus métodos para verificar se as entradas fornecidas pelo usuário são válidas.
 *     ii. Aceite somente valores positivos para o valor do imóvel, prazo do financiamento e taxa de juros anual.
 *     iii. Use estruturas de repetição (como do, do-while ou for). Se algum dos valores for inválido, o programa deve informar ao usuário sobre o erro e solicitar que ele insira novamente os dados.
 * 4 Mostrar na tela uma mensagem contendo os dados do financiamento
 * 5 Testar  valores inválidos:
 *     i. valor do imóvel negativo,
 *     ii. taxa de juros muito alta (como 100.000.000% por ano)
 *     iii. prazo de financiamento negativo?
 */

package semana03.main;


import semana03.model.Loan;
import semana03.model.LoanBuilder;
import semana03.util.UserInterface;


/**
 * Classe PRINCIPAL. Contem o loop central da aplicação.
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {

        // instancia e inicializa a interface
        UserInterface appInterface = UserInterface.getInstance().initialize();

        // instancia as variaveis
        double propertyPrice ;
        int loanTerm ;
        double loanFee ;
        boolean running;

        // loop principal da apliacação. termina somente quando usuario pede para sair
        do {

            appInterface.viewMenu();

            // recebe dados do financiamento
            propertyPrice   = appInterface.getInput().price();
            loanTerm        = appInterface.getInput().term();
            loanFee         = appInterface.getInput().fee();

            // criar objeto financiamento e mostra seus dados
            try {

                Loan model = new LoanBuilder()
                        .Price(propertyPrice)
                        .Term(loanTerm)
                        .Fee(loanFee)
                        .build();

                appInterface.viewLoan(model);

            } catch (IllegalArgumentException e) {
                appInterface.viewException(e);
            }

            running = appInterface.getInput().closeApp();

        }while(running);



        // encerramento da aplicação
        appInterface.closure();

    }
}



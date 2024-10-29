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
 */

package semana05heranca.util;


import semana05heranca.model.Loan;

/**
 * Classe responsável pela interface do usuário. Gerencia a entrada e saída de dados do sistema.
 * Segue padrão singleton para evitar múltiplas instâncias.
 *
 * @author HANDERSON GLEBER
 */
public class UserInterface {

    private static UserInterface instance;
    private InputController inputInstance;

    /**
     * Construtor private para atender o padrão singleton e evitar duas interfaces simultaneamente.
     */
    private UserInterface() {
    }

    /**
     * Criação da instância única da classe e do controlador de entrada.
     *
     * @return UserInterface
     */
    public static UserInterface getInstance() {

        if (instance == null)
            instance = new UserInterface();

        return instance;
    }

    /**
     * Inicializa a interface da aplicação.
     *
     * @return inputInstance
     */
    public UserInterface initialize() {

        inputInstance = InputController.getInstance().initialize();

        return this;
    }

    /**
     * Pergunta se é para encerrar aplicação.
     *
     * @return a resposta em boolean
     */
    public boolean promptExit() {
        return this.Input().promptExit();
    }


    /**
     * @return controlador de entradas do usuário
     */
    public InputController Input() {

        return inputInstance;
    }

    /**
     * Exibe os dados do financiamento
     */
    public void viewLoan(Loan targetLoan) {

        System.out.printf("""
                ┌──────────────────────────────────────────────┐
                │              FINANCIAMENTO nº%04d            │
                │  Prazo: %-5d      Tx Juros: %5.2f /ano      │
                │  Valor do Imóvel: R$%-23.2f  │
                │  Valor do Financiamento: R$%-16.2f  │
                └──────────────────────────────────────────────┘
                """, targetLoan.getId(), targetLoan.getTerm(), targetLoan.getFee(), targetLoan.getPrice(), targetLoan.getPaymentValueTotal());

    }

    /**
     * Exibe um erro.
     */
    public void viewException(Exception e) {

        System.out.printf("""
                
                ╔══════════[ FINANCIAMENTO INVÁLIDO ]══════════╗
                ║                                              ║
                ║  >> %-40s ║
                ╚══════════════════════════════════════════════╝
                
                """, e.getMessage());

        this.waitEnterToContinue();
    }

    /**
     * Exibe valor total dos financiamentos.
     */
    public void viewTotals(double totalProperty, double totalLoan) {

        System.out.printf("""
                
                ╔═════════════════[ TOTAIS ]═══════════════════╗
                ║ Total imóveis: R$%-26.2f  ║
                ║ Total financiamentos: R$%-19.2f  ║
                ╚══════════════════════════════════════════════╝
                
                """, totalProperty, totalLoan);
    }

    /**
     * Exibe mensagem abertura
     */
    public void viewOpening() {

        System.out.println("""
                \033[32m
                ╔══════════════════════════════════════════════╗
                ║       SISTEMA DE FINANCIAMENTO POO v4        ║
                ║      by: HANDERSON GLEBER (Gr4v4t1nh4)       ║
                ╚══════════════════════════════════════════════╝
                \033[0m""");
        this.waitEnterToContinue();
    }

    /**
     * Encerra a interface da aplicação.
     */
    public void viewClosure() {

        System.out.println("""
                \033[32m
                ╔═══════════[ Dúvidas e sugestões? ]═══════════╗
                ║  Email: handerson.gleber@gmail.com           ║
                ║  Instagram: @handersongleber                 ║
                ╚══════════════════════════════════════════════╝
                \033[0m
                """);
        this.waitEnterToContinue();
    }

    public void waitEnterToContinue() {

        this.Input().waitEnterToContinue();
    }

}


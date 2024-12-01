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

package semana08arquivos.ui;


import semana08arquivos.model.Loan;
import semana08arquivos.utils.exceptions.InvalidInputException;

/**
 * Classe responsável pela interface do usuário. Gerencia a entrada e saída de dados do sistema.
 * Segue padrão singleton para evitar múltiplas instâncias.
 *
 * @author HANDERSON GLEBER
 */
public class UserInterface {

    private static UserInterface instance;
    private UserInput inputInstance;

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

        inputInstance = UserInput.getInstance().initialize();

        return this;
    }

    /**
     * Pergunta se é para encerrar aplicação.
     *
     * @return a resposta em boolean
     */
    public boolean promptExit() {

        return inputInstance.promptExit();
    }

    /**
     * Pergunta pela opção do menu.
     *
     * @return a resposta em boolean
     */
    public char promptType(){
        System.out.println("""                
                ╔══════════════════════════════════════════════╗
                ║              MENU DE OPÇÕES                  ║
                ║                                              ║
                ║  (1) Financiamento DE CASA                   ║
                ║  (2) Financiamento DE APARTAMENTO            ║
                ║  (3) Financiamento  DE TERRENO               ║
                ║  (4) Exibir Histórico do Sistema             ║
                ║  (5) SAIR                                    ║
                ╚══════════════════════════════════════════════╝
                """);

        return this.inputInstance.promptType();
    }
    /**
     * @return controlador de entradas do usuário
     */
    public UserInput in() {

        return inputInstance;
    }

    /**
     * Exibe os dados do financiamento
     */
    public void viewLoan(Loan targetLoan) {

        System.out.printf("""
                ┌──────────────────────────────────────────────┐
                │  FINANCIAMENTO nº%3s  - %20s │
                ├──────────────────────────────────────────────┤
                │  Prazo: %-5d      Tx Juros: %5.2f /ano      │
                │  Valor do Imóvel: R$%-23.2f  │
                │  Valor do Financiamento: R$%-16.2f  │
                └──────────────────────────────────────────────┘
                """, targetLoan.getId(), targetLoan.getTypeString(), targetLoan.getTerm(), targetLoan.getFee(), targetLoan.getPrice(), targetLoan.getPaymentValueTotal());

    }

    /**
     * Exibe um erro.
     */
    public void viewException(String error) {

        System.out.printf("""    
                
                ╔══════════[ FALHA  ]════════════════════════════════════════════════════╗
                ║                                                                        ║
                ║ %-70s ║
                ║                                                                        ║
                ╚════════════════════════════════════════════════════════════════════════╝
                """, error);

        this.pressEnterToContinue();
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
                
                ╔══════════════════════════════════════════════╗
                ║  PUCPR - PROGRAMAÇÃO ORIENTADA A OBJETOS     ║
                ╠══════════════════════════════════════════════╣
                ║  SISTEMA SIMULAÇÃO DE FINANCIAMENTO          ║
                ║  VERSÃO 8.0 - IO                             ║
                ║  by: HANDERSON GLEBER (Gr4v4t1nh4)           ║
                ╚══════════════════════════════════════════════╝
                """);
        this.pressEnterToContinue();
    }

    /**
     * Encerra a interface da aplicação.
     */
    public void viewClosure() {

        System.out.println("""
                
                ╔═══════════[ Dúvidas e sugestões? ]═══════════╗
                ║  Email: handerson.gleber@gmail.com           ║
                ║  Instagram: @handersongleber                 ║
                ╚══════════════════════════════════════════════╝
                """);
        System.exit(1);
    }

    public void pressEnterToContinue() {

        System.out.println("[ Pressione <ENTER> para continuar... ]");
        this.inputInstance.pressEnterToContinue();
    }

    public double promptLandArea() {
        System.out.print(" < Digite o tamanho do TERRENO > ");
        return this.inputInstance.promptLandArea();
    }

    public double promptBuildArea() {
        System.out.print(" < Digite o tamanho da AREA CONSTRUÍDA > ");
        return this.inputInstance.promptBuildArea();
    }

    public int promptFloor() {
        System.out.print(" < Digite o ANDAR do apartamento  > ");
        return this.inputInstance.promptFloor();
    }

    public int promptGarages() {
        System.out.print(" < Digite a quantidade de GARAGENS no imóvel > ");
        return this.inputInstance.promptGarages();
    }

    public String promptZone() throws InvalidInputException {

        System.out.print(" < Digite o tipo de zona [1] comercial ou [2] residencial  > ");
        return this.inputInstance.promptZone();

    }
}


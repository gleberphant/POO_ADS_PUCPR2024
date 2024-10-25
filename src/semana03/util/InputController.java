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

package semana03.util;

import java.util.Scanner;


/**
 * Classe 'INPUT'
 * responsável pela entrada de dados pelo usuário
 * Gerencia a entrada de dados do sistema.
 * (validação de dados nessa classe ficaria melhor ? violaria o SRP ?)
 *
 * @author HANDERSON GLEBER
 */
public class InputController {

    private static InputController instance;
    private Scanner inputScanner;

    /**
     * contrutor private. padrão singleton
     */
    private InputController() {}


    /**
     * cria instancia unica da classe
     * @return InputController
     */
    protected static InputController getInstance()
    {

        if(instance == null){
            instance = new InputController();
        }
        return instance;
    }

    /**
     * inicializa a instancia. cria objeto input
     */
    public InputController initialize(){

        if(this.inputScanner == null )
            this.inputScanner = new Scanner(System.in);

        return this;
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     * @return Valor do imóvel.
     */
    public double price() {

        System.out.print("\n > Digite o VALOR do financiamento: ");
        return this.inputScanner.nextDouble();
    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     * @return Prazo do financiamento em meses.
     */
    public int term() {

        System.out.print("\n > Digite o PRAZO do financiamento: ");
        return this.inputScanner.nextInt();
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     * @return Taxa de juros anual.
     */
    public double fee() {

        System.out.print("\n > Digite o valor da TAXA DE JUROS ANUAL: ");
        return this.inputScanner.nextDouble();
    }

    /**
     * Pergunta ao usuario se ele quer fechar a aplicação
     * @return Taxa de juros anual.
     */
    public boolean closeApp() {

        String choice;

        do {

            System.out.print("\n > Deseja realizar um novo financiamento?");
            System.out.print("\n ( Digite S para sim N para não) ");

            choice = this.inputScanner.next().trim().toUpperCase();

            if ( choice.equals("S") ) {
                return true;
            } else if ( choice.equals("N") ) {
                return false;
            }

        } while (true);
    }

}

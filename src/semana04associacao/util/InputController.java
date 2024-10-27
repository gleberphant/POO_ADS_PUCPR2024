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

package semana04associacao.util;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Classe 'INPUT'
 * responsável pela entrada de dados pelo usuário.
 * Gerencia a entrada de dados do sistema.
 * (validação de dados nessa classe ficaria melhor? Violaria o SRP?)
 *
 * @author HANDERSON GLEBER
 */
public class InputController {

    private static InputController instance;
    private Scanner inputScanner;

    /**
     * construtor private. padrão singleton
     */
    private InputController() {
    }


    /**
     * cria instancia única da classe
     *
     * @return InputController
     */
    protected static InputController getInstance() {

        if (instance == null) {
            instance = new InputController();
        }
        return instance;
    }

    /**
     * inicializa a instancia. cria objeto input
     */
    public InputController initialize() {

        if (this.inputScanner == null)
            this.inputScanner = new Scanner(System.in);

        return this;
    }

    /**
     * Solicita ao usuário o valor do imóvel a ser financiado.
     *
     * @return Valor do imóvel.
     */
    public double price() {

        System.out.print(" > Digite o VALOR do financiamento: ");

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Preço inválido. Digite um número decimal.");
        }
    }

    /**
     * Solicita ao usuário o prazo do financiamento em meses.
     *
     * @return Prazo do financiamento em meses.
     */
    public int term() {

        System.out.print(" > Digite o PRAZO do financiamento: ");

        if (this.inputScanner.hasNextInt()) {

            return this.inputScanner.nextInt();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Prazo inválido. Digite um número inteiro.");
        }
    }

    /**
     * Solicita ao usuário a taxa de juros anual do financiamento.
     *
     * @return Taxa de juros anual.
     */
    public double fee() {

        System.out.print(" > Digite o valor da TAXA DE JUROS ANUAL: ");

        if (this.inputScanner.hasNextDouble()) {

            return this.inputScanner.nextDouble();
        } else {

            this.inputScanner.next();
            throw new InputMismatchException("Taxa inválida. Digite um número decimal.");
        }
    }

    /**
     * Pergunta ao usuário se ele quer fechar a aplicação.
     *
     * @return Taxa de juros anual.
     */
    public boolean promptExit() {

        String choice;

        do {

            System.out.println("Deseja realizar um novo financiamento? ( Digite S para sim N para não)");

            choice = this.inputScanner.next().trim().toUpperCase();

            if (choice.equals("S") || choice.equals("1")) {
                return true;
            } else if (choice.equals("N") || choice.equals("2")) {
                return false;
            }

        } while (true);
    }

    public void waitEnterToContinue() {

        System.out.println("\n Pressione <ENTER> para continuar...");
        this.inputScanner.nextLine();

    }
}

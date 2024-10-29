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
import semana05heranca.model.LoanApart;
import semana05heranca.model.LoanHouse;
import semana05heranca.model.LoanLand;

/**
 * Classe 'Builder'. Responsável pela construção dos financiamentos.
 *
 * @version 2
 *  Nessa versão o builder retorna um financiamento de acordo com o tipo
 * @author HANDERSON GLEBER
 */
public class LoanBuilder {
    private int term, id;
    private double price;
    private double fee;
    private char type;

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Id(int id) {

        this.id = id;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Type(char type) {
        this.type = type;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Term(int term) {

        this.term = term;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Price(double price) {

        this.price = price;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     *
     * @return LoanBuilder
     */
    public LoanBuilder Fee(double fee) {

        this.fee = fee;
        return this;
    }

    /**
     * Instancia o objeto Loan
     *
     * @return Loan
     */
    public Loan build() throws IllegalArgumentException {

        return switch (this.type) {
            case '1' -> new LoanHouse(this.id, this.price, this.term, this.fee);
            case '2' -> new LoanApart(this.id, this.price, this.term, this.fee);
            case '3' -> new LoanLand(this.id, this.price, this.term, this.fee);
            default -> throw new IllegalArgumentException("Tipo de  financiamento inexistente");
        };
    }
}

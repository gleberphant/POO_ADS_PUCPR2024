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

package semana04associacao.model;


/**
 * Classe 'Builder'. Responsável pela construção dos financiamentos.
 *
 * @author HANDERSON GLEBER
 */
public class LoanBuilder {
    private int term, id;
    private double price;
    private double fee;

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
     * @return LoanBuilder
     */
    public LoanBuilder Term(int term) {

        this.term = term;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     * @return LoanBuilder
     */
    public LoanBuilder Price(double price) {

        this.price = price;
        return this;
    }

    /**
     * "Método_Construtor" de atributo
     * @return LoanBuilder
     */
    public LoanBuilder Fee(double fee) {

        this.fee = fee;
        return this;
    }

    /**
     * Instancia o objeto Loan
     * @return Loan
     */
    public Loan build() throws IllegalArgumentException {

        return new Loan(this.id, this.price, this.term, this.fee);
    }
}

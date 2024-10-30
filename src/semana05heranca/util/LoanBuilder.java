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
 * @author HANDERSON GLEBER
 * @version 2.0
 */
public class LoanBuilder {
    final public char HOUSE = '1';
    final public char APART = '2';
    final public char LAND = '3';
    private char type;
    // atributos
    private int term, count;
    private double price, fee;
    private String id;

    /**
     * Construtor
     */
    public LoanBuilder() {
        id = "1";
        term = 0;
        count = 0;
        price = 0.0f;
        fee = 0.0f;
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
     *
     * @return LoanBuilder
     */
    public LoanBuilder Type(char type) {
        this.type = type;
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

        // define o id do novo objeto
        this.id = String.valueOf(this.count + 1);

        // Cria o novo objeto
        Loan newLoan = switch (type) {
            case HOUSE -> new LoanHouse(this.id, this.price, this.term, this.fee);
            case APART -> new LoanApart(this.id, this.price, this.term, this.fee);
            case LAND -> new LoanLand(this.id, this.price, this.term, this.fee);
            default -> new Loan(this.id, this.price, this.term, this.fee);
        };

        // incrementar o contador de criação
        this.count++;

        // Retorna objeto criado
        return newLoan;
    }

}

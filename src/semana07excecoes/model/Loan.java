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

package semana07excecoes.model;

import semana07excecoes.exceptions.LoanExceptions;
import semana07excecoes.typedef.loanTypes;

/**
 * Classe que representa o objeto financiamento (model).
 * Os diferentes tipos de financiamento herdam dessa classe.
 * Contêm a validação dos seus atributos.
 *
 * @author HANDERSON GLEBER
 */

public abstract class Loan {

    // Constantes para validação dos atributos. Evita 'magic numbers'.
    protected final String ID_PATTERN;
    protected final float MIN_PRICE, MAX_FEE, MIN_FEE;
    protected final int MAX_TERM, MIN_TERM;

    // atributos do objeto

    private int term;
    private String id;
    private double price, fee;

    // atributo para definir o tipo de financiamento
    protected final loanTypes type;

    /**
     * Construtor
     *
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanExceptions Se o preço, o prazo ou a taxa forem inválidos.
     */
    public Loan(String id, double price, int term, double fee) throws LoanExceptions{

        ID_PATTERN = "^[0-9]\\d*$";
        MIN_PRICE = 0f;
        MAX_FEE = 200f;
        MIN_FEE = 0f;
        MAX_TERM = 600;
        MIN_TERM = 1;

        type = type();
        setLoan(id, price, term, fee);

    }

    /**
     * Setter de todos atributos
     * Para facilitar eventual overload do construtor
     */
    public void setLoan(String id, double price, int term, double fee) throws LoanExceptions {
        setId(id);
        setPrice(price);
        setTerm(term);
        setFee(fee);
    }

    /**
     * Getter de atributo
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter de atributo
     * id do financiamento
     */
    public void setId(String id) {
        if (!id.matches(ID_PATTERN)) {
            throw new LoanExceptions("ID deve ser um número inteiro maior que zero");
        }

        this.id = id;
    }

    /**
     * Getter de atributo
     *
     * @return preço da propriedade
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter de atributo
     * Preço do imóvel do financiamento
     */
    public void setPrice(double price) {
        if (price < MIN_PRICE) {
            throw new LoanExceptions("Preço não pode ser inferior a R$" + MIN_PRICE);
        }

        this.price = price;
    }

    /**
     * Getter de atributo
     *
     * @return quantidade de parcelas
     */
    public int getTerm() {
        return this.term;
    }

    /**
     * Setter de atributo
     * prazo do financiamento em meses
     */
    public void setTerm(int term) {
        if (term > MAX_TERM) {
            throw new LoanExceptions("Prazo não pode ser superior a " + MAX_TERM + "mêses.");
        }

        if (term < MIN_TERM) {
            throw new LoanExceptions("Prazo não pode ser inferior a " + MIN_TERM + " mês.");
        }

        this.term = term;
    }

    /**
     * Getter de atributo
     *
     * @return taxa de juros
     */
    public double getFee() {
        return this.fee;
    }

    /**
     * Setter de atributo
     * taxa de juros por ano.
     */
    public void setFee(double fee) {
        if (fee > MAX_FEE) {
            throw new LoanExceptions("Taxa não pode ser superior a " + MAX_FEE + "%");
        }

        if (fee <= MIN_FEE) {
            throw new LoanExceptions("Taxa não pode ser inferior a " + MIN_FEE + "%");
        }

        this.fee = fee;
    }

    /**
     * Calcula pagamento mensal
     *
     * @return Valor da parcela mensal.
     */
    public double getPaymentValueMonthly() {
        return (this.getPrice() / this.getTerm()) * (1 + (this.getFee() / 12));
    }

    /**
     * Calcula pagamento total
     *
     * @return Valor total do pagamento.
     */
    public double getPaymentValueTotal() {
        return this.getPaymentValueMonthly() * this.getTerm();
    }

    public String getTypeString() {
        return this.type.toString();
    }

    protected loanTypes type(){
        return loanTypes.LOAN;
    }
}


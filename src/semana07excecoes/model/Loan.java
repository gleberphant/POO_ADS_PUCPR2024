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

import semana07excecoes.exceptions.LoanException;
import semana07excecoes.typedef.LoanConstants;
import semana07excecoes.typedef.TypeLoans;


/**
 * Classe que representa o objeto financiamento (model).
 * Os diferentes tipos de financiamento herdam dessa classe.
 * Contêm a validação dos seus atributos.
 *
 * @author HANDERSON GLEBER
 */
public abstract class Loan {

    // atributos do objeto
    private String id;

    // protected StructLoan loan;

    private double price;
    private int term;
    private double fee;

    // atributo para definir o tipo de financiamento
    protected final TypeLoans type;

    /**
     * Construtor
     *
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     */
    public Loan(String id, double price, int term, double fee) throws LoanException {

        type = type();
        setLoan(id, price, term, fee);
    }

    /**
     * Setter de todos atributos
     * Para facilitar eventual overload do construtor
     */
    public void setLoan(String id, double price, int term, double fee) throws LoanException {
        setId(id);
        setPrice(price);
        setTerm(term);
        setFee(fee);
    }

    /**
     * Setter do prazo do financiamento em meses
     *
     * @throws LoanException Se valor não estiver entre MAX_TERM e MIN_TERM
     */
    public void setTerm(int term) throws LoanException {
        if (term > LoanConstants.MAX_TERM) {
            throw new LoanException("Prazo não pode ser superior a " + LoanConstants.MAX_TERM + "mêses.");
        }

        if (term < LoanConstants.MIN_TERM) {
            throw new LoanException("Prazo não pode ser inferior a " + LoanConstants.MIN_TERM + " mês.");
        }

        this.term = term;
    }

    /**
     * Setter da taxa de juros por ano.
     *
     * @throws LoanException Se valor não estiver entre MAX_FEE e MIN_FEE
     */
    public void setFee(double fee) throws LoanException {

        if (fee > LoanConstants.MAX_FEE) {
            throw new LoanException("Taxa não pode ser superior a " + LoanConstants.MAX_FEE + "%");
        }

        if (fee <= LoanConstants.MIN_FEE) {
            throw new LoanException("Taxa não pode ser inferior a " + LoanConstants.MIN_FEE + "%");
        }

        this.fee = fee;
    }

    /**
     * Getter de atributo
     * @return (String) id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter do id do financiamento
     *
     * @throws LoanException ID não for número inteiro maior que zero
     */
    public void setId(String id) throws LoanException {
        if (!id.matches(LoanConstants.ID_PATTERN)) {
            throw new LoanException("ID deve ser um número inteiro maior que zero");
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
     * Setter do Preço do imóvel do financiamento
     *
     * @throws LoanException Se valor menor que MIN_PRICE
     */
    public void setPrice(double price) throws LoanException {
        if (price < LoanConstants.MIN_PRICE) {
            throw new LoanException("Preço não pode ser inferior a R$" + LoanConstants.MIN_PRICE);
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
     * Getter de atributo
     *
     * @return taxa de juros
     */
    public double getFee() {
        return this.fee;
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

    /**
     * Getter de atributo
     *
     * @return tipo em String
     */
    public String getTypeString() {
        return this.type.toString();
    }

    /**
     * Tipo do financiamento. Deve ser subscrito em cada classe herdada.
     * @return o tipo do financiamento
     */
    protected TypeLoans type() {
        return TypeLoans.LOAN;
    }
}


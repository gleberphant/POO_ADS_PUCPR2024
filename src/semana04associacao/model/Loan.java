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
 * Classe de financiamento. Contem métodos para validar atributos.
 *
 * @author HANDERSON GLEBER
 */
public class Loan {

    /**
     * atributos
     */
    private double price;
    private int term;
    private double fee;
    private int id;

    /**
     * Constantes para validação dos atributos. Evita uso de magic numbers.
     */
    private final float MIN_PRICE;
    private final int MAX_TERM;
    private final int MIN_TERM;
    private final float MAX_FEE;
    private final float MIN_FEE;

    /**
     * Construtor
     * inicializa constantes de validação de dados, para evitar uso de MAGIC NUMBERS
     *
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    protected Loan(final int id, final double price, final int term, final double fee) throws IllegalArgumentException {

        //INICIALIZA AS CONSTANTES DE VALIDAÇÃO PARA EVITAR O USO DE MAGIC NUMBERS
        MIN_PRICE = 0f;
        MAX_TERM = 1000;
        MIN_TERM = 1;
        MAX_FEE = 200f;
        MIN_FEE = 0f;

        //SETA OS ATRIBUTOS
        this.setId(id);
        this.setPrice(price);
        this.setTerm(term);
        this.setFee(fee);
    }

    /**
     * Setter de atributo
     * id do financiamento
     */
    public void setId(int id) {

        if (id < 0) {
            throw new IllegalArgumentException("ID não pode ser negativo");
        }

        this.id = id;
    }

    /**
     * Setter de atributo
     * Preço do imóvel do financiamento
     */
    public void setPrice(double price) {

        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("Preço não pode ser inferior a R$" + MIN_PRICE);
        }

        this.price = price;
    }

    /**
     * Setter de atributo
     * prazo do financiamento em meses
     */
    public void setTerm(int term) {

        if (term > MAX_TERM) {
            throw new IllegalArgumentException("Prazo não pode ser superior a " + MAX_TERM + "mêses.");
        }

        if (term < MIN_TERM) {
            throw new IllegalArgumentException("Prazo não pode ser inferior a " + MIN_TERM + " mês.");
        }

        this.term = term;
    }

    /**
     * Setter de atributo
     * taxa de juros por ano.
     */
    public void setFee(double fee) {

        if (fee > MAX_FEE) {
            throw new IllegalArgumentException("Taxa não pode ser superior a " + MAX_FEE + "%");
        }

        if (fee <= MIN_FEE) {
            throw new IllegalArgumentException("Taxa não pode ser inferior a " + MIN_FEE + "%");
        }

        this.fee = fee;
    }

    /**
     * Getter de atributo
     *
     * @return id
     */
    public int getId() {

        return this.id;
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
     * @return Valor da parcela mensal.
     */
    public double getPaymentValueMonthly() {

        return (this.getPrice() / this.getTerm()) * (1 + (this.getFee() / 12));
    }

    /**
     * @return Valor total do pagamento.
     */
    public double getPaymentValueTotal() {

        return this.getPaymentValueMonthly() * this.getTerm();
    }

}


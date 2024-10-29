package semana05heranca.model;

public class LoanLand extends Loan {

    /**
     * Construtor
     *
     * @param id
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanLand(int id, double price, int term, double fee) throws IllegalArgumentException {
        super(id, price, term, fee);
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * 1.02;
    }

}

package semana05heranca.model;

public class LoanHouse extends Loan {
    private final double INSURANCE_VALUE;

    /**
     * Construtor
     *
     * @param id
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws IllegalArgumentException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanHouse(int id, double price, int term, double fee) throws IllegalArgumentException {
        super(id, price, term, fee);
        INSURANCE_VALUE = 80;
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() + INSURANCE_VALUE;
    }
}

package semana05heranca.model;

import static java.lang.Math.pow;

public class LoanApart extends Loan {

    public LoanApart(int id, double price, int term, double fee) throws IllegalArgumentException {
        super(id, price, term, fee);

    }

    @Override
    public double getPaymentValueMonthly() {
        double mensalFee = getFee() / 12;

        return (this.getPrice() * pow(1 + mensalFee, this.getTerm())) / pow(1 + mensalFee, this.getTerm() - 1);
    }
}

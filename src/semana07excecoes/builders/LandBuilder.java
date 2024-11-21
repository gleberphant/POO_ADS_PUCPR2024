package semana07excecoes.builders;

import semana07excecoes.exceptions.LoanExceptions;
import semana07excecoes.model.Loan;
import semana07excecoes.model.LoanLand;

public class LandBuilder extends LoanBuilder {
    private String zone;

    public LandBuilder Zone(String zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public Loan build() throws LoanExceptions {

        // Cria o novo objeto
        Loan newLoan = new LoanLand(getId(), getPrice(), getTerm(), getFee(), this.zone);

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }
}

package semana07excecoes.builders;

import semana07excecoes.exceptions.LoanExceptions;

import semana07excecoes.model.LandLoan;

public class LandBuilder extends LoanBuilder {
    private String zone;

    public LandBuilder Zone(String zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public LandLoan build() throws LoanExceptions {

        // Cria o novo objeto
        LandLoan newLoan = new LandLoan(getId(), getPrice(), getTerm(), getFee(), this.zone);

        // incrementar o contador de criação
        nextCount();

        // Retorna objeto criado
        return newLoan;
    }
}

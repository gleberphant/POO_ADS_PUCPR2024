/**
 * a. Casa:
 * i. O banco inclui um valor do seguro obrigatório do financiamento para cada casa financiada. Portanto, inclua um valor adicional de R$ 80 para cada parcela.
 * ii. Este valor de R$ 80 deve ser adicionado depois de ter calculado o valor de cada parcela com os juros.
 * a. Casa:
 * i. Incluir um atributo para o tamanho da área construída, e outro atributo para o tamanho do terreno.
 */
package semana07excecoes.model;

import semana07excecoes.exceptions.LoanExceptions;
import semana07excecoes.typedef.loanTypes;

public class HouseLoan extends Loan {

    private double insurance;
    private double buildArea;
    private double landArea;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanExceptions Se o preço, o prazo ou a taxa forem inválidos.
     */
    public HouseLoan(String id, double price, int term, double fee, double buildArea, double landArea) throws LoanExceptions {

        super(id, price, term, fee);
        setBuildArea(buildArea);
        setInsurance(80);
        setLandArea(landArea);
    }

    @Override
    protected loanTypes type(){
        return loanTypes.HOUSE;
    }

    @Override
    public double getPaymentValueMonthly() {

        return super.getPaymentValueMonthly() + insurance;
    }

    public void setInsurance(double insuranceVALUE) {
        this.insurance = insuranceVALUE;
    }

    public void setBuildArea(double buildArea) {
        this.buildArea = buildArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getBuildArea() {
        return buildArea;
    }

    public double getLandArea() {
        return landArea;
    }
}

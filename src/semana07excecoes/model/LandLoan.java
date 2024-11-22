/**
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 * c. Terreno:
 * i. Incluir um atributo para o tipo de zona (exemplo: residencial ou comercial).
 */

package semana07excecoes.model;

import semana07excecoes.exceptions.LoanExceptions;
import semana07excecoes.typedef.loanTypes;
import semana07excecoes.typedef.zoneTypes;

public class LandLoan extends Loan {

    private zoneTypes zone;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanExceptions Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LandLoan(String id, double price, int term, double fee, String zone) throws LoanExceptions {

        super(id, price, term, fee);
        setZone(zone);

    }

    @Override
    protected loanTypes type(){
        return loanTypes.LAND;
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * 1.02;
    }

    public String getZone() {
        return this.zone.toString();
    }

    public void setZone(String value){
        this.zone = zoneTypes.valueOf(value);
    }
}

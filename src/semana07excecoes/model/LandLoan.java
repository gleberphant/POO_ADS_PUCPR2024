/**
 * c. Terreno:
 * i. Financiar terrenos possui um risco de inadimplência maior por parte dos compradores.
 * ii. Por isso, cada parcela precisa ter um acréscimo de 2% sobre o seu valor com os juros já incluídos previamente.
 * c. Terreno:
 * i. Incluir um atributo para o tipo de zona (exemplo: residencial ou comercial).
 */

package semana07excecoes.model;

import semana07excecoes.exceptions.LoanException;
import semana07excecoes.typedef.TypeLoans;
import semana07excecoes.typedef.TypeZones;

public class LandLoan extends Loan {

    private TypeZones zone;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanException Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LandLoan(String id, double price, int term, double fee, String zone) throws LoanException {

        super(id, price, term, fee);
        setZone(zone);

    }

    public void setZone(String value) throws LoanException {
        if (value.isEmpty()) {
            throw new LoanException("Tipo de zona precisa ser definido em COMERCIAL ou RESIDENCIAL");
        }
        this.zone = TypeZones.valueOf(value);
    }

    @Override
    public double getPaymentValueMonthly() {
        return super.getPaymentValueMonthly() * 1.02;
    }

    public String getZone() {
        return this.zone.toString();
    }

    @Override
    protected TypeLoans type() {
        return TypeLoans.LAND;
    }

}

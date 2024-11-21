/**
 * b. Apartamento:
 * i. De acordo com as regras do banco, todos os financiamentos de apartamentos deverão usar um sistema de amortização chamado PRICE. Este sistema já é usado por vários bancos.
 * <p>
 * <p>
 * b. Apartamento:
 * i. Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
 */


package semana07excecoes.model;

import semana07excecoes.exceptions.LoanExceptions;
import semana07excecoes.typedef.loanTypes;

import static java.lang.Math.pow;

public class LoanApart extends Loan {


    // atributos exclusivos da classe filha
    private int floorNumber, garagesCount;

    /**
     * Construtor
     *
     * @param id    código de identificação
     * @param price O preço do bem a ser financiado.
     * @param term  O prazo do financiamento em meses.
     * @param fee   A taxa de juros do financiamento.
     * @throws LoanExceptions Se o preço, o prazo ou a taxa forem inválidos.
     */
    public LoanApart(String id, double price, int term, double fee, int floorNumber, int garagesCount) throws LoanExceptions {
        super(id, price, term, fee);
        setFloorNumber(floorNumber);
        setGaragesCount(garagesCount);
    }

    @Override
    protected loanTypes type(){
        return loanTypes.APARTMENT;
    }

    @Override
    public double getPaymentValueMonthly() {
        double mensalFee = getFee() / 12;

        return (this.getPrice() * pow(1 + mensalFee, this.getTerm())) / pow(1 + mensalFee, this.getTerm() - 1);
    }

    public void setGaragesCount(int garagesCount) {
        this.garagesCount = garagesCount;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getGaragesCount() {
        return garagesCount;
    }


}

package semana07excecoes.typedef;

/**
 * Constantes para validação de dados de financiamento.
 */
public abstract class LoanConstants {
    /**
     * Expressão regular para validar IDs.
     */
    public static final String ID_PATTERN = "^[0-9]\\d*$";

    /**
     * Valor mínimo para o preço.
     */
    public static final float MIN_PRICE = 0.0f;

    /**
     * Valor máximo para a taxa.
     */
    public static final float MAX_FEE = 200f;

    /**
     * Valor mínimo para a taxa.
     */
    public static final float MIN_FEE = 0.0f;

    /**
     * Valor máximo para o prazo.
     * **Atenção:** Verifique se o valor 0 está correto.
     */
    public static final int MAX_TERM = 600;

    /**
     * Valor mínimo para o prazo.
     * **Atenção:** Verifique se o valor 0 está correto.
     */
    public static final int MIN_TERM = 0;

}

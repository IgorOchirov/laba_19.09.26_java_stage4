package bank;

/**
 * Политика расчёта комиссии за перевод.
 */
public interface CommissionPolicy {

    /**
     * Считает комиссию с суммы перевода.
     *
     * @param amount сумма перевода без комиссии
     * @return сумма комиссии
     */
    double calculate(double amount);
}

package bank;

/**
 * Комиссия в процентах от суммы перевода.
 * Например, percent = 1 значит, что с 10 000 рублей удержится 100.
 */
public class PercentCommission implements CommissionPolicy {

    private final double percent;

    public PercentCommission(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Процент комиссии не может быть отрицательным");
        }
        this.percent = percent;
    }

    @Override
    public double calculate(double amount) {
        return amount * percent / 100;
    }

    public double getPercent() {
        return percent;
    }
}

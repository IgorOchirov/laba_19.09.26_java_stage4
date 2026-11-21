package bank;

/**
 * Политика без комиссии: комиссия всегда равна нулю.
 */
public class NoCommission implements CommissionPolicy {

    @Override
    public double calculate(double amount) {
        return 0;
    }
}

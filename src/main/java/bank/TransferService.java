package bank;

/**
 * Сервис переводов между счетами. Работает с любым типом счёта:
 * правила списания определяет сам счёт через метод {@link BankAccount#withdraw(double)}.
 * Комиссия считается по переданной {@link CommissionPolicy}.
 */
public class TransferService {

    private final CommissionPolicy commissionPolicy;

    public TransferService(CommissionPolicy commissionPolicy) {
        if (commissionPolicy == null) {
            throw new IllegalArgumentException("Политика комиссии не может быть null");
        }
        this.commissionPolicy = commissionPolicy;
    }

    /**
     * Переводит деньги с одного счёта на другой.
     * С отправителя списывается сумма перевода плюс комиссия, получатель получает
     * только сумму перевода. Если списать всю сумму с комиссией не удалось,
     * баланс получателя не меняется.
     *
     * @param from   счёт отправителя
     * @param to     счёт получателя
     * @param amount сумма перевода, должна быть больше нуля
     * @return {@code true}, если перевод выполнен
     */
    public boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || from == to || amount <= 0) {
            return false;
        }

        double commission = commissionPolicy.calculate(amount);
        if (!from.withdraw(amount + commission)) {
            return false;
        }

        to.deposit(amount);
        return true;
    }
}

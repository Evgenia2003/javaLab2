package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.entity.common.Account;

@Getter
@Setter
public class PaymentAccount extends Account {
   private Double sum;

    public PaymentAccount(Integer id, User user, Bank bank) {
        super(id,user,bank);
        this.sum = 0.0D;
    }

    @Override
    public String toString() {
        String str = "\nPaymentAccount\nid " + id +
                "\nБанк: " + bank.getName() +
                "\nПользователь: " + user.getFullName() +
                "\nСумма денег: " + String.format("%.2f",sum) +
                "\n";
        return str;
    }
}

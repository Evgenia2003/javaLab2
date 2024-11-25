package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.entity.common.Account;

import java.time.LocalDate;

@Getter
@Setter
public class CreditAccount extends Account {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer countMonth;
    private Double amount;
    private Double mountsPayment;


    private Double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                         LocalDate startDate, Integer countMonth, Double amount ) {
        super(id,user,bank);
        this.startDate = startDate;
        this.countMonth = countMonth;
        this.endDate = startDate.plusMonths(this.countMonth);
        this.amount = amount;
        this.interestRate = bank.getInterestRate();
        this.mountsPayment = (1+ interestRate/100)*amount/countMonth;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        String str = "\nCreditAccount \nid: " + id +
                "\nБанк: " + bank.getName() +
                "\nПользователь: " + user.getFullName() +
                "\nКоличество месяцев: " + countMonth +
                "\nПромежутки: " + startDate.toString() + " - " + endDate.toString() +
                "\nСумма кредита: " + String.format("%.2f",amount) +
                "\nПроцентная ставка: " + String.format("%.2f",interestRate) + "%" +
                "\nЕжемесячный платёж: " + String.format("%.2f",mountsPayment) +
                "\nСотрудник, который выдал кредит: " + employee.getFullName() +
                "\nId платёжного счёта: " + paymentAccount.getId().toString()+
                "\n";
        return str;
    }
}

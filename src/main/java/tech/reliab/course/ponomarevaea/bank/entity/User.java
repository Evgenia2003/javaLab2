package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.entity.common.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class User extends Person {
    private String work;
    private Double monthSalary;
    private ArrayList<Bank> banks;
    private ArrayList<CreditAccount> creditAccounts;
    private ArrayList<PaymentAccount> paymentAccounts;
    private Integer creditRating;

    public User(Integer id, String name, String surname, Date birthday, String work) {
        super(id,name,surname,birthday);
        this.setWork(work);
        Random random = new Random();
        this.setMonthSalary(random.nextDouble(1, 10000));
        int creditRating = 0;
        Integer startRat = 0;
        Integer endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((getMonthSalary() <= endRat) && (getMonthSalary() >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        this.creditRating = creditRating;
        this.banks = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
        this.creditAccounts = new ArrayList<>();
    }


    @Override
    public String toString() {
        String str =  "\nUser\nИмя: " + getFullName() +
                "\nДата рождения: " + birthday +
                "\nРабота: " + work +
                "\nЗарплата: " + String.format("%.2f",monthSalary);
        if (banks == null){
            str += "\nБанк: пусто";
        }
        else {
            str += "\nКол-во банков: " + banks.size();
        }

        if (getCreditAccounts() == null){
            str += "\nКредитный аккаунт: пусто";
        }
        else {
            str += "\nКоличество кредитных аккаунтов: " + getCreditAccounts().size();
        }

        if (getPaymentAccounts() == null){
            str += "\nПлатёжный аккаунт: пусто";
        }
        else {
            str += "\nКоличество платёжных аккаунтов: " + getPaymentAccounts().size();
        }
        str += "\nКредитный рейтинг: " + creditRating;
        return str;
    }
}

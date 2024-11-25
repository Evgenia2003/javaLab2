package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.entity.common.Person;

import java.util.Date;

@Getter
@Setter
public class Employee extends Person {
    private String job;
    private Bank bank;
    private Boolean distantWork;
    private BankOffice bankOffice;

    private BankATM bankATM;
    private Boolean canLend;
    private Double salary;

    public Employee(Integer id, String name, String surname, Date birthday,  String job, Double salary ) {

        super(id,name,surname,birthday);
        this.bank = null;
        this.job = job;
        this.salary = salary;
        this.distantWork = true;
        this.canLend = true;
        this.bankOffice= null;
        this.bankATM = null;
    }

    @Override
    public String toString() {
        String str =  "\nEmployee \nИмя: " + getFullName() +
                "\nДата рождения: " + birthday +
                "\nДолжность: " + job +
                "\nБанк: " + bank.getName();
        if (!distantWork){
            str += "\nРаботает в офисе " + bankOffice.getName();

            if (canLend){
                str += "\nМожет выдавать кредиты";
            }
            else{
                str += "\nНе Может выдавать кредиты";
            }
        }
        else{
            str += "\nРаботает удалённо";
        }

        str += "\nЗарплата: " + String.format("%.2f", salary);

        return str;
    }
}

package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.utils.StatusATM;

@Getter
@Setter
public class BankATM {
    private Integer id;
    private String name;
    private BankOffice bankOffice;
    private StatusATM status;
    private Bank bank;
    private  Employee employee;
    private Boolean canPayMoney;
    private Boolean canDepositMoney;
    private Double money;
    private Double maintenanceCost;


    public BankATM(Integer id, String name, StatusATM status, Double maintenanceCost) {

        this.id = id;
        this.name = name;
        this.status = status;
        this.canPayMoney = false;
        this.canDepositMoney = false;
        this.maintenanceCost = maintenanceCost;
        this.bank = null;
        this.employee = null;
        this.money = 0.0D;
        this.bankOffice = null;
    }

    @Override
    public String toString(){
        String str =  "\nBankAtm\nНазвание банкомата: " + name;
        if (bankOffice != null)
           str += "\nАдрес: " + bankOffice.getAddress();
        else {
            str += "Находится на складе банка.";
            return str;
        }
        str += "\nСтатус: ";
        switch (status){
            case Work-> str += "Работает";
            case NotWork-> str += "Не работает";
            case NoMoney-> str += "Нет денег";
        }
        str += "\nОбслуживающий сотрудник: " + employee.getFullName();
        if (canPayMoney){
            str += "\nРаботает на выдачу денег";
        }
        else{
            str += "\nНе работает на выдачу денег";
        }
        if (canDepositMoney){
            str += "\nМожно внести деньги";
        }
        else{
            str += "\nНельзя внести деньги";
        }
        str += "\nДенежная сумма: " + String.format("%.2f",money) +
                "\nСтоимость обслуживания: " + String.format("%.2f",maintenanceCost);
        return str;
    }
}

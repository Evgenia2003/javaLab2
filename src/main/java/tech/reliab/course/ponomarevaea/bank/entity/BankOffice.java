package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BankOffice{
    private Integer id;
    private String name;
    private Bank bank;
    private String address;
    private Boolean status;
    private Boolean maySetATM;
    private ArrayList<BankATM> bankATMS;
    private ArrayList<Employee> employees;
    private Boolean mayApplyCredit;
    private Boolean mayWithdrawMoney;
    private Boolean mayDepositMoney;
    private Double money;
    private Double rentCost;

    public BankOffice( Integer id, String name, String address, Boolean status,
                       Double rentCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.maySetATM = true;
        this.bankATMS = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.mayDepositMoney = true;
        this.mayApplyCredit = true;
        this.mayWithdrawMoney = true;
        this.money = 0.0D;
        this.rentCost = rentCost;
    }


    @Override
    public String toString() {
        String str =  "\nBankOffice \nНазвание офиса: " + name +
                "\nБанк: " + bank.getName() +
                "\nАдрес: " + address +
                "\nСтатус: ";
        if (status){
            str+= "работает";
        }
        else{
            str+= "не работает";
        }
        if (maySetATM){
            str += "\nМожно размещать банкоматы";
        }
        else{
            str += "\nНельзя размещать банкоматы";
        }

        if (maySetATM){
            str += "\nКоличество банкоматов: " + bankATMS.size();
        }

        str += "\nКоличество сотрудников: " + getEmployees().size();

        if (mayWithdrawMoney){
            str += "\nРаботает на выдачу денег";
        }
        else{
            str += "\nНе работает на выдачу денег";
        }

        if (mayDepositMoney){
            str += "\nМожно внести деньги";
        }
        else{
            str += "\nНельзя внести деньги";
        }
        str += "\nДенежная сумма: " + String.format("%.2f",money) +
                "\nАрендная плата: " + String.format("%.2f",rentCost);

        return str;
    }

    public void addBankATMS(BankATM bankATM) {
        this.bankATMS.add(bankATM);
    }

    public void addEmployees(Employee employee) {
        this.employees.add(employee);
    }
}

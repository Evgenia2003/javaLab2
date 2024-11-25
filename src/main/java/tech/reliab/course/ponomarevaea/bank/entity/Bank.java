package tech.reliab.course.ponomarevaea.bank.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Bank {
    private Integer id;
    private String name;
    private ArrayList<BankOffice> bankOffices;
    private ArrayList<BankATM> bankATMS;
    private ArrayList<Employee> employees;
    private ArrayList<User> clients;
    private Integer rating;
    private Double money;
    private Double interestRate;

    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.bankOffices = new ArrayList<>();
        this.bankATMS = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
        Random random = new Random();
        this.rating = random.nextInt(0, 100);
        this.money = random.nextDouble(0, 1000000000);
        this.interestRate = 20.0- this.getRating() /5.0;;
    }

    @Override
    public String toString(){
        return "\nBank \nНазвание банка: " + name +
                "\nКоличество офисов: " + getBankOffices().size() +
                "\nКоличество банкоматов: " + getBankATMS().size() +
                "\nКоличество сотрудников: " + getEmployees().size() +
                "\nКоличество клиентов: " + getClients().size() +
                "\nРейтинг: " + rating +
                "\nДенежная сумма: " + String.format("%.2f",money) +
                "\nПроцентная ставка: " + String.format("%.2f",interestRate);
    }

    public void addBankOffice(BankOffice bankOffice) {
        this.bankOffices.add(bankOffice);
    }

    public void addBankATM(BankATM bankATM) {
        this.bankATMS.add(bankATM) ;
    }

    public void addEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public void addClients(User client) {
        this.clients.add(client);
    }
}
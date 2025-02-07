package tech.reliab.course.ponomarevaea.bank.service.impl;

import tech.reliab.course.ponomarevaea.bank.entity.BankATM;
import tech.reliab.course.ponomarevaea.bank.entity.Employee;
import tech.reliab.course.ponomarevaea.bank.service.EmployeeService;

import java.util.Date;
import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee create(Integer id, String name, String surname, Date birthday, String job, Double salary) {
        return new Employee(id, name, surname, birthday, job, salary);
    }

    @Override
    public void toDistantWork(Employee employee) {
        employee.setDistantWork(Boolean.TRUE);
        permissionForCredit(employee, false);
    }

    @Override
    public void toOfficeWork(Employee employee) {

        employee.setDistantWork(Boolean.FALSE);
        permissionForCredit(employee, true);
    }

    @Override
    public void permissionForCredit(Employee employee, Boolean flag){
        employee.setCanLend(flag);

    }

    @Override
    public void setWorkerToBankomat(BankATM bankATM, Employee employee){
        if (!Objects.equals(bankATM.getBankOffice(),employee.getBankOffice())){
            System.out.println("Рабочий и банкомат не находятся в 1 офисе");
        }
        else if (Objects.equals(bankATM.getEmployee(),employee))
            return;
        else {
            employee.setBankATM(bankATM);
            bankATM.setEmployee(employee);
            AtmServiceImpl atmService = new AtmServiceImpl();
            atmService.turnOnATM(bankATM);
        }
    }

    @Override
    public void removeWorkerFromBankomat(BankATM bankATM, Employee employee){
        if (!Objects.equals(employee.getBankATM(),bankATM))
            return;
        AtmServiceImpl atmService = new AtmServiceImpl();
        bankATM.setEmployee(null);
        employee.setBankATM(null);
        atmService.turnOffATM(bankATM);
    }
}

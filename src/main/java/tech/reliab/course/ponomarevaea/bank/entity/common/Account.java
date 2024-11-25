package tech.reliab.course.ponomarevaea.bank.entity.common;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.ponomarevaea.bank.entity.Bank;
import tech.reliab.course.ponomarevaea.bank.entity.User;

@Getter
@Setter
abstract public class Account {
    protected Integer id;
    protected User user;
    protected Bank bank;

    public Account(Integer id, User user, Bank bank){
        this.id = id;
        this.user = user;
        this.bank = bank;
    }
}

package tech.reliab.course.ponomarevaea.bank.entity.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
abstract public class Person {
    protected Integer id;
    protected String name;
    protected String surname;
    protected String middleName = null;
    protected Date birthday;

    public Person(Integer id, String name, String surname, Date birthday){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getFullName(){
        String str = getName();
        if (getMiddleName() != null)
            str += " " + getMiddleName();
        str += " " + getSurname();
        return str;
    }
}

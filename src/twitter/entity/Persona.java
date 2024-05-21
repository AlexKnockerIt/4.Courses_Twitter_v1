package twitter.entity;

import java.time.LocalDate;

public class Persona extends User{
    private String name;
    private String serName;
    private LocalDate dateBerth;

    public Persona() {
        super();
        this.userType = UserType.PERSON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public LocalDate getDateBerth() {
        return dateBerth;
    }

    public void setDateBerth(LocalDate dateBerth) {
        this.dateBerth = dateBerth;
    }

    @Override
    public String toString() {
        return        System.lineSeparator() + this.userType + " { "+ System.lineSeparator() +
                "     Имя: " + this.name + System.lineSeparator() +
                "     Фамилия: " + this.serName + System.lineSeparator() +
                "     Дата рождения: " + this.dateBerth + System.lineSeparator() +
                "     ID: " + this.id + System.lineSeparator() +
                "     Логин: " + this.login + System.lineSeparator() +
                "     Дата создания аккаунта: " + this.dateCreate + System.lineSeparator() +
                '}' + System.lineSeparator();
    }

}

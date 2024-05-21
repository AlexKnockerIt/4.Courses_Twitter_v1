package twitter.entity;

import java.time.LocalDate;

public class Organization extends User{
    private String title;
    private String occupation;
    private LocalDate dateFounding;

    public Organization() {
        super();
        this.userType = UserType.ORGANIZATION;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LocalDate getDateFounding() {
        return dateFounding;
    }

    public void setDateFounding(LocalDate dateFounding) {
        this.dateFounding = dateFounding;
    }

    @Override
    public String toString() {
        return        System.lineSeparator() + this.userType + " { "+ System.lineSeparator() +
                "     Название организации: " + this.title + System.lineSeparator() +
                "     Род деятельности: " + this.occupation+ System.lineSeparator() +
                "     Дата основания: " + this.dateCreate + System.lineSeparator() +
                "     ID: " + this.id + System.lineSeparator() +
                "     Логин: " + this.login + System.lineSeparator() +
                "     Дата создания аккаунта: " + this.dateCreate + System.lineSeparator() +
                '}' + System.lineSeparator();
    }
}

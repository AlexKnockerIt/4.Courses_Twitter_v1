package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.entity.Organization;
import twitter.entity.Persona;
import twitter.entity.User;
import twitter.entity.UserType;
import twitter.exception.BaseException;
import twitter.exception.DateBirthIncorrectException;
import twitter.exception.InCorrectPasswordException;
import twitter.exception.RegisterException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

@CommandDescription(title = "register", description = " - Команда для регистрации нового пользователя.")
public class Register implements Execute {
private UserHandler userHandler;
private Scanner input;
    public Register(UserHandler userHandler, Scanner input) {
        this.userHandler = userHandler;
        this.input = input;
    }

    @Override
    public void executeCommand() throws BaseException {

        System.out.println("<<<<<<<<<<<<<<<<  Регистрация >>>>>>>>>>>>>>>>>>>>>>");
        UserType userType;

        while (true) {
            try {
                System.out.println("Выберите тип пользователя: 0 - человек, 1 - организация");
                userType = UserType.values()[input.nextInt()];
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                    throw new RegisterException("Неверно введен тип пользователя регистрация прервана");
                }
        }
        if(Objects.isNull(userType)){
            throw new RegisterException("Неверно введен тип пользователя регистрация прервана");
        }
        User user;
        System.out.print("Введите логин :");
        String login = this.input.nextLine();
        if(Objects.isNull(login) || login.isEmpty()){
            login = this.input.nextLine();
        }
        System.out.print("Введите пароль: ");
        String password = input.nextLine();
        System.out.print("Повторите пароль: ");

        if(!password.equals(input.nextLine())){
            throw new InCorrectPasswordException("Некорректный пароль");
        }

        if(userType.equals(UserType.PERSON)){
            user = setPerson();
        }else {
            user = setOrganization();
        }
        if(Objects.isNull(user)){
            throw new RegisterException("Во время регистрации произошла ошибка регистрация прервана");
        }
        user.setLogin(login);
        user.setPassword(password);

        this.userHandler.saveLogin(user);

    }

    public User setPerson() throws BaseException {
        Persona persona = new Persona();
        System.out.print("Введите имя: ");
        persona.setName(this.input.nextLine());
        System.out.print("Введите фамилию: ");
        persona.setSerName(this.input.nextLine());

        try {
            System.out.print("Введите дату рождения в формате гггг-мм-дд: ");
            persona.setDateBerth(LocalDate.parse(input.nextLine()));
        }catch (DateTimeParseException e) {
            throw new DateBirthIncorrectException("Неверный ввод даты");
        }
        return persona;
    }
    public User setOrganization() throws BaseException {
        Organization organization = new Organization();
        System.out.print("Введите название организации: ");
        organization.setTitle(this.input.nextLine());
        System.out.print("Введите род деятельности: ");
        organization.setOccupation(this.input.nextLine());
        try {
            System.out.print("Введите дату основания в формате гггг-мм-дд: ");
            organization.setDateFounding(LocalDate.parse(input.nextLine()));
        }catch (DateTimeParseException e) {
            throw new DateBirthIncorrectException("Неверный ввод даты");
        }
        return organization;
    }
}

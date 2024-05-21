package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.entity.User;
import twitter.exception.BaseException;
import twitter.exception.LoginException;

import java.util.Objects;
import java.util.Scanner;

@CommandDescription(title = "login", description = " - Команда входа в систему")
public class Login implements Execute {

    private UserHandler userHandler;
    private Scanner input;

    public Login(UserHandler userHandler, Scanner input) {
        this.userHandler = userHandler;
        this.input = input;
    }

    @Override
    public void executeCommand() throws BaseException {

        if(Objects.nonNull(this.userHandler.getAuth())){
            throw new LoginException("!!!В системе уже есть авторизированный пользователь!!!");
        }
        System.out.println("<<<<<Вход в систему>>>>>");
        User user;
        System.out.print("Введите логин: ");
        this.input.nextLine();
        user = this.userHandler.getLogin(this.input.nextLine());
        if(Objects.isNull(user)){
            throw new LoginException("Неверный логин!");
        }
        System.out.print("Введите пароль: ");
        if(!user.getPassword().equals(this.input.nextLine())){
            throw new LoginException("Неверный пароль!");
        }
        System.out.println("Вы вошли в систему");
        this.userHandler.setAuth(user);
    }
}

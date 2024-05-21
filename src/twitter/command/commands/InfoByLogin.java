package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.exception.AuthException;
import twitter.exception.BaseException;

import java.util.Objects;
import java.util.Scanner;

@CommandDescription(title = "InfoByLogin", description = "Вывод информации по логину пользователя")
public class InfoByLogin implements Execute {
    private UserHandler userHandler;
    private Scanner input;


    public InfoByLogin(UserHandler userHandler, Scanner input) {
        this.userHandler = userHandler;
        this.input = input;
    }

    @Override
    public void executeCommand() throws BaseException {
        if (!Objects.isNull(this.userHandler.getAuth())){
            System.out.println("Введите логин пользователя информацию которого нужно найти: ");
            String login = this.input.next();
            this.userHandler.infoByLogin(login);
        }else {
            throw new AuthException("Нельзя запросить информацию,для начала авторизируйтесь!!!");
        }
    }
}

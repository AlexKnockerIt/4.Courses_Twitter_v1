package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.exception.AuthException;
import twitter.exception.BaseException;

import java.util.Objects;

@CommandDescription(title = "info_all_user", description = "Выводит информацию о всех пользователях")
public class InfoAllUser implements Execute {

    private UserHandler userHandler;

    public InfoAllUser(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Override
    public void executeCommand() throws BaseException {
        if(!Objects.isNull(this.userHandler.getAuth())){
            System.out.println(this.userHandler.getAll());
        } else {
            throw new AuthException("Нельзя запросить информацию,для начала авторизируйтесь!!!");
        }
    }
}

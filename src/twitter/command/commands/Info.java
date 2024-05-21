package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.exception.AuthException;
import twitter.exception.BaseException;

import java.util.Objects;

@CommandDescription(title = "info", description = " - Команда для вывода информации авторизированного пользователя.")
public class Info implements Execute {
    private UserHandler userHandler;

    public Info(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Override
    public void executeCommand() throws BaseException {
        if(!Objects.isNull(this.userHandler.getAuth())){
            System.out.println(this.userHandler.getAuth());
        }else {
            throw new AuthException("Нельзя запросить информацию,для начала авторизируйтесь!!!");
        }
    }
}


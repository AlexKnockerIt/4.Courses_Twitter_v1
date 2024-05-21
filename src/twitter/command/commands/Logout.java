package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.exception.AuthException;
import twitter.exception.BaseException;

import java.util.Objects;

@CommandDescription(title = "logout", description = " - Команда выхода из системы")
public class Logout implements Execute {
    private UserHandler userHandler;

    public Logout(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Override
    public void executeCommand() throws BaseException {
        if(Objects.isNull(this.userHandler.getAuth())){
            throw new AuthException("Нельзя выйти из системы так как вы не авторизированны!!!");
        }
        // Вы точно хотите выйти
        this.userHandler.userLogout();

    }
}

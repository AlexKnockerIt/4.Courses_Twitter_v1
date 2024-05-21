package twitter.command;

import twitter.command.commands.*;
import twitter.dataHendler.UserHandler;
import twitter.exception.CommandNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandHandler {
    private Map<String,Execute> commandCollect;
    private Scanner scanner;
    private UserHandler userHandler;

    public CommandHandler(Scanner scanner, UserHandler userHandler) {
        this.scanner = scanner;
        this.userHandler = userHandler;
        this.commandCollect = new HashMap<>();
        initCommands();
    }
    private void initCommands(){
        this.commandCollect.put("exit", new Exit(this.scanner));
        this.commandCollect.put("register", new Register(this.userHandler, this.scanner));
        this.commandCollect.put("login", new Login(this.userHandler, this.scanner));
        this.commandCollect.put("logout", new Logout(this.userHandler));
        this.commandCollect.put("info", new Info(this.userHandler));
        this.commandCollect.put("info_by_login", new InfoByLogin(this.userHandler,this.scanner));
        this.commandCollect.put("info_all_user", new InfoAllUser(this.userHandler));
        this.commandCollect.put("help", new Help(new ArrayList<>(this.commandCollect.values())));
    }
    public Execute getCommand(String command) throws CommandNotFoundException {
        if(this.commandCollect.containsKey(command)){
            return this.commandCollect.get(command);
        }
        throw new CommandNotFoundException("Такой команды нет в системе:" +
                " введите команду << help >> что бы получить список команд");
    }


}

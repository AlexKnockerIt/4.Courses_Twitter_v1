package twitter;

import twitter.command.CommandHandler;
import twitter.command.Execute;
import twitter.dataHendler.UserHandler;
import twitter.exception.BaseException;

import java.util.Scanner;

public class Twitter {
    private Scanner input;
    private CommandHandler commandHandler;
    private UserHandler userHandler;

    public Twitter(
            Scanner scanner,
            UserHandler userHandler
    ) {
        this.input = scanner;
        this.userHandler = userHandler;
        this.commandHandler = new CommandHandler(this.input, userHandler);
    }

    public void run(){
        System.out.println("<<<<<<<<<<Добро пожаловать в Твиттер>>>>>>>>>>");
        String commandInput;

        while (true){
            System.out.print("Введите команду: ");
            commandInput = this.input.next();
            try {
                Execute command = this.commandHandler.getCommand(commandInput);
                command.executeCommand();
            }catch (BaseException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

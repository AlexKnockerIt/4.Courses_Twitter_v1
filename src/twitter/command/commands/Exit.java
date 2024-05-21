package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;

import java.util.Scanner;

@CommandDescription(title = "exit", description = " - Команда для завершения программы")
public class Exit  implements Execute {
    private Scanner input;

    public Exit(Scanner input) {
        this.input = input;
    }

    @Override
    public void executeCommand(){
        System.out.println("Выполнена команда выхода из системы.");
        System.out.println("Вы точно хотите выйти: ");
        System.out.println("Введите: << да >>  если хотите выйти");
        System.out.println("Введите: << нет >> если не хотите выйти");
        if(this.input.next().equalsIgnoreCase("да")){
            System.out.println("Спасибо что воспользовались нашей программой ");
            System.exit(0);
        }
    }


}

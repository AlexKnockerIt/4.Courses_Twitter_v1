package twitter.command.commands;

import twitter.command.CommandDescription;
import twitter.command.Execute;

import java.util.List;
import java.util.Objects;

public class Help implements Execute {
    private List<Execute> executeList;

    public Help(List<Execute> executeList) {
        this.executeList = executeList;
    }

    @Override
    public void executeCommand() {
        System.out.println();
        System.out.println("Вывод списка команд");
       for (Execute el: executeList){
           CommandDescription description = el.getClass()
                                        .getAnnotation(CommandDescription.class);
           if(Objects.nonNull(description)){
               System.out.println(description.title() + description.description());
           }
       }
        System.out.println();
    }
}

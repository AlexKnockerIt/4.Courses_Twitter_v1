package twitter.command.commands;

import twitter.command.Execute;
import twitter.dataHendler.PostHandler;
import twitter.dataHendler.UserHandler;
import twitter.entity.Post;
import twitter.exception.AuthException;
import twitter.exception.BaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddPost implements Execute {
    private UserHandler userHandler;
    private PostHandler postHandler;
    private Scanner input;

    public AddPost(UserHandler userHandler, PostHandler postHandler, Scanner input) {
        this.userHandler = userHandler;
        this.postHandler = postHandler;
        this.input = input;
    }

    @Override
    public void executeCommand() throws BaseException {
        if (Objects.isNull(this.userHandler.getAuth())){
            throw new AuthException("Для создания публикации авторизируйтесь");
        }
        Post post = new Post(this.userHandler.getAuth());
        System.out.println(" Создание новой публикации ");
        System.out.println(" Введите тему публикации: ");
        post.setTheme(this.input.nextLine());
        System.out.print("Введите текст публикации");
        post.setTextArea(this.input.nextLine());
        System.out.println("Введите теги для публикации (Поле может быть пустым или теги могут быть разделены через запятую ");
        post.setTags(new ArrayList<String>(List.of(input.nextLine().replace(" ","").split(","))));
        post = this.postHandler.postSave(post);
        System.out.println("Создана новая публикация");
        System.out.println(post);
    }
}

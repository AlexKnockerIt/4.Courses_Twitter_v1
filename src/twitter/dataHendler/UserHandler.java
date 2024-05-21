package twitter.dataHendler;

import twitter.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserHandler {

    private Map<String, User> userMap;
    private User auth;
    private int id = 0;

    public UserHandler() {
        this.userMap = new HashMap<>();
    }

    public User getLogin(String login) {
        return this.userMap.get(login);
    }
    public List<User> getAll(){
        return this.userMap.values().stream().collect(Collectors.toList());
    }

    public User getAuth(){
        return this.auth;
    }
    public void setAuth (User user){
        this.auth = user;
    }
    public void userLogout(){
        this.auth = null;
    }
    public User save(User user){
        this.id++;
        user.setId(this.id);
        this.userMap.put(user.getLogin(), user);
        return user;
    }


    public void saveLogin(User user){
        if (userMap.containsKey(user.getLogin())){
            System.out.println("Такой логин уже существует,регистрацию будет прервана");
        }else {
            this.id++;
            user.setId(this.id);
            this.userMap.put(user.getLogin(), user);
            System.out.println("Регистрация окончена");
            System.out.println(user);
        }
    }

    public void infoByLogin(String login){
        if (this.userMap.containsKey(login)){
            System.out.println("Информация о пользователе: " + login);
            System.out.println(userMap.get(login));
        }else {
            System.out.println("Такого пользователя нет в системе");
        }
    }
}

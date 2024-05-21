package twitter.dataHendler;

import twitter.entity.Post;
import twitter.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class PostHandler {

    private Map<User, List<Post>> postData;
    private int id;
    private static PostHandler instance;
    private PostHandler(){
        this.postData = new HashMap<>();
        this.id = 0;
    }

    public static PostHandler getInstance(){
        if (Objects.isNull(instance)){
            instance = new PostHandler();
        }
        return instance;
    }


    public Post postSave(Post entity) {
        if (!this.postData.containsKey(entity.getAuthor())) {
            this.postData.put(entity.getAuthor(), new ArrayList<>());
        }
        this.id++;
        entity.setId(this.id);
        List<Post> tmp = this.postData.get(entity.getAuthor());
        tmp.add(entity);
        this.postData.put(entity.getAuthor(), tmp);

        return entity;
    }

    public List<Post> getAllPostByUser(User user){
        return this.postData.get(user);
    }

    public List<Post> getAll(){
        List<Post> result = new ArrayList<>();
        for(List<Post> elem : this.postData.values()){
            result.addAll(elem);
        }
        return result;
    }

    public List<Post> getAllPostByTag(String tag){
        List<Post> result = new ArrayList<>();
        for (Post el : getAll()){
            if(el.getTags().contains(tag)){
                result.add(el);
            }
        }
        return result;
    }


}

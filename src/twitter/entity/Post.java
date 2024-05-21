package twitter.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private Integer id;
    private User author;
    private String theme;
    private String textArea;
    private List<String> tags;
    private LocalDateTime createDate;

    public Post(User author) {
        this.author = author;
        this.createDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public Post setId(Integer id) {
        this.id = id;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Post setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public Post setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getTextArea() {
        return textArea;
    }

    public Post setTextArea(String textArea) {
        this.textArea = textArea;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public Post setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Post setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    @Override
    public String toString() {
        return "Post{" +"\n" +
                "id=" + id +"\n" +
                ", author=" + author +"\n" +
                ", theme='" + theme + '\'' +"\n" +
                ", textArea='" + textArea + '\'' +"\n" +
                ", tags=" + tags +"\n" +
                ", createDate=" + createDate +"\n" +
                '}';
    }
}

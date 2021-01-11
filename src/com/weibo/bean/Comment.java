package com.weibo.bean;

public class Comment {
    private Integer id;
    private String content;
    private Integer newsId;
    //评论者的名字
    private String name;

    public Comment() {
    }

    public Comment(Integer id, String content, Integer newsId, String name) {
        this.id = id;
        this.content = content;
        this.newsId = newsId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", newsId=" + newsId +
                ", name='" + name + '\'' +
                '}';
    }
}

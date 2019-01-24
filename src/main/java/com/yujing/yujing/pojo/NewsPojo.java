package com.yujing.yujing.pojo;


/*
CREATE TABLE `news` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(100) DEFAULT NULL,
        `add_date` varchar(45) DEFAULT NULL,
        `source` varchar(45) DEFAULT NULL,
        `onclick_number` int(11) DEFAULT NULL,
        `type` int(11) DEFAULT NULL,
        `imgandtext` longtext,
        `text` longtext,
        PRIMARY KEY (`id`),
        KEY `FK_nt_n_idx` (`type`),
        CONSTRAINT `FK_nt_n` FOREIGN KEY (`type`) REFERENCES `news_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

import java.util.List;

public class NewsPojo {
    private int id;
    private String name;
    private String add_date;
    private String source;
    private int onclick_number;
    private int type;
    private String imgandtext;
    private String text;
    private List<News_imgPojo> news_imgPojos;

    public List<News_imgPojo> getNews_imgPojos() {
        return news_imgPojos;
    }

    public void setNews_imgPojos(List<News_imgPojo> news_imgPojos) {
        this.news_imgPojos = news_imgPojos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getOnclick_number() {
        return onclick_number;
    }

    public void setOnclick_number(int onclick_number) {
        this.onclick_number = onclick_number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImgandtext() {
        return imgandtext;
    }

    public void setImgandtext(String imgandtext) {
        this.imgandtext = imgandtext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "NewsPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", add_date='" + add_date + '\'' +
                ", source='" + source + '\'' +
                ", onclick_number=" + onclick_number +
                ", type=" + type +
                ", imgandtext='" + imgandtext + '\'' +
                ", text='" + text + '\'' +
                ", news_imgPojos=" + news_imgPojos +
                '}';
    }
}

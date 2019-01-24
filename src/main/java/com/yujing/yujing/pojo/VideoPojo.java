package com.yujing.yujing.pojo;

/*
CREATE TABLE `video` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `path` longtext,
        `k` longtext,
        `name` varchar(45) DEFAULT NULL,
        `type_name` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK_it_v_idx` (`type_name`),
        CONSTRAINT `FK_it_v` FOREIGN KEY (`type_name`) REFERENCES `introduce_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
*/

public class VideoPojo {
    private int id;
    private String path;
    private String k;
    private String name;
    private int type_name;

    public int getType_name() {
        return type_name;
    }

    public void setType_name(int type_name) {
        this.type_name = type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "VideoPojo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", k='" + k + '\'' +
                ", name='" + name + '\'' +
                ", type_name=" + type_name +
                '}';
    }
}

package com.yujing.yujing.pojo;


/*
CREATE TABLE `solution_type` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `type_name` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/

public class Solution_typePojo {
    private int id;
    private String type_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Solution_typePojo{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}

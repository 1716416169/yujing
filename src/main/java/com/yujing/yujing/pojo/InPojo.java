package com.yujing.yujing.pojo;
/*
CREATE TABLE `in` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `type` varchar(45) DEFAULT NULL,
        `type2` varchar(45) DEFAULT NULL,
        `type3` varchar(45) DEFAULT NULL,
        `type4` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
*/

public class InPojo {
    private int id;
    private String type;
    private String type2;
    private String type3;
    private String type4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    @Override
    public String toString() {
        return "InPojo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", type2='" + type2 + '\'' +
                ", type3='" + type3 + '\'' +
                ", type4='" + type4 + '\'' +
                '}';
    }
}

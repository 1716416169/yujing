package com.yujing.yujing.pojo;
/*
CREATE TABLE `case_type` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `type_name` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/


import java.util.List;

public class Case_typePojo {
    private int id;
    private String type_name;
    private List<Case_imgPojo> case_imgPojo;


    public List<Case_imgPojo> getCase_imgPojo() {
        return case_imgPojo;
    }

    public void setCase_imgPojo(List<Case_imgPojo> case_imgPojo) {
        this.case_imgPojo = case_imgPojo;
    }

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
        return "Case_typePojo{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", case_imgPojo=" + case_imgPojo +
                '}';
    }
}

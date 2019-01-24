package com.yujing.yujing.pojo;
/*
CREATE TABLE `case` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(45) DEFAULT NULL,
        `type` int(11) DEFAULT NULL,
        `path` longtext,
        PRIMARY KEY (`id`),
        KEY `FK_ct_c_idx` (`type`),
        CONSTRAINT `FK_ct_c` FOREIGN KEY (`type`) REFERENCES `case_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/


import com.yujing.yujing.dao.admin.Case.Case_img;

import java.util.List;

public class CasePojo {
    private Integer id;
    private String name;
    private Integer type;
    private String path;
    private List<Case_imgPojo> case_imgPojos;

    public List<Case_imgPojo> getCase_imgPojos() {
        return case_imgPojos;
    }

    public void setCase_imgPojos(List<Case_imgPojo> case_imgPojos) {
        this.case_imgPojos = case_imgPojos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CasePojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", path='" + path + '\'' +
                ", case_imgPojos=" + case_imgPojos +
                '}';
    }
}

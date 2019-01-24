package com.yujing.yujing.pojo;
/*
CREATE TABLE `solution_img` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `path` longtext,
        `k` longtext,
        `sid` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK_s_si_idx` (`sid`),
        CONSTRAINT `FK_s_si` FOREIGN KEY (`sid`) REFERENCES `solution` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Solution_imgPojo {
    private int id;
    private String path;
    private String k;
    private int sid;

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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Solution_imgPojo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", k='" + k + '\'' +
                ", sid=" + sid +
                '}';
    }
}

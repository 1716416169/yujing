package com.yujing.yujing.pojo;


/*
CREATE TABLE `case_img` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `path` longtext,
        `k` longtext,
        `cid` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK_c_ci_idx` (`cid`),
        CONSTRAINT `FK_c_ci` FOREIGN KEY (`cid`) REFERENCES `case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Case_imgPojo {
    private int id;
    private String path;
    private String k;
    private int cid;

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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Case_imgPojo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", k='" + k + '\'' +
                ", cid=" + cid +
                '}';
    }
}

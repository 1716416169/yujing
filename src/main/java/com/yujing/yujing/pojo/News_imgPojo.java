package com.yujing.yujing.pojo;

/*
CREATE TABLE `news_img` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `path` longtext,
        `k` longtext,
        `nid` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK_n_ni_idx` (`nid`),
        CONSTRAINT `FK_n_ni` FOREIGN KEY (`nid`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class News_imgPojo {
    private int id;
    private String path;
    private String k;
    private int nid;

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

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Override
    public String toString() {
        return "News_imgPojo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", k='" + k + '\'' +
                ", nid=" + nid +
                '}';
    }
}

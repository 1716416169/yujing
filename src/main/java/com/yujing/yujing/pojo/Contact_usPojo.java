package com.yujing.yujing.pojo;

/*

CREATE TABLE `contact_us` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(45) DEFAULT NULL,
        `phone` varchar(45) DEFAULT NULL,
        `email` varchar(45) DEFAULT NULL,
        `text` longtext,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Contact_usPojo {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String text;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Contact_usPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

package com.yujing.yujing.dao.admin.Contact_us;

import com.yujing.yujing.pojo.Contact_usPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Contact_us_EN {
    public void insert_contact_us();

    public List<Contact_usPojo> select_contact_us();

    public void delete_contact_us(Contact_usPojo contact_usPojo);

    public void delete_contact_uss(List<Contact_usPojo> contact_usPojos);

    public int select_count_contact_us();

    public List<Contact_usPojo> select_contact_uslimit(Integer in1, Integer in2);
}

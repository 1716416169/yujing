package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.In.Intype;
import com.yujing.yujing.pojo.InPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InController {
    @Autowired
    Intype in;

    @GetMapping(value = "in")
    public String inn(){
        return "admin/in/in";
    }
    @PostMapping(value = "/updata_in_type")
    @ResponseBody
    public void updata_in_type(InPojo inPojo){
       in.updataIn(inPojo);
    }
}

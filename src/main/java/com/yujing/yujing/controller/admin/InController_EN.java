package com.yujing.yujing.controller.admin;

import com.yujing.yujing.dao.admin.In.Intype;
import com.yujing.yujing.dao.admin.In.Intype_EN;
import com.yujing.yujing.pojo.InPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InController_EN {
    @Autowired
    Intype_EN in_EN;

    @GetMapping(value = "in_EN")
    public String inn(){
        return "admin/in/in_EN";
    }
    @PostMapping(value = "/updata_in_type_EN")
    @ResponseBody
    public void updata_in_type_EN(InPojo inPojo){

        in_EN.updataIn(inPojo);
    }
}

package com.yujing.yujing.tool;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class Imgupload{

    String File_Path="File/images/upload";
    public static ArrayList<String> pathList=new ArrayList<>();

    public Map<Object,Object> upload(MultipartFile file) throws IOException {
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;
        InputStream inputStream = file.getInputStream();
        Path directory = Paths.get(File_Path);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        long copy = Files.copy(inputStream, directory.resolve(newFileName));
        System.out.println("保存的路径：" + directory.resolve(newFileName));
        HashMap<Object, Object> objectHashMap = new HashMap<>();
        //objectHashMap.put("title", key);
        objectHashMap.put("src", File_Path + File.separator + newFileName);
        return objectHashMap;
    }
}


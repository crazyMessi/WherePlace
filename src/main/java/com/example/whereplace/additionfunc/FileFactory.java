package com.example.whereplace.additionfunc;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 19892
 */

@Service
public class FileFactory {


    public String fileToUrl(MultipartFile file) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();

        //获取文件后缀名
        int index = fileName.lastIndexOf(".");
        String suffixName;
        if(index > 0) {
            suffixName = fileName.substring(fileName.lastIndexOf("."));
        }else{
            suffixName = ".png";
        }

        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;

        // 获取服务器路径(springboot虚拟服务器文件不适用)
        // String realPath = request.getServletContext().getRealPath("img");//文件的上传路径

        //获取项目路径
        Resource resource = new ClassPathResource("");
        String projectPath = resource.getFile().getAbsolutePath()+ "\\static\\img";
        System.out.println(projectPath);

        if (upload(projectPath, file, fileName)) {
            //文件存放的相对路径(一般存放在数据库用于img标签的src)
            String relativePath="img/"+fileName;
            return relativePath;
        }else {
            return null;
        }
    }


    private boolean upload(String realPath, MultipartFile file, String fileName){
        // 将img文件存入本地
        String path = realPath + "\\" + fileName;
        System.out.println(path);

        File dest = new File(path);

        //判断文件父目录是否存在

        if (!dest.getParentFile().exists()) {
            boolean b = dest.getParentFile().mkdir();
            if(!b){
                return b;
            }
        }

        //保存文件
        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}





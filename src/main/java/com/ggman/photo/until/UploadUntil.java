package com.ggman.photo.until;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class UploadUntil {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * img上传
     * @param file
     * @return
     */
    public String upload(@RequestParam("file") MultipartFile file) {
        //校验文件格式
        List<String> imageType = Lists.newArrayList("jpg", "jpeg", "png", "bmp", "gif");
        //获取文件名带后缀
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if (imageType.contains(fileSuffix)) {
            // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
            String newFileName= UUID.randomUUID().toString().replace("-","")+ originalFilename;
            // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
            String dirPath = System.getProperty("user.dir");            //获取项目路径
            String path = File.separator + "uploadImg" + File.separator + newFileName;
            File destFile = new File(dirPath + path);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(destFile);
                // 将相对路径返回给前端
                return path;
            } catch (IOException e) {
                logger.error("错误信息", e);
                return null;
            }
        } else {
            // 非法文件
            logger.error("the picture's suffix is illegal");
        }
        return "";
    }
}

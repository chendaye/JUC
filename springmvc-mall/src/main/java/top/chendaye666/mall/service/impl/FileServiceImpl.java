package top.chendaye666.mall.service.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.chendaye666.mall.service.IFileService;
import top.chendaye666.mall.util.FTPUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String filename = file.getOriginalFilename();
        // 扩展名
        String fileExtensionName = filename.substring(filename.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名:{},上传的路径:{},新文件名:{}",filename,path,uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try{
            file.transferTo(targetFile);
            // 上传成功
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            // 已经上传到ftp
            targetFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetFile.getName();
    }
}

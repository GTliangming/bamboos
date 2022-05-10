package com.example.taroapi.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.taroapi.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 文件上传
 */

@Api(tags = "文件上传",description = "包括文件上传以及根据文件flag获取文件") // swagger注解
@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${server.port}")
    private String port;

    @Value("${file.ip}")
    private String ip;

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) throws IOException {
        System.out.print("upload----------");
        //获取文件原始名
        String originFilename = file.getOriginalFilename();
        // 获取文件类型
        String originFiletype = originFilename.substring(originFilename.lastIndexOf("."));
        //定义一个唯一表示
        String flag = IdUtil.fastSimpleUUID().substring(0,8);
        //定义文件的保存名字
        String saveFilename = originFilename.substring(0,8)+ "-"+flag+originFiletype;
        //文件存储路径
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/files/"+saveFilename;
        //将文件写入上传的路径
        FileUtil.writeBytes(file.getBytes(),rootFilePath);
        return  Result.success(ip+":"+port+"/files/"+flag);
    }

    @ApiOperation("获取文件")
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response){
        // 新建一个输出流对象
        OutputStream os;
        // 获取文件存储路径
        String basePath = System.getProperty("user.dir")+"/src/main/resources/files/";
        // 获取文件存储路径下的所有文件的名称
        List<String> fileNames = FileUtil.listFileNames(basePath);
        // 找到跟唯一标识相匹配的文件
        String file = fileNames.stream().filter(name -> name.contains(flag))
                .findAny().orElse("");

        try{
            if(StrUtil.isNotEmpty(file)){
                response.addHeader("Content-Disposition","attachment;filename="+
                        URLEncoder.encode(file,"UTF-8"));
                response.setContentType("application/octet-stream");
                // 通过文件的路径获取文件的字节流
                byte[] bytes = FileUtil.readBytes(basePath+file);
                // 通过输出流返回文件
                os=response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }

        }catch (Exception e){
            System.out.println("文件下载失败！");
        }
    }
}

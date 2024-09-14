package com.tlias.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.UUID;

/**
 * 阿里云OSS操作工具类
 */
@Slf4j
@Component
public class AliyunOSSUtils {

    @Autowired
    private AliossProperties aliossProperties;

    /**
     * 上传文件
     * @param content 内容字节数组
     * @param extName 文件拓展名
     */
    public String upload(byte[] content, String extName) throws Exception {
        String endpoint = aliossProperties.getEndpoint();
        String bucketName = aliossProperties.getBucketName();
        String accessKeyId = aliossProperties.getAccessKeyId();
        String accessKeySecrect = aliossProperties.getAccessKeySecret();
        CredentialsProvider credentialsProvider = new CredentialsProvider() {
            @Override
            public Credentials getCredentials() {
                // 返回长期凭证 access_key_id, access_key_secrect
                return new DefaultCredentials(accessKeyId, accessKeySecrect);
            }

            @Override
            public void setCredentials(Credentials credentials) {
            }
        };
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = UUID.randomUUID() + extName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName,
                    new ByteArrayInputStream(content));
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            log.error(
                    "Caught an OSSException, which means your request made it to OSS, but was rejected with an error response for some reason.");
            log.error("Error Message:" + oe.getErrorMessage());
            log.error("Error Code:" + oe.getErrorCode());
            log.error("Request ID:" + oe.getRequestId());
            log.error("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            log.error(
                    "Caught an ClientException, which means the client encountered a serious internal problem while trying to communicate with OSS, such as not being able to access the network.");
            log.error("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
    }

}

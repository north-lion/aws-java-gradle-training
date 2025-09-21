package training.samples;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.utils.StringUtils;

import java.net.URI;

public class MinioSample {

    S3Client client;

    /**
     * コンストラクタ.
     */
    public MinioSample() {
        // Minioに接続するためのクライアントを生成する.
        AwsCredentials credentials = AwsBasicCredentials.create("minioadmin", "minioadmin");
        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(credentials);
        client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .endpointOverride(URI.create("http://127.0.0.1:9000"))
                .build();
    }

    /**
     * バケットを作成する.
     *
     * @param bucketName バケット名
     */
    public void createBucket(String bucketName) {
        // バケットが既に存在する場合は作成をしない.
        if (doesBucketExist(bucketName)) {
            return;
        }
        CreateBucketRequest request = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();
        client.createBucket(request);

        System.out.println("バケットの作成が完了しました。バケット名： " + bucketName);
    }

    /**
     * 指定のバケットへ指定のファイルをアップロードする.
     *
     * @param bucketName アップロード先のバケット名
     * @param folderName アップロードする際のフォルダ名（複数階層にしたい場合は"/"で繋げる）例："training/sample"
     * @param fileName   アップロードする際のファイル名s
     * @param content    コンテント
     */
    public void uploadFile(String bucketName, String folderName, String fileName, String content) {
        // オブジェクトキーの作成
        String objectKey = StringUtils.isEmpty(folderName) ? fileName : String.join("/", folderName, fileName);

        // オブジェクトのアップロード
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
        client.putObject(request, RequestBody.fromString(content));
    }

    /**
     * バケットの存在チェックを行う.
     *
     * @param bucketName バケット名
     * @return true:存在する/false:存在しない
     */
    private boolean doesBucketExist(String bucketName) {
        try {
            client.getBucketAcl(r -> r.bucket(bucketName));
        } catch (S3Exception e) {
            return false;
        }
        return true;
    }
}

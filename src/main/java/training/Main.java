package training;

import training.samples.MinioSample;

/**
 * このクラスはエントリポイントとなるクラスです.
 */
public class Main {
    // 命名規則により、バケット名は小文字、数字、ピリオド (.)、およびハイフン (-) のみで構成されていなければならない.
    private static final String bucketName = "sample-bucket";

    public static void main(String[] args) {
        MinioSample minioSample = new MinioSample();
        // バケットを作成する.
        minioSample.createBucket(bucketName);
        // サンプルファイルをアップロードする.
        minioSample.uploadFile(bucketName, "Training", "Sample.txt", "Hello Minio!");

    }
}

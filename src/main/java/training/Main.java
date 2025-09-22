package training;

import training.samples.MinioSample;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * このクラスはエントリポイントとなるクラスです.
 */
public class Main {
    // 命名規則により、バケット名は小文字、数字、ピリオド (.)、およびハイフン (-) のみで構成されていなければならない.
    private static final String bucketName = "sample-bucket";

    public static void main(String[] args) {
        // System.out関数で標準出力されるメッセージの文字化け対策
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        MinioSample minioSample = new MinioSample();
        // バケットを作成する.
        minioSample.createBucket(bucketName);
        // サンプルファイルをアップロードする.
        minioSample.uploadFile(bucketName, "Training", "Sample.txt", "Hello Minio!");
    }
}

package netDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

// 获取网络资源
public class URLConnectionDemo {

    public static void main(String[] args) throws IOException {
        /*
        此方法等同于调用带四个参数的构造方法（指定 port 为 -1 指示 URL 应使用协议的默认端口）：
            public URL(String protocol, String host, String file)
                    throws MalformedURLException {
                this(protocol, host, -1, file);
            }
        */
        // URL url = new URL("http", "www.banmashenghuo.com", "/static/tags/6dcddcae-ffaa-4feb-8b31-8be5d5bb031a.png")
        URL url = new URL("http", "www.banmashenghuo.com", 80, "/static/tags/6dcddcae-ffaa-4feb-8b31-8be5d5bb031a.png");
        // 打开 URL 的连接对象
        URLConnection conn = url.openConnection();
        try (
                // 返回从此打开的连接读取的输入流（网络 ---输入---> 程序中）
                InputStream in = conn.getInputStream();
                // 实例化扫描器对象
                // Scanner scanner = new Scanner(in)

        ) {
            // while (scanner.hasNextLine()) {
            //     System.out.println(scanner.nextLine());
            // }
            Files.copy(in, Paths.get("src/ioDemo/file/txt/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

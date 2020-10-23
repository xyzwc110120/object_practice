package ioDemo.fileDemo;

import java.io.File;
import java.io.FilenameFilter;

// 文件过滤器
public class FilenameFilterDemo {

    public static void main(String[] args) {
        File dir = new File("src/ioDemo/file/txt");
        String[] fileNames = dir.list(new FilenameFilter() {
            /**
             * 实现 FilenameFilter 接口中筛（shai）选文件的 accept 方法
             *
             * @param dir  被找到的文件所在的目录
             * @param name 文件的名称
             * @return true：放入数组中；false：过滤
             */
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(name);
                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });
        System.out.println();
        for (String name : fileNames) {
            System.out.println(name);
        }

        /*
        源码：
            public String[] list(FilenameFilter filter) {
                String names[] = list();        // 点用自身 list 方法，获取目录中所有文件名称
                if ((names == null) || (filter == null)) {  // 若文件名数组为空（目录为空文件夹）或文件过滤器为空（不对文件做筛选），则直接返回文件名数组
                    return names;
                }
                List<String> v = new ArrayList<>();     // 实例化一个集合，用来存储筛选后的文件名
                for (int i = 0 ; i < names.length ; i++) {
                    if (filter.accept(this, names[i])) {    // 若实现的 accept 方法返回 true，则放入集合对象 v 中
                        v.add(names[i]);
                    }
                }
                return v.toArray(new String[v.size()]);     // 返回数组化的集合对象 v
            }
        */
    }
}

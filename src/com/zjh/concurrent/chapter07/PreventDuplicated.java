package com.zjh.concurrent.chapter07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.Time;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PreventDuplicated {
    private final static String LOCK_PATH="E:\\Java Project\\threads_tour\\src\\com\\zjh\\concurrent\\chapter07\\";
    private final static String LOCK_FILE=".lock";
    private final static String PERMISSIONS="rw-------";

    public static void main(String[] args) throws IOException {
        //注入Hook线程，程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The program received kill SIGNAL.");
            getLockFile().toFile().delete();
        }));
        //检查是否存在lock文件
        checkRunning();

        //简单模拟程序正在执行
        for(;;){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }



    private static void checkRunning() throws IOException {
        Path path=getLockFile();
        if(path.toFile().exists()){
            throw new RuntimeException("The program already running");
        }
        Set<PosixFilePermission> perm= PosixFilePermissions.fromString(PERMISSIONS);
        Files.createFile(path,PosixFilePermissions.asFileAttribute(perm));



    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }
}

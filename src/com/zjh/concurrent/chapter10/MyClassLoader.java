package com.zjh.concurrent.chapter10;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{
    private final static Path DEFAULT_CLASS_DIR= Paths.get("\\usr\\src\\","classLoader1");
    private final Path classDir;

    public MyClassLoader() {
        super();
//        this.classDir = classDir;
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(Path classDir) {
        super();
        this.classDir = classDir;
    }

    public MyClassLoader(String classDir) {
        super();
        this.classDir =Paths.get(classDir);
    }

    public MyClassLoader(String classDir,ClassLoader parent) {
        super(parent);
        this.classDir =Paths.get(classDir);
    }

    //重写父类的findClass方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取class的二进制数据
        final byte[] classBytes = this.readClassBytes(name);
        //数据为null或没有读到任何消息，则抛出ClassNotFoundException异常
        if(classBytes==null||classBytes.length==0){
            throw new ClassNotFoundException("Can not load the class "+name);
        }
        //调用defineClass方法定义class
        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException{
        //将包名分隔符转换为文件路径分隔符
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if(!classFullPath.toFile().exists())
            throw new ClassNotFoundException("The class "+name+" not found.");
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath,baos);
            return baos.toByteArray();

        }catch (IOException e){
            throw new ClassNotFoundException("Load the class "+name+" occur error."+e);
        }



    }

    @Override
    public String toString() {
        return "myclassloader";
    }
}

package com.zjh.concurrent.chapter10;

import java.nio.file.Path;

public class BrokerDelegateClassLoader extends MyClassLoader{
    public BrokerDelegateClassLoader() {
    }

    public BrokerDelegateClassLoader(Path classDir) {
        super(classDir);
    }

    public BrokerDelegateClassLoader(String classDir) {
        super(classDir);
    }

    public BrokerDelegateClassLoader(String classDir, ClassLoader parent) {
        super(classDir, parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //确保每个类在多线程下只会被加载一次
        synchronized (getClassLoadingLock(name)){
            Class<?> kClass = findLoadedClass(name);
            if(kClass==null){
                if(name.startsWith("java.")||name.startsWith("javax")){
                    try {
                        kClass=getSystemClassLoader().loadClass(name);
                    }catch (Exception e){

                    }
                }
            }else {
                try {
                    kClass=this.findClass(name);
                }catch (ClassNotFoundException e){

                }
                if (kClass==null){
                    if(getParent()!=null){
                        kClass=getParent().loadClass(name);
                    }else {
                        kClass=getSystemClassLoader().loadClass(name);
                    }
                }
            }
           if( kClass==null){
               throw new ClassNotFoundException("This class "+name+" not found.");
           }

           if(resolve){
               resolveClass(kClass);
           }
           return kClass;
        }

    }
}

package com.zjh.concurrent.chapter01;

public class TemplateMethod {

    public  final void print(String message){
        System.out.println("######");
        wrapPrint(message);
        System.out.println("######");
    }
    protected void wrapPrint(String message){

    }


    public static void main(String[] args) {
//        System.out.println("######");
        final TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };
        t1.print("hello Thread");

        final TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };

        t1.print("hello Thread");
    }

}

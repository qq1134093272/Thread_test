package com.zjh.concurrent.chapter08;

public class RunnableDenyExceptiom extends RuntimeException {
    public RunnableDenyExceptiom(String s) {
        super(s);
    }
}

package com.zjh.concurrent.chapter01;

public class TicketWindow extends Thread{
    //柜台名称
    private final String name;

    //最多受理50笔业务
    private static final int MAX=50;

    //标记
    private static int index=1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index<=MAX){
            System.out.println("柜台"+name+"当前号码是："+(index++));
        }
    }


    public static void main(String[] args) {
        final TicketWindow window1 = new TicketWindow("柜台1");
        window1.start();

        final TicketWindow window2 = new TicketWindow("柜台2");
        window2.start();

        final TicketWindow window3 = new TicketWindow("柜台3");
        window3.start();

        final TicketWindow window4 = new TicketWindow("柜台4");
        window4.start();
    }
}

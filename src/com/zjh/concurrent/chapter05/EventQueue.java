package com.zjh.concurrent.chapter05;

import jdk.jfr.Event;

import java.io.Console;
import java.util.LinkedList;

import static java.lang.Thread.currentThread;

public class EventQueue {
    private final int max;

    static class Event{

    }

    private static LinkedList<Event> eventQueue=new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT=10;

    public EventQueue(){
        this.max=DEFAULT_MAX_EVENT;
    }
    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event){
        synchronized(eventQueue){
            if (eventQueue.size()>=max){
                try{
                    console("this queue is full");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            console("the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();


        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try {
                    console("this queue is empty");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            eventQueue.notify();
            console("this event "+event+"is handled");
            return event;
        }

    }

    private void console(String message){
        System.out.printf("%s:%s\n",currentThread().getName(),message);
    }
}

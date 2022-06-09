package com.zjh.concurrent.chapter02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FightQueryExample {

    //合作的航空公司
//    =new ArrayList<String>();
    public static List<String> fightList=Arrays.asList("CSA","CEA","HNA");


    private static List<String> search(String original,String destination){
        final List<String> result = new ArrayList<>();
        //创建查询航班信息的线程列表
        List<FightQueryTask> tasks
                = fightList.stream().map(f -> createSearchTask(f, original, destination)).collect(Collectors.toList());
        tasks.forEach(Thread::start);
        //分别调用每个线程的join方法阻塞当前线程
        tasks.forEach(t->{
            try{
                t.join();
            }catch (InterruptedException e){

            }
        });
        //在此之前，当前线程会被阻塞，获取每一个查询线程的结果，并且加入到result中

        tasks.stream().map(FightQuery::get).forEach(result::addAll);
        return result;
    }

    private static FightQueryTask createSearchTask(String fight,String original,String dest){
        return  new FightQueryTask(fight,original,dest);
    }

    public static void main(String[] args) {
        List<String> results
                = search("SH", "BJ");
        results.forEach(System.out::println);
    }


}

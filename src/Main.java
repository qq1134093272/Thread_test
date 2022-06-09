//id 用户Id
//timestamp 用户登录日期，即使多次登录，只有一条
//
//用户连续7天登录：
//select id from User where id=1 orderby timestamp;
//
//ids=pyspark.createRDD("user.csv").map(x lambda:x[0],x[1]).groupBy(x[0]).sortByKey(x[1]).partitionBy(x[1],7).reduce(x[0])

import java.util.LinkedList;

public class Main {
//    Node head;
//    Node p=head.next;
//    Node q=head;
//    while(p!=null){
//        q.next=p.next;
//        p.next=q;
//        q=p;
//        p=q.next;
//    }
//    return p;
//    public static void main(String[] args) {
//        LinkedList<Integer> arr=new LinkedList<>();
//        Node head;
//        solve(arr,head);
//    }
//    public static int solve(LinkedList<Node> arr,Node head){
//        Node begin=head;
//        Node temp=head;
//        while(head.next!=null){
//            head=head.next;
//            if(head==begin){
//                return 1;
//            }
//            else {
//                begin=head;
//                while (begin.next!=null){
//                    if(begin==temp){
//                        return 1;
//                    }
//                    else {
//                        temp=begin;
//                        begin=begin.next;
//                    }
//                }
//
//
//            }
//
//
//        }
//        return -1;
//    }
}

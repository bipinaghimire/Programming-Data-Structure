package tasks;
// Show how to implement a stack using two queue. Analyze the running time of the
// queue operations.

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueS {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public int pop() {
        if (q1 == null) {
            System.out.println("empty");
            return 0;
        } else {
            return q1.remove();
        }
    }

    public void push(int data) {
        q2.add(data);
 
        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
            // q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public static void main(String[] args) {
        TwoQueueS s1 = new TwoQueueS();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());


    }
}


        // if (q2== null) {
        //     q2.add(data);
        // } else {
        //     for (int i =0; i <q1.size(); i++) {
        //         q2.add(q1.remove());
        //     }
        //     q1.add(data);
        //     for (int j =0; j < q2.size(); j++) {
        //         q1.add(q2.remove());
        //     }

        // }

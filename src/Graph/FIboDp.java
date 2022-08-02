package src.Graph;

import java.util.HashMap;

public class FIboDp {
    int fibo(int n){

        if(n<2){
            
                return n;
            } 
            return fibo(n-1)+fibo(n-2);
    }


    int fib(int n,HashMap<Integer,Integer> map){

        if(n<2){
            
                return n;
            } 
        if(map.containsKey(n)){
            return map.get(n);
        }

            int value= fib(n-1,map)+fib(n-2,map);
            map.put(n, value);
            return value;
    }


    public static void main(String [] args){
    FIboDp d=new FIboDp();
    HashMap<Integer,Integer> map=new HashMap<>();
   System.out.println( d.fib(50,map));

    }

}

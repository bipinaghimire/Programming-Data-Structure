package GreedyAlgorithm;

public class AcitivitySelect {

    public static void ActSelection(int start[], int finish[]){
        int k=0;
        int count = 1;
        System.out.print(k);
        for (int i=1;i<start.length;i++){
            if(start[i]>=finish[k]){
                k=i;
                System.out.print(k);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int start[]={1,3,2,4,8,7,9,11,9,12};
        int finish[]={3,4,5,7,9,10,11,12,13,14};

        ActSelection(start,finish);
    }
    
}

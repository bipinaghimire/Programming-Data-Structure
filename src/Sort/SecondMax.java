package src.Sort;

public class SecondMax {
    public static int secondMaximum(int[]a, int total){
        int temp;
        for(int i =0 ; i<total;i++){
            for(int j =i+1; j<total;j++){
                if(a[i]>a[j]){
                    temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[total-2];
    }
    public static void main(String[] args) {
        int a[]={2,4,1,5,3,7};
        System.out.println("Second Maximum  " + secondMaximum(a, 6));
    }
}

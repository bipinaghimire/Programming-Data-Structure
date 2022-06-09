package src.Sort;

//brutforce algorithm   Time complexity(O(n^2))
public class MaxSubArray {
    public int maxSumSubArray(int a[]){
        int max=-99999;
        for(int i=0; i<a.length;i++){
            int sum=0;
            for(int j=i; j<a.length;j++){
                sum = sum+a[j];
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    } 
}

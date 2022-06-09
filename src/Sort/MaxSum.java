package src.Sort;

public class MaxSum {
    static int maxSumSubArray(int a[],int start,int end){
         if(start==end){
            return a[start];
         }
         int mid=(start+end)/2;
         int lmax=0;
         int rmax=0;
         int max;
         lmax=maxSumSubArray(a, start, mid);
         rmax=maxSumSubArray(a, mid+1, end);
       
       
         int sum=0;
         int leftmax=-9999;
         for (int i=0;i>=0;i--){
            sum+=a[i];
            if(sum>leftmax){
                leftmax=sum;
            }
         }
         sum=0;
         int rightmax=-9999;
         for(int i=mid+1;i<a.length;i++){
          sum+=a[i];
          if(sum>rightmax){
            rightmax=sum;
            }
        }
         int crossmax=leftmax+rightmax; 
         if(lmax>rmax && lmax>crossmax){
            max=lmax;
         }
         else if(rmax>lmax && rmax>crossmax){
            max=rmax;
         }else{
       
            max=crossmax;
         }
         return max;
    }
        public static void main(String[] args) {
         int a[]={-1,2,3,4};
         int max_sum = maxSumSubArray(a, 0, a.length);
         System.out.println("maximum"+ max_sum);
    }
}

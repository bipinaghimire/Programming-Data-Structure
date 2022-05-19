public class deletion {
 
 public static void main(String args[])
 {
 
         int i,n=5,pos=2;
 int[] a = new int[n];
 
     System.out.println("Enter the elements") ;
     for(i=0;i<n;i++)
     {
         a[i] = n;
     }
    
  for(i=pos;i<n-1;i++)
     	{
         a[i]=a[i+1];
     }
     n=n-1;
     
 System.out.println("\nOn deleting new array we get is\n");
     for(i=0;i<n;i++) 
     {
         System.out.println("a["+i+"] = "+a[i]);
     }
 }
}
    


import java.util.*;


public class Fibonacci{

    static void fibonacci(int n){
        int first=0,second=1,next;
        for(int i=0;i<n;i++){
            if(i<2)
                next=i;
            else
            {
                next=first+second;
                first=second;
                second=next;
            }
            System.out.print(next+" ");
        }
    }
    
    static int fibRecursive(int n){
        if(n<2)
            return n;
        else
            return fibRecursive(n-1)+fibRecursive(n-2);
    }
    
    static void memo(int n){
        
        int fib[] =  new int[n];
        fib[0]=0; fib[1]=1;
        for(int i=2;i<n;i++)
            fib[i]=fib[i-1]+fib[i-2];
        
        for(int i:fib){
            System.out.print(i+" ");
        }
    }
    
    public static void main(String args[]){
        
        System.out.println("\nFibonacci iterative");
        fibonacci(100);

        System.out.println("\nFibonacci Recursive");
        for(int i=0;i<100;i++)
            System.out.print(fibRecursive(i)+" ");
        
        System.out.println("\nFibonacci Memoization");   
        memo(100);
    }
}

public class Sort{
    
    static void BubbleSort(int a[]){
        
        int i,j,l=a.length;
        
        for(i=0;i<l-1;i++){
            boolean swapped=false;
            for(j=0;j<l-i-1;j++)
            {
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                    swapped=true;
                }
            }
            
            if(!swapped)
                break;
        }
    }
    
    static void InsertionSort(int a[]){
        
        for(int j=1;j<a.length;j++){
            int key=a[j];
            int i=j-1;
            while(i>=0 && a[i]>key)
                a[i+1]=a[i--];
            a[i+1]=key;
        }
        
    }
    
    static void SelectionSort(int a[]){
        
        int i,j,min;
        for(i=0;i<a.length;i++){
            min=i;
            for(j=i+1;j<a.length;j++){
                if(a[j]<a[min])
                    min=j;
            }
            
            swap(a, i, min);
        }
    }
    
    static void swap(int a[], int i, int j){
        
       int temp=a[i];
       a[i]=a[j];
       a[j]=temp;
    }
    
    static void display(int num[]){
        for(int i:num)
            System.out.print(i+" ");
    }
    
    public static void main(String args[]){
        
        int num[]={3,2,1,4,6,3,2,1,5,7};
        
        System.out.println("\nBefore Bubble Sort");
        display(num);
        BubbleSort(num);
        System.out.println("\nAfter Bubble Sort");
        display(num);
        
        
        System.out.println("\nBefore Insertion Sort");
        display(num);
        InsertionSort(num);
        System.out.println("\nAfter Insertion Sort");
        display(num);
        
        System.out.println("\nBefore Selection Sort");
        display(num);
        SelectionSort(num);
        System.out.println("\nAfter Selection Sort");
        display(num);
    }
}

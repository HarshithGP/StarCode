public class Sort{
    
    static void bubble(int nums[]){
       
        for(int i=0;i<nums.length-1;i++){
            boolean swapped=false;
            for(int j=0;j<nums.length-i-1;j++)
            {
                if(nums[j]>nums[j+1])
                {    
                    swap(nums, j,j+1);
                    swapped=true;
                }
            }
            
            if(!swapped)
                break;
        }
    }
    
    static void selection(int nums[]){
        int i,j,min;
        for(i=0;i<nums.length;i++){
            min=i;
            for(j=i+1;j<nums.length;j++){
                if(nums[j]>nums[min])
                    min=j;
            }
            swap(nums, i, min);
        }
    }
    
    static void insertion(int a[]){
        int j,key,i;
        for(j=1;j<a.length;j++){
            key=a[j];
            i=j-1;
            while(i>=0&&a[i]>key)
                a[i+1]=a[i--];
            a[i+1]=key;
        }
    }
    
    static void quicksort(int nums[], int l, int r){
        
        if(l<r){
            int p = partition(nums,l,r);
            quicksort(nums, l, p-1);
            quicksort(nums, p+1, r);
        }
        
    }
    
    static int partition(int nums[], int l, int r){
        
       
        int key=nums[r];
        int i=l-1;
        
        for(int j=l;j<r;j++){
            
            if(nums[j]<key){
                i++;
                swap(nums,i,j);
            }
        }
        
        i++;
        swap(nums, i, r);
        return i;
    }
    
    static void mergesort(int nums[], int l, int r){
        if(l<r){
            int m=(l+r)/2;
            mergesort(nums, l, m);
            mergesort(nums,  m+1,r);
            merge(nums, l, m, r);
        }
    }
    
    static void merge(int nums[], int l, int m, int r){
        
        int n1=m-l+1;
        int n2=r-m;
        int L[]=new int[n1+1]; L[n1]=Integer.MAX_VALUE;
        int R[]=new int[n2+1]; R[n2]=Integer.MAX_VALUE;
        
        int i,j,k;
        
        for(i=0;i<n1;i++)
            L[i]=nums[l+i];
        
        for(i=0;i<n2;i++)
            R[i]=nums[m+i+1];
         
        i=0;j=0;   
        for( k=l;k<=r;k++){
            if(L[i]<R[j]){
                nums[k]=L[i];
                i++;
            }
            else{
                nums[k]=R[j];
                j++;
            }
        }
        
        
    }
    
    static void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String args[]){
        
        int nums[]={4,1,3,6,5,3,1,7,8};
        mergesort(nums, 0 , nums.length-1);
        for(int n:nums)
            System.out.println(" "+n);
    }
}

class heap{

	static int A[] = {0,5,8,2,7,12,3,4,6,11,1};
	static int heap_size = A.length-1;

	static void max_heapify(int A[], int i){

		int left = 2*i;
		int right = 2*i+1;

		int largest;

		if(left <= heap_size && A[left]>A[i])
			largest=left;
		else
			largest=i;

		if(right <= heap_size && A[right]>A[largest])
			largest=right;

		if(largest!=i){

			int temp = A[i];
			A[i]=A[largest];
			A[largest]=temp;
			max_heapify(A,largest);
		}
	}

	static void buildMaxHeap(int A[]){

		for(int i=(A.length-1)/2; i>=1; i--)
			max_heapify(A,i);
	}

	static void deleteMax(int A[]){
		A[1]=A[heap_size];
		heap_size--;
		max_heapify(A,1);
	}

	static void increase(int A[], int i, int val){

		A[i]=val;
		while(i>1 && A[i/2]<A[i]){
			int temp = A[i];
			A[i]=A[i/2];
			A[i/2]=temp;

			i=i/2;
		}
	}

	static void display(int A[]){

		for(int x=1;x<=heap_size;x++)
			System.out.print(A[x]+" ");
		System.out.println();
	}

	public static void main(String args[]){

	
		buildMaxHeap(A);
		display(A);
		deleteMax(A);
		display(A);
		increase(A,4,9);
		display(A);
	}
}
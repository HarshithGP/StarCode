public class matrixFlip {
    public void rotate(int[][] matrix) {
        
        display(matrix);
        transpose(matrix);
        display(matrix);
        flipClock(matrix);
        display(matrix);
    }
    
    static void swap(int matrix[][], int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    
    static void transpose(int matrix[][]){
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++)
            for(int j=i;j<c;j++)
                swap(matrix,i,j);
    }
    
    static void flipClock(int matrix[][]){
        
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++)
            for(int j=0;j<c/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][c-1-j];
                matrix[i][c-1-j]=temp;
            }
    }
    
    static void flipAntiClock(int matrix[][]){
        
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r/2;i++)
            for(int j=0;j<c;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[r-1-i][j];
                matrix[r-1-i][j]=temp;
            }
    }
    
    static void display(int matrix[][]){
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++)
        {    for(int j=0;j<c;j++)
                System.out.print(" "+matrix[i][j]);
            System.out.println();
        }
        System.out.println("--------------");
    }
}

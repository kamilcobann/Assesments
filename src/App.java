/**
 * @author Kamil Coban
 * @since 2022-03-02 (YYYY_MM_DD)
 */

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
    
        
        // Declare Question 4's array


        int [][] arr = {
            {215},
            {193,124},
            {117,237,442},
            {218,935,347,235},
            {320,804,522,417,345},
            {229,601,723,835,133,124},
            {248,202,277,433,207,263,257},
            {359,464 ,504 ,528 ,516 ,716, 871 ,182},
            {461 ,441 ,426 ,656, 863 ,560 ,380, 171, 923},
            {381 ,348, 573, 533 ,447 ,632 ,387 ,176 ,975 ,449},
            {223, 711 ,445 ,645 ,245 ,543, 931 ,532 ,937, 541, 444},
            {330 ,131 ,333 ,928, 377 ,733, 017 ,778 ,839 ,168 ,197 ,197},
            {131 ,171 ,522 ,137 ,217 ,224 ,291 ,413 ,528, 520 ,227 ,229 ,928},
            {223 ,626 ,034 ,683 ,839 ,053 ,627 ,310 ,713 ,999 ,629 ,817 ,410 ,121},
            {924 ,622 ,911 ,233 ,325 ,139 ,721 ,218 ,253 ,223 ,107 ,233 ,230 ,124 ,233},
            
        };
        
        makePrimeZero(arr); // Detects prime numbers in the array and sets them to 0.
        printArray(arr); // Prints the new array that has no prime numbers.
        int sum=  findMaxSumOnPath(arr, 0, 0,arr.length-1); // Finds max sum depending on the path 
        System.out.println(sum); // Outputs the sum

    }

    // Detect prime numbers

    public static boolean isPrime(int n){
        if(n<=1)
            return false;
        
        for(int i= 2; i<n ;i++)
            if(n%i == 0)
                return false;
        
        return true;
        
    }


    // To avoid prime numbers in the array, assign prime numbers to zero.

    public static int[][] makePrimeZero(int array[][]){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(isPrime(array[i][j]))
                    array[i][j]=0;
                
            }
        }
        return array;
        
    }


    public static void printArray(int array[][]){
        for (int[] x : array){
            for (int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }



    public static int findMaxSumOnPath(int array[][],int row, int col, int rowIndex){
        
        if(row==rowIndex){
            return 0;
        }else{
            if(array[row+1][col] > array[row+1][col+1]){
                return array[row][col]+findMaxSumOnPath(array, row+1, col,rowIndex);
            }else{
                return array[row][col]+findMaxSumOnPath(array, row+1, col+1,rowIndex);
            }
        }
    }
}


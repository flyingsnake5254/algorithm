import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //sort();
        //metrix();
        //search();
        inputN();
    }

    public static void sort(){
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[5];
        while(true){
            System.out.print("input data : ");
            for(int i = 0 ; i < 5 ; i ++)
                data[i] = scanner.nextInt();

            exangeSort(data);

            for(int i = 0 ; i < data.length ; i ++)
                System.out.print(data[i] + " ");
            System.out.println();
        }
    }

    public static void metrix(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("input metrix A size : ");
        int[][] metrixA = new int[scanner.nextInt()][scanner.nextInt()];
        System.out.print("input metrix A : ");
        for(int i = 0 ; i < metrixA.length ; i ++){
            for(int j = 0 ; j < metrixA[i].length ; j ++){
                metrixA[i][j] = scanner.nextInt();
            }
        }
        System.out.print("input metrix B size : ");
        int[][] metrixB = new int[scanner.nextInt()][scanner.nextInt()];
        System.out.print("input metrix B : ");
        for(int i = 0 ; i < metrixB.length ; i ++){
            for(int j = 0 ; j < metrixB[i].length ; j ++){
                metrixB[i][j] = scanner.nextInt();
            }
        }

        metrixMulti(metrixA , metrixB);

    }

    public static void search(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("input data size : ");
        int[] data = new int[scanner.nextInt()];
        System.out.print("input data : ");
        for(int i = 0 ; i < data.length ; i ++)
            data[i] = scanner.nextInt();

        System.out.print("input target : ");
        int target = scanner.nextInt();

        // binary search
        System.out.println(binarySearch(data , target , 0 , (data.length - 1) / 2 , data.length - 1));
    }

    public static void inputN(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("input n : ");

            // fib
            System.out.println(fib(scanner.nextInt()));
        }
    }

    public static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int binarySearch(int[] data , int target , int head , int mid , int end){
        if(head < end) {
            if (data[mid] == target) return mid;
            if (data[mid] < target) binarySearch(data, target, mid + 1, (mid + 1 + end) / 2, end);
            else binarySearch(data, target, head, (head + mid - 1) / 2, mid - 1);
        }
        return -1;
    }

    public static void metrixMulti(int[][] metrixA , int[][] metrixB){
        int[][] newMetrix = new int[metrixA.length][metrixB[0].length];
        for(int i = 0 ; i < newMetrix.length ; i ++){
            for(int j = 0 ; j < newMetrix[i].length ; j ++){
                newMetrix[i][j] = 0;
                for(int k = 0 ; k < metrixB.length ; k ++){
                    newMetrix[i][j] += metrixA[i][k] * metrixB[k][j];
                }
            }
        }

        for(int i = 0 ; i < newMetrix.length ; i ++){
            for(int j = 0 ; j < newMetrix[i].length ; j ++){
                System.out.print(newMetrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void exangeSort(int[] data){
        for(int i = 0 ; i < data.length ; i ++){
            for(int j = i + 1 ; j < data.length ; j ++){
                if(data[j] < data[i]){
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
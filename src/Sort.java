import com.sun.istack.internal.NotNull;

public class Sort {


    public static void main(String[] args) {
        int[] str = {2,3,1,6,3,2,7};
        //test();
        //quickSort(str, 0, str.length - 1);
        heapSort(str);
        //sink(str,1,str.length);
        System.out.println("排序结果：");
        for (int i : str) {
            System.out.println("" + i);
        }
    }


    public static void test(){
        int[] str={1,6,2,3,3,2,7};
        sink(str,0,str.length-1);
        for(int i : str){
            System.out.println(""+i);
        }
    }

    //快排
    public static void quickSort(int[] str, int lo, int hi) {

        if (hi <= lo)
            return;
        int target = partation(str, lo, hi);
        quickSort(str, lo, target - 1);
        quickSort(str, target + 1, hi);

    }

    private static int partation(int[] str, int lo, int hi) {
        int temp = str[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (str[++i] < temp) {
                if (i == hi) {
                    break;
                }
            }
            while (str[--j] > temp)
                if (j == lo) {
                    break;
                }
            if (i >= j) break;
            swap(str, lo, j);
        }
        exch(str, lo, j);
        return j;
    }

    private static void swap(int[] str, int i, int j) {
        str[i] = str[i] + str[j];//不用第三个变量交换
        str[j] = str[i] - str[j];//缺点是数字太大会溢出
        str[i] = str[i] - str[j];
    }

    public static void exch(int[] str, int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    //堆排

    public static void heapSort(int[] str) {
        //先让堆有序
        int length = str.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            sink(str, i, length);
        }
        System.out.println("堆有序：");
        for (int i : str){
            System.out.println(""+i);
        }
        for (int i = length - 1; i >= 0;) {
            exch(str, 0, i--);
            sink(str, 0, i+1);
        }
    }


    public static void sink(int[] str, int target, int length) {
        while (2 * target + 1 < length - 1) {
            int j = 2 * target + 1;
            if (2 * target + 2 < length && less(str, j, j + 1)) {
                j++;
            }
            if (less(str, target, j)) {
                swap(str, target, j);
                target =j;
            }else {
                break;
            }

        }
    }

    public static boolean less(@NotNull int[] str, int i, int j) {
        if (str[i] < str[j])
            return true;
        else {
            return false;
        }
    }
}

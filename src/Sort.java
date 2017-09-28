public class Sort {

    public static void main(String[] args) {
        int[] str = {2, 3, 1, 6, 3};
        quickSort(str, 0, str.length - 1);
        for (int i : str) {
            System.out.println("" + i);
        }
    }

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
            while (str[++i] <temp) {
                if (i == hi) {
                    break;
                }
            }
            while (str[--j] >temp)
                if (j == lo) {
                    break;
                }
                if(i>=j) break;
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

    public static void exch(int[] str,int i,int j){
        int temp = str[i];
        str[i] = j;
        str[j] = temp;
    }

}

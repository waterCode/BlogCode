public class Search {


    public static void main(String[] args){
        int[] str = {1,2,3,5,7};
        System.out.println("" + binarySearch(str,2));
    }

    public static int binarySearch(int[] str,int target){
        if(str == null){
            return -1;
        }
        int lo = 0,hi = str.length-1;
        while(lo <= hi){//一定要等于
            int temp = (lo + hi) / 2;
            if(target == str[temp]){
                return temp;
            }else if (target < str[temp]){
                hi = temp - 1;//这里高低位不要搞错
            }else {
                lo = temp + 1;
            }
        }

        return -1;
    }
}

/**
 * @version 版权 Copyright(c)2021 浙江设维信息技术有限公司
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class Test {
    static String s1 = "123123";
    public static void main(String[] args) {
        String s2 = "2232";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(2<<3);
        int i = 1;
        if(i==2 & i++==2){//不管前面正不正确，后面都会执行
            System.out.println("dd");
        }
        System.out.println(i);
        int j = 1;
        if(j==2&&j++==2){//前面不正确，后面就不会执行，效率高
            System.out.println("zz");
        }
        System.out.println(j);
        short s1 = 1;
//        s1 = s1 + 1;
        s1+=1;
        System.out.println(s1);
        float f = 3.4f;
        System.out.println("-------------------");
        int[] arr = {2,3,1,5,2,1,5};
        for (int z=0;z<arr.length-1;z++){//外层控制循环躺数
            for (int y=0;y<arr.length-1-z;y++){//内层控制每趟循环次数
                if(arr[y]>arr[y+1]){
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }
        }
        for (int i1 : arr) {
            System.out.println(i1);
        }
    }
}

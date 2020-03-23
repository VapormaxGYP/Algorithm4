package ToBinaryString;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println(toBinaryString(7));
        System.out.println(toBinaryString2(7));

    }

    public static String toBinaryString(long N)
    {
        String s = "";
        for(int n = 31; n>=0; n--)
        {
            s = s + (N>>>n&1);
        }
        return s;
    }
    public static String toBinaryString2(int N)
    {
        String s = "";
        for(int n = N; n>0; n/=2)
        {
            s = s + (n%2);
        }
        return s;
    }
}

package String_Algorithm;

/**
 * 回文字符串查询 IsPalindrome?
 * true: the String that you insert is a Palindrome
 * False: the String that you insert is not a Palindrome
 */
public class Palindrome {

    public static void main(String[] args) {

        System.out.println(IsPalindrome("12344321"));
        System.out.println(IsPalindrome("12"));
    }

    public static boolean IsPalindrome(String s)
    {
        int length = s.length();

        for(int i = 0; i < length; i++)
        {
            if(s.charAt(i) != s.charAt(length-1-i))
                return false;
        }
        return true;
    }

}

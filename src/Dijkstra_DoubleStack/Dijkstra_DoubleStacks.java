package Dijkstra_DoubleStack;
/**
 * Dijkstra_DoubleStacks method only can calculate the expresion with "()" at the beginning if it do not has a "()"
 * it will not work.
 * Also, if you want to calculate the part, you need add () to them.
 */

import java.util.Stack;

public class Dijkstra_DoubleStacks {
    Stack<Character> operator = new Stack<>();
    Stack<Double> value = new Stack<>();

    public void Calculate(String expression)
    {
        String form = "(" + expression + ")";
        System.out.println(form);
        int size = form.length();
        for(int i = 0; i < size; i++)
        {
            char s = form.charAt(i);
            if(s == '(');
            else if(s == '+') operator.push(s);
            else if(s == '-') operator.push(s);
            else if(s == '*') operator.push(s);
            else if(s == '/') operator.push(s);
            else if(s == ')')
            {
                char c = operator.pop();
                double v = value.pop();

                if(c == '+') value.push(v + value.pop());
                else if(c == '-') value.push(v - value.pop());
                else if(c == '*') value.push(v * value.pop());
                else if(c == '/') value.push(v / value.pop());

            }
            else
                value.push((double)(s-'0'));
        }
        System.out.println(value.pop());
    }

    public static void main(String[] args) {
        Dijkstra_DoubleStacks DD = new Dijkstra_DoubleStacks();

        DD.Calculate("2+(3*4)");
        DD.Calculate("(2+3*4)");

    }
}

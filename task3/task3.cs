using System;
using System.Collections.Generic;

public class Solver
{
    public static int Calculate(string expression)
    {
        if (String.IsNullOrWhiteSpace(expression))
        {
            return 0;
        }

        var tokens = expression.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        var stack = new Stack<int>((tokens.Length + 3) / 2);

        foreach (var token in tokens)
        {
            switch (token)
            {
                case "+":
                    stack.Push(stack.Pop() + stack.Pop());
                    break;
                case "-":
                    stack.Push(-stack.Pop() + stack.Pop());
                    break;
                case "*":
                    stack.Push(stack.Pop() * stack.Pop());
                    break;
                case "/":
                    var divisor = stack.Pop();
                    stack.Push(stack.Pop() / divisor);
                    break;
                default:
                    stack.Push(Convert.ToInt32(token));
                    break;
            }
        }

        return stack.Pop();
    }

    public static void Main(string[] args)
    {
        var inputString = Console.ReadLine();

        Console.WriteLine(Calculate(inputString));
        Console.ReadLine();
    }
}

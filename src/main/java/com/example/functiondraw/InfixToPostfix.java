package com.example.functiondraw;


public class InfixToPostfix {

    public static  String infixToPostfix(String expression) throws Exception {

        MyStack obj=new MyStack();
        String output="";
        for(int i=0;i<expression.length();i++)
        {

            if((expression.charAt(i)>='a'&&expression.charAt(i)<='j'))
            {
                output += expression.charAt(i);


            }

            else {

                switch(expression.charAt(i))
                {
                    case 'x':
                        if( !obj.isEmpty() && ((char) obj.peek()=='^'||(char) obj.peek()=='x'||(char) obj.peek()=='/'))
                        {

                            output+=obj.pop();
                            obj.push(expression.charAt(i));
                        }
                        else {
                            obj.push('x');

                        }
                        break;
                    case '/':
                        if( !obj.isEmpty() &&((char) obj.peek()=='^'||(char) obj.peek()=='*'||(char) obj.peek()=='/'))
                        {
                            output+=obj.pop();
                            obj.push(expression.charAt(i));
                        }
                        else {
                            obj.push('/');
                        }
                        break;
                    case '+':
                        while(! obj.isEmpty())
                        {output+=obj.pop();}
                        obj.push('+');
                        break;
                    case '-':
                        while(! obj.isEmpty())
                        {output+=obj.pop();}
                        obj.push('-');
                        break;
                    case '^':
                        if( !obj.isEmpty() && (char) obj.peek()=='^')
                        {
                            output+=obj.pop();
                            obj.push(expression.charAt(i));
                        }
                        else {
                            obj.push('^');
                        }
                        break;
                }
            }
        }

        while(obj.Top!= null)
        {
            output+=obj.pop();
        }

        return output;
    }

}

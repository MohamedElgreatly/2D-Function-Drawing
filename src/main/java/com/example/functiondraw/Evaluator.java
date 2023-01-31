package com.example.functiondraw;

public class Evaluator {
    public static float evaluate(String expression, float[] equivalentNumb) throws Exception {
        MyStack obj2=new MyStack();
        for(int i=0;i<expression.length();i++)
        {


            if((expression.charAt(i)=='-'||expression.charAt(i)=='+'||expression.charAt(i)=='x'||expression.charAt(i)=='/'||expression.charAt(i)=='^')){
                float  opr1 =0;
                float opr2=0;
                opr2=(float)(obj2.pop());
                if(obj2.Top!=null){
                    opr1=(float)(obj2.pop());
                }

                switch(expression.charAt(i))
                {
                    case 'x':
                        obj2.push((float)opr1*(float)opr2);
                        break;
                    case '/':
                        if(opr2==0)
                        {
                            throw new Exception();
                        }
                        obj2.push((float)opr1/(float)opr2);
                        break;
                    case '+':
                        obj2.push((float)opr1+(float)opr2);
                        break;
                    case '-':
                        obj2.push((float)opr1-(float)opr2);
                        break;
                    case '^':
                        obj2.push((float)Math.pow((double)opr1,(double)opr2));
                        break;
                }
            }

            else {
                obj2.push(equivalentNumb[expression.charAt(i)-'a']);
            }
        }
        return (float)obj2.pop();
    }
}

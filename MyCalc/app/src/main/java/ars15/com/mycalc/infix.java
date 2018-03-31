package ars15.com.mycalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by ars15 on 12/23/2016.
 */

public class infix extends AppCompatActivity {
    boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infixcalc);
        Button one = (Button) findViewById(R.id.button2);
        Button two = (Button) findViewById(R.id.button3);
        Button three = (Button) findViewById(R.id.button4);
        Button four = (Button) findViewById(R.id.button5);
        final Button five = (Button) findViewById(R.id.button6);
        Button six = (Button) findViewById(R.id.button7);
        Button seven = (Button) findViewById(R.id.button8);
        Button eight = (Button) findViewById(R.id.button9);
        Button nine = (Button) findViewById(R.id.button10);
        Button zero = (Button) findViewById(R.id.button12);
        Button sum = (Button) findViewById(R.id.button13);
        Button minus = (Button) findViewById(R.id.button11);
        Button multi = (Button) findViewById(R.id.button14);
        Button divide = (Button) findViewById(R.id.button15);
        Button equals = (Button) findViewById(R.id.button16);
        Button dot=(Button) findViewById(R.id.button22);
        Button power=(Button) findViewById(R.id.button17);
        Button brcopen=(Button)findViewById(R.id.button19);
        Button brcclose=(Button)findViewById(R.id.button20);
        Button clear=(Button)findViewById(R.id.button);
        final TextView edt1=(TextView)findViewById(R.id.editText);
        final TextView edt2=(TextView)findViewById(R.id.textView2);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    edt1.setText(edt1.getText().toString().substring(0, edt1.length()-1));
                }
            }
        });
        clear.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v)
            {
                edt1.setText("");
                edt2.setText("");
                return true;
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "1");
                                   }
                               }
        );
        two.setOnClickListener(new View.OnClickListener() {

                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "2");
                                   }
                               }
        );
        three.setOnClickListener(new View.OnClickListener() {

                                     public void onClick(View v) {
                                         edt1.setText(edt1.getText() + "3");
                                     }
                                 }
        );
        four.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "4");
                                    }
                                }
        );
        five.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "5");
                                    }
                                }
        );
        six.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "6");
                                   }
                               }
        );
        seven.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         edt1.append("7");
                                     }
                                 }
        );
        eight.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         edt1.append("8");
                                     }
                                 }
        );
        nine.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "9");
                                    }
                                }
        );
        zero.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "0");
                                    }
                                }
        );
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                edt1.setText(edt1.getText()+"+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                edt1.append("-");
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                edt1.append("/");
            }
        });
        multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                edt1.append("*");
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.append("^");
            }
        });
        brcclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.append(")");
            }
        });
        brcopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.append("(");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.append(".");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               String s=Double.toString(calculate_postfix(infix_2_postfix((edt1.getText().toString().toCharArray())).toCharArray()));
               if(check)
               {
                   edt2.setText("Error in Expression\n");
               }
               else
               {
                   edt2.setText(s);
               }
            }
        });
        equals.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                edt1.setText(edt2.getText());
                edt2.setText("");
                return true;
            }
        });
    }
    int isp(char a)
    {
        if(a=='(')
        {
            return 0;
        }
        else if(a=='^')
        {
            return 5;
        }
        else if(a=='*'||a=='/')
        {
            return 4;
        }
        else if(a=='+'||a=='-')
        {
            return 2;
        }
        else
        {
            return -1;
        }
    }
    int icp(char a)
    {
        if(a=='(')
        {
            return 7;
        }
        else if(a=='^')
        {
            return 6;
        }
        else if(a=='*'||a=='/')
        {
            return 3;
        }
        else if(a=='+'||a=='-')
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    String infix_2_postfix(char a[])
    {
        String res="";
        char stack[]=new char[200];
        int i,flag=0,len=a.length,top=0;
        for(i=0;i<len;i++)
        {
            if((a[i]>='A'&&a[i]<='Z')||(a[i]>='a'&&a[i]<='z')||(a[i]>='0'&&a[i]<='9')||a[i]=='.')
            {
                res+=a[i];
                flag=0;
            }
            else if(a[i]=='(')
            {
                stack[top++]=a[i];
                flag=1;
            }
            else if(a[i]==')')
            {
                while(stack[--top]!='(')
                {
                    res+=" ";
                    res+=stack[top];
                }
                flag=0;
            }
            else
            {
                res+=" ";
                if(top==0)
                {
                    stack[top++]=a[i];
                }
                else if(icp(a[i])<=(isp(stack[top-1])))
                {
                    while(top>0&&icp(a[i])<(isp(stack[top-1])))
                    {
                        res+=" ";
                        res+=stack[--top];
                    }
                    res+=" ";
                    stack[top++]=a[i];
                }
                else if(icp(a[i])>=isp(stack[top-1]))
                {
                    stack[top++]=a[i];
                }
                else if(top==0)
                {
                    stack[top++]=a[i];
                }
                flag=1;
            }
        }
        while(top>0)
        {
            res+=" ";
            res+=stack[--top];
        }
        return res;
    }
    double calculate_postfix(char c[])
    {
        double stack[]=new double[200];
        String s="";
        check=false;
        int i,top=-1,len=c.length;
        for(i=0;i<len;i++)
        {
            if(c[i]==' ')
            {
                if(s.equals("/"))
                {
                    if(top<1)
                    {
                        check=true;
                        return -1;
                    }
                    stack[top-1]=stack[top-1]/stack[top--];
                }
                else if(s.equals("*"))
                {
                    if(top<1)
                    {
                        check=true;
                        return -1;
                    }
                    stack[top-1]=stack[top-1]*stack[top--];
                }
                else if(s.equals("+"))
                {
                    if(top<1)
                    {
                        check=true;
                        return -1;
                    }
                    stack[top-1]=stack[top-1]+stack[top--];
                }
                else if(s.equals("-"))
                {
                    if(top<1)
                    {
                        check=true;
                        return -1;
                    }
                    stack[top-1]=stack[top-1]-stack[top--];
                }
                else if(s.equals("^"))
                {
                    if(top<1)
                    {
                        check=true;
                        return -1;
                    }
                    stack[top-1]=Math.pow(stack[top-1],stack[top--]);
                }
                else if(s.equals("."))
                {
                    check=true;
                    return -1;
                }
                else if(!s.equals(""))
                {
                    stack[++top]=Double.parseDouble(s);
                }
                s="";
            }
            else
            {
                s+=c[i];
            }
        }
        if(s.equals("/"))
        {
            if(top<1)
            {
                check=true;
                return -1;
            }
            stack[top-1]=stack[top-1]/stack[top--];
        }
        else if(s.equals("*"))
        {
            if(top<1)
            {
                check=true;
                return -1;
            }
            stack[top-1]=stack[top-1]*stack[top--];
        }
        else if(s.equals("+"))
        {
            if(top<1)
            {
                check=true;
                return -1;
            }
            stack[top-1]=stack[top-1]+stack[top--];
        }
        else if(s.equals("-"))
        {
            if(top<1)
            {
                check=true;
                return -1;
            }
            stack[top-1]=stack[top-1]-stack[top--];
        }
        else if(s.equals("^"))
        {
            if(top<1)
            {
                check=true;
                return -1;
            }
            stack[top-1]=Math.pow(stack[top-1],stack[top--]);
        }
        else if(s.equals("."))
        {
            check=true;
            return -1;
        }
        if(top>0)
        {
            check=true;
            return -1;
        }
        return stack[0];
    }
}

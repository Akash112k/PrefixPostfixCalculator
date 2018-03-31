package ars15.com.mycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import  android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class  postfix extends AppCompatActivity{
    int length,top=0;float result[]=new float[30];
    String str[]=new String[30];
    boolean check=false;
    void putspace(TextView edt1)
    {
        if(edt1.getText().length()==0)
        {
            return;
        }
        if(edt1.getText().toString().charAt(edt1.getText().length()-1)!=' ') {
            edt1.setText(edt1.getText() + " ");
            top++;
            str[top] = "";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str[0]="";
        setContentView(R.layout.postfix);
        final TextView edt1 = (TextView) findViewById(R.id.editText);
        final TextView edt2 = (TextView)findViewById(R.id.textView2);
        Button one = (Button) findViewById(R.id.button2);
        Button two = (Button) findViewById(R.id.button3);
        Button three = (Button) findViewById(R.id.button4);
        Button four = (Button) findViewById(R.id.button5);
        Button five = (Button) findViewById(R.id.button6);
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
        Button space =(Button)findViewById(R.id.button17);
        Button clear=(Button)findViewById(R.id.button);
        Button pow=(Button)findViewById(R.id.powerbutton);
        Button dot=(Button)findViewById(R.id.dotbutton);
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    if (edt1.getText().toString().charAt((edt1.getText().length()-1)) == ' ') {
                        top--;
                    } else if (str[top].length() == 0) {
                        str[--top] = str[top].substring(0, str[top].length() - 1);
                    } else {
                        str[top] = str[top].substring(0, str[top].length() - 1);
                    }
                    edt1.setText(edt1.getText().toString().substring(0, edt1.getText().length()-1));
                }
            }
        });
        clear.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v)
            {
                edt1.setText("");
                edt2.setText("");
                top=0;str[top]="";
                return true;
            }
        });
        one.setOnClickListener(new OnClickListener(){
                                   @Override
                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "1");
                                       str[top]+="1";
                                   }
                               }
        );
        two.setOnClickListener(new View.OnClickListener() {

                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "2");
                                       str[top]+="2";
                                   }
                               }
        );
        three.setOnClickListener(new View.OnClickListener() {

                                     public void onClick(View v) {
                                         edt1.setText(edt1.getText() + "3");
                                         str[top]+="3";
                                     }
                                 }
        );
        four.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "4");
                                        str[top]+="4";
                                    }
                                }
        );
        five.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "5");
                                        str[top]+="5";
                                    }
                                }
        );
        six.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       edt1.setText(edt1.getText() + "6");
                                       str[top]+="6";
                                   }
                               }
        );
        seven.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         edt1.setText(edt1.getText() + "7");
                                         str[top]+="7";
                                     }
                                 }
        );
        eight.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         edt1.setText(edt1.getText() + "8");
                                         str[top]+="8";
                                     }
                                 }
        );
        nine.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "9");
                                        str[top]+="9";
                                    }
                                }
        );
        zero.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        edt1.setText(edt1.getText() + "0");
                                        str[top]+="0";
                                    }
                                }
        );
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
                edt1.setText(edt1.getText()+"+");
                str[top]+="+";
                putspace(edt1);
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
                edt1.setText(edt1.getText()+"-");
                str[top]+="-";
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
                edt1.setText(edt1.getText()+"/");
                str[top]+="/";
                putspace(edt1);
            }
        });
        pow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
                edt1.setText(edt1.getText()+"^");
                str[top]+="^";
                putspace(edt1);
            }
        });
        dot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                edt1.setText(edt1.getText()+".");
                str[top]+=".";
            }
        });
        multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
                edt1.setText(edt1.getText()+"*");
                str[top]+="*";
                putspace(edt1);
            }
        });
        space.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                putspace(edt1);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(edt1.getText().length()>0)
                {
                    int i,j,top2=-1;
                    for(i=0;i<=top;i++)
                    {
                        if(str[i].equals("+"))
                        {
                            if(top2<1)
                            {
                                edt2.setText("Error in Expression\n");
                                return;
                            }
                            else
                            {
                                result[top2-1]+=result[top2--];
                            }
                        }
                        else if(str[i].equals("-"))
                        {
                            if(top2<1)
                            {
                                edt2.setText("Error in Expression\n");
                                return;
                            }
                            else
                            {
                                result[top2-1]-=result[top2--];
                            }
                        }
                        else if(str[i].equals("*"))
                        {
                            if(top2<1)
                            {
                                edt2.setText("Error in Expression\n");
                                return;
                            }
                            else
                            {
                                result[top2-1]*=result[top2--];
                            }
                        }
                        else if(str[i].equals("/"))
                        {
                            if(top2<1)
                            {
                                edt2.setText("Error in Expression\n");
                                return;
                            }
                            else if(result[top2]==0)
                            {
                                edt2.setText("Cannot Divide by Zero\n");
                                return;
                            }
                            else
                            {
                                result[top2-1]/=result[top2--];
                            }
                        }
                        else
                        {
                            if(!str[i].equals("")) {
                                result[++top2] = parseInt(str[i]);
                                //edt1.setText("hello");
                            }
                        }
                    }
                    if(top2>=1||top2<0)
                    {
                        edt2.setText("Error in Expression\n");
                    }
                    else
                    {
                        edt2.setText(Float.toString(result[top2]));
                    }
                }*/
                double result=calculate_postfix(edt1.getText().toString().toCharArray());
                if(check)
                {
                    edt2.setText("Error in Expression\n");
                }
                else
                {
                    edt2.setText(Double.toString(result));
                }
            }
        });
    }
    double calculate_postfix(char c[])
    {
        double stack[]=new double[70];
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

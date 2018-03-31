package ars15.com.mycalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ars15 on 12/24/2016.
 */

public class convert extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert);
        final String opcode = getIntent().getExtras().getString("Extra");
        final TextView expression = (TextView) findViewById(R.id.exp);
        final EditText enter = (EditText) findViewById(R.id.enter_expression);
        final TextView result1 = (TextView) findViewById(R.id.res1);
        final TextView result2 = (TextView) findViewById(R.id.res2);
        Button calculate = (Button) findViewById(R.id.button18);
        enter.setText("");
           if (opcode.equals("1"))
           {
                expression.setText("Infix Converter");
                enter.setHint("eg. a+b*(c-d)");
                result1.setText("After Conversion to Postfix \n");
                result2.setText("After Conversion to Prefix \n");
           }
            else if (opcode.equals("2"))
            {
                expression.setText("Prefix Converter");
                enter.setHint("eg. +b a");
                result1.setText("After Conversion to Infix \n");
                result2.setText("After Conversion to Postfix \n");
            }
            else if (opcode.equals("3"))
            {
                expression.setText("Postfix Converter");
                enter.setHint("eg. ba+");
                enter.setText("");
                result1.setText("After Conversion to Infix \n");
                result2.setText("After Conversion to Prefix \n");
            }
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opcode.equals("1")) {
                    expression.setText("Infix Converter");
                    enter.setHint("eg. a+b*(c-d)");
                    result1.setText("After Conversion to Postfix \n");
                    result2.setText("After Conversion to Prefix \n");
                    result1.append(infix_2_postfix(enter.getText().toString().toCharArray()));
                    result2.append(infix_2_prefix(enter.getText().toString().toCharArray()));
                } else if (opcode.equals("2")) {
                    expression.setText("Prefix Converter");
                    enter.setHint("eg. +b a");
                    result1.setText("After Conversion to Infix \n");
                    result2.setText("After Conversion to Postfix \n");
                    String s = prefix_to_infix(enter.getText().toString().toCharArray());
                    result1.append(s);
                    result2.append(infix_2_postfix(s.toCharArray()));
                } else if (opcode.equals("3")) {
                    expression.setText("Postfix Converter");
                    enter.setHint("eg. ba+");
                    result1.setText("After Conversion to Infix \n");
                    result2.setText("After Conversion to Prefix \n");
                    String s = postfix_to_infix(enter.getText().toString().toCharArray());
                    result1.append(s);
                    result2.append(infix_2_prefix(s.toCharArray()));
                }
            }
        });
    }
    int priority(char c) {
        if (c == '^') {
            return 4;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    boolean is_operator(char c) {
        if (c == '+' || c == '/' || c == '-' ||/* c == '*' ||*/ c == '^') {
            return true;
        } else {
            return false;
        }
    }
    int isp(char a) {
        if (a == '(') {
            return 0;
        } else if (a == '^') {
            return 5;
        } else if (a == '*' || a == '/') {
            return 4;
        } else if (a == '+' || a == '-') {
            return 2;
        } else {
            return -1;
        }
    }
    int icp(char a) {
        if (a == '(') {
            return 7;
        } else if (a == '^') {
            return 6;
        } else if (a == '*' || a == '/') {
            return 3;
        } else if (a == '+' || a == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    String infix_2_postfix(char a[]) {
        String res = "";
        char stack[] = new char[70];
        int i, flag = 0, len = a.length, top = 0;
        for (i = 0; i < len; i++) {
            if ((a[i] >= 'A' && a[i] <= 'Z') || (a[i] >= 'a' && a[i] <= 'z') || (a[i] >= '0' && a[i] <= '9')) {
                res += a[i];
                flag = 0;
            } else if (a[i] == ')') {
                stack[top++] = a[i];
                flag = 1;
            } else if (a[i] == '(') {
                while (stack[--top] != ')') {
                    res += " ";
                    res += stack[top];
                }
                flag = 0;
            } else {
                res += " ";
                if (top == 0) {
                    stack[top++] = a[i];
                } else if (icp(a[i]) <= (isp(stack[top - 1]))) {
                    while (top > 0 && icp(a[i]) < (isp(stack[top - 1]))) {
                        res += " ";
                        res += stack[--top];
                    }
                    res += " ";
                    stack[top++] = a[i];
                } else if (icp(a[i]) >= isp(stack[top - 1])) {
                    stack[top++] = a[i];
                } else if (top == 0) {
                    stack[top++] = a[i];
                }
                flag = 1;
            }
        }
        while (top > 0) {
            res += " ";
            res += stack[--top];
        }
        return res;
    }

    String infix_2_prefix(char s[]) {
        int len = s.length, top = -1, i;
        String res = "";
        int charcount = 0, operatorcount = 0;
        char stack[] = new char[70];
        for (i = len - 1; i >= 0; i--) {
            if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z') || (s[i] >= '0' && s[i] <= '9')) {
                    res = s[i] + res;
                    charcount++;
                }
            else if (s[i] == ')') {
                stack[++top] = s[i];
            } else if (s[i] == '(') {
                while (top >= 0 && stack[top] != ')') {
                    res = stack[top--] + res;
                }
                if (top < 0) {
                    return "Incorrect Expression\n";
                }
                top--;
            } else if (top == -1) {
                operatorcount++;
                stack[++top] = s[i];
            } else if (icp(s[i]) > isp(stack[top])) {
                operatorcount++;
                stack[++top] = s[i];
            } else if (isp(s[i]) <= isp(stack[top])) {
                operatorcount++;
                res = stack[top--] + res;
                stack[++top] = s[i];
            }
        }
        while (top >= 0) {
            res = stack[top--] + res;
        }
        if (charcount - operatorcount != 1) {
            return "Incorrect Expression";
        }
        return res;
    }
    String prefix_to_infix(char s[])
    {
        String res="";
        char stack[]=new char[70];
        int i,top=-1,len=s.length;
        for(i=0;i<len;i++)
        {
            if((s[i]>='a'&&s[i]<='z')||(s[i]>='A'&&s[i]<='Z')||(s[i]>='0'&&s[i]<='9'))
            {
                if(res.length()==0||is_operator(res.charAt(res.length()-1)))
                {
                    res+=s[i];
                }
                else if(top<0)
                {
                    return "Incorrect Expression";
                }
                else
                {
                    res+=stack[top--];
                    res+=s[i];
                }
            }
            else if(top>=0&&res.length()>0&&(priority(stack[top])>=priority(s[i])))
            {
                if(!is_operator(res.charAt(res.length()-1)))
                {
                    res+=stack[top--];
                    stack[++top]=s[i];
                }
                else
                {
                    stack[++top]=s[i];
                }
            }
            else
            {
                stack[++top]=s[i];
            }
        }
        if(top>=0)
        {
            return "Incorrect Expression";
        }
        return res;
    }
    String postfix_to_infix(char s[])
    {
        String res="";
        char stack[]=new char[70];
        int i,top=-1,len=s.length;
        int operator_count=0,operand_count=0;
        for(i=0;i<len;i++)
        {
            int reslen=res.length();
            if((s[i]>='a'&&s[i]<='z')||(s[i]>='A'&&s[i]<='Z') || (s[i] >= '0' && s[i] <= '9') )
            {
                //	System.out.println("Pushing "+s[i]);
                stack[++top]=s[i];
                operand_count++;
            }
            else if(s[i]=='.')
            {
                return "Incorrect Expression";
            }
            else if(s[i]!=' ')
            {
                operator_count++;
                if(i<2||top<0)
                {
                    return "Incorrect Expression";
                }
                else if(res=="")
                {
                    res+=stack[top--];
                    res=s[i]+res;
                    res=stack[top--]+res;
                }
                else if(is_operator(s[i-1]))
                {
                    //		System.out.println("Popping "+stack[top]);
                    res=s[i]+res;
                    res=stack[top--]+res;
                }
                else if(s[i]!=' ')
                {
                    //		System.out.println("Popping "+stack[top]);
                    res+=s[i];
                    res+=stack[top--];
                }
            }
        }
        return res;
    }
}
package netpythontojavaviewmodecontents.csdn.blog.calculator0;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.view.View.OnClickListener;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button add;     //��ť+
    private Button subtract;    //��ť-
    private Button multiply;    //��ť*
    private Button divide;      //��ť/
    private Button equal;       //��ť=
    private Button delete;      //��ťɾ��һ������ķ���
    private Button clear;       //��ť������������
    private Button point;       //��ťС����

    private Button one;         //��ť1
    private Button two;
    private Button three;

    private Button four;
    private Button five;
    private Button six;

    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private EditText showtext;//������ʾ����ķ��ź�����

    private String OperateSum="";//�ַ�������������������ֺͷ���
    private char Operator;      //������¼�������
    private double num1=0,num2=0,sum=0;     //num1,num2��¼��������֣�sum��������Ľ��
    //private boolean NewCalculate=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//�԰�ť���¼����г�ʼ��
    }
    private void initView()
    {
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        zero=(Button) findViewById(R.id.zero);

        add=(Button) findViewById(R.id.add);
        subtract=(Button) findViewById(R.id.subtract);
        multiply=(Button) findViewById(R.id.multiply);
        divide=(Button) findViewById(R.id.divide);
        delete=(Button) findViewById(R.id.delete);
        clear=(Button) findViewById(R.id.clear);
        equal=(Button) findViewById(R.id.equal);
        point=(Button) findViewById(R.id.point);
        //about=(Button) findViewById(R.id.about);
        showtext=(EditText) findViewById(R.id.text);
        showtext.setCursorVisible(false);

        zero.setOnClickListener(this);//��Ӱ�ť�¼�
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        point.setOnClickListener(this);
        //about.setOnClickListener(this);
        showtext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:      //��¼���������1
                OperateSum=AddSum('1');//��������ӽ�OperateSum
                showtext.setText(OperateSum);   //�������������ʾ��EditText
                break;
            case R.id.two:      //��¼���������2
                OperateSum=AddSum('2');
                showtext.setText(OperateSum);
                break;
            case R.id.three:
                OperateSum=AddSum('3');
                showtext.setText(OperateSum);
                break;
            case R.id.four:
                OperateSum=AddSum('4');
                showtext.setText(OperateSum);
                break;
            case R.id.five:
                OperateSum=AddSum('5');
                showtext.setText(OperateSum);
                break;
            case R.id.six:
                OperateSum=AddSum('6');
                showtext.setText(OperateSum);
                break;
            case R.id.seven:
                OperateSum=AddSum('7');
                showtext.setText(OperateSum);
                break;
            case R.id.eight:
                OperateSum=AddSum('8');
                showtext.setText(OperateSum);
                break;
            case R.id.nine:
                OperateSum=AddSum('9');
                showtext.setText(OperateSum);
                break;
            case R.id.zero:
                OperateSum=AddSum('0');
                showtext.setText(OperateSum);
                break;

            case R.id.add:      //��¼+��
                OperateSum=AddSum('+');
                Operator='+';       //��¼�ӷ�
                showtext.setText(OperateSum);   //�������+����ʾ��EditText
                break;
            case R.id.subtract:
                OperateSum=AddSum('-');
                Operator='-';
                showtext.setText(OperateSum);
                break;
            case R.id.multiply:
                OperateSum=AddSum('*');
                Operator='*';
                showtext.setText(OperateSum);
                break;
            case R.id.divide:
                OperateSum=AddSum('/');
                Operator='/';
                showtext.setText(OperateSum);
                break;
            case R.id.point:
                OperateSum=AddSum('.');
                showtext.setText(OperateSum);
                break;
            case R.id.delete:       //ɾ���ո������һ������
                if(OperateSum.length()>=1)//�������Ѿ�������һ�����Ų�ִ��
                {
                    OperateSum=OperateSum.substring(0,OperateSum.length()-1);
                }
                showtext.setText(OperateSum);
                break;
            case R.id.clear:        //���������ʾ��
                OperateSum="";      //����ȫ����ʼ��
                num1=0;
                num2=0;
                sum=0;
                Operator=' ';
                showtext.setText(OperateSum);
                break;
            case R.id.equal:
                if(CheckInput(OperateSum))//����������ֺ����������ȷ���Ž��м���
                {
                    OperateSum=OperateSum+"="+String.valueOf(equals(OperateSum));
                    showtext.setText(OperateSum);//��ʾ����������ͽ��
                    OperateSum=String.valueOf(sum); //�������������Ա���ֱ������һ���������һ�����ֽ�����һ������
                }
                else                        //���벻����������
                {
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }
    public String AddSum(char c)//��Ӳ���¼һ����������ֻ����
    {
        OperateSum=OperateSum+String.valueOf(c);
        return OperateSum;
    }

    public boolean CheckInput(String OperateSum)    //���������������û�����������Ƿ���������û�������"9/3"���Ǻ���ģ����������� " 8/*",�ⲿ����
    {
        if(OperateSum.length()<=2)//����Ҫ�ֱ�������һ�����ֺ�һ���������һ�����֣����볤��<=2�϶������������� 99 ����=��ť�϶�������
        {
            return false;
        }
        if(OperateSum.indexOf(Operator, 1)==-1)     //���û��������������϶�������
        {
            return false;
        }

        if(OperateSum.endsWith(String.valueOf(Operator)))       //������������β���������֣��϶������� ������ 9** �������м���
        {
            return false;
        }
        return true;
    }
    public double equals(String OperateSum)         //������
    {
        int indexOfOperator=0;
        indexOfOperator=OperateSum.indexOf(Operator,1);         //����������ڴ������OperateSum�ַ������λ��
        if(OperateSum.length()>=3)
        {
            num1=Double.parseDouble(OperateSum.substring(0, indexOfOperator));  //�������OperateSum�ַ�����õ���һ��������
            num2=Double.parseDouble(OperateSum.substring(indexOfOperator + 1, OperateSum.length()));    //�������OperateSum�ַ�����õ��ڶ���������
        }
        switch (Operator)       //������������м���
        {
            case '+':           //�ӷ�����
                sum=num1+num2;
                break;
            case '-':           //��������
                sum=num1-num2;
                break;
            case '*':           //�˷�����
                sum=num1*num2;
                break;
            case '/':           //��������
                if(num2!=0)     //������Ӧ��Ϊ0
                {
                    sum=num1/num2;
                }
                else
                {
                    sum=0;
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();//��������0����������
                }
                break;
            default:
                break;
        }
        return sum;         //���ؽ��
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

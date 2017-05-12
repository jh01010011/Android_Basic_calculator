package jh.dorid.binaryworld.android04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends Activity implements View.OnClickListener {

    static final String EXP = "exp";
    static final String RES = "res";
    public static final String file_name="PF";
    //ArrayList<Word> history=new ArrayList<Word>();
    ArrayList<String> e=new ArrayList<String>();
    ArrayList<String> r=new ArrayList<String>();
    String str1;
    String str2;
    DbMan db;
    //TextView disp_txt0;
    //TextView disp_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DbMan(this);
        Configuration config= getResources().getConfiguration();


        if(config.orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
            TextView disp_txt0=(TextView) findViewById(R.id.disp_txt0);
            TextView disp_txt=(TextView) findViewById(R.id.disp_txt);


            if(savedInstanceState!=null){

                disp_txt0.setText(savedInstanceState.getString(EXP).toString());
                disp_txt.setText(savedInstanceState.getString(RES).toString());
                Toast.makeText(MainActivity.this,"on create prot [saveintance]",Toast.LENGTH_LONG).show();

            }
            else {

                disp_txt0.setText("");
                disp_txt.setText("0");
                Toast.makeText(MainActivity.this,"on create prot init",Toast.LENGTH_LONG).show();

            }


           // Log.d("orientation","__potrate___");
           // Toast.makeText(MainActivity.this,"__Portrait__",Toast.LENGTH_LONG).show();

        }

        else if(config.orientation==Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main);

            TextView disp_txt0=(TextView) findViewById(R.id.disp_txt0);
            TextView disp_txt=(TextView) findViewById(R.id.disp_txt);
            Button btn_db= (Button) findViewById(R.id.btn_db);
            btn_db.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent i=new Intent(getApplicationContext(),DataBaseView.class);
                    startActivity(i);

                }
            });

            if(savedInstanceState!=null){

                disp_txt0.setText(savedInstanceState.getString(EXP).toString());
                disp_txt.setText(savedInstanceState.getString(RES).toString());
                Toast.makeText(MainActivity.this,"on create Lan [Saveinstance]",Toast.LENGTH_LONG).show();

            }
            else{

                disp_txt0.setText("");
                disp_txt.setText("0");
                Toast.makeText(MainActivity.this,"oncreate Lan init",Toast.LENGTH_LONG).show();



            }



            Log.d("orientation","landscape");

            Toast.makeText(MainActivity.this,"Landscape",Toast.LENGTH_LONG).show();

        }






    }



        @Override
        public void onResume() {
            super.onResume();


            final TextView disp_txt0=(TextView) findViewById(R.id.disp_txt0);
            final TextView disp_txt=(TextView) findViewById(R.id.disp_txt);


            //disp_txt0.setText("");
            //disp_txt.setText("0");


            Button btn0= (Button) findViewById(R.id.btn0);
            Button btn1= (Button) findViewById(R.id.btn1);
            Button btn2= (Button) findViewById(R.id.btn2);
            Button btn3= (Button) findViewById(R.id.btn3);
            Button btn4= (Button) findViewById(R.id.btn4);
            Button btn5= (Button) findViewById(R.id.btn5);
            Button btn6= (Button) findViewById(R.id.btn6);
            Button btn7= (Button) findViewById(R.id.btn7);
            Button btn8= (Button) findViewById(R.id.btn8);
            Button btn9= (Button) findViewById(R.id.btn9);
            Button btn_eql= (Button) findViewById(R.id.btn_eql);
            Button btn_add= (Button) findViewById(R.id.btn_add);
            Button btn_sub= (Button) findViewById(R.id.btn_sub);
            Button btn_div= (Button) findViewById(R.id.btn_div);
            Button btn_mul= (Button) findViewById(R.id.btn_mul);
            Button btn_c= (Button) findViewById(R.id.btn_c);
            Button btn_mc= (Button) findViewById(R.id.btn_mc);
            Button btn_mp= (Button) findViewById(R.id.btn_mp);
            Button btn_ms= (Button) findViewById(R.id.btn_ms);
            Button btn_mm= (Button) findViewById(R.id.btn_mm);
            Button btn_del= (Button) findViewById(R.id.btn_del);
            Button btn_dot= (Button) findViewById(R.id.btn_dot);

            Button btn_hist= (Button) findViewById(R.id.btn_hist);


            btn0.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("0");
                }
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("1");
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("2");
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("3");
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("4");
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("5");
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("6");
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("7");
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("8");
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.append("9");
                }
            });







            btn_hist.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Intent i =new Intent(getApplicationContext(),History.class);
                        i.putStringArrayListExtra("exp",e);
                        i.putStringArrayListExtra("res",r);
                        //i.putExtra("Mylist",history);
                        startActivity(i);

                }
            });

            btn_add.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try{
                        String test= disp_txt0.getText().toString();
                        char t=test.charAt(test.length()-1);
                        if(test.length()==0){
                            disp_txt0.setText(disp_txt0.getText());
                        }
                        else if(t != '/' && t != '*' && t != '+' && t != '-' && t != '.' )
                        {
                            disp_txt0.append("+");
                        }
                        else {

                            disp_txt0.setText(disp_txt0.getText());
                        }
                    }
                    catch (Exception ignored){}
                }
            });
            btn_sub.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try{
                        String test= disp_txt0.getText().toString();
                        char t=test.charAt(test.length()-1);
                        if(test.length()==0){
                            disp_txt0.append("-");
                        }
                        else if(t != '/' && t != '*' && t != '+' && t != '-' && t != '.' )
                        {
                            disp_txt0.append("-");
                        }
                        else {

                            disp_txt0.setText(disp_txt0.getText());
                        }
                    }
                    catch (Exception ignored){}
                }
            });
            btn_mul.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try{
                        String test= disp_txt0.getText().toString();
                        char t=test.charAt(test.length()-1);
                        if(test.length()==0){
                            disp_txt0.setText(disp_txt0.getText());
                        }
                        else if(t != '/' && t != '*' && t != '+' && t != '-' && t != '.' )
                        {
                            disp_txt0.append("*");
                        }
                        else {

                            disp_txt0.setText(disp_txt0.getText());
                        }
                    }
                    catch (Exception ignored){}
                }
            });
            btn_div.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try{
                        String test= disp_txt0.getText().toString();
                        char t=test.charAt(test.length()-1);
                        if(test.length()==0){
                            disp_txt0.setText(disp_txt0.getText());
                        }
                        else if(t != '/' && t != '*' && t != '+' && t != '-' && t != '.' )
                        {
                            disp_txt0.append("/");
                        }
                        else {

                            disp_txt0.setText(disp_txt0.getText());
                        }
                    }
                    catch (Exception ignored){}
                }
            });
            btn_dot.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   if(search_dot((disp_txt0.getText().toString()))){
                        disp_txt0.append(".");
                    }
                    else{
                        disp_txt0.setText(disp_txt0.getText());
                    }

                }
            });
            btn_c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    disp_txt0.setText("");
                    disp_txt.setText("0");

                }
            });
            btn_eql.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String str = "result =";
                    str = str + disp_txt0.getText().toString();
                    char t=str.charAt(str.length()-1);
                    if(t == '/' || t == '*' || t == '+' || t == '-' || t == '.' ){
                        String err_msg="Syntax error!!!";
                        disp_txt.setText(err_msg);
                    }
                    else {

                        try {
                            Interpreter interpreter = new Interpreter();
                            interpreter.eval(str);
                            disp_txt.setText(interpreter.get("result").toString());
                            e.add(disp_txt0.getText().toString());
                            r.add(disp_txt.getText().toString());
                            boolean isSet= db.insertData(disp_txt0.getText().toString(),disp_txt.getText().toString());
                            if(isSet){
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this,"Data is not inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (EvalError ignored) {
                        }
                    }
                }
            });
            btn_mc.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences shared_pref = getSharedPreferences(file_name,0);
                    SharedPreferences.Editor editor=shared_pref.edit();
                    editor.clear();
                    editor.apply();
                }
            });
            btn_mp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences shared_pref = getSharedPreferences(file_name,0);
                    String str=disp_txt.getText().toString();
                    str="result ="+str+"+"+shared_pref.getString("last_val","");

                    try {
                        Interpreter interpreter = new Interpreter();
                        interpreter.eval(str);
                        disp_txt.setText(interpreter.get("result").toString());
                    } catch (EvalError ignored) {
                    }

                }
            });
            btn_ms.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences shared_pref = getSharedPreferences(file_name,0);
                    SharedPreferences.Editor editor=shared_pref.edit();
                    editor.putString("last_val",disp_txt.getText().toString());
                    editor.apply();
                }
            });

            btn_mm.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences shared_pref = getSharedPreferences(file_name,0);
                    String str=disp_txt.getText().toString();
                    str="result ="+str+"-"+shared_pref.getString("last_val","");

                    try {
                        Interpreter interpreter = new Interpreter();
                        interpreter.eval(str);
                        disp_txt.setText(interpreter.get("result").toString());
                    } catch (EvalError ignored) {
                    }
                }
            });

            btn_del.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String str=disp_txt0.getText().toString();

                    if(str.length() == 0){

                    }
                    else{
                        disp_txt0.setText(str.substring(0,str.length()-1));
                    }
                }
            });





        }


    public void showMessage(String title,String msg){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TextView disp_txt0=(TextView) findViewById(R.id.disp_txt0);
        TextView disp_txt=(TextView) findViewById(R.id.disp_txt);

        disp_txt0.setText(savedInstanceState.getString(EXP).toString());
        disp_txt.setText(savedInstanceState.getString(RES).toString());

        Toast.makeText(MainActivity.this,"onRestoreCallBack",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);



        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){

            //Toast.makeText(MainActivity.this,""+Configuration.ORIENTATION_LANDSCAPE,Toast.LENGTH_LONG).show();

//           setContentView(R.layout.activity_main);
//
//
//
//            Button btn_db= (Button) findViewById(R.id.btn_db);
//            btn_db.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//
//                    Intent i=new Intent(getApplicationContext(),DataBaseView.class);
//                    startActivity(i);
//
//                }
//            });
//
//            //onCreate();
//            //onResume();
            recreate();

        }

        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(MainActivity.this,""+Configuration.ORIENTATION_PORTRAIT,Toast.LENGTH_LONG).show();
//            setContentView(R.layout.activity_main);
//            //onResume();
            recreate();

        }


    }

    boolean search_dot(String str_d)
    {
        int ln = str_d.length()-1;
        while(ln>=0 )
        {
            if(str_d.charAt(ln) =='+' || str_d.charAt(ln) =='-' || str_d.charAt(ln) =='*' || str_d.charAt(ln) =='/')
            {
                break;
            }
            else if(str_d.charAt(ln)=='.')
            {
                return false;
            }
            ln--;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView disp_txt0=(TextView) findViewById(R.id.disp_txt0);
        TextView disp_txt=(TextView) findViewById(R.id.disp_txt);

        str1= disp_txt0.getText().toString();
        str2=disp_txt.getText().toString();

        outState.putString(EXP,str1);
        outState.putString(RES,str2);
        Toast.makeText(MainActivity.this,"onSaveCallBack",Toast.LENGTH_LONG).show();
        super.onSaveInstanceState(outState);


    }


    @Override
    public void onClick(View v) {

    }
}

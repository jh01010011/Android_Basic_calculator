package jh.dorid.binaryworld.android04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends Activity {
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Log.v("_______Historryy","_________testing");

        ArrayList<Word> his = new ArrayList<Word>();
        Intent i=getIntent();
        ArrayList<String> exp=i.getStringArrayListExtra("exp");
        ArrayList<String> res=i.getStringArrayListExtra("res");
        int ind=0;
        while (ind<exp.size()){
            his.add(new Word(exp.get(ind),res.get(ind)));
            ind++;
        }


        //ArrayList<Word> his = new ArrayList<Word>();

             //ArrayList<Word>   his= (ArrayList<Word>) i.getSerializableExtra("Mylist");
        //Log.v("Historryy",his.get(0).getS1()+"\n"+his.get(0).getS2());

        CusAdapter his_adapter=new CusAdapter(this,his);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(his_adapter);
    }
}

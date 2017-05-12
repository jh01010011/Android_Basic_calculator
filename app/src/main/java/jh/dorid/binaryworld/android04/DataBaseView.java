package jh.dorid.binaryworld.android04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBaseView extends Activity {

    DbMan db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_view);


        Intent i=getIntent();

        ArrayList<Word> his = new ArrayList<Word>();

        CusAdapter his_adapter=new CusAdapter(this,his);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(his_adapter);
       db=new DbMan(this);
        Cursor cursor=db.getAll();

        if(cursor.getCount()==0){
            Toast.makeText(DataBaseView.this,"Data Not found",Toast.LENGTH_LONG).show();
            showMessage("Error","No Data Found");
            return;
        }

        while (cursor.moveToNext()){

            his.add(new Word(cursor.getString(1),cursor.getString(2)));

        }


    }

    public void showMessage(String title,String msg){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }
}

package jh.dorid.binaryworld.android04;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by blueb on 3/11/2017.
 */

public class DbMan extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="CAL_DB.db";
    public static final int DB_V=1;

    public static final String TABLE_NAME="CAL_HIS";
    public static final String COL_1="ID";
    public static final String COL_2="EXP";
    public static final String COL_3="RES";


    public DbMan(Context context) {
        super(context, DATABASE_NAME, null, DB_V);
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table CAL_HIS (ID INTEGER PRIMARY KEY AUTOINCREMENT,EXP TEXT,RES TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXITS CAL_HIS");
        onCreate(db);

    }

    public boolean insertData(String exp, String res){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_2,exp);
        values.put(COL_3,res);

        long result=db.insert(TABLE_NAME,null,values);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }

    }

    public Cursor getAll(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);

        return  cursor;
    }

    public boolean updateData(String id,String exp, String res){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1,exp);
        values.put(COL_2,exp);
        values.put(COL_3,res);
        db.update(TABLE_NAME,values,"ID = ?",new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID =?",new String[]{id});

    }

}

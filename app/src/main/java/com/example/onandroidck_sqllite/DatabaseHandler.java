package com.example.onandroidck_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context,"OnThiCKSQLite", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create= String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s DOUBLE , %s TEXT )", "OnThiCKSQLite" ,"id","type","price","country");
        db.execSQL(create);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s OnThiCKSQLite");
        db.execSQL(drop_students_table);
        onCreate(db);
    }
    public  void addProduct(Product product){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("type",product.getType());
        values.put("country",product.getCountry());
        values.put("price",product.getPrice());
        db.insert("OnThiCKSQLite",null,values);
        db.close();
    }

    public Product getProductByID(int idProduct){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.query("OnThiCKSQLite",null,"id=?",new String[] { String.valueOf(idProduct) },null, null, null);
        if(cursor!=null) {
            ((Cursor) cursor).moveToFirst();
        }
            Product product= new Product(cursor.getInt(0),cursor.getString(1),cursor.getDouble(2),cursor.getString(3));
            return product;

    }
    public List<Product> getAll(){
        List<Product> list= new ArrayList<Product>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from OnThiCKSQLite",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Product product= new Product(cursor.getInt(0),cursor.getString(1),cursor.getDouble(2),cursor.getString(3));
            list.add(product);
            cursor.moveToNext();
        }
        return list;
    }

    public void updateProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type",product.getType());
        values.put("price",product.getPrice());
        values.put("country",product.getCountry());
        db.update("OnThiCKSQLite",values,"id=?",new String[] { String.valueOf(product.getId()) });
        db.close();
    }
    public void deleteProduct(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("OnThiCKSQLite","id=?",new String[] { String.valueOf(id) });
        db.close();
    }
}

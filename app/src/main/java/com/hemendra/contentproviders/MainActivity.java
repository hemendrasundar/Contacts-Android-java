package com.hemendra.contentproviders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        contentResolver = getContentResolver();
       Cursor c = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
String[] columns ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
int[] tvs = {R.id.tv_name,R.id.tv_phone};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.lv_item,c,columns,tvs);


        lv.setAdapter(simpleCursorAdapter);
    }
}
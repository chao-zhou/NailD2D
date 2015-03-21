package com.naild2d.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.naild2d.android.service.AccountService;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private AccountService accountService;
    private EditText editCode;
    private ListView list;


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_packagelist);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        list = (ListView)findViewById(R.id.pkgls_list);
        ArrayList<HashMap<String,String>> data = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("shop","shop test");
        data.add(map);


        ListAdapter adapter = new SimpleAdapter(this,data,R.layout.item_packge,new String[]{"shop"},new int[] {R.id.pkg_item_name});
        list.setAdapter(adapter);

        //editCode  = (EditText)findViewById(R.id.txtCode);

        //accountService = new AccountService();
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




    public void code(View v){
        accountService.getCertCode("18600406362");
    }

    public void newUser(View v){
        String code = editCode.getText().toString();
        accountService.register("18600406362","841111",code,"");
    }
}

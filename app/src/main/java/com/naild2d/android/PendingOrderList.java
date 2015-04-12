package com.naild2d.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class PendingOrderList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order_list);

        /*
        ListView listView = (ListView)findViewById(R.id.pending_order_list_order);

        List<Map<String,?>> data = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("price","200.00");
        data.add(map);

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_pending_order_list,
                new String[]{"price"},
                new int[]{R.id.item_pending_order_list_price});
        listView.setAdapter(adapter);
*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pending_order_list, menu);
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

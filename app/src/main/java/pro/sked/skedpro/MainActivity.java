package pro.sked.skedpro;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends Activity {

    ArrayList<ItemLst> items = new ArrayList<ItemLst>();
   ShopListAdapter shopListAdapter;
    Date d = new Date();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillItems();

        shopListAdapter = new ShopListAdapter(this, items);
        // настраиваем список
        ListView shop_list = (ListView) findViewById(R.id.shop_list);
        shop_list.setAdapter(shopListAdapter);

    }



    // генерируем данные для адаптера
    void fillItems() {
        for (int i = 1; i <= 20; i++) {
            items.add(new ItemLst("Item "  + i, d.toString() ,"Bondint "+i , i * 10));

         }
    }


}

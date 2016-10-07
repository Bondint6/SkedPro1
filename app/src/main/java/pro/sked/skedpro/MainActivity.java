package pro.sked.skedpro;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<ItemLst> items = new ArrayList<ItemLst>();
    ShopListAdapter shopListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // создаем адаптер
        fillData();
        shopListAdapter = new ShopListAdapter(this, items);

        // настраиваем список
        ListView shop_list = (ListView) findViewById(R.id.shop_list);
        shop_list.setAdapter(shopListAdapter);

    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            items.add(new ItemLst("ItemLst " + i, i * 1000));

        }
    }
}

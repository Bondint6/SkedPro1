package pro.sked.skedpro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;



import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<ItemLst> items = new ArrayList<ItemLst>();
    ShopListAdapter shopListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
            items.add(new ItemLst("ItemLst "  + i, i * 10));

        }
    }
}

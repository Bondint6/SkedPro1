package pro.sked.skedpro;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private SkedProAPIService service = SkedProAPIService.getInstance();
    private ShopListAdapter shopListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopListAdapter = new ShopListAdapter(this, null);
        // set adapter
        ListView shop_list = (ListView) findViewById(R.id.shop_list);
        shop_list.setAdapter(shopListAdapter);
        String Login = getIntent().getStringExtra("Login");
        Button btnAddItem = (Button) findViewById(R.id.add_item);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SkedProAddItemFragment();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.activity_main, fragment);
                ft.commit();
            }
        });

        Call<List<GetItems>> call = service.getApi().getItems(Login);
        call.enqueue(new Callback<List<GetItems>>() {
            @Override
            public void onResponse(Call<List<GetItems>> call, Response<List<GetItems>> response) {
                List<GetItems> items = response.body();
                shopListAdapter.setmItems(items);
            }

            @Override
            public void onFailure(Call<List<GetItems>> call, Throwable t) {
                System.out.println("z");
            }
        });

    }


    // generic data for adapter
 /*   void fillItems() {

        for (int i = 1; i <= 20; i++) {
            items.add(new ItemLst("Item "  + i, d.toString() ,Login , i * 10));

         }
    }
*/


}

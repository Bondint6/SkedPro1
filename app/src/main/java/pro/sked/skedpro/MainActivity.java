package pro.sked.skedpro;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private  SkedProAPIService service = SkedProAPIService.getInstance();

    ArrayList<ItemLst> items = new ArrayList<ItemLst>();

    ShopListAdapter shopListAdapter;

    Date d = new Date();
    String Login;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = getIntent().getStringExtra("Login");
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
            List<GetItems> item = response.body();
            System.out.println(item.get(0).items);
               /* for (int i=0; i< response.body().size(); i++)
                {
                    items.add(new ItemLst(item.get(i).items,item.get(i).create,item.get(i).user,item.get(i).counts));
                }*/


            }

            @Override
            public void onFailure(Call<List<GetItems>> call, Throwable t) {
                System.out.println("z");
            }
        });
        // create adapter
  //      fillItems();

        shopListAdapter = new ShopListAdapter(this, items);
        // set adapter
        ListView shop_list = (ListView) findViewById(R.id.shop_list);
        shop_list.setAdapter(shopListAdapter);
        shopListAdapter.notifyDataSetChanged();// refresh ListView

    }



    // generic data for adapter
 /*   void fillItems() {

        for (int i = 1; i <= 20; i++) {
            items.add(new ItemLst("Item "  + i, d.toString() ,Login , i * 10));

         }
    }
*/

}

package pro.sked.skedpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Bondint on 07.10.2016.
 */

    public class ShopListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<ItemLst> objects;


    ShopListAdapter(Context context, ArrayList<ItemLst> items)
    {
        ctx = context;
        objects = items;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null) {
        view = lInflater.inflate(R.layout.list_adapter,parent,false);
        }
        ItemLst itm = getItemLst(position);
        ((TextView) view.findViewById(R.id.count_item)).setText(Integer.toString(itm.count));
        ((TextView) view.findViewById(R.id.item)).setText(itm.item_name);
        ((TextView) view.findViewById(R.id.name_add)).setText(itm.add_name);
        ((TextView) view.findViewById(R.id.date_add)).setText(itm.add_date);
       return view;
    }
    ItemLst getItemLst(int position) {
        return ((ItemLst) getItem(position));
    }

    InfLst getInfLst(int position) {
        return ((InfLst) getItem(position));
    }



    ArrayList<ItemLst> getBox() {
        ArrayList<ItemLst> box = new ArrayList<ItemLst>();
        for (ItemLst itm : objects) {
            box.add(itm);
        }
        return box;
    }

}

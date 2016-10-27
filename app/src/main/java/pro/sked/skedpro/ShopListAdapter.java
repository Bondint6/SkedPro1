package pro.sked.skedpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Bondint on 07.10.2016.
 */

    public class ShopListAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater lInflater;
    private List<GetItems> mItems;


    ShopListAdapter(Context context, List<GetItems> items)
    {
        ctx = context;
        mItems = items;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null)
        {
            view = lInflater.inflate(R.layout.list_adapter,parent,false);
        }

        GetItems item = mItems.get(position);
        ((TextView) view.findViewById(R.id.count_item)).setText(item.counts);
        ((TextView) view.findViewById(R.id.item)).setText(item.create);
        ((TextView) view.findViewById(R.id.name_add)).setText(item.user);
        ((TextView) view.findViewById(R.id.date_add)).setText(item.create);
       return view;
    }


    public List<GetItems> getItems()
    {
        return mItems;
    }

    public void setmItems(List<GetItems> items)
    {
        mItems = items;
        this.notifyDataSetChanged();
    }

    

//
//    ArrayList<ItemLst> getBox() {
//        ArrayList<ItemLst> box = new ArrayList<ItemLst>();
//        for (ItemLst itm : mItems) {
//            box.add(itm);
//        }
//        return box;
//    }

}

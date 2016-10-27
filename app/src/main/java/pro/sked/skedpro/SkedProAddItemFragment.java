package pro.sked.skedpro;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Bondint on 27.10.2016.
 */

public class SkedProAddItemFragment extends Fragment implements View.OnClickListener


{
    /*Fragment fragment = new SkedProAddItemFragment();
    FragmentTransaction ft = getFragmentManager().beginTransaction();*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_item_fragment, null);
        Button btnOk = (Button) v.findViewById(R.id.add);
        Button btnCancel = (Button) v.findViewById(R.id.cancel);


            btnCancel.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(this);
        ft.commit();

    }
}

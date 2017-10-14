package android.telacad.ro.jmc4e1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/16/2017.
 */

public class OptiuniAdapter extends BaseAdapter {

    private List<Optiune> optiuni=new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public OptiuniAdapter(Context context){
        this.context=context;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return optiuni.size();
    }

    @Override
    public Object getItem(int position) {
        return optiuni.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= inflater.inflate(R.layout.list_item,null);

        Optiune a=optiuni.get(position);

        TextView nume=(TextView) view.findViewById(R.id.nume);
        Switch activ=(Switch) view.findViewById(R.id.sw);
        nume.setText(a.getNume());
        activ.setChecked(a.isActiv());
        return view;
    }

    public void adaugaOptiune(Optiune a){
        optiuni.add(a);
    }
}
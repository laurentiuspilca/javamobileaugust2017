package android.telacad.ro.jmc3e3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/2/2017.
 */

public class AngajatAdaptor extends BaseAdapter {

    private List<Angajat> angajati=new ArrayList<>();
    private LayoutInflater inflater; //se obtine pe baza contextului
    private Context context;

    public AngajatAdaptor(Context context){
        this.context=context;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return angajati.size();
    }

    @Override
    public Object getItem(int position) {
        return angajati.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //spunem cum arata elementul din lista
        //apelata pt fiecare element din lista
        View view= inflater.inflate(R.layout.list_item,null);

        Angajat a=angajati.get(position);

        TextView nume=(TextView) view.findViewById(R.id.nume);
        TextView functie=(TextView) view.findViewById(R.id.funtie);
        nume.setText(a.getNume());
        functie.setText(a.getFunctie());

        return view;
    }

    public void addAngajat(Angajat a){
        angajati.add(a);
    }
}

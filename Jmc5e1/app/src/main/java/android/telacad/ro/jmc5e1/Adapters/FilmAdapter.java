package android.telacad.ro.jmc5e1.Adapters;

import android.content.Context;
import android.telacad.ro.jmc5e1.Model.Film;
import android.telacad.ro.jmc5e1.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/23/2017.
 */

public class FilmAdapter extends BaseAdapter{
    private List<Film> filmList=new ArrayList<>();
    private LayoutInflater inflater;

    public FilmAdapter(Context context){
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return filmList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= inflater.inflate(R.layout.itemlayout,null);
        Film film=filmList.get(position);
        TextView titlu=(TextView)view.findViewById(R.id.titlu_item);
        TextView regizor=(TextView)view.findViewById(R.id.regizor_item);
        TextView descriere=(TextView)view.findViewById(R.id.descriere_item);
        titlu.setText(film.getTitlu());
        regizor.setText(film.getRegizor());
        descriere.setText(film.getDescriere());
        return view;
    }

    public void addFilm(Film film){
        filmList.add(film);
    }
}

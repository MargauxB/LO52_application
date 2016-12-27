package com.example.margaux.test04menulattral;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by margaux on 23/12/2016.
 */

public class FilmAdapter extends BaseAdapter {

    private Context myContext;
    private List<FilmRow> myListFilmRow;

    public FilmAdapter(Context context, List<FilmRow> list){
        myContext=context;
        myListFilmRow=list;
    }
    @Override
    public int getCount() {
        return myListFilmRow.size();
    }

    @Override
    public Object getItem(int position) {
        return myListFilmRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FilmRow entry = myListFilmRow.get(position);
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(myContext);
            convertView = inflater.inflate(R.layout.film_row,null);
        }

        TextView film_name = (TextView)convertView.findViewById(R.id.film_name);
        film_name.setText(Media.fromMyHtml(entry.getName()));

        ImageView film_poster = (ImageView)convertView.findViewById(R.id.film_poster);
        film_poster.setImageDrawable(entry.getPoster());

        TextView film_year = (TextView)convertView.findViewById(R.id.film_year);
        film_year.setText(Media.fromMyHtml("<b>Année : </b>"+entry.getYear()));

        TextView film_producer = (TextView)convertView.findViewById(R.id.film_producer);
        film_producer.setText(Media.fromMyHtml("<b>Réalisateur : </b>"+entry.getProducer()));

        TextView film_actors = (TextView)convertView.findViewById(R.id.film_actors);
        film_actors.setText(Media.fromMyHtml("<b>Acteurs : </b>"+Media.setToDotList(entry.getActors())));

        TextView film_type = (TextView)convertView.findViewById(R.id.film_type);
        film_type.setText(Media.fromMyHtml("<b>Genre : </b>"+Media.setToLinearList(entry.getTypes())));

        TextView film_synopsis = (TextView)convertView.findViewById(R.id.film_resume);
        film_synopsis.setText(Media.fromMyHtml("<b>Résumé :</b><br/>"+entry.getSynopsis()));

        return convertView;
    }

}

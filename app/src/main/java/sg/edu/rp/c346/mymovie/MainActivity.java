package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMovies;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMovies = findViewById(R.id.listViewMovies);
        alMovieList = new ArrayList<>();
        final Movie movie1 = new Movie("The Avengers", "2012","pg13","Action | Sci-Fi","15/11/2014","Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovieList.add(movie1);
        Movie movie2 = new Movie("Planes", "2013","pg","Animation | Comedy","15/5/2015","Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this, R.layout.row,alMovieList);
        listViewMovies.setAdapter(caMovie);

        listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),Description.class);
                intent.putExtra("title", alMovieList.get(position).getTitle());
                intent.putExtra("year", alMovieList.get(position).getYear());
                intent.putExtra("genre", alMovieList.get(position).getGenre());
                intent.putExtra("rating", alMovieList.get(position).getRated());
                intent.putExtra("watchon", alMovieList.get(position).getWatched_on());
                intent.putExtra("getin", alMovieList.get(position).getIn_theatre());
                intent.putExtra("description", alMovieList.get(position).getDescription());
                startActivity(intent);



            }
        });






    }
}

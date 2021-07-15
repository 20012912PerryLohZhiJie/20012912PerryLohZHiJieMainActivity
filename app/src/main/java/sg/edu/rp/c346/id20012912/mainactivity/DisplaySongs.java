package sg.edu.rp.c346.id20012912.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

public class DisplaySongs extends AppCompatActivity
{
    Button btndisplayall;
    ListView lvshowall;

    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_songs);

        btndisplayall = findViewById(R.id.btnshow5stars);
        lvshowall = findViewById(R.id.lvallsongs);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);

        btndisplayall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DBHelper dbh = new DBHelper(DisplaySongs.this);
                al.clear();
                al.addAll(dbh.getAllSongs());
                aa.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity)
            {
                Song data = al.get(position);
                Intent i = new Intent(DisplaySongs.this,
                        UpdateDeleteSongs.class);
                i.putExtra("data", String.valueOf(data));
                startActivity(i);
            }
        });





    }

}
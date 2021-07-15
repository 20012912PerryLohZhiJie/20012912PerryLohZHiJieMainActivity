package sg.edu.rp.c346.id20012912.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView SongTitle,Singers,Year,Stars;
    EditText editsong, editname, edityear;
    RadioButton Star1, Star2, Star3, Star4, Star5;
    RadioGroup rgstars;
    Button Insert, ShowList;


    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongTitle = findViewById(R.id.SongTitle);
        Singers = findViewById(R.id.Singers);
        Year = findViewById(R.id.Year);
        Stars = findViewById(R.id.Stars);

        editsong = findViewById(R.id.editsong);
        editname = findViewById(R.id.editname);
        edityear = findViewById(R.id.edityear);

        rgstars = findViewById(R.id.radiogroupstars);
        Star1 = findViewById(R.id.Star1);
        Star2 = findViewById(R.id.Star2);
        Star3 = findViewById(R.id.Star3);
        Star4 = findViewById(R.id.Star4);
        Star5 = findViewById(R.id.Star5);

        Insert = findViewById(R.id.Insert);
        ShowList = findViewById(R.id.ShowList);
        Intent i = getIntent();


        Insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String songtitle = editsong.getText().toString();
                String songname = editname.getText().toString();
                String songyear = edityear.getText().toString();

                DBHelper dbh = new DBHelper(MainActivity.this);
                String inserted_details = dbh.insertSong(songtitle,songname,songyear);

                if (inserted_details != null)
                {
                    al.clear();
                    al.addAll(dbh.getAllSongs());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        ShowList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, DisplaySongs.class);
                startActivity(i);

            }
        });

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ShowList.performClick();
    }

}
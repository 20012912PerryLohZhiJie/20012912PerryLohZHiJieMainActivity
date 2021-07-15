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

import java.util.ArrayList;

public class UpdateDeleteSongs<aa> extends AppCompatActivity
{
    TextView SongID, SongTitle,Singers, Year, Stars;
    EditText editsongid,editsong, editname, edityear;
    RadioGroup rgstars;
    RadioButton Star1, Star2, Star3, Star4, Star5;
    Button btnupdate, btndelete,btncancel;
    Song data;
    ArrayList<Integer> al = new ArrayList<Integer>();
    ArrayAdapter<Song> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_songs);

        SongID = findViewById(R.id.SongID);
        SongTitle = findViewById(R.id.Title);
        Singers = findViewById(R.id.Singer);
        Year = findViewById(R.id.SongYear);
        Stars = findViewById(R.id.stars);

        editsongid = findViewById(R.id.editsongid);
        editsong = findViewById(R.id.edittitle);
        editname = findViewById(R.id.editSinger);
        edityear = findViewById(R.id.editsongyear);

        rgstars = findViewById(R.id.rg);
        Star1 = findViewById(R.id.star1);
        Star2 = findViewById(R.id.star2);
        Star3 = findViewById(R.id.star3);
        Star4 = findViewById(R.id.star4);
        Star5 = findViewById(R.id.star5);

        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        btncancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        Song song = (Song) i.getSerializableExtra("song");
        editsongid.setText(song.get_id());
        editsong.setText(song.getTitle());
        editname.setText(song.getSingers());
        edityear.setText(song.getYear());


        int stars = song.getStars();

            if (stars == 1) {
                Star1.setChecked(true);
                int star1 = Integer.parseInt(String.valueOf("*"));
                al.add(star1);
                aa.notifyDataSetChanged();

            }

            if (stars == 2) {
                Star2.setChecked(true);
                int star2 = Integer.parseInt(String.valueOf("**"));
                al.add(star2);
                aa.notifyDataSetChanged();
            }

            if (stars == 3) {
                Star3.setChecked(true);
                int star3 = Integer.parseInt(String.valueOf("***"));
                al.add(star3);
                aa.notifyDataSetChanged();
            }

            if (stars == 4) {
                Star4.setChecked(true);
                int star4 = Integer.parseInt(String.valueOf("****"));
                al.add(star4);
                aa.notifyDataSetChanged();
            }

            if (stars == 5) {
                Star5.setChecked(true);
                int star5 = Integer.parseInt(String.valueOf("*****"));
                al.add(star5);
                aa.notifyDataSetChanged();
            }



        btnupdate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                song.setTitle(editsong.getText().toString());
                song.setSingers(editname.getText().toString());
                song.setYear(edityear.getText().toString());

                DBHelper dbh = new DBHelper(UpdateDeleteSongs.this);

                dbh.updateSong(song);
                setResult(RESULT_OK);
                finish();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DBHelper dbh = new DBHelper(UpdateDeleteSongs.this);
                dbh.deleteSong(data.get_id());
                finish();

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });



    }
}
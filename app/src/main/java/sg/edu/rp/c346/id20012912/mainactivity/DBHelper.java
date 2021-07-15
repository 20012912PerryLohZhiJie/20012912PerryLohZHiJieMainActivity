package sg.edu.rp.c346.id20012912.mainactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "ndpsongs.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SONG = "songs";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final int COLUMN_YEAR = 0;
    private static final int COLUMN_STARS = 0;
    private int year = 0;
    private int stars = 0;
    private String singers = "";

    public DBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String Sql = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT,%s TEXT,%dINTEGER,%dINTEGER )",
                                TABLE_SONG, COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STARS);
        db.execSQL(Sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN  module_name TEXT ");
    }


    public ArrayList<Song> getAllSongs()
    {
        ArrayList<Song> songs = new ArrayList<Song>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_TITLE + COLUMN_SINGERS + COLUMN_YEAR + COLUMN_STARS + " FROM " + TABLE_SONG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singers =cursor.getString(2);
                int year = cursor.getInt(3);
                int stars = cursor.getInt(4);
                Song newsong = new Song(title, singers, year, stars);
                songs.add(newsong);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }

    public String insertSong(String songtitle, String songname, String songdata)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, songdata);
        values.put(COLUMN_TITLE, songdata);
        values.put(COLUMN_SINGERS, songdata);
        values.put(String.valueOf(COLUMN_YEAR), songdata);
        values.put(String.valueOf(COLUMN_STARS), songdata);
        return songtitle;
    }


    public void updateSong(Song data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String songyear = String.valueOf(data.getYear());
        String songstars = String.valueOf(data.getStars());

        values.put(COLUMN_ID, data.get_id());
        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_SINGERS, data.getSingers());
        values.put(String.valueOf(COLUMN_YEAR), songyear);
        values.put(String.valueOf(COLUMN_STARS), songstars);

        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.get_id())};
        int result = db.update(TABLE_SONG, values, condition, args);
        db.close();

    }

    public void deleteSong(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_SONG, condition, args);
        db.close();


    }


    public void updateSong(String title, String singers, int year)
    {

    }
}

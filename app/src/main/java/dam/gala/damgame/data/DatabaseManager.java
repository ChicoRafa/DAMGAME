package dam.gala.damgame.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import dam.gala.damgame.model.Question;

public class DatabaseManager {
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(DataBaseHelper dataBaseHelper){
        this.sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }
    public ArrayList<Question> getPreguntas(){
        ArrayList<Question> preguntas=new ArrayList<>();
        Cursor cursor = this.sqLiteDatabase.query("PREGUNTA",
                null,null,null,null,null,null);
        while(!cursor.isAfterLast() && !cursor.isBeforeFirst()){
            Question question = new Question(cursor.getString(3),
                    cursor.getInt(4),cursor.getInt(5),null,null,10);
            preguntas.add(question);
            cursor.moveToNext();
        }

        return preguntas;
    }
}

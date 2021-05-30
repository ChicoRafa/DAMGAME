package dam.gala.damgame.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.stream.Collectors;

import dam.gala.damgame.model.Answer;
import dam.gala.damgame.model.Question;

public class DatabaseManager {
    private SQLiteDatabase sqLiteDatabase;
    public DatabaseManager(DataBaseHelper databaseHelper){
        this.sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Answer> answers = new ArrayList<>();
        Question question=null;
        Answer answer = null;

        Cursor qCursorQ = sqLiteDatabase.rawQuery("SELECT * FROM PREGUNTA;",
                null);
//otro cursosr.
        while(qCursorQ.moveToNext()) {
            question = new Question(qCursorQ.getInt(0), //numero
                    qCursorQ.getInt(1), //curso
                    qCursorQ.getInt(2), //asignatura
                    qCursorQ.getString(3), //enunciado
                    qCursorQ.getInt(4), //complejidad
                    qCursorQ.getInt(5)); //tipo
            questions.add(question);
        }
        qCursorQ.close();

        Cursor qCursorA = sqLiteDatabase.rawQuery("SELECT * FROM RESPUESTA;",
                null);

        while(qCursorA.moveToNext()) {
            answer = new Answer(qCursorA.getInt(0), //numero_pregunta
                    qCursorA.getInt(1), //curso
                    qCursorA.getInt(2), //asignatura
                    qCursorA.getInt(3), //numero
                    qCursorA.getString(4), //respuesta
                    qCursorA.getInt(5) //correcta
            );
            answers.add(answer);
        }
        qCursorA.close();

        for(Question q:questions){
            q.setRespuestas(answers.stream().filter(f->f.getCurso()==q.getCurso() &&
                    f.getAsignatura()==q.getAsignatura() &&
                    f.getNumQuest() == q.getNivel()).collect(Collectors.toList()));
        }

        return questions;
    }
}

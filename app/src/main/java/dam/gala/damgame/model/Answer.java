package dam.gala.damgame.model;

/**
 *
 */
public class Answer {
    private int numQuest;
    private int curso;
    private int asignatura;
    private int nivel;
    private String answer;
    private int correct;

    public Answer(int numQuest, int curso, int asignatura, int nivel, String answer, int correct) {
        this.numQuest = numQuest;
        this.curso = curso;
        this.asignatura = asignatura;
        this.nivel = nivel;
        this.answer = answer;
        this.correct = correct;
    }

    public int getNumQuest() {
        return numQuest;
    }

    public int getCurso() {
        return curso;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public int getNivel() {
        return nivel;
    }

    public String getAnswer() {
        return answer;
    }

    public int getCorrect() {
        return correct;
    }
}
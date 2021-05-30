package dam.gala.damgame.model;

import dam.gala.damgame.activities.GameActivity;
import dam.gala.damgame.scenes.Scene;

/**
 * Gestiona la configuración de la aplicación
 *
 * @author 2º DAM - IES Antonio Gala
 * @version 1.0
 */
public class GameConfig {
    //questions
    private int questions = 5;
    private int timeToQuestion = 60;
    private int framesToNewQuestion = 0;
    //crash blocks
    private int crashBlocks = 5;
    private int timeToCrashBlock = 20;
    private int framesToNewCrashBlock = 0;
    private int minHeightCrashBlock = 0;
    //gravity
    private int gravity = 3;
    private Scene scene;

    //Setter gravity
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public GameConfig(Scene scene) {
        this.scene = scene;
        this.crashBlocks = scene.getScreenWidth() / (2 * scene.getCrashViewWidth());
        this.minHeightCrashBlock = scene.getBouncyViewHeight() / 2;
    }

    /* Métodos getter y setters para propiedades de configuración del juego */
    //preguntas
    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }
    //tiempo para salida de pregunta
    public int getTimeToQuestion() {
        return timeToQuestion;
    }

    public void setTimeToQuestion(int timeToQuestion) {
        this.timeToQuestion = timeToQuestion;
    }
    public int getFramesToNewQuestion() {
        return framesToNewQuestion;
    }

    public void setFramesToNewQuestion(int framesToNewQuestion) {
        this.framesToNewQuestion = framesToNewQuestion;
    }
    //frames para creación de nuevo bloque de colisión
    public int getFramesToNewCrashBlock() {
        return framesToNewCrashBlock;
    }

    public void setFramesToNewCrashBlock(int framesToNewCrashBlock) {
        this.framesToNewCrashBlock = framesToNewCrashBlock;
    }
    //tiempo para colision
    public int getTimeToCrashBlock() {
        return timeToCrashBlock;
    }
    public void setTimeToCrashBlock(int timeToCrashBlock) {
        this.timeToCrashBlock = timeToCrashBlock;
    }
    //bloques colisionables
    public int getCrashBlocks() {
        return crashBlocks;
    }
    //bloques colisionables
    public void setCrashBlocks(int crashBlocks) {
        this.crashBlocks = crashBlocks;
    }
    //altura minima de choque
    public int getMinHeightCrashBlock() {
        return minHeightCrashBlock;
    }
    public void setMinHeightCrashBlock(int minHeightCrashBlock) {
        this.minHeightCrashBlock = minHeightCrashBlock;
    }
    //gravedad
    public int getGravity() {
        return this.gravity;
    }
}

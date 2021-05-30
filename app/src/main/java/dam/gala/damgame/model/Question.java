package dam.gala.damgame.model;

import java.util.List;

import dam.gala.damgame.utils.GameUtil;

/**
 * Pregunta
 * @author 2º DAM - IES Antonio Gala
 * @version 1.0
 */
public class Question {
    private String enunciado;
    private int complejidad;
    private int tipo;
    private List<Answer> respuestas;
    private int puntos;
    private int curso;
    private int asignatura;
    private int nivel;
    /**
     * Construye una pregunta a partir de las propiedades indicadas como parámetros
     * @param enunciado Enunciado de la pregunta
     * @param complejidad Complejidad de la pregunta (ALTA O BAJA)
     * @param tipo Tipo de pregunta (respuesta simple o respuesta múltiple)
     */
    public Question(int numero,int curso, int asignatura, String enunciado, int complejidad
            , int tipo){
        this.enunciado=enunciado;
        this.complejidad = complejidad;
        this.tipo = tipo;
        this.puntos = complejidad ==
                GameUtil.PREGUNTA_COMPLEJIDAD_ALTA?GameUtil.PUNTOS_PREGUNTA_CALTA:
                GameUtil.PUNTOS_PREGUNTA_CBAJA;
        this.asignatura = asignatura;
        this.nivel = nivel;
        this.curso = curso;
    }

    //-----------------------------------------------------------------------------------------
    //Métodos getter y setter para propiedades la pregunta
    //-----------------------------------------------------------------------------------------
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Answer> getRespuestas() {
        return respuestas;
    }
    public int getPuntos() {
        return puntos;
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
    public void setRespuestas(List<Answer> respuestas) {
        this.respuestas = respuestas;
    }
}

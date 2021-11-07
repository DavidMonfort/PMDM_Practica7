package com.example.a6_dashboard.model;

public class Pregunta {
    private String enunciado;
    private String respuesta1;
    private String respuesta2;

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    private boolean respuestaCorrecta;

    /**
     * Constructor de la clase pregunta.
     * @param enunciado
     * @param respuesta1
     * @param respuesta2
     * @param respuestaCorrecta true es correcta la primera respuesta, false es correcta la segunda
     */
    public Pregunta(String enunciado, String respuesta1, String respuesta2, boolean respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuestaCorrecta = respuestaCorrecta;
    }


}

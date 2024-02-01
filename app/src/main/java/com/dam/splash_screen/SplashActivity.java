/*
    Creación de un Splash Screen.
    Aquí hay varias cosas que no hemos visto, pero que veremos a la vuelta de las vacas.

    Las dos cosas nuevas son:
        1. Objetos Intent -> se usan para lanzar otra actividad, es decir, pasar a otra "Pantallita"
        2. TimerTask -> Es la forma de ejecutar una tarea controlada por tiempo.

    IMPORTANTE : Hay que modificar el fichero "AndroidManifest" e incluir todas las actividades
    que contenga la aplicación. En este caso son dos. Por favor, id a este fichero y mirad cómo están
    declaradas y quién empieza antes.

    Pondré todo esto más detallado en los apuntes, pero el código es muy simple y no deberíais tener
    problemas en entenderlo.

    ¡Hasta el año que viene!
 */

package com.dam.splash_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        // Crea una tarea asyncrona
        // Sobrescribe el método run() para indicar qué se hará cuando se ejecute.
        TimerTask tarea = new TimerTask()
        {
            @Override
            public void run()
            {
                // Es un Intent especial, porque ejecuta otra actividad del proyecto (no externa)
                // Esto se sabe porque la extensión es .class ¿Ok?
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                // La ejecuta como si fuera un proceso (aunque no exactamente igual)
                // Lo veremos en clase porque hay muchas diferencias.
                startActivity(intent);

                // Termina
                finish();
            }
        };

        // Usa un temporizador para lanzar la tarea anterior
        // He puesto 3seg, poned lo que queráis.
        Timer timeOut = new Timer();
        timeOut.schedule(tarea, 3000);
    }
}
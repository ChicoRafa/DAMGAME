package dam.gala.damgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import dam.gala.damgame.R;
import dam.gala.damgame.utils.GameUtil;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class PlayActivity extends AppCompatActivity {
    private int codigoScena;
    private final int SETTINGS = 1;
    private final int GAME_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //actividad principal
        setContentView(R.layout.activity_principal);
        //Esconde IU y establece tema
        hideSystemUI();
        setTema();
        //enlaza botones de vista con actividad
        Button btLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        ///on click para el boton del login
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(PlayActivity.this, GameActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
            }
        });
        //on click para el botón del register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(PlayActivity.this, RegisterActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
            }
        });
    }

    /**
     * Elimina la barra de acción y deja el mayor área posible de pantalla libre
     */
    public void hideSystemUI() {

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // establece el contenido de forma que aparezca bajo las barras de sistema,
                        // con el fin de que no se redimensionen al esconder y mostrar las barras
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // esconde barra de navegación y de estado
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    /**
     * Establece el tema seleccionado en las preferencias, en este caso, el tema será el de la ciudad
     */
    private void setTema() {
        this.codigoScena = Integer.parseInt(getDefaultSharedPreferences(this).
                getString("theme_setting", String.valueOf(GameUtil.TEMA_CIUDAD)));
        switch (this.codigoScena) {
            case GameUtil.TEMA_CIUDAD:
                setTheme(R.style.City_DamGame);
                break;
            default:
                setTheme(R.style.City_DamGame);
                break;
        }

    }


}
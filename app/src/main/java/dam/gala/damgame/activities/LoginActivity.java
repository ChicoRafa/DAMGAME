package dam.gala.damgame.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dam.gala.damgame.R;

import dam.gala.damgame.utils.GameUtil;


import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class LoginActivity extends AppCompatActivity {
    private int codigoScena;
    private static final int GAME_ACTIVITY = 2;
    private Button btnLogin;
    private EditText edTextEmail;
    private EditText edTextPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //se selecciona la actividad de login
        setContentView(R.layout.activity_login);
        //Esconde IU y estipula tema
        hideSystemUI();
        setTema();
        //se enlazan los botones con las variables
        btnLogin = findViewById(R.id.btnLogin);
        edTextEmail = findViewById(R.id.EmailLogin);
        edTextPswd = findViewById(R.id.PasswordLogin);
        //Al hacer click en login se procede con el mismo
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(LoginActivity.this, GameActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
                loger();
            }

        });

    }

    /**
     * Método que permite el inicio de sesión en la app, básicamente toma una cadena y hace un toast
     */
    private void loger() {
        Context context = getApplicationContext();
        CharSequence text = "Inicio de sesión exitoso";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Elimina la barra de acción y deja el mayor área posible de pantalla libre
     */
    public void hideSystemUI() {
        // Activa el modo inmersivo normal.
        // para el modo "lean back", elimine SYSTEM_UI_FLAG_IMMERSIVE.
        // o para "sticky immersive," reemplacelo por SYSTEM_UI_FLAG_IMMERSIVE_STICKY
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
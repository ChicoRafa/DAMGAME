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

public class RegisterActivity extends AppCompatActivity {
    private int codigoScena;
    private static final int GAME_ACTIVITY = 2;
    private Button btnRegister;
    private EditText inputUsername;
    private EditText inputEmail;
    private EditText inputPassword;
    private final int SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //actividad de registro
        setContentView(R.layout.activity_register);
        //esconde IU y establece tema
        hideSystemUI();
        setTema();
        inputUsername = (EditText) findViewById(R.id.UsernameRegister);
        inputEmail = (EditText) findViewById(R.id.RegisterEmail);
        inputPassword = (EditText) findViewById(R.id.PasswordRegister);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(RegisterActivity.this, GameActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
                register();
            }
        });
    }

    /**
     * Método de registro, toma los datos del usuario y los almacena/registra,
     * tras eso realiza un toast mostrando el registro exitoso
     */
    private void register() {
        Context context = getApplicationContext();
        CharSequence text = "Registro exitoso";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    /**
     * Elimina la barra de acción y deja el mayor área posible de pantalla libre
     */
    public void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

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
package dam.gala.damgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        setContentView(R.layout.activity_login);

        hideSystemUI();
        setTema();

        btnLogin = findViewById(R.id.btnLogin);
        edTextEmail = findViewById(R.id.editTextRegisterEmail);
        edTextPswd = findViewById(R.id.editTextPasswordRegister);

     /*   btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(LoginActivity.this, GameActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
            }
        }); */

        }


    /**
     * Elimina la barra de acción y deja el mayor área posible de pantalla libre
     */
    public void hideSystemUI(){
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

    private void setTema(){
        this.codigoScena = Integer.parseInt(getDefaultSharedPreferences(this).
                getString("theme_setting",String.valueOf(GameUtil.TEMA_CIUDAD)));
        switch(this.codigoScena){
            case GameUtil.TEMA_CIUDAD:
                setTheme(R.style.City_DamGame);
                break;
            default:
                setTheme(R.style.City_DamGame);
                break;
        }

    }
}
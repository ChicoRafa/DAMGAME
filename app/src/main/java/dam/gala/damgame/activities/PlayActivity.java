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
    private final int SETTINGS =1;
    private final int GAME_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        hideSystemUI();
        setTema();

        Button btLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferences = new Intent(PlayActivity.this, GameActivity.class);
                startActivityForResult(preferences, GAME_ACTIVITY);
            }
        });
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
    public void hideSystemUI(){

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
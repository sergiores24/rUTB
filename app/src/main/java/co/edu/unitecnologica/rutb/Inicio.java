package co.edu.unitecnologica.rutb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent moverse= new Intent();
        moverse.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        moverse.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        moverse.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        setContentView(R.layout.activity_inicio);
        String user= getDefaults("user",getApplicationContext());
        String pass= getDefaults("",getApplicationContext());
        if(user=="" && pass==""){
            moverse.setClass(getApplicationContext(), LoginActivity.class);
        }else{
            moverse.setClass(getApplicationContext(),PrincipalMenu.class);
        }
        startActivity(moverse);
    }

    public static String getDefaults(String nom, Context cntxt) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cntxt);
        return preferences.getString(nom, null);
    }

    private void setDefaults(String nom, String cont, Context cntxt) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(cntxt);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(nom, cont);
        editor.commit();
    }
}

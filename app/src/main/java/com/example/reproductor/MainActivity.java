package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView lamazacuato;
    LinearLayout fondin, colorin;
    TextView textin;
    int posicion = 0;
    MediaPlayer[] player = new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lamazacuato = (ImageView) findViewById(R.id.icono);
        textin = findViewById(R.id.textazo);
        fondin = findViewById(R.id.fondazo);
        colorin = findViewById(R.id.colorazo);
        player[0] = MediaPlayer.create(this, R.raw.necromancindancin);
        player[1] = MediaPlayer.create(this, R.raw.photosynthesis);
        player[2] = MediaPlayer.create(this, R.raw.dontmakemechange);
        player[3] = MediaPlayer.create(this, R.raw.smokesignals);
        player[4] = MediaPlayer.create(this, R.raw.everythingmachine);
    }

    public void play_pause(View view) {
        if (player[posicion].isPlaying()) {
            player[posicion].pause();
        } else {
            player[posicion].start();
        }
    }

    public void Stop(View view) {
        if (player[posicion] != null) {
                player[posicion].stop();
                player[0] = MediaPlayer.create(this, R.raw.necromancindancin);
                player[1] = MediaPlayer.create(this, R.raw.photosynthesis);
                player[2] = MediaPlayer.create(this, R.raw.dontmakemechange);
                player[3] = MediaPlayer.create(this, R.raw.smokesignals);
                player[4] = MediaPlayer.create(this, R.raw.everythingmachine);
                posicion = 0;
                lamazacuato.setImageResource(R.drawable.necromanciniconazo);
                fondin.setBackgroundResource(R.drawable.necromanciniconazo);
                textin.setText(R.string.NecroSongTitle);
                colorin.setBackgroundColor(Color.parseColor("#667A7C"));
        }
    }

    public void Siguiente (View view){
        if (posicion < player.length -1){

            if(player[posicion].isPlaying()){
                player[posicion].stop();
                posicion++;
                player[posicion].start();
            }else{
                posicion++;
            }
            switch(posicion){
                case 0:
                    lamazacuato.setImageResource(R.drawable.necromanciniconazo);
                    fondin.setBackgroundResource(R.drawable.necromanciniconazo);
                    textin.setText(R.string.NecroSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#667A7C"));
                    break;
                case 1:
                    lamazacuato.setImageResource(R.drawable.photosynthesisiconazo);
                    fondin.setBackgroundResource(R.drawable.photosynthesisiconazo);
                    textin.setText(R.string.PhotoSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#7C6666"));
                    break;
                case 2:
                    lamazacuato.setImageResource(R.drawable.dontmakeiconazo);
                    fondin.setBackgroundResource(R.drawable.dontmakeiconazo);
                    textin.setText(R.string.ChangeSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#7C7166"));
                    break;
                case 3:
                    lamazacuato.setImageResource(R.drawable.smokesignalsiconazo);
                    fondin.setBackgroundResource(R.drawable.smokesignalsiconazo);
                    textin.setText(R.string.SmokeSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#66737C"));
                    break;
                case 4:
                    lamazacuato.setImageResource(R.drawable.everythingmachineiconazo);
                    fondin.setBackgroundResource(R.drawable.everythingmachineiconazo);
                    textin.setText(R.string.EverythingSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#6E667C"));
                    break;
            }

        }else{
            Toast.makeText(this, R.string.NoMoreSongs, Toast.LENGTH_SHORT).show();
        }
    }

    public  void Anterior(View view){
        if(posicion >= 1){

            if(player[posicion].isPlaying()){
                player[posicion].stop();
                player[0] = MediaPlayer.create(this, R.raw.necromancindancin);
                player[1] = MediaPlayer.create(this, R.raw.photosynthesis);
                player[2] = MediaPlayer.create(this, R.raw.dontmakemechange);
                player[3] = MediaPlayer.create(this, R.raw.smokesignals);
                player[4] = MediaPlayer.create(this, R.raw.everythingmachine);
                posicion--;
                player[posicion].start();
            }else{
                posicion--;
            }
            switch(posicion){
                case 0:
                    lamazacuato.setImageResource(R.drawable.necromanciniconazo);
                    fondin.setBackgroundResource(R.drawable.necromanciniconazo);
                    textin.setText(R.string.NecroSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#667A7C"));
                break;
                case 1:
                    lamazacuato.setImageResource(R.drawable.photosynthesisiconazo);
                    fondin.setBackgroundResource(R.drawable.photosynthesisiconazo);
                    textin.setText(R.string.PhotoSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#7C6666"));
                break;
                case 2:
                    lamazacuato.setImageResource(R.drawable.dontmakeiconazo);
                    fondin.setBackgroundResource(R.drawable.dontmakeiconazo);
                    textin.setText(R.string.ChangeSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#7C7166"));
                break;
                case 3:
                    lamazacuato.setImageResource(R.drawable.smokesignalsiconazo);
                    fondin.setBackgroundResource(R.drawable.smokesignalsiconazo);
                    textin.setText(R.string.SmokeSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#66737C"));
                break;
                case 4:
                    lamazacuato.setImageResource(R.drawable.everythingmachineiconazo);
                    fondin.setBackgroundResource(R.drawable.everythingmachineiconazo);
                    textin.setText(R.string.EverythingSongTitle);
                    colorin.setBackgroundColor(Color.parseColor("#6E667C"));
                break;
            }

        }else{
            Toast.makeText(this, R.string.NoMoreSongs, Toast.LENGTH_SHORT).show();
        }
    }

}
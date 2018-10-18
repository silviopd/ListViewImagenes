package com.example.user.listviewimagenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main7Activity extends YouTubeBaseActivity implements View.OnClickListener{

    TextView titulo;
    YouTubePlayerView video;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Bundle parametros = this.getIntent().getExtras();
        final String titu = parametros.getString("titulo");
        video = (YouTubePlayerView) findViewById(R.id.videoyt);
        titulo = (TextView) findViewById(R.id.lblTitulo);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        titulo.setText(titu);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("Wuc4xEzNJY8");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        video.initialize("AIzaSyCChp3dAaOYQd6hUO1pWt2_knHV9Dkn7os",onInitializedListener);

        this.setTitle(titu);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent pantalla2 = new Intent(this, MainActivity.class);
        startActivity(pantalla2);
    }

}
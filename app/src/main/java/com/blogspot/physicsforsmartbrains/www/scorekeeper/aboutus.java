package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }

    public void facebook(View view){
        String url="https://www.facebook.com/awesomescience0/";

        Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent chooser = Intent.createChooser(yt_play , "Open With");

        if (yt_play .resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
    public void youtube(View view){
        String url="https://www.youtube.com/channel/UCVq7rvBCSRY2qdl0GnRONDw";

        Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent chooser = Intent.createChooser(yt_play , "Open With");

        if (yt_play .resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
    public void linkedin(View view){
        String url="https://www.linkedin.com/in/aakash-yadav-4a2376140/";
        Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent chooser = Intent.createChooser(yt_play , "Open With");

        if (yt_play .resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
    public void web(View view){
        String url="https://physicsforsmartbrains.blogspot.in/";
        Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent chooser = Intent.createChooser(yt_play , "Open With");

        if (yt_play .resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}

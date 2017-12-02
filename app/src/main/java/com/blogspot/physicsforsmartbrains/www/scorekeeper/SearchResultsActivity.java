package com.blogspot.physicsforsmartbrains.www.scorekeeper;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        handleIntent(getIntent());


    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }
    private static final String TAG = "MyActivity";

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow

            Log.v(TAG,query);
            Log.v("hello","you");
            TextView textView = (TextView)findViewById(R.id.hello_moto);
            textView.setText(query);

        }
    }
}

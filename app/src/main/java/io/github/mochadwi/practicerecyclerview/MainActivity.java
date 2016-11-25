package io.github.mochadwi.practicerecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button arrayList;
    Button okHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = (Button) findViewById(R.id.btn_arraylist);
        okHttp = (Button) findViewById(R.id.btn_okhttp);

        arrayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ArrayListActivity.class));
            }
        });

        okHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
            }
        });
    }
}

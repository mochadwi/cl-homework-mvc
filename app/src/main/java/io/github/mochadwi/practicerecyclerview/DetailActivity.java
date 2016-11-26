package io.github.mochadwi.practicerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    private TextView txtTitle;
    private TextView txtPublisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        txtTitle.setText(getIntent().getStringExtra("Judul"));
        txtPublisher.setText(getIntent().getStringExtra("Penerbit"));
    }

    private void initView() {
        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtPublisher = (TextView) findViewById(R.id.txt_publisher);
    }
}

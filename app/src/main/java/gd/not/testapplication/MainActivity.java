package gd.not.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((TestApplication)getApplication()).getComponent().inject(this);

        setContentView(R.layout.activity_main);


    }
}

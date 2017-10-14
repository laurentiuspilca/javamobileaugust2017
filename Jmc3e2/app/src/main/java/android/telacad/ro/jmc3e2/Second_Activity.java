package android.telacad.ro.jmc3e2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        textView=(TextView)findViewById(R.id.textView1);

        Intent intent=getIntent();
        Persoana p=(Persoana) intent.getSerializableExtra("persoana");

        textView.setText("You know nothing,\n"+p);
    }
}

package android.telacad.ro.jmc4e2;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView nume_actor, nume_singer;
    private Button selectActor, selectSinger, afisare;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==1)
        {
            if(data!=null){
                Actor a=(Actor)data.getSerializableExtra("actor");
                nume_actor.setText(a.getNume());
            }

        }
        else
        {
            if(data!=null){
                Singer a=(Singer) data.getSerializableExtra("singer");
                nume_singer.setText(a.getNume());
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nume_actor=(TextView)findViewById(R.id.actor_name);
        nume_singer=(TextView)findViewById(R.id.singer_name);
        selectActor=(Button)findViewById(R.id.actor_buton);
        selectSinger=(Button)findViewById(R.id.singer_buton);
        afisare=(Button)findViewById(R.id.afisaza);
        selectActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, ActorActivity.class);
                startActivityForResult(i,1);
            }
        });
        selectSinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, SingerActivity.class);
                startActivityForResult(i,2);
            }
        });
        afisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actor=nume_actor.getText().toString();
                String singer=nume_singer.getText().toString();
                Toast.makeText(MainActivity.this,"Ai selectat "+actor+ " si "+singer,Toast.LENGTH_LONG).show();
            }
        });
    }
}

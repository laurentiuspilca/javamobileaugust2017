package android.telacad.ro.jmc2e5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.buton);
        user=(EditText)findViewById(R.id.userIntrod);
        pass=(EditText)findViewById(R.id.passIntrod);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifica();
            }
        });
    }
    public void verifica(){
        String u=user.getText().toString();
        String p=pass.getText().toString();
        if(u.equals("ada")&&p.equals("12345"))
        {
            Intent intent=new Intent(MainActivity.this,AplicationActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(MainActivity.this, "Login reusit!", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"Username sau parola gresite!",Toast.LENGTH_LONG).show();
    }
}

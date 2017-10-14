package android.telacad.ro.jmc4e3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc4e3.Entities.Contact;
import android.telacad.ro.jmc4e3.Managers.DBManager;
import android.telacad.ro.jmc4e3.dao.ContactDao;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    private Button btnAdauga,btnAfisare;
    private EditText etTel,etNume;
    private ContactDao dao;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager=new DBManager(this);
        dao=new ContactDao(dbManager);

        btnAdauga=(Button)findViewById(R.id.addContact);
        btnAfisare=(Button)findViewById(R.id.viewContact);
        etNume=(EditText)findViewById(R.id.editnume);
        etTel=(EditText)findViewById(R.id.edittel);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nume=etNume.getText().toString();
                String tel=etTel.getText().toString();
                Contact c=new Contact();
                c.setNume(nume);
                c.setTel(tel);
                dao.adaugaContact(c);
                Toast.makeText(AddContactActivity.this,"A fost adaugat un contact!",Toast.LENGTH_LONG).show();
            }
        });
        btnAfisare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddContactActivity.this, ViewContactsActivity.class);
                startActivity(i);
            }
        });
    }
}

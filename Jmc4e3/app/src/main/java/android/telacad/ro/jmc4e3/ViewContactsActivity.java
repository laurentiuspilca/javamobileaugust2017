package android.telacad.ro.jmc4e3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc4e3.Entities.Contact;
import android.telacad.ro.jmc4e3.Managers.DBManager;
import android.telacad.ro.jmc4e3.dao.ContactDao;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewContactsActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<Contact> adapter;
    private DBManager dbManager;
    private ContactDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        list=(ListView)findViewById(R.id.list);
        adapter=new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        dbManager=new DBManager(this);
        dao=new ContactDao(dbManager);
        List<Contact> contacts=dao.getContacte();
        for (Contact c:contacts)
        {
            adapter.add(c);
        }

    }
}

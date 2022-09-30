package com.lakshaykamat.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Contacts contacts0 = new Contacts("777888999","Lakshay", R.drawable.deafultusrimage);
    Contacts contacts1 = new Contacts("777888999","Jasmine Shukla",R.drawable.jasmine);
    Contacts contacts2 = new Contacts("777888999","Khusi", R.drawable.tomato);
    Contacts contacts3 = new Contacts("777888999","Divisha",R.drawable.div);
    Contacts contacts4 = new Contacts("777888999","Kunal",R.drawable.kunal);
    Contacts contacts5 = new Contacts("777888999","Ronit",R.drawable.deafultusrimage);
    Contacts contacts6 = new Contacts("777888999","Shaytam",R.drawable.shatam);
    Contacts contacts7 = new Contacts("777888999","Sakshi Srivastava",R.drawable.saks);
    Contacts contacts8 = new Contacts("777888999","Aadya Singh",R.drawable.deafultusrimage);
    Contacts contacts9 = new Contacts("777888999","Stranger",R.drawable.deafultusrimage);
    Contacts contacts10 = new Contacts("777888999","Aaditya",R.drawable.deafultusrimage);

    Contacts[] peoples = {contacts0,contacts1,contacts2,contacts3,contacts4,contacts5,contacts6,contacts7,contacts8,contacts9,contacts10};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter myAdapter = new CustomAdapter(peoples);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
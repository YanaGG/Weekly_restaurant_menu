package yana.geo.weeklyrestaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note>notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("Breakfast", "French toast","Fried toast", "Saturday", 2));
        notes.add(new Note("Lunch", "Onion soup", "Soup with onion","Saturday", 2));
        notes.add(new Note("Dinner", "Pepper steak", "Pork meat with pepper sauce","Saturday", 1));
        notes.add(new Note("Breakfast", "Croissants", "Puff pastry","Sunday", 2));
        notes.add(new Note("Lunch", "Paella", "Vegetables with rice and seafood","Sunday", 2));
        notes.add(new Note("Dinner", "Pizza", "Pizza Margherita","Sunday", 2));
        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
    }
}
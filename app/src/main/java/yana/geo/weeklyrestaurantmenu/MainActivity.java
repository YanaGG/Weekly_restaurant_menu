package yana.geo.weeklyrestaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note>notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("Breakfast", "French toast","Fried toast", "Saturday", 2));
        notes.add(new Note("Lunch", "Onion soup", "Soup with onion","Saturday", 1));
        notes.add(new Note("Dinner", "Pepper steak", "Pork meat with pepper sauce","Saturday", 3));
        notes.add(new Note("Breakfast", "Croissants", "Puff pastry","Sunday", 2));
        notes.add(new Note("Lunch", "Paella", "Seafood with rice and vegetables","Sunday", 1));
        notes.add(new Note("Dinner", "Pizza", "Pizza Margherita","Sunday", 1));
        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}
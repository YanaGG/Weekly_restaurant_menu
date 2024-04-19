package yana.geo.weeklyrestaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {

    private Spinner spinnerMealOfDay;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupTypeOfMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        spinnerMealOfDay = findViewById(R.id.spinnerDayMeal);
        editTextTitle = findViewById(R.id.editTextDishTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDayOfWeek);
        radioGroupTypeOfMeal = findViewById(R.id.radioGroupCuisineCode);
    }

    public void onClickSaveNote(View view) {
        String mealOfDay = spinnerMealOfDay.getSelectedItem().toString();
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String daysOfWeek = spinnerDaysOfWeek.getSelectedItem().toString();
        int radioButtonId = radioGroupTypeOfMeal.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int type = Integer.parseInt(radioButton.getText().toString());
        Note note = new Note(mealOfDay, title, description, daysOfWeek, type);
        MainActivity.notes.add(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
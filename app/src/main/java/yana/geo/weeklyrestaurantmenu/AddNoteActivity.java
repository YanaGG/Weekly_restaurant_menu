package yana.geo.weeklyrestaurantmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private Spinner spinnerMealOfDay;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupTypeOfMeal;
    private NotesDBHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        dbHelper = new NotesDBHelper(this);
        database = dbHelper.getWritableDatabase();
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
        if (isFilled(title, description)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_MEAL, mealOfDay);
            contentValues.put(NotesContract.NotesEntry.COLUMN_MEAL_TITLE, title);
            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, description);
            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, daysOfWeek);
            contentValues.put(NotesContract.NotesEntry.COLUMN_TYPE_OF_MEAL, type);
            database.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show();
        }

    }
    private boolean isFilled (String title, String description){
        return !title.isEmpty() && !description.isEmpty();
    }
}
package yana.geo.weeklyrestaurantmenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note>notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_elements, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int i) {
        Note note = notes.get(i);
        notesViewHolder.textViewDayMealFill.setText(note.getDayMeal());
        notesViewHolder.textViewTitleFill.setText(note.getMealTitle());
        notesViewHolder.textViewDescriptionFill.setText(note.getDescription());
        notesViewHolder.textViewDayWeekFill.setText(note.getDayOfWeek());
        int colorId;
        int cuisineCode = note.getTypeOfMeal();
        switch (cuisineCode){
            case 1:
                colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_green_dark);
                break;
            case 2:  colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_orange_dark);
                break;
            default: colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_red_dark);
            break;
        }
        notesViewHolder.textViewTitleFill.setBackgroundColor(colorId);



    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewDayMealFill;
        private TextView textViewTitleFill;
        private TextView textViewDescriptionFill;
        private TextView textViewDayWeekFill;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDayMealFill = itemView.findViewById(R.id.textViewDayMealFill);
            textViewTitleFill = itemView.findViewById(R.id.textViewTitleFill);
            textViewDescriptionFill = itemView.findViewById(R.id.textViewDescriptionFill);
            textViewDayWeekFill = itemView.findViewById(R.id.textViewDayWeekFill);

        }
    }
}

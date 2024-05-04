package yana.geo.weeklyrestaurantmenu;

public class Note {

    private int id;
    private String dayMeal;
    private String mealTitle;
    private String description;
    private String dayOfWeek;
    private int typeOfMeal;


    public Note(int id, String dayMeal, String mealTitle, String description, String dayOfWeek, int typeOfMeal) {
        this.id = id;
        this.dayMeal = dayMeal;
        this.mealTitle = mealTitle;
        this.dayOfWeek = dayOfWeek;
        this.description = description;
        this.typeOfMeal =typeOfMeal;
    }

    public int getId(){return id;}
    public String getDayMeal() {
        return dayMeal;
    }

    public String getMealTitle() {
        return mealTitle;
    }
    public String getDescription() {
        return description;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getTypeOfMeal() {
        return typeOfMeal;
    }
}




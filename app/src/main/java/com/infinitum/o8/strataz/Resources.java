package com.infinitum.o8.strataz;

public class Resources {
    private String name;
    private int imageResourceId;

    public static final Resources[] resource = {
            new Resources("Cords of Pine", R.drawable.wood_resource),
            new Resources("Cords of Cedar", R.drawable.stone_resource),
            new Resources("Cords of Maple", R.drawable.wheat_resource),
            new Resources("Tons of Tin", R.drawable.wheat_resource),
            new Resources("Tons of Copper", R.drawable.wheat_resource),
            new Resources("Tons of Iron", R.drawable.wheat_resource),
            new Resources("Teams of Horses", R.drawable.wheat_resource),
            new Resources("Tons of Gravel", R.drawable.wheat_resource),
            new Resources("Orb of Intellect", R.drawable.wheat_resource)
    };

    private Resources(String name, int imageResourceId){
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }
}
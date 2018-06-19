package com.infinitum.o8.strataz;

import java.util.ArrayList;

    public class Units {
        private String mName;
        private int mImageUnitId;
        private  int numWarriors;



        public static ArrayList<com.infinitum.o8.strataz.Units> createUnitList(int numUnits){
            ArrayList<com.infinitum.o8.strataz.Units> mUnits = new ArrayList<com.infinitum.o8.strataz.Units>();

            for (int i = 0; i<=numUnits; i++) {
                i = i+1;
                int x = 0;
                int y = 0;
                mUnits.add(new com.infinitum.o8.strataz.Units("Warrior " + (i), R.drawable.warrior_unit));
                x++;
                mUnits.add(new com.infinitum.o8.strataz.Units("Warrior " + (i+x), R.drawable.warrior_unit));
                x++;
                mUnits.add(new com.infinitum.o8.strataz.Units("Warrior " + (i+x), R.drawable.warrior_unit));
                x++;
                mUnits.add(new com.infinitum.o8.strataz.Units("Warrior " + (i+x), R.drawable.warrior_unit));
                x++;
                mUnits.add(new com.infinitum.o8.strataz.Units("Warrior " + (i+x), R.drawable.warrior_unit));
                x++;
            }
            return mUnits;
        };


        public Units(String name, int imageUnitId){
            this.mName = name;
            this.mImageUnitId = imageUnitId;
        }

        public String getName(){
            return mName;
        }

        public int getImageUnitId(){
            return mImageUnitId;
        }

        public void setName(String newName){
            this.mName = newName;
        }

        public void setImageUnitId(int newImageUnitId){
            this.mImageUnitId = newImageUnitId;
        }}

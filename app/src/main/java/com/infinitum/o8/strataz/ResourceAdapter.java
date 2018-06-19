package com.infinitum.o8.strataz;

import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ViewHolder>{

    private String[] name;
    private int [] imageIds;
    private Listener listener;
    public TextView resourceAmountView;
    public int pineInt = 0, cedarInt = 0, mapleInt = 0,
            tinInt = 0, copperInt = 0, ironInt = 0,
            horseInt = 0, gravelInt = 0, orbInt = 0;


    interface Listener{
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;
        public Button resourceMmBtn, resourceMBtn, resourcePpBtn, resourcePBtn, clearBtn;
        public TextView resourceAmountView;


        public ViewHolder(final CardView v){
            super(v);
            cardView = v;

            resourceMmBtn = (Button)itemView.findViewById(R.id.resourceMinusMBtn);
            resourceMBtn = itemView.findViewById(R.id.resourceMinusBtn);
            resourcePpBtn = itemView.findViewById(R.id.resourcePlusPBtn);
            resourcePBtn = itemView.findViewById(R.id.resourcePlusBtn);
            clearBtn = itemView.findViewById(R.id.clearBtn);

            resourceAmountView = (TextView)itemView.findViewById(R.id.resourceAmount);

        }

    }

    public ResourceAdapter(String [] name, int[] imageIds){
        this.name = name;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount(){
        return name.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }


    @Override
    public ResourceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_resources, parent, false);
        return new ViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.resourceImg);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(name[position]);
        TextView textView = cardView.findViewById(R.id.resourceText);
        textView.setText(name[position]);
        TextView resourceAmountView = cardView.findViewById(R.id.resourceAmount);

        //Only Do if First Resource in list "0"
        //Use a switch for position to dictate which card


        //if (position == 0) {
        switch(position){
//Pine
            case 0:
                //Set Wood Amount to 0
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            pineInt = pineInt - 5;
                            String resourceString = String.valueOf(pineInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            pineInt = pineInt - 1;
                            String resourceString = String.valueOf(pineInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            pineInt = pineInt + 5;
                            String resourceString = String.valueOf(pineInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            pineInt = pineInt + 1;
                            String resourceString = String.valueOf(pineInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            pineInt = 0;
                            String resourceString = String.valueOf(pineInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Cedar
            case 1:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            cedarInt = cedarInt - 5;
                            String resourceString = String.valueOf(cedarInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            cedarInt = cedarInt - 1;
                            String resourceString = String.valueOf(cedarInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            cedarInt = cedarInt + 5;
                            String resourceString = String.valueOf(cedarInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            cedarInt = cedarInt + 1;
                            String resourceString = String.valueOf(cedarInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            cedarInt = 0;
                            String resourceString = String.valueOf(cedarInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;
//Maple
            case 2:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            mapleInt = mapleInt - 5;
                            String resourceString = String.valueOf(mapleInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            mapleInt = mapleInt - 1;
                            String resourceString = String.valueOf(mapleInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            mapleInt = mapleInt + 5;
                            String resourceString = String.valueOf(mapleInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            mapleInt = mapleInt + 1;
                            String resourceString = String.valueOf(mapleInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            mapleInt = 0;
                            String resourceString = String.valueOf(mapleInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Tin
            case 3:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            tinInt = tinInt - 5;
                            String resourceString = String.valueOf(tinInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            tinInt = tinInt - 1;
                            String resourceString = String.valueOf(tinInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            tinInt = tinInt + 5;
                            String resourceString = String.valueOf(tinInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            tinInt = tinInt + 1;
                            String resourceString = String.valueOf(tinInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            tinInt = 0;
                            String resourceString = String.valueOf(tinInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Copper
            case 4:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            copperInt = copperInt - 5;
                            String resourceString = String.valueOf(copperInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            copperInt = copperInt - 1;
                            String resourceString = String.valueOf(copperInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            copperInt = copperInt + 5;
                            String resourceString = String.valueOf(copperInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            copperInt = copperInt + 1;
                            String resourceString = String.valueOf(copperInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            copperInt = 0;
                            String resourceString = String.valueOf(copperInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Iron
            case 5:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            ironInt = ironInt - 5;
                            String resourceString = String.valueOf(ironInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            ironInt = ironInt - 1;
                            String resourceString = String.valueOf(ironInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            ironInt = ironInt + 5;
                            String resourceString = String.valueOf(ironInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            ironInt = ironInt + 1;
                            String resourceString = String.valueOf(ironInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            ironInt = 0;
                            String resourceString = String.valueOf(ironInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Horse
            case 6:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            horseInt = horseInt - 5;
                            String resourceString = String.valueOf(horseInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            horseInt = horseInt - 1;
                            String resourceString = String.valueOf(horseInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            horseInt = horseInt + 5;
                            String resourceString = String.valueOf(horseInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            horseInt = horseInt + 1;
                            String resourceString = String.valueOf(horseInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            horseInt = 0;
                            String resourceString = String.valueOf(horseInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//Gravel
            case 7:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            gravelInt = gravelInt - 5;
                            String resourceString = String.valueOf(gravelInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            gravelInt = gravelInt - 1;
                            String resourceString = String.valueOf(gravelInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            gravelInt = gravelInt + 5;
                            String resourceString = String.valueOf(gravelInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            gravelInt = gravelInt + 1;
                            String resourceString = String.valueOf(gravelInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            gravelInt = 0;
                            String resourceString = String.valueOf(gravelInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;

//OoI
            case 8:
                holder.resourceAmountView.setText("0");

                //On Click --, minus 5
                holder.resourceMmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            orbInt = orbInt - 5;
                            String resourceString = String.valueOf(orbInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click -, minus 1
                holder.resourceMBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            orbInt = orbInt - 1;
                            String resourceString = String.valueOf(orbInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click ++, +5
                holder.resourcePpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            orbInt = orbInt + 5;
                            String resourceString = String.valueOf(orbInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click +, +1
                holder.resourcePBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            orbInt = orbInt + 1;
                            String resourceString = String.valueOf(orbInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });

                //On Click, clear TextView
                holder.clearBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);

                            orbInt = 0;
                            String resourceString = String.valueOf(orbInt);

                            holder.resourceAmountView.setText(resourceString);
                        }
                    }
                });
                break;
        }
    }

}

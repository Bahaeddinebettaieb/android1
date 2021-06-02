package com.itgate.androidapp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class TechnoAdapter extends RecyclerView.Adapter<TechnoAdapter.MyHolder> {
    Context context;
    List<ModelTech> techList;

    public TechnoAdapter(Context context, List<ModelTech> techList) {
        this.context = context;
        this.techList = techList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tech,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int i) {
        final ModelTech tech = techList.get(i);

        String name = techList.get(i).getName();
        String description = techList.get(i).getDescription();
        int image = techList.get(i).getImage();

        myHolder.nameTv.setText(name);
        myHolder.descriptionTv.setText(description);
        Picasso.get().load(image).into(myHolder.bImageTv);

        myHolder.itemLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Ajouter au Panier...", Toast.LENGTH_SHORT).show();
                showAlert(tech);
            }
        });
    }

    private void showAlert(ModelTech tech) {
        View view = LayoutInflater.from(context).inflate(R.layout.alert,null);

        ImageView techImg  = view.findViewById(R.id.tech_img);
        final TextView nameTv = view.findViewById(R.id.name_text);

        String name = tech.getName();
        int image = tech.getImage();


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);


            Picasso.get().load(image).into(techImg);

        nameTv.setText(name);

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    @Override
    public int getItemCount() {
        return techList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView bImageTv;
        LinearLayout itemLinear;
        TextView nameTv,descriptionTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            bImageTv = itemView.findViewById(R.id.image);
            nameTv = itemView.findViewById(R.id.name);
            descriptionTv = itemView.findViewById(R.id.description);
            itemLinear = itemView.findViewById(R.id.item_linear);
        }
    }
}

package com.example.politicalresourcefinder.ui.elections;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.politicalresourcefinder.R;
import com.example.politicalresourcefinder.ScrollingBiography;
import com.example.politicalresourcefinder.ScrollingPoliticalView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    public static final String EXTRA_INT = "com.example.politialresourcefinder.POSITION";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer>  mImage = new ArrayList<>();
    private ArrayList<String> mParty = new ArrayList<>();
    private ArrayList<String>  mWebsite = new ArrayList<>();
    private ArrayList<String> mSlogan = new ArrayList<>();
    private Context mContext;

    ImageButton img;
    TextView party;
    TextView website;
    TextView slogan;
    TextView nameqb;
    View root;

    public RecyclerViewAdapter(ArrayList<String> mNames, ArrayList<Integer> mImage, ArrayList<String> mParty, ArrayList<String> mWebsite, ArrayList<String> mSlogan, Context mContext, View root) {
        this.mNames = mNames;
        this.mImage = mImage;
        this.mContext = mContext;
        this.mParty = mParty;
        this.mWebsite = mWebsite;
        this.mSlogan = mSlogan;

        party = (TextView)root.findViewById(R.id.Party);
        website = (TextView)root.findViewById(R.id.Website);
        slogan = (TextView)root.findViewById(R.id.Slogan);
        img = (ImageButton)root.findViewById(R.id.image);
        nameqb = (TextView)root.findViewById(R.id.nameqb);
        this.root = root;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                //.load(R.drawable.candidate1)
                .into(holder.image);
        holder.name.setText(mNames.get(position));
        holder.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(mContext, "Swipe from left to go back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(root.getContext(), ScrollingBiography.class);
                intent.putExtra(EXTRA_INT,position);
                mContext.startActivity(intent);

            }
        });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(mContext, "Swipe from left to go back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(root.getContext(), ScrollingPoliticalView.class);
                intent.putExtra(EXTRA_INT,position);
                mContext.startActivity(intent);

            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(position));
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();

                party.setText(mParty.get(position));
                website.setText(mWebsite.get(position));
                website.setClickable(true);
                slogan.setText(mSlogan.get(position));
                img.setBackgroundResource(mImage.get(position));
                img.setImageResource(mImage.get(position));
                nameqb.setText(mNames.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image; //don't have to be same name is layout_list_item.xml
        TextView name;
        Button button1;
        Button button2;
        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            button1 = itemView.findViewById((R.id.button1));
            button2 = itemView.findViewById((R.id.button2));
        }
    }
}

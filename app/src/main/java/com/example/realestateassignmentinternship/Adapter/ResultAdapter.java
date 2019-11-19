package com.example.realestateassignmentinternship.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestateassignmentinternship.Model.Dob;
import com.example.realestateassignmentinternship.Model.Picture;
import com.example.realestateassignmentinternship.Model.Result;
import com.example.realestateassignmentinternship.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.Calendar;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {



    private List<Result> result;
    private int rowLayout;
    private Context context;


    public ResultAdapter(List<Result> result, int rowLayout, Context context) {
        this.result = result;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public ResultAdapter.ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ResultViewHolder holder, int position) {
        String firstName = toUpperCase(result.get(position).getName().getFirst());
        String lastName = toUpperCase(result.get(position).getName().getLast());

        holder.username.setText(firstName + " " + lastName);
        holder.age.setText(String.valueOf(result.get(position).getDob().getAge()));
        Picasso.get().load(result.get(position).getPicture().getMedium()).into(holder.imageView);

    }

    String toUpperCase(String name){
        StringBuilder sb = new StringBuilder(name);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView age;
        ImageView imageView;


        public ResultViewHolder(View v) {
            super(v);
            username = (TextView) v.findViewById(R.id.username);
            age = (TextView) v.findViewById(R.id.age);
            imageView = (ImageView) v.findViewById(R.id.userimage);
        }
    }




}

package com.san22.api_fetch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.san22.api_fetch.model.Images;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

class rvAdapter extends RecyclerView.Adapter<rvAdapter.myViewHolder> {
    Context context;
    List<Images>data= new ArrayList();

    public rvAdapter(Context context, List<Images> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    String url= data.get(position).getImages();
      Picasso.get().load(url).resize(2048,1600).onlyScaleDown().into(holder.imageView, new Callback() {
          @Override
          public void onSuccess() {
              holder.progressBar.setVisibility(View.GONE);
          }

          @Override
          public void onError(Exception e) {

          }

      });
      holder.progressBar.setVisibility(View.VISIBLE);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        ProgressBar progressBar;
        public myViewHolder(View itemview) {
            super(itemview);
             imageView=itemview.findViewById(R.id.imageView);
             progressBar=itemview.findViewById(R.id.progressBar);
        }

    }
    public void sendtoadapter(ArrayList<Images> list) {
        this.data=list;
        notifyDataSetChanged();

    }
}

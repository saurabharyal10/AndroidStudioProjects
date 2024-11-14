package com.neatroots.samplesocial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.viewHolder> {

    ArrayList<DashboardModel> list;
    Context context;
    boolean clicked = false;
    int likeCount;

    public DashboardAdapter(ArrayList<DashboardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_rv_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DashboardModel model = list.get(position);
        holder.profile.setImageResource(model.getPrfile());
        holder.dashImg.setImageResource(model.getDashboardImg());
        holder.name.setText(model.getUser_name());
        holder.bio.setText(model.getBio());
        holder.like.setText(model.getLike());
        holder.comment.setText(model.getComment());
        holder.share.setText(model.getShare());

        holder.dashImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked){
                    holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like, 0, 0, 0);
                    likeCount = Integer.parseInt(holder.like.getText()+"");
                    //holder.like.setText(likeCount++);
                    clicked = true;
                }
                else {
                    holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like_red, 0, 0, 0);
                    likeCount = Integer.parseInt(holder.like.getText()+"");
                   // holder.like.setText(Integer.parseInt(model.getLike())-1);
                    clicked = false;
                }
            }
        });

        holder.saveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!clicked){
                    holder.saveImg.setImageResource(R.drawable.saved);
                    clicked = true;
                }
                else {
                    holder.saveImg.setImageResource(R.drawable.ic_bookmark);
                    clicked = false;
                }

            }



        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView profile, dashImg, saveImg;
        TextView name, bio, like, comment, share;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);
            dashImg = itemView.findViewById(R.id.addStoryImg);
            saveImg = itemView.findViewById(R.id.saveImg);
            name = itemView.findViewById(R.id.userName);
            bio = itemView.findViewById(R.id.bio);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
        }
    }
}

package com.hh1995.myapplication.calendarteam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmMainAdapter extends RecyclerView.Adapter<AlarmMainAdapter.CustomViewHolder> {

    private ArrayList<AlarmMainData> arrayList;

    public AlarmMainAdapter(ArrayList<AlarmMainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AlarmMainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AlarmMainAdapter.CustomViewHolder holder, int position) {

        holder.tv_date.setText(arrayList.get(position).getTv_date());
        holder.tv_schedule.setText(arrayList.get(position).getTv_schedule());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_date.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());


                return true;
            }
        });
    }




    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_date;
        protected TextView tv_schedule;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            this.tv_schedule = (TextView) itemView.findViewById(R.id.tv_schedule);
        }
    }
}

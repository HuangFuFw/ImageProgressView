package com.ai.eve.ui.demo.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ai.eve.ui.demo.R;

import java.util.ArrayList;

/**
 * Created by huangfu on 2016/2/24 17:02.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> myDataset;
    private int TYPE_L=0;
    private int TYPE_R=1;


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView firstLine;
        private TextView secondLine;

        public ViewHolder(View itemView) {
            super(itemView);
            firstLine= (TextView) itemView.findViewById(R.id.firstLine);
            secondLine= (TextView) itemView.findViewById(R.id.secondLine);
        }
    }

    public MyAdapter(ArrayList<String> myDataset) {
        this.myDataset=myDataset;
    }

    public void  addItem(int position,String item){
        myDataset.add(position,item);
        notifyDataSetChanged();
    }
    public void  removeItem(int position){
        myDataset.remove(position);
        notifyDataSetChanged();
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if(viewType==TYPE_R){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rightlayout,parent,false);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        }
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.firstLine.setText(myDataset.get(position));
        holder.firstLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        holder.secondLine.setText("Footer"+myDataset.get(position));


    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
            if (position % 2 != 0) {
                return TYPE_R;
            }
        return TYPE_L;
    }
}

package com.ai.eve.ui.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ai.eve.ui.demo.R;

import java.util.ArrayList;

/**
 * Created by huangfu on 2016/8/9 17.:13
 */
public class PageFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);

        RecyclerView mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerList);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> myDataset = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            myDataset.add("item" + i);
        }
        MyAdapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }



    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<String> mDataset;
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txt;
            public ViewHolder(View v) {
                super(v);
                txt = (TextView) v.findViewById(R.id.ttt);
            }
        }
        public MyAdapter(ArrayList<String> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final String name = mDataset.get(position);
            holder.txt.setText(mDataset.get(position)+"-.-");
        }


        @Override
        public int getItemCount() {
            return mDataset.size();
        }

    }
}

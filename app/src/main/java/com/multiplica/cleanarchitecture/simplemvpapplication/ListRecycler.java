package com.multiplica.cleanarchitecture.simplemvpapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.multiplica.cleanarchitecture.simplemvpapplication.entity.EarthquakeEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 08/11/18.
 */

public class ListRecycler extends RecyclerView.Adapter<ListRecycler.ContentHolder>{

    private Context context;
    private ArrayList<EarthquakeEntity> data;

    public ListRecycler(Context context, ArrayList<EarthquakeEntity> data) {

        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_main_item, parent, false);

        return new ListRecycler.ContentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, int position) {

        ContentHolder contentHolder = (ContentHolder) holder;

        contentHolder.itemTitle.setText(data.get(position).getTitle());
        contentHolder.itemDescription.setText(data.get(position).getPlace());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    protected class ContentHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.recycler_main_item_title)
        TextView itemTitle;
        @BindView(R.id.recycler_main_item_description)
        TextView itemDescription;

        public ContentHolder(View view) {

            super(view);

            ButterKnife.bind(this, view);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.earthquake_view_item:

                default:
            }
        }
    }
}

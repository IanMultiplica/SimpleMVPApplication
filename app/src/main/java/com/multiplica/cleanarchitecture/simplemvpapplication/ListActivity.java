package com.multiplica.cleanarchitecture.simplemvpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.multiplica.cleanarchitecture.simplemvpapplication.entity.EarthquakeEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements IListInterface.View{

    @BindView(R.id.layoutRecycler)
    View layoutRecycler;
    @BindView(R.id.main_recycler_earthquakes)
    RecyclerView recyclerView;

    @BindView(R.id.layoutProgressBar)
    View layoutProgessBar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.service_recharge_header_text)
    TextView headerText;

    private ListRecycler adapter;

    private IListInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        initPresenter();
        initResources();
    }

    private void initPresenter(){
        presenter = new ListPresenterImpl(this);
        presenter.onGetEarthquakes();
    }

    private void initResources(){
        LinearLayoutManager llmGral = new LinearLayoutManager(this);
        llmGral.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llmGral);
    }

    @Override
    public void showList(ArrayList<EarthquakeEntity> earthquakes) {
        layoutRecycler.setVisibility(View.VISIBLE);
        adapter = new ListRecycler(this,earthquakes);
        recyclerView.setAdapter(adapter);
        layoutProgessBar.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessageError(String error) {
        headerText.setText(error);
        layoutProgessBar.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }
}

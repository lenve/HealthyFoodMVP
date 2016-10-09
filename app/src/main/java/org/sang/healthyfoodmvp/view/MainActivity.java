package org.sang.healthyfoodmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.sang.healthyfoodmvp.R;
import org.sang.healthyfoodmvp.model.FoodEntity;
import org.sang.healthyfoodmvp.presenter.FoodPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IFoodView {

    private ListView lv;
    private FoodPresenter presenter = new FoodPresenter(this);
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter.loadData();
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        pb = ((ProgressBar) findViewById(R.id.pb));
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void initData(List<FoodEntity> foodEntities) {
        lv.setAdapter(new MyAdapter(foodEntities, this));
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}

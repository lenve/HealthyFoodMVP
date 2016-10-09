package org.sang.healthyfoodmvp.presenter;

import android.os.Handler;

import org.sang.healthyfoodmvp.model.FoodEntity;
import org.sang.healthyfoodmvp.model.ILoadFoodData;
import org.sang.healthyfoodmvp.model.LoadFoodDataImpl;
import org.sang.healthyfoodmvp.model.OnDataLoadListener;
import org.sang.healthyfoodmvp.model.util.Constant;
import org.sang.healthyfoodmvp.view.IFoodView;

import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public class FoodPresenter {
    private IFoodView iFoodView;
    private ILoadFoodData iLoadFoodData;
    private Handler mHandler = new Handler();

    public FoodPresenter(IFoodView iFoodView) {
        this.iFoodView = iFoodView;
        iLoadFoodData = new LoadFoodDataImpl();
    }

    public void loadData() {
        iFoodView.showLoading();
        iLoadFoodData.getData(Constant.LISTURL, new OnDataLoadListener() {
            @Override
            public void onSuccess(final List<FoodEntity> foodEntities) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFoodView.initData(foodEntities);
                        iFoodView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailed(final String errorMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFoodView.showErrorMsg(errorMsg);
                        iFoodView.hideLoading();
                    }
                });
            }
        });
    }
}

package org.sang.healthyfoodmvp.view;

import org.sang.healthyfoodmvp.model.FoodEntity;

import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public interface IFoodView {
    public void showLoading();

    public void hideLoading();

    public void initData(List<FoodEntity> foodEntities);

    public void showErrorMsg(String errorMsg);
}

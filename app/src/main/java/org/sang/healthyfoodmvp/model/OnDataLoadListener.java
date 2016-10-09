package org.sang.healthyfoodmvp.model;

import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public interface OnDataLoadListener {
    public void onSuccess(List<FoodEntity> foodEntities);

    public void onFailed(String errorMsg);
}

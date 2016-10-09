package org.sang.healthyfoodmvp.model;

/**
 * Created by 王松 on 2016/10/8.
 */

public interface ILoadFoodData {
    public void getData(String httpUrl,OnDataLoadListener onDataLoadListener);
}

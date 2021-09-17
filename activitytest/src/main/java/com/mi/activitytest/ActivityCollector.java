package com.mi.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有活动的集合管理类
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * 销毁所有活动
     */
    public static void finishAll(){
        for (Activity activity : activities) {
            if(activity != null){
                activity.finish();
            }
        }
    }
}

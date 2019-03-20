package com.devitis.mvp_v1.base;

import android.content.Context;
import android.widget.RelativeLayout;

import com.devitis.mvp_v1.interactor.IScreenView;


/**
 * Created by Diana on 20.03.2019.
 */

public abstract class BaseView extends RelativeLayout implements IScreenView {
    public BaseView(Context context) {
        super(context);
    }
}

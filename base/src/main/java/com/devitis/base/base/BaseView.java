package com.devitis.base.base;

import android.content.Context;
import android.widget.RelativeLayout;

import com.devitis.base.interactor.IScreenView;

/**
 * Created by Diana on 20.03.2019.
 */

public abstract class BaseView extends RelativeLayout implements IScreenView {
    public BaseView(Context context) {
        super(context);
    }
}

package com.yiban.test.ui.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

import com.yiban.test.R;
import com.yiban.test.ui.base.BaseActivity;
import com.yiban.test.utils.SpUtils;

public class SettingActivity extends BaseActivity {

    private Switch settingAutoSignUp;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {


        settingAutoSignUp = (Switch) findViewById(R.id.setting_auto_sign_up);

    }

    @Override
    public void init() {

        settingAutoSignUp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SpUtils.putBoolean("auto", true);
                }else{
                    SpUtils.putBoolean("auto", false);

                }
            }
        });
    }
}

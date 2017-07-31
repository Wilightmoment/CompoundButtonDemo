package com.example.royal.compoundbuttondemo;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView tvMessage;
    private RadioGroup rgGender;
    private Switch swWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        tvMessage=(TextView)findViewById(R.id.tvMessage);
        rgGender=(RadioGroup)findViewById(R.id.rgGender);
        swWifi=(Switch)findViewById(R.id.swWifi);

        //RadioGroup註冊 OnCheckedChangeListener 監聽器，當Group內的Button選項改變時，會呼叫onCheckedChanged()並傳遞被選取RadioButton的ID(checkedId)，可以呼叫findViewById()取得該元件
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
                tvMessage.setText(radioButton.getText());
            }
        });

        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Switch sw=(Switch)buttonView;
                String swName = sw.getText().toString();
                String message="";

                if(isChecked) message+=swName+" "+sw.getTextOn();
                else message+=swName+" "+sw.getTextOff();

                tvMessage.setText(message);
            }
        });
    }

    public void onPlaceClick(View v){
        CheckBox checkBox = (CheckBox) v;
        String checkBoxName = checkBox.getText().toString();
        String message;
        if(checkBox.isChecked())
            message=getString(R.string.checked)+" "+checkBoxName;
        else
            message=getString(R.string.unchecked)+" "+checkBoxName;
        tvMessage.setText(message);
    }

    public void onVibrateClick(View v){
        ToggleButton toggleButton = (ToggleButton) v;
        tvMessage.setText(toggleButton.getText());
    }
}

package com.wanziooo.androidshowcase;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nameInput;
    private RadioGroup directionGroup;
    private CheckBox dailyCheck;
    private Switch reminderSwitch;
    private Spinner levelSpinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupLevelSpinner();
        setupSubmitButton();
    }

    private void bindViews() {
        nameInput = findViewById(R.id.nameInput);
        directionGroup = findViewById(R.id.directionGroup);
        dailyCheck = findViewById(R.id.dailyCheck);
        reminderSwitch = findViewById(R.id.reminderSwitch);
        levelSpinner = findViewById(R.id.levelSpinner);
        resultText = findViewById(R.id.resultText);
    }

    private void setupLevelSpinner() {
        String[] levels = {"初学者", "学习中", "可以独立完成小项目"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                levels
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter);
    }

    private void setupSubmitButton() {
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this::showFormResult);
    }

    private void showFormResult(View view) {
        String name = nameInput.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            nameInput.setError("请先输入名字");
            return;
        }

        int selectedId = directionGroup.getCheckedRadioButtonId();
        RadioButton selectedDirection = findViewById(selectedId);
        String direction = selectedDirection.getText().toString();
        String level = levelSpinner.getSelectedItem().toString();

        String result = "你好，" + name
                + "\n学习方向：" + direction
                + "\n当前阶段：" + level
                + "\n今日打卡：" + yesOrNo(dailyCheck.isChecked())
                + "\n每日提醒：" + onOrOff(reminderSwitch.isChecked());

        resultText.setText(result);
        Toast.makeText(this, "控件数据读取成功", Toast.LENGTH_SHORT).show();
    }

    private String yesOrNo(boolean checked) {
        return checked ? "已完成" : "未完成";
    }

    private String onOrOff(boolean enabled) {
        return enabled ? "已开启" : "未开启";
    }
}

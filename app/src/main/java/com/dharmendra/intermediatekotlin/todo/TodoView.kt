package com.dharmendra.intermediatekotlin.todo;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dharmendra.intermediatekotlin.R;
import com.dharmendra.intermediatekotlin.Todo;

public class TodoView extends ConstraintLayout {
    private CheckBox completeCheckBox;
    private TextView descriptionView;

    public TodoView(@NonNull Context context) {
        super(context);
    }

    public TodoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo){
        completeCheckBox = findViewById(R.id.completeCheckBox);
        descriptionView  = findViewById(R.id.descriptionView);

        descriptionView.setText(todo.getDescription());
        completeCheckBox.setChecked(todo.isComplete());

        if (todo.isComplete()){
            createStrikeThrough();
        }
        setUpCheckStateListener();
    }

    private void setUpCheckStateListener(){
        completeCheckBox.setOnCheckedChangeListener((button,isChecked)->{
            if (isChecked)
                createStrikeThrough();
            else
                removeStrikeThrough();
        });
    }

    private void createStrikeThrough(){
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void removeStrikeThrough(){
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }




}

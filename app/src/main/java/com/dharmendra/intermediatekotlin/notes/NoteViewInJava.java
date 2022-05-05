package com.dharmendra.intermediatekotlin.notes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dharmendra.intermediatekotlin.Note;
import com.dharmendra.intermediatekotlin.R;

public class NoteViewInJava extends ConstraintLayout {
    private TextView notes;

    public NoteViewInJava(@NonNull Context context) {
        super(context);
    }

    public NoteViewInJava(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteViewInJava(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Note note){
        notes = findViewById(R.id.notes);

        notes.setText(note.getDescription());
    }
}

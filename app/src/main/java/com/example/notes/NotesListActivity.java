package com.example.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.notes.Adapters.NotesAdapter;
import com.example.notes.Models.Note;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {

    private static final String TAG = "NotesListAcitivy";

    //UI Components
    private RecyclerView mRecyclerView;

    //Variables
    private ArrayList<Note> mNotes= new ArrayList<>();
    private NotesAdapter mRecyclerAdpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        initRecyclerView();
        insertNotes();
    }

    private void insertNotes(){
            for(int i =0;i<20;i++) {
            Note note = new Note();
            note.setContent("content # is" + i);
            note.setTimestamp("June 2019");
            note.setTitle("title " + i);
            mNotes.add(note);
            }
            mRecyclerAdpater.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerAdpater = new NotesAdapter(mNotes);
        mRecyclerView.setAdapter(mRecyclerAdpater);
    }
}

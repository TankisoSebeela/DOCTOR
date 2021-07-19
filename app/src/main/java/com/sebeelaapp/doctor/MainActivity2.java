package com.sebeelaapp.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sebeelaapp.doctor.viewholder.categoryitem;

import org.jetbrains.annotations.NotNull;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    DatabaseReference myreference;
     private FirebaseRecyclerOptions<UserHelperClass> options;
     private FirebaseRecyclerAdapter<UserHelperClass, categoryitem> adaptersss;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView)findViewById(R.id.recy1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myreference = FirebaseDatabase.getInstance().getReference().child("Clients");

        options = new FirebaseRecyclerOptions.Builder<UserHelperClass>().setQuery(myreference,UserHelperClass.class).build();

        adaptersss = new FirebaseRecyclerAdapter<UserHelperClass, categoryitem>(options) {

            @Override
            protected void onBindViewHolder(@NonNull categoryitem holder, int position,@NonNull UserHelperClass model) {
                holder.name.setText(model.getName());
                holder.surname.setText(model.getName());
                holder.email.setText(model.getName());
                holder.date.setText(model.getName());
                holder.address.setText(model.getName());
                holder.phone.setText(model.getName());
                holder.gender.setText(model.getName());
            }


            @Override
            public categoryitem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
               View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collection2,viewGroup,false);

                return new categoryitem(v);
            }

        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),7);

        recyclerView.setLayoutManager(gridLayoutManager);
        adaptersss.startListening();
        recyclerView.setAdapter(adaptersss);
        }
    @Override
    protected void onStart() {
        super.onStart();
        if(adaptersss!=null)
            adaptersss.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(adaptersss!=null)
            adaptersss.stopListening();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}



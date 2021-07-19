package com.sebeelaapp.doctor.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
//import android.support.v7.widget.RecyclerView;

import com.sebeelaapp.doctor.R;

public class categoryitem extends RecyclerView.ViewHolder {

    public TextView  name ,surname,email,date,address,phone,gender;
    public categoryitem(@NonNull View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.name1);
        surname = (TextView)itemView.findViewById(R.id.surname2);
        gender = (TextView)itemView.findViewById(R.id.gender1);
        date = (TextView)itemView.findViewById(R.id.date1);
        email = (TextView)itemView.findViewById(R.id.email1);
        address = (TextView)itemView.findViewById(R.id.address1);
        phone = (TextView)itemView.findViewById(R.id.phone1);
    }

}

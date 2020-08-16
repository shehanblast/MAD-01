package com.example.mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class guestAdapter extends ArrayAdapter <guest> {

    private Context context;
    private int resource;
    List<guest>Guests;

    //private TextView add_name,addinvitation;



    guestAdapter(Context context, int resource, List<guest>Guests){
        super(context,resource);
        this.context=context;
        this.resource=resource;
        this.Guests=Guests;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);

        TextView add_name=row.findViewById(R.id.add_name);
        TextView addinvitation=row.findViewById(R.id.addinvitation);
        ImageView image=row.findViewById(R.id.onGoing);

        guest guest=Guests.get(position);
        add_name.setText(guest.getName());
        addinvitation.setText(guest.getInvitation());
        image.setVisibility(row.INVISIBLE);

        if(guest.getFinished() >0){
            image.setVisibility(View.VISIBLE);
        }
        return row;

    }
}

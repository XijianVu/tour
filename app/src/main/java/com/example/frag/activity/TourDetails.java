package com.example.frag.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frag.MainActivity;
import com.example.frag.R;
import com.example.frag.model.Blog;
import com.example.frag.model.Tour;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class TourDetails extends AppCompatActivity {
    private ViewPager2 mviewPager2;
    private CircleIndicator3 mcircleIndicator3;
    private List<Tour> mlistPhoto;



    private ImageView viewPagerdetails;
    private TextView tvTourName;
    private TextView placeTour;
    private TextView timeTour;
    private TextView placeStart;
    private TextView tourtrend, tvPrice;
    private Button btnTimTour;
    private Tour itemDetail;

    Button btn_edit_tour;
    Button btn_remove_tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        initViews();

        Bundle bundle = getIntent().getExtras();
        String image = bundle.getString("image");
        String name = bundle.getString("name");
        String timeTour = bundle.getString("timeTour");
        String place = bundle.getString("placeTour");
        String startPlace = bundle.getString("placeStart");
        String pricePeople = bundle.getString("pricePeople");
        String priceChild = bundle.getString("priceChild");
        String about = bundle.getString("about");


        Picasso.get().load(image).into(viewPagerdetails);
        //viewPagerdetails.setImageResource(image);
        tvTourName.setText(name);

        placeTour.setText(place);
        placeStart.setText(startPlace);
        tvPrice.setText(pricePeople);
        tourtrend.setText(about);

        btnTimTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourDetails.this, Tour_FindTour.class);
                intent.putExtra("name", name);

                intent.putExtra("timeTour", timeTour);
                intent.putExtra("image", image);

                intent.putExtra("pricePeople", pricePeople);
                intent.putExtra("priceChild", priceChild);

                startActivity(intent);
            }
        });

        btn_remove_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                                Query applesQuery = ref.child("tour").orderByChild("name").equalTo(name);
                                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                            appleSnapshot.getRef().removeValue();

                                            Toast.makeText(view.getContext(),"Xoá thành công", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        btn_edit_tour.setOnClickListener(new View.OnClickListener() {
            private DatabaseReference ref;
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.layout_dialog_edit_tour);

                Window window = dialog.getWindow();
                if(window==null){
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btn_cancle_tour = dialog.findViewById(R.id.btn_cancle_tour);
                btn_cancle_tour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btn_update_tour = dialog.findViewById(R.id.btn_update_tour);
                EditText tour_edit_about = dialog.findViewById(R.id.tour_edit_about);
                EditText tour_edit_name = dialog.findViewById(R.id.tour_edit_name);
                EditText tour_edit_placeStart = dialog.findViewById(R.id.tour_edit_placeStart);
                EditText tour_edit_placeTour = dialog.findViewById(R.id.tour_edit_placeTour);
                EditText tour_edit_priceChild = dialog.findViewById(R.id.tour_edit_priceChild);
                EditText tour_edit_pricePeople = dialog.findViewById(R.id.tour_edit_pricePeople);
                EditText tour_edit_resourceId = dialog.findViewById(R.id.tour_edit_resourceId);
                EditText tour_edit_timeTour = dialog.findViewById(R.id.tour_edit_timeTour);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                ref = database.getReference();

                btn_update_tour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String about = tour_edit_about.getText().toString();
                        String name = tour_edit_name.getText().toString();
                        String placeStart = tour_edit_placeStart.getText().toString();
                        String placeTour = tour_edit_placeTour.getText().toString();
                        String priceChild = tour_edit_priceChild.getText().toString();
                        String pricePeople = tour_edit_pricePeople.getText().toString();
                        String resourceId = tour_edit_resourceId.getText().toString();
                        String timeTour = tour_edit_timeTour.getText().toString();

                        Tour tour = new Tour(about,name,placeStart,placeTour,priceChild,pricePeople,resourceId,timeTour);
                        ref.child("tour").child(String.valueOf(tour.getName())).setValue(tour);

                        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference();
                        Query applesQuery = ref1.child("tour").orderByChild("name").equalTo(bundle.getString("name"));
                        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                    appleSnapshot.getRef().removeValue();
                                    Toast.makeText(view.getContext(),"Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });

                    }
                });

                dialog.show();
            }
        });


    }

    private void initViews() {
        viewPagerdetails = findViewById(R.id.viewPagerdetails);
        tvTourName = findViewById(R.id.tvTourName);
        tvPrice = findViewById(R.id.tvPrice);
        tourtrend = findViewById(R.id.tourtrend);
        timeTour = findViewById(R.id.timeTour);
        placeTour = findViewById(R.id.placeTour);
        placeStart = findViewById(R.id.placeStart);
        btnTimTour = findViewById(R.id.btnTimTour);

        btn_edit_tour = findViewById(R.id.btn_edit_tour);
        btn_remove_tour = findViewById(R.id.btn_remove_tour);
    }


}
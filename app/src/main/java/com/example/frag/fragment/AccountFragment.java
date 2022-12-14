package com.example.frag.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.frag.Login;
import com.example.frag.LoginActivity;
import com.example.frag.MainActivity;
import com.example.frag.R;
import com.example.frag.activity.Blog_add;
import com.example.frag.activity.Tour_add;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    TextView tvName;
    Button btnLogin,blog_add,btnLogout;


    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        Button btnLogout = view.findViewById(R.id.btnLogout);
        TextView tvName =view.findViewById(R.id.tvName);
        //getProfile();
        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                //tvName.setVisibility(View.VISIBLE);

                startActivity(intent);
            }
        });*/
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail().toString().trim();
        tvName.setText(email);
        //blog_add.setVisibility(View.VISIBLE);
        LinearLayout blog_add = view.findViewById(R.id.blog_add);

        /*blog_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Blog_add.class);
                startActivity(intent);
            }
        });*/

        if ( email.equals("admin@gmail.com") )
        {
            blog_add.setVisibility(View.VISIBLE);
            blog_add.setOnClickListener(new Button.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(getActivity(), Blog_add.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "DOne", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            blog_add.setVisibility(View.INVISIBLE);
        }


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                tvName.setText("Bạn chưa đăng nhập");

                //btnLogout.setVisibility(View.VISIBLE);
                //imageView.setVisibility(View.GONE);
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
            }
        });



        return view;
    }
    private void getProfile() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;
        }
        String email = user.getEmail().toString().trim();
        //Uri photoUrl = user.getPhotoUrl();

        tvName.setText(email);

       /*btnLogin.setVisibility(View.VISIBLE);
        blog_add.setVisibility(View.VISIBLE);
        btnLogout.setVisibility(View.VISIBLE);*/

        //imageView.setVisibility(View.VISIBLE);
    }
}
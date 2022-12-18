package com.example.frag.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.frag.LoginActivity;
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
    LinearLayout acti_support, acti_infor;


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
        LinearLayout acti_support = view.findViewById(R.id.acti_support);
        acti_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_support);

                Window window = dialog.getWindow();
                if(window==null){
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageButton btn_back = dialog.findViewById(R.id.btn_back);
                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        LinearLayout acti_infor = view.findViewById(R.id.acti_infor);
        acti_infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_infor);

                Window window = dialog.getWindow();
                if(window==null){
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageButton btn_back = dialog.findViewById(R.id.btn_back);
                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail().toString().trim();
        tvName.setText(email);
        //blog_add.setVisibility(View.VISIBLE);
        LinearLayout blog_add = view.findViewById(R.id.blog_add);
        LinearLayout tour_add = view.findViewById(R.id.tour_add);

        if ( email.equals("admin@gmail.com") )
        {
            blog_add.setVisibility(View.VISIBLE);
            tour_add.setVisibility(View.VISIBLE);
            blog_add.setOnClickListener(new Button.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(getActivity(), Blog_add.class);
                    startActivity(intent);
                    //Toast.makeText(getContext(), "Done", Toast.LENGTH_LONG).show();
                }
            });
            tour_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Tour_add.class);
                    startActivity(intent);
                    //Toast.makeText(getContext(), "Done", Toast.LENGTH_LONG).show();
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

}
package com.example.frag.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.frag.R;
import com.example.frag.adapter.BestSaleAdapter;
import com.example.frag.fragment.itemTab1.Photo2Adapter;
import com.example.frag.fragment.itemTab1.Photo3Adapter;
import com.example.frag.fragment.itemTab1.Photo4Adapter;
import com.example.frag.fragment.itemTab1.photo2;
import com.example.frag.model.Tour;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mView;
    private List<Tour> listitem;
    private BestSaleAdapter photo1Adapter;
    private Photo2Adapter photo2Adapter;
    private Photo3Adapter photo3Adapter;
    private Photo4Adapter photo4Adapter;
    private TabLayout tabLayout;

    private ArrayList<Tour> arrayList;
    private RecyclerView home1_viewpager1;
    private BestSaleAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout1 = (TabLayout) mView.findViewById(R.id.tab1layout1);

        TabLayout.Tab tab1 = tabLayout1.newTab();
        tab1.setText("Hạ Long");
        tabLayout1.addTab(tab1,true);

        TabLayout.Tab tab2 = tabLayout1.newTab();
        tab2.setText("SaPa");
        tabLayout1.addTab(tab2,false);

        TabLayout.Tab tab3 = tabLayout1.newTab();
        tab3.setText("Đà Lạt");
        tabLayout1.addTab(tab3,false);

        TabLayout.Tab tab4 = tabLayout1.newTab();
        tab4.setText("Phú Quốc");
        tabLayout1.addTab(tab4,false);

        TabLayout.Tab tab5 = tabLayout1.newTab();
        tab5.setText("Nha Trang");
        tabLayout1.addTab(tab5,false);


        TabLayout tabLayout2 = (TabLayout) mView.findViewById(R.id.tab1layout2);

        TabLayout.Tab tab6 = tabLayout2.newTab();
        tab6.setText("Tour tham quan");
        tabLayout2.addTab(tab6,true);

        TabLayout.Tab tab7 = tabLayout2.newTab();
        tab7.setText("Tour thiên nhiên");
        tabLayout2.addTab(tab7,false);

        TabLayout.Tab tab8 = tabLayout2.newTab();
        tab8.setText("Tour biển");
        tabLayout2.addTab(tab8,false);


        TabLayout tabLayout3 = (TabLayout) mView.findViewById(R.id.tab1layout3);

        TabLayout.Tab tab9 = tabLayout3.newTab();
        tab9.setText("Hàn Quốc");
        tabLayout3.addTab(tab9,true);

        TabLayout.Tab tab10 = tabLayout3.newTab();
        tab10.setText("Nhật Bản");
        tabLayout3.addTab(tab10,false);

        TabLayout.Tab tab11 = tabLayout3.newTab();
        tab11.setText("Singapore");
        tabLayout3.addTab(tab11,false);

        TabLayout.Tab tab12 = tabLayout3.newTab();
        tab12.setText("Thái Lan");
        tabLayout3.addTab(tab12,false);

        TabLayout.Tab tab13 = tabLayout3.newTab();
        tab13.setText("Ấn Độ");
        tabLayout3.addTab(tab13,false);

        TabLayout.Tab tab14 = tabLayout3.newTab();
        tab14.setText("Bali");
        tabLayout3.addTab(tab14,false);


        TabLayout tabLayout4 = (TabLayout) mView.findViewById(R.id.tab1layout4);

        TabLayout.Tab tab15 = tabLayout4.newTab();
        tab15.setText("Điểm đến nội địa");
        tabLayout4.addTab(tab15,true);

        TabLayout.Tab tab16 = tabLayout4.newTab();
        tab16.setText("Điểm đến quốc tế");
        tabLayout4.addTab(tab16,false);


         tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initValue();

        home1_viewpager1 = view.findViewById(R.id.home1_viewpager1);
        home1_viewpager1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        home1_viewpager1.hasFixedSize();
        BestSaleAdapter adapter = new BestSaleAdapter(getContext(),arrayList);
        home1_viewpager1.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listitem=new ArrayList<>();
       // photo1Adapter = new Photo1Adapter(this,getListPhoto1());
        photo2Adapter = new Photo2Adapter(this,getListPhoto2());
        photo3Adapter = new Photo3Adapter(this,getListPhoto3());
        photo4Adapter = new Photo4Adapter(this,getListPhoto4());

        /*RecyclerView rcv1 = view.findViewById(R.id.home1_viewpager1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcv1.setLayoutManager(layoutManager);
        photo1Adapter.setData(getListPhoto1());
        rcv1.setAdapter(photo1Adapter);
        SnapHelper startSnapHelper1 = new LinearSnapHelper();
        startSnapHelper1.attachToRecyclerView(rcv1);*/

        RecyclerView rcv2 = view.findViewById(R.id.home1_viewpager2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcv2.setLayoutManager(layoutManager2);
        rcv2.setAdapter(photo2Adapter);
        SnapHelper startSnapHelper2 = new LinearSnapHelper();
        startSnapHelper2.attachToRecyclerView(rcv2);

        RecyclerView rcv3 = view.findViewById(R.id.home1_viewpager3);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcv3.setLayoutManager(layoutManager3);
        rcv3.setAdapter(photo3Adapter);
        SnapHelper startSnapHelper3 = new LinearSnapHelper();
        startSnapHelper3.attachToRecyclerView(rcv3);

        RecyclerView rcv4 = view.findViewById(R.id.home1_viewpager4);
        RecyclerView.LayoutManager layoutManager4 = new GridLayoutManager(getActivity(),2);
        rcv4.setLayoutManager(layoutManager4);
        rcv4.setAdapter(photo4Adapter);
        SnapHelper startSnapHelper4 = new LinearSnapHelper();
        startSnapHelper4.attachToRecyclerView(rcv4);


    }

    private void initValue() {
        arrayList = new ArrayList<>();
        arrayList.add(new Tour(R.drawable.a1,"Tour du lịch Nam Cát Tiên 2N1D","2 ngày 1 đêm","Cát Tiên", "Hồ Chí Minh","Phương tiện: Xe 29 chỗ đời mới, băng đôi, ghế bật, máy lạnh, đạt tiêu chuẩn du lịch.\n" +
                "Lưu trú: Tiêu chuẩn 2 người/phòng: máy lạnh, tivi, toilet riêng, wifi,...\n" +
                "Ăn uống:\n" +
                "02 buổi Ăn sáng.\n" +
                "02 buổi ăn chính ( Ăn trưa, tối ): 150.000đ/khách thực đơn 5-6 món thay đổi theo từng bữa ăn.\n" +
                "01 bữa tiệc nướng BBQ menu đính kèm.\n" +
                "Hướng dẫn viên: Đoàn có hướng dẫn viên thuyết minh nhiệt tình và phục vụ ăn, nghỉ, tham quan cho quý khách. Hoạt náo viên tổ chức các trò chơi vận động tập thể, sinh hoạt, ca hát.\n" +
                "Tổ chức chương trình teambuilding cho đoàn.\n" +
                "Bảo hiểm: Khách được bảo hiểm du lịch trọn gói, mức bồi thường tối đa 30.000.000đ/vụ. Thuốc y tế thông thường.\n" +
                "Quà tặng: Mỗi vị khách trên đường đi được phục vụ 1 khăn lạnh, 1 chai nước tinh khiết/ ngày / người, nón quà lưu niệm công ty.\n" +
                "Tham quan: Giá tour bao gồm phí vào cổng tại các điểm tham quan nêu trên chương trình, đêm hội lửa trại:\n" +
                "Vé vào vườn quốc gia\n" +
                "Xe đạp\n" +
                "Phí tham quan Bàu Sấu\n" +
                "Lửa trại: Đống củi, MC hoạt náo dẫn chương trình. Ngoài ra tặng thêm quý khách hàng 10 trái bắp và 10 củ khoai.","1850000"));
        arrayList.add(new Tour(R.drawable.a2,"Tour du lịch Đảo Ó Đồng Trường","1 ngày","vfv","df","Chi phí vận chuyển: Xe du lịch đời mới đưa đón tham quan suốt tuyến.\n" +
                "Khách sạn 3 sao theo tiêu chuẩn: Phòng 2 – 3-4/người.\n" +
                "02 bữa sáng\n" +
                "04 bữa chính đặc sản theo chương trình ( thực đơn đính kèm )\n" +
                "Hướng dẫn viên chuyên nghiệp, nhiệt tình, chu đáo phục vụ suốt tuyến.\n" +
                "Phí tham quan theo chương trình.\n" +
                "Quà tặng: Nón du lịch Khăn lạnh, Nước suối 1 chai / 1 ngày / 1 người.\n" +
                "Bảo hiểm du lịch suốt chuyến tham quan 30.000.000 đồng/vụ .","1400000" ));
        arrayList.add(new Tour(R.drawable.a3,"Du lịch Đà Lạt","2 ngày","Đà Lạt","Hồ Chí Minh", "Vận chuyển: Xe du lịch 29-45 chỗ đời mới phục vụ suốt tuyến.\n" +
                "Vé tham quan: Vé các điểm tham quan theo lịch trình\n" +
                "Lưu trú: Khách sạn 2-3 sao tiêu chuẩn 2 - 4 – 6 khách/ 1 phòng\n" +
                "Ăn uống\n" +
                "Ăn sáng: 02 bữa tô ly và 02 bữa Buffet sáng.\n" +
                "Ăn chính: 05 bữa thực đơn 110.000vnđ/pax\n" +
                "Bảo hiểm 30.000.000 đ/người/trường hợp (chỉ áp dụng cho những khách hoàn tất thủ tục đăng ký tour trước khởi hành 1 ngày, không bao gồm các ngày nghỉ cuối tuần và các ngày nghỉ lễ, Tết)\n" +
                "Hướng dẫn viên HDV nhiệt tình, kinh nghiệm, vui vẻ phục vụ chu đáo\n" +
                "Nước suối, khăn lạnh,nón Nước suối: 1 chai 500ml/ngày/khách Khăn lạnh: 1 cái/ngày/khách\n" +
                "Nón du lịch: 1 nón/khách","1750000"));
        arrayList.add(new Tour(R.drawable.a4,"Nha Trang","gdh","dfgdf","fdgd","item1","2400000"));
        arrayList.add(new Tour(R.drawable.a5,"Sa Pa","gdh","dfgdf","fdgd","item1","3000000"));
        arrayList.add(new Tour(R.drawable.a6,"Vung Tau","gdh","dfgdf","fdgd","item1","1000000"));
    }

    private List<photo2> getListPhoto1 () {
        List<photo2> list = new ArrayList<>();
        list.add(new photo2(R.drawable.a1,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a2,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a3,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a4,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a5,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a6,"item1","5.000.000"));
        return list;
    }

    private List<photo2> getListPhoto2 () {
        List<photo2> list = new ArrayList<>();
        list.add(new photo2(R.drawable.a1,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a2,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a3,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a4,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a5,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a6,"item1","5.000.000"));
        return list;
    }

    private List<photo2> getListPhoto3 () {
        List<photo2> list = new ArrayList<>();
        list.add(new photo2(R.drawable.a1,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a2,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a3,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a4,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a5,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a6,"item1","5.000.000"));
        return list;
    }

    private List<photo2> getListPhoto4 () {
        List<photo2> list = new ArrayList<>();
        list.add(new photo2(R.drawable.a1,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a2,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a3,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a4,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a5,"item1","5.000.000"));
        list.add(new photo2(R.drawable.a6,"item1","5.000.000"));
        return list;
    }


}

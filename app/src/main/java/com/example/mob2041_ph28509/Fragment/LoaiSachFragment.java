package com.example.mob2041_ph28509.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mob2041_ph28509.Adapter.LoaiSachAdapter;
import com.example.mob2041_ph28509.Adapter.SachAdapter;
import com.example.mob2041_ph28509.DAO.LoaiSachDAO;
import com.example.mob2041_ph28509.DAO.SachDAO;
import com.example.mob2041_ph28509.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class LoaiSachFragment extends Fragment {
    private LoaiSachDAO loaiSachDAO;
    private RecyclerView recyclerView;
    private LoaiSachAdapter loaiSachAdapter;
    private FloatingActionButton floatingButtonLoaiSach;



    public LoaiSachFragment() {

    }


    public static LoaiSachFragment newInstance() {
        LoaiSachFragment fragment = new LoaiSachFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loai_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loaiSachDAO = new LoaiSachDAO(getActivity());
        loaiSachDAO.open();
        recyclerView = view.findViewById(R.id.recylerViewLoaiSach);
        loaiSachAdapter = new LoaiSachAdapter(getActivity());
        loaiSachAdapter.setData(loaiSachDAO.selectAll(),loaiSachDAO);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(loaiSachAdapter);
        floatingButtonLoaiSach = view.findViewById(R.id.floatingButtonLoaiSach);
        floatingButtonLoaiSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiSachAdapter.AddLoaiSach();
            }
        });
    }
}
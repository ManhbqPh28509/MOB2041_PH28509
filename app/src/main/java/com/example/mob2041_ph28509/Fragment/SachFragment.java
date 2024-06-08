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
import android.widget.Button;

import com.example.mob2041_ph28509.Adapter.SachAdapter;
import com.example.mob2041_ph28509.DAO.SachDAO;
import com.example.mob2041_ph28509.Model.Sach;
import com.example.mob2041_ph28509.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SachFragment extends Fragment {

    private SachDAO sachDAO;
    private RecyclerView recyclerView;
    private SachAdapter sachAdapter;
    private FloatingActionButton floatingButtonSach;

    public SachFragment() {

    }


    public static SachFragment newInstance() {
        SachFragment fragment = new SachFragment();
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
        return inflater.inflate(R.layout.fragment_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sachDAO = new SachDAO(getActivity());
        sachDAO.open();
        recyclerView = view.findViewById(R.id.recylerViewSach);
        sachAdapter = new SachAdapter(getActivity());
        sachAdapter.setData(sachDAO.selectAll(),sachDAO);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sachAdapter);
        floatingButtonSach = view.findViewById(R.id.floatingButtonSach);
        floatingButtonSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
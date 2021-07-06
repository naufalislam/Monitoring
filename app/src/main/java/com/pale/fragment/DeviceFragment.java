package com.pale.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pale.data.Alat;
import com.pale.data.AlatAdapter;
import com.pale.R;
import com.pale.network.BaseApiService;

import java.util.ArrayList;

public class DeviceFragment extends Fragment{


    private RecyclerView recyclerView;
    private AlatAdapter alatAdapter;
    private ArrayList<Alat> alatArrayList;


    BaseApiService mApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device, container, false);


        alatArrayList = new ArrayList<>();
//        alatArrayList.add(new Alat("28001","1","1","apa"));
//        alatArrayList.add(new Alat("Dx28002","Kolam 2"));
//        alatArrayList.add(new Alat("Dx28003","Kolam 3"));
//        alatArrayList.add(new Alat("Dx28004","Kolam 4"));


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        alatAdapter = new AlatAdapter(alatArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(alatAdapter);

        return view;
        
    }



}

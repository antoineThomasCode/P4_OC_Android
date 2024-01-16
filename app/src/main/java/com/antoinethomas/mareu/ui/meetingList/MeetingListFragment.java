package com.antoinethomas.mareu.ui.meetingList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.antoinethomas.mareu.R;
import com.antoinethomas.mareu.databinding.FragmentFirstBinding;
import com.antoinethomas.mareu.repositories.MeetingRepository;

public class MeetingListFragment extends Fragment {

    private FragmentFirstBinding binding;

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        recyclerView = binding.meetingList;
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MeetingAdapter adapter = new MeetingAdapter(MeetingRepository.getInstance().getMeetings());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
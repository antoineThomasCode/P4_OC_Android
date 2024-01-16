package com.antoinethomas.mareu.ui.addMeeting;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.MultiAutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.antoinethomas.mareu.databinding.FragmentAddMeetingBinding;
import com.antoinethomas.mareu.domain.Participant;
import com.antoinethomas.mareu.domain.Room;
import com.antoinethomas.mareu.repositories.MeetingRepository;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.Calendar;
import java.util.List;

public class AddMeetingFragment extends Fragment {

    private FragmentAddMeetingBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAddMeetingBinding.inflate(inflater, container, false);
        binding.datePickerButton.setOnClickListener(v -> showDatePickerDialog());

        List<Participant> participantList = MeetingRepository.getInstance().getParticipants();

        String[] emailAddresses = new String[participantList.size()];

        for (int i = 0; i< participantList.size() ; i++) {
            emailAddresses[i] = participantList.get(i).getEmail();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, emailAddresses);
        binding.emailList.setAdapter(adapter);

        binding.emailList.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        List<Room> roomList = MeetingRepository.getInstance().getRooms();
        for (Room r : roomList) {
            Chip chip = new Chip(getContext());

            chip.setText(r.getName());
            chip.getCheckedIcon();

            chip.setCheckable(true);
            binding.roomList.addView(chip);



        }

        binding.roomList.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list) {
                for (int i = 0; i < binding.roomList.getChildCount(); i++) {
                    View child = binding.roomList.getChildAt(i);
                    if (child instanceof Chip) {
                        Chip chip = (Chip) child;
                        if (list.contains(chip.getId())) {
                            // Set a different background color for the selected chip
                            chip.setChipBackgroundColorResource(android.R.color.black);
                            chip.setChecked(true);

                        } else {
                            // Reset the background color for other chips
                            chip.setChipBackgroundColorResource(android.R.color.white);
                            chip.setChecked(false);
                        }
                    }
                }
            }


        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void showDatePickerDialog() {


        Context context = this.getContext();
        if(context == null) {
            return;
        }


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;

                }, year, month, day);

        datePickerDialog.show();
    }
    public void createNewMeeting() {
        // get all values when I click on the button
        String meetingName = binding.meetingName.getText() == null ? "" : binding.meetingName.getText().toString().trim();
        String participant = binding.participantInputText.getText() == null ? "" : binding.participantInputText.getText().toString().trim();
        String location = binding.locationInputText.getText() == null ? "" : binding.locationInputText.getText().toString().trim();





        // validate all values before create meeting
        boolean isDataValid = false;
        if (meetingName.isEmpty()) {
           binding.meetingName.setError("le nom ne doit pas être vide.");
        } else {
            binding.meetingName.setError(null);
            isDataValid = true;
        }

        if (participant.isEmpty()) {
            binding.participantInputText.setError("L'email doit être dans une format valide.");
        } else {
            binding.participantInputText.setError(null);
            isDataValid = true;
        }
        if (location.isEmpty()) {
            binding.locationInputText.setError("La localisation ne doit pas être vide.");
        } else {
            binding.locationInputText.setError(null);
            isDataValid = true;
        }

        // create new meeting width valide values

        if (isDataValid) {
            // here create new meeting
            String ok = "test";

        }


    }

}
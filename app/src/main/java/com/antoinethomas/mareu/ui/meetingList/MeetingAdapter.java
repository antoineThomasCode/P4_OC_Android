package com.antoinethomas.mareu.ui.meetingList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antoinethomas.mareu.R;
import com.antoinethomas.mareu.domain.Meeting;

import org.w3c.dom.Text;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    private List<Meeting> meetings;

    public MeetingAdapter(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.meeting_item, parent, false);

        return new MeetingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {
        Meeting meeting = meetings.get(position);
        holder.title.setText(meeting.getTitle());

    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    public static class  MeetingViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView mails;
        View circleColor;
        View removeButton;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.meetingTitle);
            mails = itemView.findViewById(R.id.emails);
            circleColor = itemView.findViewById(R.id.circleShape);
            removeButton = itemView.findViewById(R.id.buttonDelete);
        }
    }
}

package com.example.timecraft.ui.task.utils;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timecraft.R;
import com.example.timecraft.ui.task.Adapter.CalendarAdapter;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public final TextView dayOfMonth;
    private final CalendarAdapter.OnItemListener onItemListener;
    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener)
    {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getBindingAdapterPosition(), (String) dayOfMonth.getText());
    }
}

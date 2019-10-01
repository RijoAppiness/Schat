package com.example.schat.root_activity.open_connects;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schat.R;
import com.example.schat.Utils.DateParser;
import com.example.schat.models.UserProfile;

import de.hdodenhof.circleimageview.CircleImageView;

public class OpenConnect extends Fragment {

    private OpenConnectViewModel mViewModel;

    public static OpenConnect newInstance() {
        return new OpenConnect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.open_connect_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OpenConnectViewModel.class);



    }

    class OpenChatlistAdapter extends ListAdapter<UserProfile,OpenChatlistAdapter.ChatViewHolder> {



        protected OpenChatlistAdapter() {
            super(new DiffUtil.ItemCallback<UserProfile>() {
                @Override
                public boolean areItemsTheSame(@NonNull UserProfile oldItem, @NonNull UserProfile newItem) {
                    return oldItem.getUsername().equals(newItem.getUsername());
                }

                @Override
                public boolean areContentsTheSame(@NonNull UserProfile oldItem, @NonNull UserProfile newItem) {

                    return oldItem.equals(newItem);
                }
            });
        }

        @NonNull
        @Override
        public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.open_connect_list_item_design,parent,false);

            return new ChatViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

            DateParser dateParser = new DateParser(getItem(position).getLastseen_date());
            holder.profile_pic_view.setImageResource(R.drawable.sample_prof_pic_1);
            holder.last_seen.setText(dateParser.getDate());
            holder.stat_string.setText(getItem(position).getStat_string());
            holder.nickname.setText(getItem(position).getNickname());

        }

        class ChatViewHolder extends RecyclerView.ViewHolder{
            public CircleImageView profile_pic_view;
            public TextView nickname,stat_string,last_seen;

            public ChatViewHolder(@NonNull View itemView) {
                super(itemView);
                profile_pic_view = itemView.findViewById(R.id.profile_pic_view);
                nickname = itemView.findViewById(R.id.nickname);
                stat_string = itemView.findViewById(R.id.stat_string);
                last_seen = itemView.findViewById(R.id.last_login_time);

            }
        }
    }

}

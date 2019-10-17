package com.example.schat.root_activity.my_connects;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schat.R;
import com.example.schat.Utils.DateParser;
import com.example.schat.Utils.DummyFactory;
import com.example.schat.models.UserProfile;

import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyConnect extends Fragment {

    private MyConnectViewModel mViewModel;
    private RecyclerView my_connect_recyclerView;

    public static MyConnect newInstance() {
        return new MyConnect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_connect_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyConnectViewModel.class);
        my_connect_recyclerView = getActivity().findViewById(R.id.myconnect_recyclerview);

        My_connect_rv_list adapter = new My_connect_rv_list(getActivity().getApplicationContext());
        adapter.submitList(DummyFactory.getDummyUserList(28));
        my_connect_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        my_connect_recyclerView.setAdapter(adapter);



    }









}

class My_connect_rv_list extends ListAdapter<UserProfile, My_connect_rv_list.ViewHolder>{
    private static DiffUtil.ItemCallback<UserProfile> itemCallback = new DiffUtil.ItemCallback<UserProfile>() {
        @Override
        public boolean areItemsTheSame(@NonNull UserProfile oldItem, @NonNull UserProfile newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserProfile oldItem, @NonNull UserProfile newItem) {
            return false;
        }
    };
    private Context context;

    protected My_connect_rv_list(Context context) {
        super(itemCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.my_connect_list_item_design,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.profile_pic.setImageResource(R.drawable.sample_prof_pic_1);
        holder.nickname.setText(getItem(position).getNickname());
        DateParser dateParser = new DateParser(getItem(position).getLastseen_date());
        holder.lastSeen.setText(dateParser.getDate());
        holder.statString.setText(getItem(position).getStat_string());
        if(position==0){
            holder.topSpacer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, My_connect_rv_list.ViewHolder.TOP_SPACE_WIDTH));
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView profile_pic;
        private TextView nickname,statString,lastSeen;
        private LinearLayout topSpacer;
        private static final int TOP_SPACE_WIDTH = 32;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_pic = itemView.findViewById(R.id.profile_pic_view);
            nickname = itemView.findViewById(R.id.nickname);
            statString = itemView.findViewById(R.id.stat_string);
            lastSeen = itemView.findViewById(R.id.last_login_time);
            topSpacer = itemView.findViewById(R.id.topspacer);
        }
    }
}

package com.nghianv.nghiachat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nghianv.nghiachat.ChatActivity;
import com.nghianv.nghiachat.R;
import com.nghianv.nghiachat.adapter.FriendAdapter;
import com.nghianv.nghiachat.data.Data;

/**
 * Created by NguyenNghia on 4/3/2016.
 */
public class FriendFragment extends Fragment {


    public FriendFragment(){
        Data.initNghiaUser();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_layout, container, false);
        ListView lvFriends = (ListView)view.findViewById(R.id.lvFriends);

        FriendAdapter adapter = new FriendAdapter(getContext(), Data.NghiaUser.getFriends() );
        lvFriends.setAdapter(adapter);

        lvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), ChatActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}

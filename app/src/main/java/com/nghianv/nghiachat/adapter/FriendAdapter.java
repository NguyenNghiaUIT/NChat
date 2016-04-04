package com.nghianv.nghiachat.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nghianv.nghiachat.R;
import com.nghianv.nghiachat.model.User;

import java.util.List;

/**
 * Created by NguyenNghia on 4/3/2016.
 */
public class FriendAdapter extends ArrayAdapter<User> {
    private Context mContext;
    private List<User> users;
    public FriendAdapter(Context context, List<User> objects) {
        super(context, 0, objects);
        mContext = context;
        users = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.row_friend, parent, false);
        }

        User user = users.get(position);
        ImageView imgAvatar = (ImageView)convertView.findViewById(R.id.imAvatar);
        TextView txtName = (TextView)convertView.findViewById(R.id.txtName);

        txtName.setText(user.getName());
        imgAvatar.setImageResource(R.drawable.profile_icon);

        return convertView;
    }
}

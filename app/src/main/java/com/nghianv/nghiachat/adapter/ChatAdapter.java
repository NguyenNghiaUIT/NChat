package com.nghianv.nghiachat.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nghianv.nghiachat.model.MessageChat;
import com.nghianv.nghiachat.R;

import java.util.List;

/**
 * Created by NguyenNghia on 4/2/2016.
 */
public class ChatAdapter extends ArrayAdapter<MessageChat> {
    private Context mContext;
    private List<MessageChat> mMessageChats;
    RelativeLayout container;

    public ChatAdapter(Context context,  List<MessageChat> objects) {
        super(context, 0, objects);
        mContext = context;
        mMessageChats = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.row_chat, parent, false);


            container = (RelativeLayout)convertView.findViewById(R.id.rowContanier);
        }

        MessageChat messageChat = mMessageChats.get(position);
        TextView txtChat = (TextView)convertView.findViewById(R.id.txtMessageChat);
        txtChat.setText(messageChat.getMessage());



        if(messageChat.getIsMine()){
            if(Build.VERSION.SDK_INT >= 16)
                convertView.setBackground(mContext.getResources().getDrawable(R.drawable.border_chat_mine));
            else
                convertView.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.border_chat_mine));
        }
        else {
            if(Build.VERSION.SDK_INT >= 16)
                convertView.setBackground(mContext.getResources().getDrawable(R.drawable.border_row_chat));
            else
                convertView.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.border_row_chat));
        }

        return convertView;
    }
}

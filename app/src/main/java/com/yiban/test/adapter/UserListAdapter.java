package com.yiban.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yiban.test.R;
import com.yiban.test.adapter.bean.UserBean;
import com.yiban.test.custom.NameImageView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private final Context context;
    private final List<UserBean> ls;

    public UserListAdapter(Context context, List<UserBean> ls) {
        this.context = context;
        this.ls = ls;

    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userlist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserListAdapter.ViewHolder holder, int position) {
        holder.userListPhone.setText(ls.get(position).getPhone());
        holder.nameImageView.setName(ls.get(position).getName());
        String msg = ls.get(position).getMsg();
        holder.userListShowMsg.setText(msg ==null?"":msg);
        holder.nameImageView.setOK(ls.get(position).isOk());

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userListPhone;
        private TextView userListShowMsg;
        private NameImageView nameImageView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            nameImageView = (NameImageView) itemView.findViewById(R.id.name);

            userListPhone = (TextView) itemView.findViewById(R.id.user_list_phone);
            userListShowMsg = (TextView) itemView.findViewById(R.id.user_list_show_msg);

        }
    }
}

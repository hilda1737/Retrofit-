package com.getfit.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.getfit.mypost.databinding.ActivityCommentBinding.inflate
import com.getfit.mypost.databinding.ActivityrvcommentsBinding
import com.getfit.mypost.databinding.RetrofitListItemBinding

class CommentRVadapter(var commentList: List<Post>) :
    RecyclerView.Adapter<CommentRVadapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var bindingView = ActivityrvcommentsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentPost = commentList.get(position)

       with(holder.bindingView){
           tvUserId0.text = currentPost.userId.toString()
           tvBody0.text = currentPost.body.toString()
           tvId0.text = currentPost.id.toString()
           tvTittle0.text = currentPost.title.toString()
       }

    }


    override fun getItemCount(): Int {
        return commentList.size
    }


    class CommentViewHolder(var bindingView: ActivityrvcommentsBinding) :
        RecyclerView.ViewHolder(bindingView.root)
}

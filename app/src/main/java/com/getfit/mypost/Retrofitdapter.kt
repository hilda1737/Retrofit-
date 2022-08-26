package com.getfit.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.getfit.mypost.databinding.RetrofitListItemBinding

class Retrofitdapter(var context: Context, var postList: List<Post>
) : RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView = RetrofitListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
//        val context = holder.itemView.context

        with(holder.bindingView) {
            tvId.text = currentItem.userId
            tvId.text = currentItem.id.toString()
            tvTittle.text = currentItem.title
            tvBody.text = currentItem.body
            val context = holder.itemView.context
            holder.bindingView.cvContacts.setOnClickListener{
                val intent=Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID",currentItem.id)
                context.startActivity(intent)

            }

        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitListItemBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}

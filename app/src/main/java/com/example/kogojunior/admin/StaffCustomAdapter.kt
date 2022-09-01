package com.example.kogojunior.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kogojunior.R
import com.google.firebase.database.core.Context

class StaffCustomAdapter(var context: EditStaffActivity, var data:ArrayList<Staff>): BaseAdapter()  {
    private class ViewHolder(row: View?){
        var reName: TextView
        var reposition: TextView
        init {
            this.reName = row?.findViewById(R.id.reName) as TextView
            this.reposition = row?.findViewById(R.id.reposition) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.admin_staff_item,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Staff = getItem(position) as Staff
        viewHolder.reName.text = item.username
        viewHolder.reposition.text = item.rank
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}


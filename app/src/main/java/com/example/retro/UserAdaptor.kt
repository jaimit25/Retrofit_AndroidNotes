//package com.example.retro
//
//import android.widget.BaseAdapter
//import android.widget.TextView
//
//class UserAdapter(private val userList: List<UserModel>) : BaseAdapter() {
//    override  fun getCount(): Int {
//        return userList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return userList[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        // Inflate or reuse a layout view for each item in the ListView
//        val itemView: View = convertView ?: LayoutInflater.from(parent?.context).inflate(
//            R.layout.list_item_user, parent, false
//        )
//
//        // Get the user at the specified position
//        val user: UserModel = userList[position]
//
//        // Update the UI of the item view with the user's data
//        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
//        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
//
//        nameTextView.text = user.name
//        emailTextView.text = user.email
//
//        return itemView
//    }
//}
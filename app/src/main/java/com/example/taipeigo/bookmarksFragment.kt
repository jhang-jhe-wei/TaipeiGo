package com.example.taipeigo

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import kotlinx.android.synthetic.main.fragment_search.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [bookmarksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class bookmarksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmarks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchAdapter=SearchAdapter()
        val linearLayoutManager= LinearLayoutManager(context)
        bookmarks_recycleview.adapter=searchAdapter
        bookmarks_recycleview.layoutManager=linearLayoutManager
        bookmarks_recycleview.addItemDecoration(object : RecyclerView.ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                with(outRect){
                    bottom=60
                }
            }
        })
    }

    inner class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var itemView: View
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_search_item, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
        }


        override fun getItemCount(): Int {
            return 3
        }

        //	ViewHolder需要繼承RecycleView.ViewHolder
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val photo: ImageView =itemView.findViewById(R.id.search_item_photo)
            val image: ImageView =itemView.findViewById(R.id.search_item_image)
            val name: TextView =itemView.findViewById(R.id.search_item_name)
            val like: ImageButton =itemView.findViewById(R.id.search_item_like)
            val local: TextView =itemView.findViewById(R.id.search_item_local)
            val local_name: TextView =itemView.findViewById(R.id.search_item_local_name)
            val feature: TextView =itemView.findViewById(R.id.search_item_feature)
            var like_flag=false
            fun bind(i: Int) {
                photo.setImageResource(R.drawable.maxresdefault)
                image.setImageResource(R.drawable.messageimage_1591191361542)
                name.text="Amo"
                like.setOnClickListener({
                    like_flag= !like_flag
                    when(like_flag){
                        true-> like.setImageResource(R.drawable.ic_baseline_bookmark_24)
                        false-> like.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
                    }
                })
                local.text="大安區"
                local_name.text="好吃拉麵"
                feature.text="吃不飽"
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment bookmarksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            bookmarksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
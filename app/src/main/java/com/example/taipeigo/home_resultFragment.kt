package com.example.taipeigo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home_result.*
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home_resultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class home_resultFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_home_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  homeAdapter=HomeAdapter()
        val linearLayoutManager=LinearLayoutManager(context)
        home_result_recycleview.layoutManager=linearLayoutManager
        home_result_recycleview.adapter=homeAdapter

    }

    inner class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var itemView: View
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_result, parent, false)
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
            val image:ImageView=itemView.findViewById(R.id.home_result_image)
            val name:TextView=itemView.findViewById(R.id.home_result_name)
            val like:ImageButton=itemView.findViewById(R.id.home_result_like)
            var like_flag=false
            fun bind(i: Int) {
                image.setImageResource(R.drawable.zhongzheng_cks)
                name.text="中正紀念堂"
                like.setOnClickListener({
                    like_flag= !like_flag
                    when(like_flag){
                        true-> like.setImageResource(R.drawable.ic_baseline_favorite_24)
                        false-> like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    }
                })
                itemView.setOnClickListener({
                    findNavController().navigate(R.id.home_result_infoFragment)
                })
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
         * @return A new instance of fragment home_resultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_resultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
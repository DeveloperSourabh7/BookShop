package com.sourabh.bookshop.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.sourabh.bookshop.R
import com.sourabh.bookshop.adapter.ParentItemAdapter
import com.sourabh.bookshop.databinding.FragmentHomeMainBinding
import com.sourabh.bookshop.model.ChildItem
import com.sourabh.bookshop.model.ParentItem

class HomeMainFragment : Fragment() {

    private lateinit var parentItemAdapter: ParentItemAdapter
    private lateinit var parentItemsList: ArrayList<ParentItem>
    private lateinit var childItemsList: ArrayList<ChildItem>
    private lateinit var binding: FragmentHomeMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_home_main,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupAdapter()
        setBanner()
    }

    private fun init(){
        parentItemsList = ArrayList()
        childItemsList = ArrayList()
        childItemsList.add(ChildItem("https://www.designforwriters.com/wp-content/uploads/2017/10/design-for-writers-book-cover-ec-1-looking-for-lala.jpg"))
        childItemsList.add(ChildItem("https://www.designforwriters.com/wp-content/uploads/2017/10/design-for-writers-book-cover-tf-2-a-million-to-one.jpg"))
        childItemsList.add(ChildItem("https://www.designforwriters.com/wp-content/uploads/2017/10/design-for-writers-book-cover-pp-mrh-4-thy-fathers-house.jpg"))
        childItemsList.add(ChildItem("https://www.designforwriters.com/wp-content/uploads/2017/10/design-for-writers-book-cover-km-1-godhead.jpg"))
        childItemsList.add(ChildItem("https://www.designforwriters.com/wp-content/uploads/2017/10/design-for-writers-book-cover-ec-5stones-into-the-sky.jpg"))

        parentItemsList.add(ParentItem("Recommended for you", childItemsList))
        parentItemsList.add(ParentItem("New Releases", childItemsList))
        parentItemsList.add(ParentItem("Best Books", childItemsList))
        parentItemsList.add(ParentItem("Awarded Books", childItemsList))
        parentItemsList.add(ParentItem("Ancient Epic", childItemsList))
        parentItemsList.add(ParentItem("Explore More Books", childItemsList))

    }

    private fun setupAdapter(){
        parentItemAdapter= ParentItemAdapter(parentItemsList){
            Toast.makeText(activity,"Session ",Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter= parentItemAdapter
        binding.recyclerView.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
    private fun setBanner() {
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.",
            ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP))

        binding.imageSlider.setImageList(imageList)
    }

}
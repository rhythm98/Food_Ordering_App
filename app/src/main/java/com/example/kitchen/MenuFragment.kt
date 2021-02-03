package com.example.kitchen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        val dishList=generateDummyList(50)
        rv_dish_list.adapter=DishAdapter(dishList)
        rv_dish_list.layoutManager= LinearLayoutManager(getApplicationContext())
        rv_dish_list.setHasFixedSize(true)

    }
    private fun generateDummyList(size: Int): List<Dish> {
        val list = ArrayList<Dish>()
        for (i in 0 until size) {
            val imageUrl = when (i % 6) {
                0 -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/alooTikki.jpg?alt=media&token=28d459fb-6954-4b3b-bc6e-733d187e1152"
                1 -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/dahiBhalla.jpg?alt=media&token=ce65a97a-fd0b-4e52-8b14-56beebe2c57e"
                2 -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/malaiChaap.jpg?alt=media&token=51879bb7-c724-4b8e-b27e-5ec62924f983"
                3 -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/momos.jpg?alt=media&token=8ca63e61-3d77-4e5e-a970-0a20eb91cad0"
                4 -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/omelte.jpg?alt=media&token=7323802a-c29e-4d74-a7a4-09c6c4b7f627"
                else -> "https://firebasestorage.googleapis.com/v0/b/chaat-bae.appspot.com/o/rajKachori.JPG?alt=media&token=c849f4ba-cbd5-46bd-a577-7a071ef093c5"
            }
            val name = when (i % 6) {
                0 -> "Aloo Tikki"
                1 -> "Dahi Bhalla"
                2 -> "Malai Chaap"
                3 -> "Momos"
                4 -> "Omelette"
                else -> "Raj Kachori"
            }
            val description = when (i % 6) {
                0 -> "Aloo tikki is a golden fried-potato patty that is often stuffed with peas or dal and served with a variety of spicy chutneys and sometimes chickpeas, while aloo chaat is simply boiled potatoes that are fried, seasoned, and served hot."
                1 -> "Served with topping of yogurt and chutneys and that’s what makes them so delectable."
                2 -> "Malai Chaap is rich and spicy soya chaap recipe, cooked into creamy and mildly spiced flavourful masala gravy which is made with rich malai or milk cream, butter....."
                3 -> "Momo made with flour and a savory stuffing of veggies, mushrooms, paneer and a balanced taste of lightly spices."
                4 -> "It is quite common for the omelette to be folded around fillings such as cheese, chives, vegetables, mushrooms, meat (often ham or bacon), or some combination of the above."
                else -> "Raj Kachori can pretty much be called the Queen-bee of the Chaat family and has quite an apt, royal name to signify that as well 🙂 Raj Kachori is crispy, crunchy, sweet, spicy, tangy, extremely flavorful and is the ultimate form of chaat."
            }
            val price = when (i % 6) {
                0 -> 60
                1 -> 45
                2 -> 110
                3 -> 35
                4 -> 55
                else -> 85
            }
            val item = Dish(name,description,imageUrl,price,false)
            list += item
        }
        return list
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
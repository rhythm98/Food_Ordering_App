package com.example.kitchen

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.test.view.*


class DishAdapter(private val dishList:List<Dish>): RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.test,
            parent,false)
        return DishViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val currentItem=dishList[position]
        val url = currentItem.imageUrl
        Log.d("ajit",url)
        val dish_img=Glide.with(holder.itemView.context)
                .load(url)
                .placeholder(R.drawable.ic_round_cloud_download_24)
                .error(R.drawable.ic_round_broken_image_24)
                .fallback(R.drawable.ic_round_image_24)
                .centerCrop()
                .into(holder.dishImage)


        //first store image in bitmap variable then use getHeight() getWidth()
        //then use height=0dp width=match_parent app:layout_constraintDimensionRatio="16:9" <--width:height

        //Android background jobs -
        /*  https://www.raywenderlich.com/2945946-glide-tutorial-for-android-getting-started
        * Clearing the Cache
          There are some good reasons to clear the cache. One reason is to debug.
          You want to make sure Glide isn’t loading images from memory or disk.
          Another reason is to allow users to clear some disk space. Someday,
          you might build an app that catches up to hundreds of megabytes of images!

          To clear Glide’s cache, add the following code to clearCache()
          at the end of MainActivity.kt:

          Thread(Runnable {
            Glide.get(this).clearDiskCache() //1
          }).start()
          Glide.get(this).clearMemory() //2

          You can only call clearDiskCache() in background. A simple solution
          is to call this method in a thread.
          You can only call clearMemory() in the main thread.
        */

//        holder.fav.
        holder.dishName.text=currentItem.name
//        holder.dishDescription.text=currentItem.description
        holder.dishPrice.text="\u20B9"+currentItem.price.toString()

    }

    override fun getItemCount()=dishList.size

    class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dishImage: ImageView = itemView.iv_dish
        val fav:CheckBox=itemView.fav_icon
        val dishName:TextView=itemView.tv_dish_name
//        val dishDescription:TextView=itemView.tv_dish_description
        val dishPrice:TextView=itemView.tv_dish_price
//        itemView.root.setO
    }
}


package com.example.teachkotlin

import android.media.Image.Plane
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teachkotlin.databinding.UnitMenuLayoutBinding

class UnitAdapter : RecyclerView.Adapter<UnitAdapter.UnitHolder>() {
    //    private val unitList2 = listOf(
//        Unit("Начало", R.drawable.unit1),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Начало", R.drawable.unit1),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Начало", R.drawable.unit1),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Начало", R.drawable.unit1),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//        Unit("Кончало", R.drawable.unit2),
//    )
    private val unitList = ArrayList<Unit>()

    class UnitHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = UnitMenuLayoutBinding.bind(item)

        fun bind(unit: Unit) = with(binding) {
            unitImage.setImageResource(unit.imageOfUnit)
            unitHeader.text = unit.nameOfUnit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.unit_menu_layout, parent, false)
        return UnitHolder(view)
    }


    override fun onBindViewHolder(holder: UnitHolder, position: Int) {
        holder.bind(unitList[position])
    }


    override fun getItemCount(): Int {
        return unitList.size
    }

    fun addUnit(unit: Unit) {
        unitList.add(unit)
        notifyItemInserted(0)
    }
}
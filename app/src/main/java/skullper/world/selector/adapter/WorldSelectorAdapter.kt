package skullper.world.selector.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_world.view.*
import skullper.world.selector.R
import skullper.world.selector.api.models.WorldItem
import skullper.world.selector.extensions.inflate

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class WorldSelectorAdapter(private val items: List<WorldItem>, val onClick: (WorldItem) -> Unit)
    : RecyclerView.Adapter<WorldSelectorAdapter.WorldViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : WorldViewHolder {
        val holder = WorldViewHolder(parent.inflate(R.layout.item_world))
        setOnItemClickListener(holder)
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WorldViewHolder, position: Int) = holder.bind(items[position])

    private fun setOnItemClickListener(holder: WorldViewHolder) = holder.itemView.setOnClickListener {
        val selectedPosition = holder.adapterPosition
        if (selectedPosition != RecyclerView.NO_POSITION) onClick(items[selectedPosition])
    }

    inner class WorldViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = view.tv_item_world_name
        private val tvDescription: TextView = view.tv_item_world_description
        private val tvCountryCode: TextView = view.tv_item_world_country

        fun bind(item: WorldItem) = with(item) {
            tvName.text = name
            tvDescription.text = description
            tvCountryCode.text = countryCode
        }
    }
}
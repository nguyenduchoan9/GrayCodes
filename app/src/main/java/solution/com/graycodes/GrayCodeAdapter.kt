package solution.com.graycodes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class GrayCodeAdapter(var grayCodes: List<String>): RecyclerView.Adapter<GrayCodeAdapter.GrayCodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GrayCodeViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_gray_code, parent, false)
        return GrayCodeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return grayCodes.size
    }

    override fun onBindViewHolder(viewholder: GrayCodeViewHolder, pos: Int) {
        viewholder.bindDataToView(grayCodes[pos])
    }

    fun setData(newGrayCode: List<String>){
        this.grayCodes = newGrayCode
        notifyDataSetChanged()
    }

    inner class GrayCodeViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val tvGrayCode = view.findViewById<TextView>(R.id.tvGrayCode)

        fun bindDataToView(grayCode: String){
            tvGrayCode.text = "$grayCode"
        }
    }
}
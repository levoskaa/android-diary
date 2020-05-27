package hu.bme.aut.mydiary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.mydiary.R
import hu.bme.aut.mydiary.model.DiaryEntry
import kotlinx.android.synthetic.main.content_viewholder.view.*

class DiaryEntryAdapter(
    private val diaryEntries: MutableList<DiaryEntry>,
    private val context: Context
) : RecyclerView.Adapter<DiaryEntryAdapter.DiaryEntriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryEntriesViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.content_viewholder, parent, false)
        return DiaryEntriesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return diaryEntries.size
    }

    override fun onBindViewHolder(holder: DiaryEntriesViewHolder, position: Int) {
        val diaryEntry = diaryEntries[position]
        holder.run {
            tvTitle.text = diaryEntry.title
            tvText.text = diaryEntry.text
            tvPlace.text = diaryEntry.place
            tvDate.text = String.format("%02d.%02d.%d", diaryEntry.creationDate.date, diaryEntry.creationDate.month, diaryEntry.creationDate.year)
            cbIsPersonal.isChecked = diaryEntry.isPersonal
        }
    }

    fun addDiaryEntry(diaryEntry: DiaryEntry) {
        diaryEntries.add(0, diaryEntry)
        notifyItemInserted(0)
    }

    fun deleteAllEntries() {
        diaryEntries.clear()
        notifyDataSetChanged()
    }

    inner class DiaryEntriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.title
        val tvText: TextView = itemView.text
        val tvPlace: TextView = itemView.place
        val tvDate: TextView = itemView.date
        val cbIsPersonal: CheckBox = itemView.isPersonal
    }
}
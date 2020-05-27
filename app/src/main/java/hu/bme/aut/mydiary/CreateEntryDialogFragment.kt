package hu.bme.aut.mydiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import hu.bme.aut.mydiary.model.DiaryEntry
import kotlinx.android.synthetic.main.content_diarylist.*
import kotlinx.android.synthetic.main.fragment_create_entry_dialog.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateEntryDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateEntryDialogFragment : DialogFragment() {
    private var dateSelected: Date = Calendar.getInstance().time

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_entry_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bAdd.setOnClickListener {
            if (title.text.isEmpty()) {
                title.error = "Title is required!"
                return@setOnClickListener
            }
            if (text.text.isEmpty()) {
                text.error = "Description is required!"
                return@setOnClickListener
            }
            val diaryEntry = DiaryEntry(title.text.toString(), text.text.toString(),
                isPersonal.isChecked, place.text.toString(), dateSelected)
            (activity as DiaryListActivity).addDiaryEntry(diaryEntry)
            dismiss()
        }
        date.setOnDateChangedListener { it, year, monthOfYear, dayOfMonth ->
            dateSelected = Date(year, monthOfYear, dayOfMonth)
        }
    }
}

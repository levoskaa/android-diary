package hu.bme.aut.mydiary

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.mydiary.adapter.DiaryEntryAdapter
import hu.bme.aut.mydiary.model.DiaryEntry
import kotlinx.android.synthetic.main.activity_diarylist_scrolling.*

class DiaryListActivity : AppCompatActivity() {
    private lateinit var adapter: DiaryEntryAdapter
    private var diaryEntries: List<DiaryEntry> = new List<DiaryEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diarylist_scrolling)
        setSupportActionBar(toolbar)
        adapter= DiaryEntryAdapter(this@Diary)
    }
}

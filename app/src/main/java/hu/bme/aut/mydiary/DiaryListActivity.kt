package hu.bme.aut.mydiary

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.mydiary.adapter.DiaryEntryAdapter
import hu.bme.aut.mydiary.model.DiaryEntry
import kotlinx.android.synthetic.main.activity_diarylist.*
import kotlinx.android.synthetic.main.content_diarylist.*
import java.util.*

class DiaryListActivity : AppCompatActivity() {
    private lateinit var adapter: DiaryEntryAdapter
    private var diaryEntries: MutableList<DiaryEntry> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diarylist)
        title = resources.getString(R.string.app_name)
        setSupportActionBar(toolbar)
        diaryEntries.add(DiaryEntry("asd", "asd", true, "asd", Date(2000, 1, 1)))
        adapter = DiaryEntryAdapter(diaryEntries, this@DiaryListActivity)
        diaryEntriesRV.layoutManager = LinearLayoutManager(applicationContext)
        diaryEntriesRV.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_diarylist, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.miAdd) {
            val tran = supportFragmentManager.beginTransaction()
            tran.add(CreateEntryDialogFragment(), "Create entry dialog")
            tran.commit()
        }
        if (item.itemId == R.id.miDelete) {
            deleteAllEntries()
        }
        return true
    }

    fun addDiaryEntry(diaryEntry: DiaryEntry) {
        adapter.addDiaryEntry(diaryEntry)
    }

    fun deleteAllEntries() {
        adapter.deleteAllEntries()
    }
}

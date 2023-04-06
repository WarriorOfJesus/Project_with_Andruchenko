package com.example.projectwithandruchenko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.projectwithandruchenko.databinding.ActivitySimpleListViewBinding
import java.util.SimpleTimeZone

class ActivitySimpleListView : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setContentView(R.layout.activity_simple_list_view)
        setupListViewSimple()
    }

    private fun setupListViewSimple() {
        val data = listOf(
            mapOf(
                KEY_TITLE to "First Title 111",
                KEY_DESCRIPTION to "the first some description"
            ),
            mapOf(
                KEY_TITLE to "second title 222",
                KEY_DESCRIPTION to " the second some description"
            ),
            mapOf(
                KEY_TITLE to " third title 333",
                KEY_DESCRIPTION to "the third some description "
            )
        )

        val adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESCRIPTION),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listview.adapter = adapter

        /*binding.listview.onItemClickListener =
            AdapterView.OnItemClickListener(parent, view, position, id ->
        val selectedItemTitle = data[position][KEY_TITLE]
        val selectedItemDescription = data[position][KEY_DESCRIPTION]

        val dialog = AlertDialog.Builder(this)
            .setTitle(selectedItemTitle)
            .setMessage(getString(R.string.item_selected_message, SelectedItemDiscriptiom))
            .setPositiveButton(){dialog.which ->}
        dialog.show()
        )*/
    }


/*    private fun setupListViewSimpleGeneratedData() {
        val data = (1..100).map {
            mapOf(
                KEY_TITLE to "Item #$it",
                KEY_DESCRIPTION to "Description #$it"
            )
        }


        val adapter = SimpleAdapter(
            this,
            data,
            R.layout.item_custom,
            arrayOf(R.id.titleTextView, R.id.descriptionTextView)
        )
        binding.listview.adapter = adapter
    }*/


    companion object {
        @JvmStatic
        val KEY_TITLE = "title"

        @JvmStatic
        val KEY_DESCRIPTION = "description"
    }
}
package com.example.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var list_btn: ImageButton? = null
    private var search_btn: ImageButton? = null
    private var settings_btn: ImageButton? = null
    private var bookmarks_btn: ImageButton? = null
    private var library_btn: ImageButton? = null
    private var arrowDown_btn: ImageButton? = null
    private var arrowBack_btn: ImageButton? = null
    private var plus_btn: ImageButton? = null
    private var minus_btn: ImageButton? = null
    private var font_icon: ImageView? = null
    private var fontSize_icon: ImageView? = null
    private var bold_icon: ImageView? = null
    private var bold_check: CheckBox? = null
    private var font_counterEditor: TextInputEditText? = null
    private var text: TextView? = null
    private var counter: Int = 14
    private var spinner: Spinner? = null
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrowDown_btn = findViewById(R.id.imageButton)//Visible
        search_btn = findViewById(R.id.imageButton2)//Visible
        settings_btn = findViewById(R.id.imageButton3)//Visible
        bookmarks_btn = findViewById(R.id.imageButton4)//Visible
        list_btn = findViewById(R.id.imageButton5)//Visible
        library_btn = findViewById(R.id.imageButton6)//Visible
        arrowBack_btn = findViewById(R.id.imageButton7)//Invisible
        plus_btn = findViewById(R.id.imageButton9)//Invisible
        minus_btn = findViewById(R.id.imageButton10)//Invisible
        bold_check = findViewById(R.id.checkBox)//Invisible
        font_counterEditor = findViewById(R.id.textEdit)//Invisible
        text = findViewById(R.id.editTextTextMultiLine)//Visible
        font_icon = findViewById(R.id.imageView2)//Invisible
        fontSize_icon = findViewById(R.id.imageView3)//Invisible
        bold_icon = findViewById(R.id.imageView4)//Invisible
        spinner = findViewById(R.id.spinner)//Invisible

        text?.setTypeface(Typeface.createFromAsset(resources.assets, "fonts/TimesNewRoman.ttf"))

        ArrayAdapter.createFromResource(
            this,
            R.array.fontNames,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner?.adapter = adapter
        }

        search_btn?.setOnClickListener{
            Toast.makeText(this, "in developing", Toast.LENGTH_LONG).show()
        }

        arrowDown_btn?.setOnClickListener {
            Toast.makeText(this, "in developing", Toast.LENGTH_LONG).show()
        }

        arrowBack_btn?.setOnClickListener {
            arrowDown_btn?.visibility = View.VISIBLE
            search_btn?.visibility = View.VISIBLE
            settings_btn?.visibility = View.VISIBLE
            bookmarks_btn?.visibility = View.VISIBLE
            list_btn?.visibility = View.VISIBLE
            library_btn?.visibility = View.VISIBLE
            text?.visibility = View.VISIBLE
            arrowBack_btn?.visibility = View.GONE
            plus_btn?.visibility = View.GONE
            minus_btn?.visibility = View.GONE
            bold_check?.visibility = View.GONE
            font_icon?.visibility = View.GONE
            fontSize_icon?.visibility = View.GONE
            font_counterEditor?.visibility = View.GONE
            bold_icon?.visibility = View.GONE
            spinner?.visibility = View.GONE
        }

        bookmarks_btn?.setOnClickListener{
            Toast.makeText(this, "in developing", Toast.LENGTH_LONG).show()
        }

        list_btn?.setOnClickListener {
            Toast.makeText(this, "in developing", Toast.LENGTH_LONG).show()
        }

        settings_btn?.setOnClickListener {
            arrowDown_btn?.visibility = View.GONE
            search_btn?.visibility = View.GONE
            settings_btn?.visibility = View.GONE
            bookmarks_btn?.visibility = View.GONE
            list_btn?.visibility = View.GONE
            library_btn?.visibility = View.GONE
            text?.visibility = View.GONE
            arrowBack_btn?.visibility = View.VISIBLE
            plus_btn?.visibility = View.VISIBLE
            minus_btn?.visibility = View.VISIBLE
            bold_check?.visibility = View.VISIBLE
            font_icon?.visibility = View.VISIBLE
            fontSize_icon?.visibility = View.VISIBLE
            font_counterEditor?.visibility = View.VISIBLE
            bold_icon?.visibility = View.VISIBLE
            spinner?.visibility = View.VISIBLE

            if (font_counterEditor?.hint?.toString()?.trim()?.equals("")!!)
                font_counterEditor?.hint = counter.toString()
            else
            {
                val fontSize: String = font_counterEditor?.hint.toString()
                counter = fontSize.toInt()
            }
        }

        plus_btn?.setOnClickListener {
            font_counterEditor?.hint = counter.plus(1).toString()
            counter = counter.plus(1)
            text?.setTextSize(counter.toFloat())
        }

        minus_btn?.setOnClickListener {
            if (font_counterEditor?.hint != "1")
            {
                font_counterEditor?.hint = counter.minus(1).toString()
                counter = counter.minus(1)
            } else {
                font_counterEditor?.hint = "1"
                counter = 1
                text?.setTextSize(counter.toFloat())
            }

        }

        bold_check?.setOnClickListener {
            val checked = bold_check?.isChecked()
            if (checked == true) {
                text?.setTypeface(null, Typeface.BOLD)
            } else {
                text?.setTypeface(null, Typeface.NORMAL)
            }
        }

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinner?.selectedItem
                if (selectedItem!!.equals("Times New Roman")) {
                    text?.setTypeface(Typeface.createFromAsset(resources.assets, "fonts/TimesNewRoman.ttf"))
                }
                if (selectedItem.equals("Calibri")) {
                    text?.setTypeface(Typeface.createFromAsset(resources.assets, "fonts/Calibri.ttf"))
                }
                if (selectedItem.equals("Roboto")) {
                    text?.setTypeface(Typeface.createFromAsset(resources.assets, "fonts/Roboto.ttf"))
                }
            }

        }
    }

    override fun onBackPressed() {

        if (backPressedTime.plus(2000) > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(this, "Press a second time to exit!", Toast.LENGTH_LONG).show()
        }

        backPressedTime = System.currentTimeMillis()
    }
}
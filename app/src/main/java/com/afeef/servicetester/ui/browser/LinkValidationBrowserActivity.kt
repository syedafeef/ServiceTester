package com.afeef.servicetester.ui.browser

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afeef.servicetester.R
import com.afeef.servicetester.ui.browser.adapter.UrlAdapter
import com.afeef.servicetester.ui.browser.viewmodel.UrlViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LinkValidationBrowserActivity : AppCompatActivity() {

    private val urlViewModel: UrlViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_link_validation_browser)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val verifyButton: Button = findViewById(R.id.verify_button)

        val adapter = UrlAdapter(urlViewModel.urls.value ?: listOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        urlViewModel.urls.observe(this) { urls ->
            adapter.notifyDataSetChanged()
        }

        verifyButton.setOnClickListener {
            urlViewModel.checkUrls()
        }

    }

}
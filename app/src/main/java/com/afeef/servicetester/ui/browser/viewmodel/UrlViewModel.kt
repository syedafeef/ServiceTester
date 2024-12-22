package com.afeef.servicetester.ui.browser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afeef.servicetester.data.repository.UrlRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UrlStatus(val url: String, var isReachable: Boolean? = null)

@HiltViewModel
class UrlViewModel @Inject constructor(private val urlRepository: UrlRepository) : ViewModel() {

    private val _urls = MutableLiveData<List<UrlStatus>>()
    val urls: LiveData<List<UrlStatus>> get() = _urls

    init {
        _urls.value = listOf(
            UrlStatus("https://www.google.com"),
            UrlStatus("https://www.invalidurl.com"),
            UrlStatus("https://www.youtube.com"),
            UrlStatus("https://www.test.com"),
            UrlStatus("https://global.rakuten.com"),
            UrlStatus("https://www.1nval1durl.c0m")
        )
    }

    fun checkUrls() {
        val currentUrls = _urls.value ?: return
        viewModelScope.launch {
            currentUrls.forEach { urlStatus ->
                urlRepository.checkUrl(urlStatus.url) { isReachable ->
                    urlStatus.isReachable = isReachable
                    _urls.postValue(currentUrls)
                }
            }
        }
    }

}
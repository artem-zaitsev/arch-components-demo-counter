package ru.vrn.r3tam.demoarchcomponents.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vrn.r3tam.demoarchcomponents.repo.CounterRepository
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    private val counterRepository: CounterRepository
) : ViewModel() {

    private val counterLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = counterRepository.counterGet
        }
    }

    val counter: LiveData<Int> get() = counterLiveData

    fun incrementCounter(inc: Int) {
        counterLiveData.value = counter.value?.plus(inc)
        counterRepository.inc(inc)
    }
}
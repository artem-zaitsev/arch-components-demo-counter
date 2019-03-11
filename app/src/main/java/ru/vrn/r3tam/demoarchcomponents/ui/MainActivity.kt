package ru.vrn.r3tam.demoarchcomponents.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import ru.vrn.r3tam.demoarchcomponents.R
import ru.vrn.r3tam.demoarchcomponents.di.ViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this, viewModelFactory)[CounterViewModel::class.java]
        model.counter.observe(this, Observer { i: Int ->
            counter.text = "Count: $i"
        })

        increment.setOnClickListener {
            model.incrementCounter(1)
        }
    }
}

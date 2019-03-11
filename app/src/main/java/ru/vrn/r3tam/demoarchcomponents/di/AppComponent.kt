package ru.vrn.r3tam.demoarchcomponents.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.vrn.r3tam.demoarchcomponents.App
import ru.vrn.r3tam.demoarchcomponents.repo.CounterRepository

@Component(
    modules = [AndroidInjectionModule::class, MainActivityModule::class, AppModule::class, ViewModelModule::class]
)
interface AppComponent {

    fun counterRepository(): CounterRepository
    fun inject(a: App)
}
package ru.vrn.r3tam.demoarchcomponents.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.vrn.r3tam.demoarchcomponents.ui.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeInjector(): MainActivity
}
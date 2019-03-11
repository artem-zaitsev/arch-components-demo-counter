package ru.vrn.r3tam.demoarchcomponents.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vrn.r3tam.demoarchcomponents.repo.CounterRepository
import ru.vrn.r3tam.demoarchcomponents.repo.CounterStorage

@Module
class AppModule(
    val context: Context
){

    @Provides
    fun provideCounterRepo(counterStorage: CounterStorage) = CounterRepository(counterStorage)

    @Provides
    fun provideContext() = context
}
package ru.vrn.r3tam.demoarchcomponents.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.vrn.r3tam.demoarchcomponents.ui.CounterViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
    //You are able to declare ViewModelProvider.Factory dependency in another module. For example in ApplicationModule.

    @Binds
    @IntoMap
    @ViewModelKey(CounterViewModel::class)
    abstract fun counterVm(userViewModel: CounterViewModel): ViewModel
}

class ViewModelFactory @Inject constructor(private val viewModels: Map<Class<out ViewModel>,  @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider =
            viewModels[modelClass] ?: throw IllegalArgumentException("model class $modelClass not found")

        return viewModelProvider.get() as T
    }
}
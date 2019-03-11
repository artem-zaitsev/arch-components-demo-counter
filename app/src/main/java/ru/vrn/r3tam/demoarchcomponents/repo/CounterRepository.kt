package ru.vrn.r3tam.demoarchcomponents.repo

class CounterRepository(
    private val counterStorage: CounterStorage
) {

    private var counter: Int = counterStorage.counter
        set(value) {
            field = value
            counterStorage.counter = field
        }

    val counterGet get() = counter

    fun inc(i: Int) {
        counter += i
    }
}
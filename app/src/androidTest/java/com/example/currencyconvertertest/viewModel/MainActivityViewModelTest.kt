package com.example.currencyconvertertest.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.currencyconverter.room.repository.CurrencyRepository
import com.example.currencyconverter.ui.viewModel.MainActivityViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class MainActivityViewModelTest {
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject
    lateinit var repository: CurrencyRepository

    private lateinit var viewModel : MainActivityViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        viewModel = MainActivityViewModel(repository)
    }

    @Test
    fun testViewModel(){
        viewModel.getLatest

    }
}
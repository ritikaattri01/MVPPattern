package com.example.mvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mvpexample.R
import com.example.mvpexample.contract.ContractInterface
import com.example.mvpexample.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), ContractInterface.View {
    private var presenter: MainActivityPresenter? = null
    private var counterTextView: TextView? = null
    private var clickButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterTextView = findViewById(R.id.counterTextView)
        clickButton = findViewById(R.id.clickButton)
        presenter = MainActivityPresenter(this)
    }

    override fun initView() {
        counterTextView?.text = presenter?.getCounter()
        clickButton?.setOnClickListener { presenter?.incrementValue() }
    }

    override fun updateViewData() {
        counterTextView?.text = presenter?.getCounter()
    }
}
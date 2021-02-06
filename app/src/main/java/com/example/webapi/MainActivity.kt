package com.example.webapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.webapi.Retrofit.RetrofitHelper
import com.example.webapi.Retrofit.TablePOJO
import com.example.webapi.Retrofit.WebAPI
import com.example.webapi.databinding.ActivityMainBinding
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy{DataBindingUtil.setContentView(this,R.layout.activity_main)}
    private val disposables:CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initButtons()
    }

    private fun initButtons(){
        disposables.add(RxView.clicks(binding.downloadTable).observeOn(Schedulers.io()).subscribe(){
          val obs: Observable<TablePOJO>? = RetrofitHelper.sendTable(WebAPI::class.java).getTable()?.flatMapIterable { it }
            if (obs != null) {
                setupRecView(obs)
            }
        })
        disposables.add(RxView.clicks(binding.sendTable).observeOn(Schedulers.io()).subscribe(){})
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    private fun setupRecView(obs: Observable<TablePOJO>){
        val observer:DisposableObserver<TablePOJO> =object:DisposableObserver<TablePOJO>(){
            override fun onNext(value: TablePOJO?) {
                if (value != null) {
                    Log.d("tut",value.Data)
                }
            }

            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }

            override fun onComplete() {
                
            }

        }
        obs.subscribe(observer)
    }
}
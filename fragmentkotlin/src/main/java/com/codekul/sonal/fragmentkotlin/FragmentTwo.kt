package com.codekul.sonal.fragmentkotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by sonal on 8/12/17.
 */
class FragmentTwo : Fragment(){

    val TAG = "FragmentTwo"

    override fun onAttach(context: Context?) {
        Log.d(TAG,"OnAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"OnCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"OnCreateView")
        return inflater!!.inflate(R.layout.fragment_two,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG,"OnActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG,"OnStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"OnResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"OnPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"OnStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG,"OnDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG,"OnDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG,"OnDetach")
        super.onDetach()
    }


}
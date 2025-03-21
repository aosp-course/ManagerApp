package com.example.managerapp

import android.app.ActivityManager
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var recyclerViewApps: RecyclerView
    private lateinit var appAdapter: AppAdapter
    private val appList = mutableListOf<AppInfo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate chamado")

        recyclerViewApps = findViewById(R.id.recyclerViewApps)
        recyclerViewApps.layoutManager = LinearLayoutManager(this)

        loadInstalledApps()
        appAdapter = AppAdapter(this, appList)
        recyclerViewApps.adapter = appAdapter
    }

    private fun loadInstalledApps() {
        val packageManager: PackageManager = packageManager
        val installedApps: List<ApplicationInfo> = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)

        for (appInfo in installedApps) {

            val appName = appInfo.loadLabel(packageManager).toString()
            val packageName = appInfo.packageName
            val appIcon = appInfo.loadIcon(packageManager)

            val app = AppInfo(appName, packageName, appIcon)
            appList.add(app)

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy chamado")
    }
}
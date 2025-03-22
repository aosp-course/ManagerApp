package com.example.managerapp

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
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

        optimizeUI()
    }

    /**
     * Carrega os aplicativos instalados no dispositivo.
     *
     * Esta função utiliza o gerenciador de pacotes para obter uma lista de todos os aplicativos
     * instalados e, em seguida, extrai informações relevantes, como nome, nome do pacote e ícone
     * de cada aplicativo. As informações coletadas são armazenadas em uma lista de objetos AppInfo.
     *
     * @throws PackageManager.NameNotFoundException Se o gerenciador de pacotes não conseguir encontrar
     * o nome do pacote de um aplicativo específico.
     */
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

    /**
     * @brief Ajusta o brilho da tela da janela atual e esconde a barra de navegação.
     */
    fun optimizeUI() {
        //Otimização da UI com WindowManager
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        val layoutParams = window.attributes
        layoutParams.screenBrightness = 0.5f // Define o brilho para 50%
        layoutParams.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //Esconde a barra de navegação
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

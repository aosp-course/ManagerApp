package com.example.managerapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class AppAdapterTest {
    private lateinit var SUT: AppAdapter
    private lateinit var context: Context
    private lateinit var appList: List<AppInfo>

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()

        // Simulação de dados
        val appIcon: Drawable = context.getDrawable(R.drawable.ic_launcher_foreground)!!
        appList = listOf(
            AppInfo("App1", "com.myapp.app1", appIcon),
            AppInfo("App2", "com.myapp.app2", appIcon)
        )

        SUT = AppAdapter(context, appList)
    }

    @Test
    fun classNotNull(){
        //Arrange
        //Act
        //Assert
        assertNotNull(SUT)
    }

    @Test
    fun getItemCountReturnCorrectValue(){
        //Arrange
        //Act
        val result = SUT.itemCount
        //Assert
        assertEquals(result, appList.size)
    }

    @Test
    fun onBindViewHolder_bindsDataCorrectly() {
        val parent = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context) // Definindo o LayoutManager
        }
        val viewHolder = SUT.onCreateViewHolder(parent, 0)

        SUT.onBindViewHolder(viewHolder, 0)

        val textViewAppName = viewHolder.itemView.findViewById<TextView>(R.id.textViewAppName)

        assertEquals("App1", textViewAppName.text.toString())
    }

    @Test
    fun onCreateViewHolder_inflatesViewCorrectly() {
        val parent = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context) // Definindo o LayoutManager
        }

        // Chama o método onCreateViewHolder
        val viewHolder = SUT.onCreateViewHolder(parent, 0)

        // Verifica se a view foi inflada corretamente
        val itemView = viewHolder.itemView
        assertNotNull( itemView)

        // Verifica se os componentes esperados estão presentes
        val imageViewAppIcon = itemView.findViewById<ImageView>(R.id.imageViewAppIcon)
        val textViewAppName = itemView.findViewById<TextView>(R.id.textViewAppName)

        assertNotNull(imageViewAppIcon)
        assertNotNull(textViewAppName)
    }
}
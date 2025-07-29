package com.example.contact_manager

import android.annotation.SuppressLint
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contact_manager.ui.theme.Contact_ManagerTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val txt=findViewById<TextView>(R.id.tvName)
        val btn=findViewById<Button>(R.id.btn)
        val btn2=findViewById<Button>(R.id.btnTask2)
        btn.setOnClickListener{
            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent=Intent(this,ContactActivity::class.java)
            startActivity(intent)
        }

        val btnShare=findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener{
            val shareIntent=Intent(Intent.ACTION_SEND).apply {
                type="text/plain"
                putExtra(Intent.EXTRA_TEXT,"Hello From My App !")
            }
            startActivity(Intent.createChooser(shareIntent,"share via"))
        }
        logEvent("onCreate")


    }
private fun logEvent(event:String){
    Log.d("LifeCycle",event)

}
    override fun onStart() {
        super.onStart()
        logEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logEvent("onResume")
    }
    override fun onPause() {
        super.onPause()
        logEvent("onPause")
    }
    override fun onStop() {
        super.onStop()
        logEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent("onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Contact_ManagerTheme {
        Greeting("Android")
    }
}


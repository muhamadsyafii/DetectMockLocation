package com.syafii.detectmocklocation

import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.syafii.detectmocklocation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkIsMockSettingsON()
    }

    //this is for check app mock setting on
    private fun checkIsMockSettingsON(): Boolean {
        showDialogWarning()
        return !Settings.Secure.getString(contentResolver, Settings.Secure.ALLOW_MOCK_LOCATION)
            .equals("0")
    }

    //this is show dialog warning
    private fun showDialogWarning() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Warning!")
        dialog.setMessage("App use Mock Location")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Close") { dialog, _ ->
            dialog.dismiss()
            finishAffinity()
        }
        dialog.show()
    }
}
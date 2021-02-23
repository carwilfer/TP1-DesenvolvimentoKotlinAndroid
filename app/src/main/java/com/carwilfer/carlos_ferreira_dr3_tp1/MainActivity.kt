package com.carwilfer.carlos_ferreira_dr3_tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.carwilfer.carlos_ferreira_dr3_tp1.database.AppDatabase
import com.carwilfer.carlos_ferreira_dr3_tp1.database.OculosDao
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //file
/*        val file = File(filesDir, "carlos_Ferreira_tp1_DR3") //filesDir = armazenamento interno : Diretorio files
        //Criar
        if (!file.exists())
            file.createNewFile()
        //Ler
        if (file.canRead())
            Log.i("Arquivo", "Leitura permitida!")
        //Escrever
        if (file.canWrite())
            Log.i("Arquivo", "Escrita permitida!")*/

        //if (file.delete())


        /* val lentes = resources.getStringArray(R.array.tipo_lentes)
        val armacao = resources.getStringArray(R.array.tipoArmacoes)

        val spinner = findViewById<Spinner>(R.id.tipo_lentes)
        val spinner2 = findViewById<Spinner>(R.id.tipoArmacoes)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, lentes
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + lentes[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            if (spinner2 != null) {
                val adapter2 = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, armacao
                )
                spinner2.adapter = adapter2

                spinner2.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.selected_item) + " " +
                                    "" + armacao[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action
                    }
                }
            }
        }*/
    }

}
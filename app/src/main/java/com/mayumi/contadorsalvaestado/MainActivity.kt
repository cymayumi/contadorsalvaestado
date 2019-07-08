package com.mayumi.contadorsalvaestado

import android.app.Activity
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var conta: Int = 0
    val CONTADOR = "contador" //criamos uma variável CONTADOR do tipo chave-valor

    override fun onSaveInstanceState(outState: Bundle) {
        //método irá salvar o valor já contado, ao recriar a activity (onCreate) o valor salvo será usado

        outState.run {
            //tudo o que desejarmos salvar deve ser declarado aqui (chave/valor)

            putInt(CONTADOR, conta)
        }
        super.onSaveInstanceState(outState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vai avaliar de estamos recriando ou nao uma nova instancia
        if (savedInstanceState != null) {
            with(savedInstanceState) {

                conta = getInt(CONTADOR)
                tv_contador.text = conta.toString()
            }
        } else {
            conta = 0
        }


        btn_add.setOnClickListener {
            conta = conta + 1

            tv_contador.text = conta.toString()

        }

        btn_del.setOnClickListener {
            conta=0
            tv_contador.text = "0"
        }
    }

}

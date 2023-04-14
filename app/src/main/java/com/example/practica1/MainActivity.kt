package com.example.practica1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.size
import com.example.practica1.databinding.ActivityMainBinding
import java.util.Random
        //onresume()
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var cont:Int=0
    var contC:Int=0
    var dano:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.capturar.setOnClickListener{capturar()}

        val cl = binding.linear1
        for(i in 0  until cl.size){
            var tv:View=cl.getChildAt(i)
            if(tv is TextView){
                tv.setOnClickListener{ataquechar(tv,tv.tag)}

            }

        }
        val cl2 = binding.linear2
        for(i in 0  until cl2.size){
            var tv2:View=cl2.getChildAt(i)
            if(tv2 is TextView){
                tv2.setOnClickListener{ataqueryq(tv2,tv2.tag)}
            }

        }
        binding.button2.setOnClickListener{huir()}


    }

            private fun capturar() {
                binding.rywview.setImageResource(R.drawable.pokeball)
                binding.rywview.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.girar))
                Toast.makeText(this,"LO HAS CAPTURADO",Toast.LENGTH_SHORT).show()

            }
            private fun huir() {
        val intent: Intent = Intent(this@MainActivity, huida::class.java)
        startActivity(intent)

    }

    private fun ataqueryq(tvv:TextView, tag: Any) {
        var tv:TextView= TextView(this)
        tvv.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.presionar))
        tv.setBackgroundResource(android.R.color.holo_red_dark)
        var vida:String=""
        if(tag=="1"){
            vida+="     "
            tv.text=vida
            binding.vidachar.addView(tv)
            cont+=5

        }
        if(tag=="2"){
            tv.text="   "
            binding.vidachar.addView(tv)
            cont+=3
        }
        if(tag=="3"){
            tv.text="  "
            binding.vidachar.addView(tv)
            cont+=2
        }
        if(tag=="4"){
            var r: Random = Random()
            var tx:String=""
            var r2:Int=r.nextInt(5)+1
            for(i in 0 until r2){
                tx+=" "
            }

            tv.text=tx
            binding.vidachar.addView(tv)
            cont+=r2

        }

        binding.char100.text=""+(60-cont)+"/60"
        binding.charview.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.defensa))
        binding.rywview.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.ataqe))

       // binding.vidachar.addView(tv)
        if(cont>=60){
            val builder : AlertDialog.Builder= AlertDialog.Builder(this)
            var cont1 :Int
            builder.setTitle("HA GANADO!!!")
            builder.setMessage("DESEA VOLVER A COMBATIR?")
            builder.setPositiveButton("SI", DialogInterface.OnClickListener{

                    dialogInterface, i ->

                recreate()
            })

            builder.setNegativeButton("NO", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                finish()
            })

            var alertDialog: AlertDialog =builder.create()
            alertDialog.show()
        }




    }


    private fun ataquechar(tvv:TextView, tag: Any) {
        var tv:TextView= TextView(this)
        tvv.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.presionar))
        tv.text=" "

        tv.setBackgroundResource(android.R.color.holo_red_dark)
        if(tag=="5"){
            tv.text="   "
            binding.vidaryq.addView(tv)
            contC+=3

        }
        if(tag=="6"){
            tv.text="    "
            binding.vidaryq.addView(tv)
            contC+=4
        }
        if(tag=="7"){
            tv.text="  "
            binding.vidaryq.addView(tv)
            contC+=2
        }
        if(tag=="8"){
            var r: Random = Random()
            var tx:String=""
            var r2:Int=r.nextInt(5)+1
            for(i in 0 until r2){
                tx+=" "
            }
            tv.text=tx
            binding.vidaryq.addView(tv)
            contC+=r2

            if(cont>1) {
                cont-=r2

                if(binding.vidachar.size-r2-1>=0) {
                    binding.vidachar.removeViews(binding.vidachar.size - r2 , r2)
                }


                when {
                    contC<=0 -> {
                        binding.vidachar.removeAllViews()
                        binding.ryq100.text="60/60"
                    }
                    else -> binding.char100.text = "" + (60 - cont) + "/60"
                }
            }

        }

        binding.charview.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.ataqe))
        binding.rywview.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.defensa))

            binding.ryq100.text=""+(60-contC)+"/60"
        // binding.vidachar.addView(tv)
        if(contC>=60){
            val builder : AlertDialog.Builder= AlertDialog.Builder(this)
            var cont1 :Int
            builder.setTitle("HA GANADO!!!")
            builder.setMessage("DESEA VOLVER A COMBATIR?")
            builder.setPositiveButton("SI", DialogInterface.OnClickListener{

                    dialogInterface, i ->

                recreate()
            })

            builder.setNegativeButton("NO", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                Toast.makeText(this,"fin del juego",Toast.LENGTH_SHORT)
                finish()
            })

            var alertDialog: AlertDialog =builder.create()
            alertDialog.show()
        }



    }
}
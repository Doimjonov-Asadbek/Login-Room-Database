package com.example.logindb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PasswordPage : AppCompatActivity() {

    private var view1: View? = null
    private var view2: View? = null
    private var view3: View? = null
    private var view4: View? = null

    private var click = true
    private var username = ""
    private var writePass = ""
    private var index = 0
    private var pasIndex = false
    private var password = ""
    private var newPassword = ""

    private var txtGetName: TextView? = null
    private var sharedPreferences: SharedPreferences? = null
    private var txtPassword: TextView? = null
    private var button1: TextView? = null
    private var button2: TextView? = null
    private var button3: TextView? = null
    private var button4: TextView? = null
    private var button5: TextView? = null
    private var button6: TextView? = null
    private var button7: TextView? = null
    private var button8: TextView? = null
    private var button9: TextView? = null
    private var button0: TextView? = null
    private var finger: ImageView? = null
    private var back: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.password_page)


        view1 = findViewById(R.id.viewlog_one)
        view2 = findViewById(R.id.viewlog_two)
        view3 = findViewById(R.id.viewlog_three)
        view4 = findViewById(R.id.viewlog_four)

        txtGetName = findViewById(R.id.txtlog_getname)
        txtPassword = findViewById(R.id.txtlog_pass)
        button1 = findViewById(R.id.txtPass1)
        button2 = findViewById(R.id.txtpass2)
        button3 = findViewById(R.id.txtpass3)
        button4 = findViewById(R.id.txtpass4)
        button5 = findViewById(R.id.txtpass5)
        button6 = findViewById(R.id.txtpass6)
        button7 = findViewById(R.id.txtpass7)
        button8 = findViewById(R.id.txtpass8)
        button9 = findViewById(R.id.txtpass9)
        button0 = findViewById(R.id.txtpass0)
        finger = findViewById(R.id.imglog_finger)
        back = findViewById(R.id.imglog_back)


        sharedPreferences = getSharedPreferences("MyReg", Context.MODE_PRIVATE)
        password = sharedPreferences?.getString("password","").toString()
        Toast.makeText(this, "Welcome $password", Toast.LENGTH_SHORT).show()
        txtGetName?.text = username



        button1?.setOnClickListener {
            if (click) {
                index++
                writePass += "1"
                onClick()
            }
        }

        button2?.setOnClickListener {
            if (click) {
                index++
                writePass += "2"
                onClick()
            }
        }

        button3?.setOnClickListener {
            if (click) {
                index++
                writePass += "3"
                onClick()
            }
        }

        button4?.setOnClickListener {
            if (click) {
                index++
                writePass += "4"
                onClick()
            }
        }

        button5?.setOnClickListener {
            if (click) {
                index++
                writePass += "5"
                onClick()
            }
        }

        button6?.setOnClickListener {
            if (click) {
                index++
                writePass += "6"
                onClick()
            }
        }

        button7?.setOnClickListener {
            if (click) {
                index++
                writePass += "7"
                onClick()
            }
        }

        button8?.setOnClickListener {
            if (click) {
                index++
                writePass += "8"
                onClick()
            }
        }

        button9?.setOnClickListener {
            if (click) {
                index++
                writePass += "9"
                onClick()
            }
        }

        button0?.setOnClickListener {
            if (click) {
                index++
                writePass += "0"
                onClick()
            }
        }

        back?.setOnClickListener {
            index--
            backSpace()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun onClick() {
        if (index > 4) {
            index = 4
        }

        when (index) {
            1 -> { view1?.setBackgroundResource(R.drawable.password) }
            2 -> { view2?.setBackgroundResource(R.drawable.password) }
            3 -> { view3?.setBackgroundResource(R.drawable.password) }
            4 -> { view4?.setBackgroundResource(R.drawable.password)

                if (password == "" && pasIndex) {
                    if (newPassword == writePass) {
                        click = false
                        writePass = ""
                        index = 0
                        view1?.setBackgroundResource(R.drawable.passoucses)
                        view2?.setBackgroundResource(R.drawable.passoucses)
                        view3?.setBackgroundResource(R.drawable.passoucses)
                        view4?.setBackgroundResource(R.drawable.passoucses)
                        Handler(Looper.getMainLooper()).postDelayed({
                            click = true
                            sharedPreferences?.edit()?.putString("password", newPassword)?.apply()
                            startActivity(Intent(this, HomeFragment::class.java))
                            finish()
                        }, 500)
                    } else {
                        click = false
                        writePass = ""
                        index = 0
                        view1?.setBackgroundResource(R.drawable.passerror)
                        view2?.setBackgroundResource(R.drawable.passerror)
                        view3?.setBackgroundResource(R.drawable.passerror)
                        view4?.setBackgroundResource(R.drawable.passerror)
                        Handler(Looper.getMainLooper()).postDelayed({
                            click = true
                            view1?.setBackgroundResource(R.drawable.password1)
                            view2?.setBackgroundResource(R.drawable.password1)
                            view3?.setBackgroundResource(R.drawable.password1)
                            view4?.setBackgroundResource(R.drawable.password1)
                            txtPassword?.text = getString(R.string.Repeat_password)
                        }, 500)
                        Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show()
                    }
                }
                if (password == "" && !pasIndex) {
                    click = false
                    newPassword = writePass
                    writePass = ""
                    index = 0
                    pasIndex = true
                    Handler(Looper.getMainLooper()).postDelayed({
                        click = true
                        view1?.setBackgroundResource(R.drawable.password1)
                        view2?.setBackgroundResource(R.drawable.password1)
                        view3?.setBackgroundResource(R.drawable.password1)
                        view4?.setBackgroundResource(R.drawable.password1)
                        txtPassword?.text = getString(R.string.Repeat_password)
                    }, 500)
                }
                if (password != "" && !pasIndex) {
                    if (writePass == password) {
                        click = false
                        writePass = ""
                        index = 0
                        view1?.setBackgroundResource(R.drawable.passoucses)
                        view2?.setBackgroundResource(R.drawable.passoucses)
                        view3?.setBackgroundResource(R.drawable.passoucses)
                        view4?.setBackgroundResource(R.drawable.passoucses)
                        Handler(Looper.getMainLooper()).postDelayed({
                            click = true
                            startActivity(Intent(this, HomeFragment::class.java))
                            finish()
                        }, 500)
                    } else {
                        click = false
                        writePass = ""
                        index = 0
                        view1?.setBackgroundResource(R.drawable.passerror)
                        view2?.setBackgroundResource(R.drawable.passerror)
                        view3?.setBackgroundResource(R.drawable.passerror)
                        view4?.setBackgroundResource(R.drawable.passerror)
                        Handler(Looper.getMainLooper()).postDelayed({
                            click = true
                            view1?.setBackgroundResource(R.drawable.password1)
                            view2?.setBackgroundResource(R.drawable.password1)
                            view3?.setBackgroundResource(R.drawable.password1)
                            view4?.setBackgroundResource(R.drawable.password1)
                        }, 500)
                        Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun backSpace() {
        if (index > 4) {
            index = 4
        }
        if (index < 0) {
            index = 0
        }
        if (index > 0) {
            writePass = writePass.substring(0, writePass.length - 1)
        }
        when (index) {
            0 -> {
                view1?.setBackgroundResource(R.drawable.password1)
            }
            1 -> {
                view2?.setBackgroundResource(R.drawable.password1)
            }
            2 -> {
                view3?.setBackgroundResource(R.drawable.password1)
            }
            3 -> {
                view4?.setBackgroundResource(R.drawable.password1)
            }
        }
    }


}









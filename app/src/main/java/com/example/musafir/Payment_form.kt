package com.example.musafir

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.musafir.databinding.ActivityPaymentFormBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class Payment_form : AppCompatActivity(), PaymentResultListener {
    private lateinit var binding: ActivityPaymentFormBinding
    private lateinit var btnCal : AppCompatButton
    private lateinit var textdate : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val payBtn = binding.paymentbtn
        val items = listOf("Adhar Card", "Pan Card", "Passport")
        val adapter = ArrayAdapter(this, R.layout.verification_name_list, items)
        (binding.menuItem)?.setAdapter(adapter)
        btnCal = binding.datebtn
        textdate = binding.dateText
        btnCal.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setTheme(R.style.cal)
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()


            datePicker.show(supportFragmentManager,"datePicker")
            datePicker.addOnPositiveButtonClickListener {
                val simpledateFormat = SimpleDateFormat("dd-MMMM-yyyy",Locale.getDefault())
                textdate.text = simpledateFormat.format(Date(it).time)

            }
        }
        val context = this
        payBtn.setOnClickListener {
            if(binding.EmailtextField.editText?.text.toString()>0.toString()
                && binding.IDtextField.editText?.text.toString()>0.toString()
                && binding.NametextField.editText?.text.toString()>0.toString()
                && binding.PhoneNotextField.editText?.text.toString()>0.toString()
            ){
                var user = UserData(binding.NametextField.editText?.text.toString(),
                    binding.EmailtextField.editText?.text.toString(),
                    binding.PhoneNotextField.editText?.text.toString(),
                    binding.IDtextField.editText?.text.toString(),
                    binding.childtextField.editText?.text.toString().toInt(),
                    binding.adulttextField.editText?.text.toString().toInt(),
                    binding.foreignertextField.editText?.text.toString().toInt(),
                    binding.dateText.text.toString(),
                    pid
                )
                var db = DatabaseHandler(context)
                db.insertData(user)
            }
            startPayment()
        }
    }
    var pid : String = ""


    private fun startPayment() {
        /*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * */
        val activity: Activity = this
        val co = Checkout()
        val numChild:Int = binding.childtextField.editText?.text.toString().toInt()
        val numAdult:Int = binding.adulttextField.editText?.text.toString().toInt()
        val numForeigner:Int = binding.foreignertextField.editText?.text.toString().toInt()
        var total:Int = numChild*15+numAdult*20+numForeigner*100

        try {
            val options = JSONObject()
            options.put("name", "Musafir")
            options.put("description", "ticket payment")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", total.toString()+"00")//pass amount in currency subunits

            val prefill = JSONObject()
            prefill.put("email", "")
            prefill.put("contact", "")

            options.put("prefill", prefill)
            co.open(activity, options)
        } catch (e: Throwable) {
            Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }
    fun randomChar(chars: String): Char {
        return chars[Random.nextInt(chars.length)]
    }
    var flag : Boolean = false


    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        try {

            var dialog = CustomDialogFragment(razorpayPaymentId!!)
//            val mBundle = Bundle()
//            mBundle.putString("mText",razorpayPaymentId)
//            dialog.arguments = mBundle
            dialog.show(supportFragmentManager, "QR")
            flag = true
            pid = razorpayPaymentId

            Toast.makeText(getApplicationContext(), razorpayPaymentId, Toast.LENGTH_LONG).show();
        }catch (e:Throwable){

        }

    }


    override fun onPaymentError(p0: Int, p1: String?) {
        var dialog = CustomDialogFragment(null)
        dialog.show(supportFragmentManager,"QR")
        flag = false


    }


}



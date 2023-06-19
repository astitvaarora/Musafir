package com.example.musafir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.example.musafir.databinding.FragmentCustomDialogBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class CustomDialogFragment(private val id:String?) : DialogFragment(){
    private var _binding: FragmentCustomDialogBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val bundle = arguments
//        val orderid = bundle!!.getString("mText")
        id?.let {
            qr_code(it)
        }
    }


    private fun qr_code(orderid:String?){
        val mWriter = MultiFormatWriter()
        try {
            val mMatrix = mWriter.encode(orderid, BarcodeFormat.QR_CODE, 400, 400)
            val mEncoder = BarcodeEncoder()
            val mBitmap = mEncoder.createBitmap(mMatrix) //creating bitmap of code
            binding.qrCode.setImageBitmap(mBitmap) //Setting generated QR code to imageView

        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

}
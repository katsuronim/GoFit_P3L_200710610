package com.example.gofit_p3l_10610.Instruktur.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.gofit_p3l_10610.BookingKelasAPI.BookingKelas
import com.example.gofit_p3l_10610.Instruktur.DashboardInstrukturActivity
import com.example.gofit_p3l_10610.Instruktur.IzinInstrukturAdapter
import com.example.gofit_p3l_10610.Instruktur.ReadHistoriInstrukturActivity
import com.example.gofit_p3l_10610.Member.ReadPaketActivity
import com.example.gofit_p3l_10610.R
import com.example.gofit_p3l_10610.databinding.FragmentDashboardInstrukturBinding
import com.example.gofit_p3l_10610.databinding.FragmentProfileInstrukturBinding
import com.example.gofit_p3l_10610.izinInstrukturAPI.ClientIzinInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.Instruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateInstruktur
import com.example.gofit_p3l_10610.izinInstrukturAPI.ResponseCreateIzinInstruktur
import com.example.gofit_p3l_10610.userAPI.User
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileInstrukturFragment : Fragment() {
    private var _binding: FragmentProfileInstrukturBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""
    private val listInstruktur = ArrayList<Instruktur>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: DashboardInstrukturActivity? = activity as DashboardInstrukturActivity?
        _binding = FragmentProfileInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        val call: Call<ResponseCreateInstruktur> = ClientIzinInstruktur.apiService.getInstruktur(idUser)
        call?.enqueue(object : Callback<ResponseCreateInstruktur> {
            override fun onResponse(call: Call<ResponseCreateInstruktur>, response: Response<ResponseCreateInstruktur>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.NAMA_INSTRUKTUR)
                        binding.txtId.setText(it.data.ID_INSTRUKTUR)
                        binding.txtAlamat.setText(it.data.ALAMAT_INSTRUKTUR)
                        binding.txtTanggalLahir.setText(it.data.TANGGAL_LAHIR_INSTRUKTUR)
                        binding.txtNoTelp.setText(it.data.NO_TELEPON_INSTRUKTUR)
                        binding.txtEmail.setText(it.data.EMAIL_INSTRUKTUR)
                        binding.txtKeterlambatan.setText(it.data.KETERLAMBATAN + " detik")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateInstruktur>, t: Throwable) {
            }
        })

        binding.btnHistori.setOnClickListener {
            val intent = Intent(requireActivity(), ReadHistoriInstrukturActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        return binding.root
    }
}
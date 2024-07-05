package id.pinterest.app.inbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.pinterest.app.R
import id.pinterest.app.create.ImageModel
import id.pinterest.app.databinding.FragmentShareBinding

class ShareFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentShareBinding? = null
    private val binding get() = _binding!!
    private val socialMediaAdapter by lazy { SocialMediaAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShareBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolbar.setNavigationOnClickListener {
                dismiss()
            }

            rvSocialMedia.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = socialMediaAdapter

                socialMediaAdapter.submitList(
                    listOf(
                        ImageModel(R.drawable.image_social_whatsapp, "WhatsApp"),
                        ImageModel(R.drawable.image_social_line, "Line"),
                        ImageModel(R.drawable.image_social_message, "Imessage"),
                        ImageModel(R.drawable.image_social_email, "Email"),
                    )
                )
            }
        }
    }
}
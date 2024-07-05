package id.pinterest.app.create

import android.media.Image
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginEnd
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import id.pinterest.app.R
import id.pinterest.app.databinding.FragmentCreateBinding


class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!
    private val menuImageAdapter by lazy { ImageAdapter() }
    private val photosImageAdapter by lazy { ImageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (i in 0 until binding.tabLayout.tabCount) {
            val tab: TabLayout.Tab? = binding.tabLayout.getTabAt(i)
            tab?.view?.gravity = Gravity.START or Gravity.CENTER_VERTICAL
            val params: ViewGroup.MarginLayoutParams = tab?.view?.layoutParams as ViewGroup.MarginLayoutParams
            params.marginEnd = 24
        }

        binding.rvPhoto.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = photosImageAdapter
            photosImageAdapter.submitList(listOf(
                ImageModel(R.drawable.image_photos_1),
                ImageModel(R.drawable.image_photos_2),
                ImageModel(R.drawable.image_photos_3),
                ImageModel(R.drawable.image_home_1)
            ))
        }

        binding.rvMenu.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuImageAdapter
            menuImageAdapter.submitList(
                listOf(
                    ImageModel(R.drawable.image_menu_1, "Blank"),
                    ImageModel(R.drawable.image_menu_2, "Collage"),
                    ImageModel(R.drawable.image_menu_3, "Remove"),
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
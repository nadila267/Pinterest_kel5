package id.pinterest.app.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.pinterest.app.R
import id.pinterest.app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        navView.setupWithNavController(navController)

        navView.getOrCreateBadge(R.id.navigation_inbox).apply {
            isVisible = true
            backgroundColor = getColor(R.color.red_700)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.navView.isVisible =
                destination.id == R.id.navigation_inbox ||
                        destination.id == R.id.navigation_profile ||
                        destination.id == R.id.navigation_home ||
                        destination.id == R.id.navigation_search ||
                        destination.id == R.id.navigation_create ||
                        destination.id == R.id.action_navigation_search_to_searchResultFragment
        }
    }
}
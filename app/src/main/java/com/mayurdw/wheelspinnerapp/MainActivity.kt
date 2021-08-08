package com.mayurdw.wheelspinnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.mayurdw.wheelspinnerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        this.navController = this.findNavController(R.id.myNavHostFragment)
        this.drawerLayout = binding.drawerLayout

        NavigationUI.setupActionBarWithNavController(
            this, this.navController, this.drawerLayout
        )
        NavigationUI.setupWithNavController(binding.navView, this.navController)

        this.navController.addOnDestinationChangedListener{
            controller, destination, _ ->
            if( destination.id == controller.graph.startDestination ){
                this.drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
            } else {
                this.drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
            }
        }
        AppBarConfiguration(this.navController.graph, this.drawerLayout)
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's
     * activity hierarchy from the action bar.
     *
     *
     * If a parent was specified in the manifest for this activity or an activity-alias to it,
     * default Up navigation will be handled automatically. See
     * [.getSupportParentActivityIntent] for how to specify the parent. If any activity
     * along the parent chain requires extra Intent arguments, the Activity subclass
     * should override the method [.onPrepareSupportNavigateUpTaskStack]
     * to supply those arguments.
     *
     *
     * See [Tasks and
 * Back Stack]({@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html) from the developer guide and
     * [Navigation]({@docRoot}design/patterns/navigation.html) from the design guide
     * for more information about navigating within your app.
     *
     *
     * See the [androidx.core.app.TaskStackBuilder] class and the Activity methods
     * [.getSupportParentActivityIntent], [.supportShouldUpRecreateTask], and
     * [.supportNavigateUpTo] for help implementing custom Up navigation.
     *
     * @return true if Up navigation completed successfully and this Activity was finished,
     * false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(this.navController, drawerLayout)
    }
}
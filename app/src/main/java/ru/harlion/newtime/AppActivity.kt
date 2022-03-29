package ru.harlion.newtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.harlion.newtime.ui.main.MainFragment
import ru.harlion.newtime.ui.goals.GoalsFragment
import ru.harlion.newtime.ui.habits.HabitsFragment
import ru.harlion.newtime.ui.profile.ProfileFragment
import ru.harlion.newtime.ui.profile.on_boarding.OnBoardingFragment
import ru.harlion.newtime.ui.tasks.TasksFragment
import ru.harlion.newtime.utils.Prefs
import ru.harlion.newtime.utils.replaceFragment

class AppActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SkyTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = Prefs(this)
        bottomNavView = findViewById(R.id.bottom_nav_view)

        if (!prefs.isShowOnBoarding) {
            prefs.isShowOnBoarding = true
             replaceFragment(OnBoardingFragment(), false)
        } else {
            replaceFragment(MainFragment(), false)
        }

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_main_page -> {
                    replaceFragment(MainFragment(), true)
                    true
                }

//                R.id.item_tasks_page -> {
//                    replaceFragment(TasksFragment(), true)
//                    true
//                }

                R.id.item_goals_page -> {
                    replaceFragment(GoalsFragment(), true)
                    true
                }

                R.id.item_habits_page -> {
                    replaceFragment(HabitsFragment(), true)
                    true
                }
                R.id.item_profile_page -> {
                    replaceFragment(ProfileFragment(), true)
                    true
                }

                else -> false
            }
        }
    }

    fun setBottomNavigationVisible(isVisible: Boolean) {
        if (isVisible) {
            bottomNavView.visibility = View.VISIBLE
        } else {
            bottomNavView.visibility = View.GONE
        }
    }

//    fun updateNavigation(fragment: Fragment) {
//        when (fragment) {
//            is MainFragment -> bottomNavView.menu.findItem(R.id.item_main_page).isChecked =
//                true
//            is  -> bottomNavView.menu.findItem(R.id.item_tasks_page).isChecked =
//                true
//            is ListProjectsFragment -> bottomNavView.menu.findItem(R.id.item_projects_page).isChecked =
//                true
//            is ProfileFragment -> bottomNavView.menu.findItem(R.id.item_profile_page).isChecked =
//                true
//        }
//    }
}
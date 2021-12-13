package br.com.mbecker.choppcount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.mbecker.choppcount.bu.ChoppCounter
import br.com.mbecker.choppcount.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var counter: ChoppCounter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counter = ChoppCounter()
        restoreData(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            counter.incCounter()
            updateCounterText()
        }

    }

    private fun restoreData(savedInstanceState: Bundle?) {
        val savedCounter: Int = savedInstanceState?.getInt("counter") ?: 0
        counter.set(savedCounter)
    }

    override fun onResume() {
        super.onResume()
        updateCounterText()
    }

    private fun updateCounterText() {
        binding.tvCount.text = counter.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_reset -> {
                counter.resetCounter()
                updateCounterText()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreData(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter.get())
    }

}
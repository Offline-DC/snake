package com.snake

import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var snakeGameView: SnakeGameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Keep screen on while playing
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContentView(R.layout.activity_main)
        snakeGameView = findViewById(R.id.snakeGameView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                snakeGameView.handleKey(Direction.UP)
                true
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                snakeGameView.handleKey(Direction.DOWN)
                true
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                snakeGameView.handleKey(Direction.LEFT)
                true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                snakeGameView.handleKey(Direction.RIGHT)
                true
            }
            KeyEvent.KEYCODE_DPAD_CENTER,
            KeyEvent.KEYCODE_ENTER -> {
                snakeGameView.handleKeyCenter()
                true
            }
            // Also handle number keys as alternative controls
            KeyEvent.KEYCODE_2 -> { snakeGameView.handleKey(Direction.UP); true }
            KeyEvent.KEYCODE_8 -> { snakeGameView.handleKey(Direction.DOWN); true }
            KeyEvent.KEYCODE_4 -> { snakeGameView.handleKey(Direction.LEFT); true }
            KeyEvent.KEYCODE_6 -> { snakeGameView.handleKey(Direction.RIGHT); true }
            KeyEvent.KEYCODE_5 -> { snakeGameView.handleKeyCenter(); true }
            else -> super.onKeyDown(keyCode, event)
        }
    }

    override fun onPause() {
        super.onPause()
        snakeGameView.pauseGame()
    }

    override fun onResume() {
        super.onResume()
        snakeGameView.resumeIfNeeded()
    }
}

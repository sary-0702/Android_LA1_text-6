package app.nunome.sary.primequiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object {
        private const val QUESTION_COUNT: Int = 10
    }

    var random: Random = Random
    val questions: IntArray = IntArray(QUESTION_COUNT)
    var point: Int = 0
    var answerCount: Int = 0
    var whatnum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until QUESTION_COUNT) {
            val number = random.nextInt(1000)
            Log.d("Number", "Question" + number.toString())
            questions[i] = number
        }
        /*
        point = 0
        answerCount = 0

        textView.text = questions[answerCount].toString() + ""
        textView.setTextColor(Color.BLACK)
        */
    }

    fun maru (view: View) {
        var answer = true
        val number = questions[answerCount]

        for (i in 2 until number) {
            if (number % i == 0) {
                answer = false
                break
            }
        }

        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show()
        }

        if (answer) {
            point++
            Log.d("maru", "正解" + point.toString())
            Log.d("answer", answer.toString())
        } else {
            Log.d("maru", "不正解")
            Log.d("answer", answer.toString())
            Log.d("whatnum", whatnum.toString())
        }

        answerCount++

        if (answerCount == QUESTION_COUNT) {
            textView.text = point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0

        } else {
            textView.text = questions[answerCount].toString() + ""
            textView.setTextColor(Color.BLACK)
        }
    }

    fun batsu (view: View) {
        var answer = true
        val number = questions[answerCount]

        for (i in 2 until number) {
            if (number % i == 0) {
                answer = false
                whatnum = i
                break
            }
        }

        if (answer) {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show()
        }

        if (answer) {
            point++
            Log.d("batsu", "不正解")
            Log.d("answer", answer.toString())
        } else {
            Log.d("batsu", "正解" + point.toString())
            Log.d("answer", answer.toString())
            Log.d("whatnum", whatnum.toString())
        }

        answerCount++

        if (answerCount == QUESTION_COUNT) {
            textView.text = point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0

        } else {
            textView.text = questions[answerCount].toString() + ""
            textView.setTextColor(Color.BLACK)
        }
    }
}
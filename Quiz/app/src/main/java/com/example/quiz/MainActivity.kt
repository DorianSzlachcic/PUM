package com.example.quiz

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private data class Question(val question: String,
                        val answer1: String,
                        val answer2: String,
                        val answer3: String,
                        val answer4: String,
                        val rightAnswer: String)

    private val questions = listOf(
        Question(
            "W którym roku powstał język Kotlin?",
            "2023",
            "1999",
            "2011",
            "2010",
            "2011"
        ),
        Question(
            "Z jakim językiem może współpracować język Kotlin?",
            "C++",
            "Java",
            "C",
            "Python",
            "Java"
        ),
        Question(
            "Jaka jest najnowsza wersja Androida?",
            "14",
            "10",
            "9",
            "13",
            "14"
        ),
        Question(
            "Jaki telefon jako pierwszy posiadał system Android?",
            "HTC Dream",
            "Nokia 3310",
            "HTC Magic",
            "Nexus One",
            "HTC Dream"
        ),
        Question(
            "W którym roku powstawł język Java?",
            "2010",
            "2007",
            "1997",
            "1996",
            "1996"
        ),
        Question(
            "Ile aktywnych urządzeń używa Androida?",
            "2 miliony",
            "3 tysiące",
            "ponad 3 miliardy",
            "2 miliardy",
            "ponad 3 miliardy"
        ),
        Question(
            "Kto jest twórcą Kotlina?",
            "JetBrains",
            "Google",
            "Microsoft",
            "Android Inc.",
            "JetBrains"
        ),
        Question(
            "Jak zadeklarować zmienną w Kotlinie?",
            "let nazwa_zmiennej;",
            "nazwa_zmiennej = wartość",
            "typ_zmiennej nazwa_zmiennej;",
            "var nazwa_zmiennej: typ_zmiennej",
            "var nazwa_zmiennej: typ_zmiennej"
        ),
        Question(
            "Jaki typ zmiennej przechowuje liczbę naturalną?",
            "string",
            "integer",
            "bool",
            "float",
            "integer"
        ),
        Question(
            "Jak wypisać tekst w konsoli w Kotlinie?",
            "println(...)",
            "console.log(...);",
            "cout << ...;",
            "System.out.println(...);",
            "println(...)"
        ),
    )

    private var questionCounter = 0
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setQuestion()
        binding.nextButton.setOnClickListener {
            val answerGroup: RadioGroup by lazy {findViewById(R.id.answers)}
            val userAnswer: RadioButton by lazy {findViewById(answerGroup.checkedRadioButtonId)}

            if (userAnswer.text == questions[questionCounter].rightAnswer)
                points += 10
            questionCounter++
            binding.progressBar.progress += 10

            if (questionCounter < questions.size)
            {
                setQuestion()
                answerGroup.clearCheck()
            }
            else
            {
                showEndScreen()
            }
        }
    }

    private fun setQuestion()
    {
        val currentQuestion = questions[questionCounter]
        binding.questionCounter.text = "Pytanie ${questionCounter + 1}/${questions.size}"
        binding.question.text = currentQuestion.question
        binding.answer1.text = currentQuestion.answer1
        binding.answer2.text = currentQuestion.answer2
        binding.answer3.text = currentQuestion.answer3
        binding.answer4.text = currentQuestion.answer4
    }

    private fun showEndScreen()
    {
        binding.gameScreen.visibility = android.view.View.INVISIBLE
        binding.endScreen.visibility = android.view.View.VISIBLE
        binding.points.text = points.toString()
    }
}
package com.example.android.unscramble.ui

import androidx.compose.runtime.ScopeUpdateScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.android.unscramble.data.MAX_NO_OF_WORDS
import com.example.android.unscramble.data.SCORE_INCREASE
import com.example.android.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    // StateFlow: 현재 상태와 새로운 상태 업데이트를 내보내는 관찰 가능한 데이터 홀더 플로우
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow() // 읽기 전용 흐름 상태
    var userGuess by mutableStateOf("") // 추측단어
        private set

    private lateinit var currentWord: String // 글자가 섞인 현재 단어 저장
    private var usedWords: MutableSet<String> = mutableSetOf() // 사용된 단어들 저장

    init {
        resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    //현재 단어의 순서를 섞는 도우미 메서드
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    // 유저 추측 단어 메서드
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    // 추측 단어 확인 메서드
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            //정답일 경우
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
            // 틀린 경우
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }

    //점수 업데이트
    private fun updateGameState(updatedScore: Int){
        if (usedWords.size == MAX_NO_OF_WORDS){
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc(),
                    isGameOver = true
                )
            }
        } else{
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    // 단어 스킵
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    // 게임을 초기화하는 도우미 함수
    fun resetGame() {
        usedWords.clear() // 게임초기화
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle()) // 새 단어 선택
    }
}
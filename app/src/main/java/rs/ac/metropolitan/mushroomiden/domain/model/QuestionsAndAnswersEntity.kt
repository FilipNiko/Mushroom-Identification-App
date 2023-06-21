package rs.ac.metropolitan.mushroomiden.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QuestionsAndAnswers")
data class QuestionsAndAnswersEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstQuestionPicture:String,
    val secondQuestionPicture:String,
    val firstAnswer:String,
    val secondAnswer:String,
    val thirdAnswer:String,
    val fourthAnswer:String,
    val correctAnswer:String,




)
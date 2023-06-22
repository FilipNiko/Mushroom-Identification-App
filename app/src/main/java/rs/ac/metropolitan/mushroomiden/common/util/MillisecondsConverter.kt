package rs.ac.metropolitan.mushroomiden.common.util

object MillisecondsConverter {

    fun millisecondsToMinutesAndSecondsString(milliseconds: Long): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60

        val minutesString:String
        val secondsString:String

        if(minutes<10){
            minutesString="0${minutes}"
        }else{
            minutesString = "${minutes}"
        }

        if(seconds<10){
            secondsString="0${seconds}"
        }else{
            secondsString = "${seconds}"
        }

        return "${minutesString}:${secondsString}"
    }
}
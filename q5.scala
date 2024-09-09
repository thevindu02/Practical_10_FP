object Letters {

        def countLetterOccurrences(words: List[String]): Int = {
            words.map(_.length).reduce(_ + _)
        }


        def main(args:Array[String]):Unit = {

            // Usage
            val words = List("apple", "banana", "cherry", "date")
            val totalLetters = countLetterOccurrences(words)
            println(s"Total count of letter occurrences: $totalLetters") 

        }

}




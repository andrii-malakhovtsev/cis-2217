// Andrii Malakhovtsev
// Words Testing

package Problem2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Complete the methods below. You may add helper methods
 * as you require.
 */
public class Words
{
   /**
    * The noLetterRepeated method reads all of the words
    * in filename and returns a list of all words with
    * length of at least ten, in which no letter is repeated.
    * You may assume that filename has one word per line.
    */
   public static List<String> noLetterRepeated(String filename)
   {
      List<String> result = new ArrayList<>();
      try (Scanner in = new Scanner(new File(filename))) {
         while (in.hasNext()) {
            String word = in.next();
            if (!word.endsWith("'s") && word.length() >= 10 && allLettersUnique(word)) {
               result.add(word);
            }
         }
      } catch (IOException e) {
         System.out.println("File not found: " + filename);
      }
      return result;
   }

   /**
    * The longestWord method takes a Stream<String> and
    * returns the longest word in the stream.
    */
   public static String longestWord(Stream<String> stream)
   {
      String result = stream
              .reduce("", (a, b) -> a.length() >= b.length() ? a : b);
      return result;
   }

   /**
    * Given a Stream<String> and a length,
    * returns the number of words of that length in the stream.
    */
   public static long wordCount(Stream<String> stream, int len)
   {
      long result = stream
              .filter(word -> word.length() == len)
              .count();
      return result;
   }

   // Helper method to check if all characters in a word are unique
   private static boolean allLettersUnique(String word)
   {
      for (int i = 0; i < word.length(); i++) {
         for (int j = i + 1; j < word.length(); j++) {
            if (word.charAt(i) == word.charAt(j)) {
               return false;
            }
         }
      }
      return true;
   }
}

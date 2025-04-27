// Andrii Malakhovtsev
// Time Odds

package Problem1;

import java.util.Random;
import java.util.stream.Stream;

public class StreamUtil
{
   /**
    * Measures the time it takes to count the number of odd numbers using
    * an infinite stream, given a limit. 
    * @param generator the Random generator used to generate the numbers.
    * @param limit the number of odd numbers to count
    * @param isParallel if true, use a parallel stream
    */
   public static long timeOdds(Random generator, int limit, boolean isParallel)
   {
      long start = System.nanoTime();

      Stream<Integer> stream = Stream.generate(() -> generator.nextInt())
              .filter(n -> n % 2 != 0)
              .limit(limit);

      if (isParallel) {
         stream = stream.parallel();
      }

      long count = stream.count(); // terminal operation to trigger evaluation

      long end = System.nanoTime();
      return end - start;
   }

}
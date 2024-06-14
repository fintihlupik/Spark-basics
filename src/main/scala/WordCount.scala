
  import org.apache.spark.sql.SparkSession

  object WordCount {
    def main(args: Array[String]) {
      val spark = SparkSession
        .builder()
        .appName("Java Spark WordCount basic example")
        .config("spark.master", "local")
        .getOrCreate();
      // create Spark context with Spark configuration
      val sc = spark.sparkContext
      // read in text file and split each document into words
      val tokenized = sc.textFile("src/main/scala/fichero.txt").flatMap(_.split(" "))
     // count the occurrence of each wordval wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
     val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
      wordCounts.foreach(println)
      //scala.io.StdIn.readLine() // it waits..
    }
  }




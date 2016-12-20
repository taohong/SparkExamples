package com.taohong.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.sql.DataFrame
import org.apache.spark.ml.clustering.KMeans

object KmeansTest {
  
  def main(args: Array[String]):Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName(s"$this.getClass.getSimpleName")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)
    
    val dataFrame: DataFrame = sqlContext.createDataFrame(Seq(
        (1, Vectors.dense(0.0, 0.0, 0.0)),
        (2, Vectors.dense(0.1, 0.1, 0.1)),
        (3, Vectors.dense(0.2, 0.2, 0.2)),
        (4, Vectors.dense(9.0, 9.0, 9.0)),
        (5, Vectors.dense(9.1, 9.1, 9.1)),
        (6, Vectors.dense(9.2, 9.2, 9.2))
    )
    ).toDF("id", "features")
    
    val kmeans = new KMeans().setK(2).setFeaturesCol("features").setPredictionCol("prediction")
    
    val model = kmeans.fit(dataFrame)
    
    println("Final Centers: ")
    model.clusterCenters.foreach(println)
    
    sc.stop()
  }
}
package com.taohong.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Matrix
import org.apache.spark.mllib.linalg.SingularValueDecomposition
import org.apache.spark.mllib.linalg.{Vectors, Vector}
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object SvdTest {
  
  def main(args:Array[String]):Unit={
    println("******************** SVD test is started! ************************")
    val conf = new SparkConf().setMaster("local").setAppName("SVDTest");
    val sc = new SparkContext(conf);
    val data = Array(
      Vectors.sparse(5, Seq((1,1.0),(3, 7.0))),
      Vectors.dense(2.0,0.0,3.0,4.0,5.0),
      Vectors.dense(4.0,0.0,0.0,6.0,7.0)
    )
    
    val dataRDD = sc.parallelize(data, 2);
    val mat:RowMatrix = new RowMatrix(dataRDD)
    val svd:SingularValueDecomposition[RowMatrix, Matrix] = mat.computeSVD(3, true)
    
    val u:RowMatrix = svd.U
    val s:Vector = svd.s
    val v: Matrix = svd.V
    
    val path:String = "C:\\Users\\tho\\DEV\\output\\SvdTest_" + MlUtils.getFormattedDate()
    println(s"U is output to: $path")
    u.rows.saveAsTextFile(path)
    
    println("S is: ")
    println(s)
    
    println("V is: ")
    println(v)
    
    println("******************** SVD test is done! ************************")
  }
}
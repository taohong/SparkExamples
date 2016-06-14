package com.taohong.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCounter {
  def main(args:Array[String]){
    val conf = new SparkConf().setMaster("local").setAppName("wordcount");
    val sc = new SparkContext(conf);
    val input = sc.textFile("C:\\Users\\tho\\DEV\\spark-1.6.1-bin-hadoop2.6\\README.md");
    val words = input.flatMap { line => line.split(" ") };
    val counts = words.map(word => (word,1)).reduceByKey(_+_);
    counts.saveAsTextFile("C:\\Users\\tho\\DEV\\output");
  }
}
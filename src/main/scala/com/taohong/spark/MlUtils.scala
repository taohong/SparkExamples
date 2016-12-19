package com.taohong.spark

import java.text.SimpleDateFormat
import java.util.Date

object MlUtils {
  
  
  def getFormattedDate():String = {
    var now:Date = new Date()
    var  dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss")
    dateFormat.format( now )
    
  }
}
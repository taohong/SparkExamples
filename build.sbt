name := "Spark Examples"
version := "1.0"
scalaVersion := "2.11.8"
	
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "1.6.1" % "provided",
	"org.apache.spark" %% "spark-mllib" % "1.6.1" % "provided"
)

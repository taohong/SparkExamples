name := "Spark Examples"
version := "1.0"
scalaVersion := "2.11.8"

resolvers += "Aliyun Maven Repository" at "http://maven.aliyun.com/nexus/content/groups/public/"

externalResolvers := Resolver.withDefaultResolvers(resolvers.value)
	
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "1.6.1" % "provided",
	"org.apache.spark" %% "spark-sql" % "1.6.1" % "provided",
	"org.apache.spark" %% "spark-mllib" % "1.6.1" % "provided"
)

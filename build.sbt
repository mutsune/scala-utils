name := "scala-utils"

version := "1.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test" withSources() withJavadoc()
)

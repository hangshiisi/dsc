
name := "ScalaMesos"

version := "1.0"

scalaVersion := "2.12.0-M3" 

resolvers += "Mesosphere Repo" at "http://downloads.mesosphere.io/maven"

libraryDependencies ++= Seq(
  "org.apache.mesos" % "mesos" % "0.25.0",
  "org.scala-lang" % "scala-library" % "2.11.7",
  "org.scalatest" % "scalatest_2.11" % "2.2.3" % "test"
  )


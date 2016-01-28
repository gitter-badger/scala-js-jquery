name := "udash-jquery"

version := "0.1.0"
organization := "io.udash"
scalaVersion := "2.11.7"
scalacOptions in ThisBuild ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:existentials",
  "-language:dynamics",
  "-Xfuture",
  "-Xfatal-warnings",
  "-Xlint:_,-missing-interpolator,-adapted-args"
)

libraryDependencies +=
  "org.scala-js" %%% "scalajs-dom" % "0.8.2"

jsDependencies +=
  "org.webjars" % "jquery" % "2.2.0" / "2.2.0/jquery.js" minified "2.2.0/jquery.min.js"

lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)

// Deployment configuration
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
  <url>https://github.com/UdashFramework/scala-js-jquery</url>
  <licenses>
    <license>
      <name>GPL-3.0</name>
      <url>http://opensource.org/licenses/GPL-3.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:UdashFramework/scala-js-jquery.git</url>
    <connection>scm:git@github.com:UdashFramework/scala-js-jquery.git</connection>
  </scm>
  <developers>
    <developer>
      <id>avsystem</id>
      <name>AVSystem</name>
      <url>http://www.avsystem.com/</url>
    </developer>
  </developers>
}
